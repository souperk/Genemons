package gr.genemons.server.networking;

import gr.genemons.server.GenemonsServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.List;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO implement this with the service class.
// TODO write javadoc.
public class SessionManager
		implements Runnable
{
	/*
	 * What is the idea of the SessionManager?
	 */

	protected GenemonsServer server;

	protected List<Session> sessionPool = new ArrayList<>();

	protected boolean running = false;

	protected long idCount = 0;

	protected long connectTimeout = 1000 * 60 * 10;

	public SessionManager(GenemonsServer server)
	{
		super();
		this.server = server;
	}

	public synchronized void start()
	{
		this.running = true;
		new Thread(this).start();
	}

	public synchronized void stop()
	{
		this.running = false;
	}

	@Override
	public void run()
	{
		int port = server.getResources().getInteger("genemons.server.port");
		System.out.println("SessionManager : port set to " + port);

		try
		{
			ServerSocket socket = new ServerSocket(port);

			while (running)
			{
				Session session = new Session(server, socket.accept());

				session.id = ++idCount; // first increases then assigns

				System.out.println("Creating new session.");
				synchronized (sessionPool)
				{
					sessionPool.add(session);
				}
				session.start();
			}

			socket.close();

		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void update()
	{
		long time = server.getTime();

		List<Session> dead = new ArrayList<>();

		for (Session session : sessionPool)
		{
			if (session.getState() == Session.STOPPED)
			{
				dead.add(session);
				continue;
			}

			if (session.lastTime - time > connectTimeout)

			{
				System.out.println("Stopping session.");
				session.stop();
			}

			if (session.isAuthorized())
			{
				synchronized (session)
				{
					session.update();
				}
			}

		}

		for (Session session : dead)
		{
			sessionPool.remove(session);
		}
	}
}
