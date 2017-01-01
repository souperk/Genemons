package gr.genemons.server;


import java.util.Timer;
import java.util.TimerTask;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class ServerLoop
		extends TimerTask
{

	protected GenemonsServer server;

	public final int updateFrequency;

	protected Timer timer = new Timer();

	protected boolean running = false;

	public ServerLoop(GenemonsServer server, int updateFrequency)
	{
		super();
		this.server = server;
		this.updateFrequency = updateFrequency;
	}

	public synchronized void start()
	{
		if (running)
			return;

		running = true;
		timer.schedule(this, 0, 1000 / updateFrequency);
	}

	public synchronized void stop()
	{
		timer.cancel();
		running = false;
	}

	@Override
	public void run()
	{
		if (server.getState() == GenemonsServer.SERVER_RUNNING)
		{
			server.update();
		}
	}
}
