package gr.genemons.server;

import gr.genemons.server.map.World;
import gr.genemons.server.networking.SessionManager;
import gr.genemons.share.bean.WorldBean;
import gr.souperk.utils.State;
import gr.souperk.utils.configure.Setting;
import gr.souperk.utils.context.Context;
import gr.souperk.utils.context.support.MappedContext;
import gr.souperk.utils.events.ActionEvent;
import gr.souperk.utils.events.ActionEventObserver;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class GenemonsServer
		implements ActionEventObserver
{
	/* States. */
	@Setting(key = "genemons.server.state.loading")
	public static final State SERVER_LOADING = new State("gr.genemons.server.state.loading");

	@Setting(key = "genemons.server.state.running")
	public static final State SERVER_RUNNING = new State("gr.genemons.server.state.running");

	@Setting(key = "genemons.server.state.pause")
	public static final State SERVER_PAUSE = new State("gr.genemons.server.state.pause");

	@Setting(key = "genemons.server.state.saving")
	public static final State SERVER_SAVING = new State("gr.genemons.server.state.saving");

	/* Inner parameters. */
	protected State state;

	protected ServerLoop loop;

	protected Context resources;

	protected PlayerManager playerManager;

	protected SessionManager sessionManager;

	protected WorldManager worldManager;

	protected long time = 0;

	public GenemonsServer(Context resources)
	{
		setState(SERVER_LOADING);

		this.resources = resources;
		this.loop = new ServerLoop(this, resources.getInteger("genemons.server.update-frequency"));
		this.playerManager = new PlayerManager();
		this.sessionManager = new SessionManager(this);
		this.worldManager = new WorldManager();

		worldManager.load(resources);
		playerManager.load(resources);

	}

	public synchronized void start()
	{
		System.out.println("Starting Server");

		if (getState() == SERVER_RUNNING)
			return; // TODO log this.

		setState(SERVER_RUNNING);

		System.out.println("Starting Loop");
		loop.start();

		System.out.println("Opeing Port");
		sessionManager.start();
	}

	public synchronized void pause()
	{
		setState(SERVER_PAUSE);
	}

	public synchronized void stop()
	{
		sessionManager.stop();
		loop.stop();

		setState(SERVER_SAVING);
	}

	public void update()
	{
		Context updateContext = new MappedContext();
		time = System.currentTimeMillis();

		worldManager.update(updateContext);
		sessionManager.update();
	}
	
	public World getWorld(WorldBean worldBean)
	{	
		return null; //TODO implement.
	}

	@Override
	public void triggerEvent(ActionEvent event)
	{
		// TODO implement.
	}

	public long getTime()
	{
		// TODO implement.
		return time;
	}

	/* Getters and Setters. */
	public boolean isRunning()
	{
		return getState() == SERVER_RUNNING;
	}

	public boolean isPaused()
	{
		return getState() == SERVER_PAUSE;
	}

	public boolean isStopped()
	{
		return !isRunning() && !isPaused();
	}

	public State getState()
	{
		return state;
	}

	public synchronized void setState(State state)
	{
		this.state = state;
	}

	public PlayerManager getPlayerManager()
	{
		return playerManager;
	}

	public synchronized void setPlayerManager(PlayerManager playerManager)
	{
		this.playerManager = playerManager;
	}

	public Context getResources()
	{
		return resources;
	}

	public SessionManager getSessionManager()
	{
		return sessionManager;
	}

	public WorldManager getWorldManager()
	{
		return worldManager;
	}

}
