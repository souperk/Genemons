package gr.genemons.server.networking;

import gr.genemons.server.GenemonsServer;
import gr.genemons.server.entity.Entity;
import gr.genemons.server.entity.Player;
import gr.genemons.share.networking.AuthQuery;
import gr.genemons.share.networking.Encoder;
import gr.genemons.share.networking.Parser;
import gr.genemons.share.networking.Protocol;
import gr.souperk.games.Service;
import gr.souperk.utils.events.Action;
import gr.souperk.utils.events.ActionEvent;

import java.io.IOException;
import java.net.Socket;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * The {@code Session} is an Object that represents the connection with the
 * user.<br>
 * <br>
 * When initiated it will wait a fixed period of time for authorization data. If
 * the data don't point to any valid user or no data at all are sent after the
 * waiting period the session will be terminated.<br>
 * <br>
 * // TODO I should check what happens with the memory of stopped threads<br>
 * <br>
 * 
 * After the authorization is completed successfully, the server will update the
 * client on a fixed frequency. Updating the client involves sending the "world
 * data" from the server to the client. The world data are consisted of nearby
 * {@code Entity} instances to the player. <br>
 * <br>
 * 
 * //TODO I didn't explain the player variable.<br>
 * //TODO Should I make a prediction for additional world data? If so what kind
 * of prediction?<br>
 * <br>
 * 
 * Another job of the {@code Session} is receiving action events from the
 * client.<br>
 * 
 * <br>
 * //TODO for now it seems passing just action id is fine. Should I make some
 * kind of prediction for action variables?
 * 
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class Session
		extends Service
{

	/* Local Variables. */
	protected GenemonsServer server;

	protected Parser parser;
	protected Encoder encoder;

	protected Player player;

	protected Socket clientSocket;

	protected Queue<ActionEvent> eventQueue = new LinkedList<>();

	public long lastTime;

	public long id;

	public Session(GenemonsServer server, Socket clientSocket) throws IOException
	{
		super();
		this.server = server;
		this.clientSocket = clientSocket;

		this.parser = new Parser(clientSocket.getInputStream());
		this.encoder = new Encoder(clientSocket.getOutputStream());

		this.lastTime = server.getTime();
	}

	@Override
	public void execute()
	{
		if (clientSocket.isClosed())
			stop();

		try
		{
			if (!isAuthorized())
			{
				authorize();
				lastTime = server.getTime();
			}
			ActionEvent event = parser.deserialize(ActionEvent.class);

			if (event != null)
			{
				eventQueue.add(event);
				lastTime = server.getTime();
			}
			
		} catch (ClassNotFoundException e)
		{
			//TODO manage exception
		}
	}

	protected void authorize() throws ClassNotFoundException
	{
		AuthQuery auth = parser.deserialize(AuthQuery.class);

		player = server.getPlayerManager().getPlayer(auth.getUsername(), auth.getPassword());

		if (player == null)
		{
			stop();
		} else
		{
			encoder.serialize(player); // TODO use system log.
			System.out.println("Authorized Player : " + player.getId());
		}
	}

	@Override
	public synchronized void stop()
	{
		super.stop();
		player.triggerEvent(new ActionEvent("idle"));

		try
		{
			clientSocket.close();
		} catch (IOException e)
		{
			System.err.println("BOOM!");
		}
	}

	/**
	 * Checks whether the session is authorized by checking it's player variable
	 * for null. If it is null the session has yet to be authorized.<br>
	 * <br>
	 * This works under the assumption that the player variable will be
	 * initiated upon authorizing the session, take note of this when overriding
	 * the execute() method.
	 * 
	 * @return true if and only if the Session is authorized.
	 */
	public boolean isAuthorized()
	{
		return player != null;
	}

	/**
	 * If the session is not authorized nothing is done.
	 * 
	 * Else, first updates the client, by sending the data about the Entity
	 * instances on the same world with the player. Then pushes all the events
	 * from the eventQueue to the player.
	 * 
	 */
	public void update()
	{

		if (!isAuthorized())
		{
			System.out.println("not authorized");
			return;
		}

		Iterator<Entity> it = server.getWorld(player.getWorld()).entityIterator();

		while (it.hasNext())
		{
			Entity entity = it.next();
			encoder.serialize(entity);
		}

		while (!eventQueue.isEmpty())
		{
			player.triggerEvent(eventQueue.poll());
		}
	}

}
