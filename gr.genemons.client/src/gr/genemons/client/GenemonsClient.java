package gr.genemons.client;

import gr.genemons.client.entity.Player;
import gr.genemons.client.map.World;
import gr.genemons.client.networking.GenemonsSession;
import gr.souperk.utils.State;
import gr.souperk.utils.configure.Setting;
import gr.souperk.utils.context.Context;
import gr.souperk.utils.events.ActionEvent;
import gr.souperk.utils.events.ActionEventObserver;

/**
 * Ποιος ειναι ο σκοπος του GenemonsClient ;
 * 
 * GenemonsClient is a central point for synchronizing the actions of the
 * different components of the client. The main components is the GUI, the
 * mechanism and the actual data.
 * 
 * The GUI component.
 * 
 * 
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class GenemonsClient
		implements ActionEventObserver
{
	/*
	 * A problem with thread synchronization in gr.souperk.ui may exist.
	 * 
	 * It seems that under unknown circumstances even though the removal of a
	 * Component from it's container may be successful, the container is not
	 * invalidated.
	 * 
	 * My guess is that the window.render and window.remove methods are called
	 * simultaneously(they operate on different threads) resulting in a
	 * conflict.
	 * 
	 * If I recall correctly this issue is resolved. Check to be sure, and
	 * delete the comment. (13/5/2016)
	 */

	/*
	 * TODO Whenever the client is stopped, make sure to terminate the session
	 * with the server first.
	 */

	/* Settings. */

	@Setting(key = "genemons.client.resources")
	public static Context resources;

	/* States. */

	@Setting(key = "genemons.client.state.init")
	public static State INIT;

	@Setting(key = "genemons.client.state.main-menu")
	public static State MAIN_MENU;

	@Setting(key = "genemons.client.state.playing")
	public static State PLAYING;

	@Setting(key = "genemons.client.state.loading")
	public static State LOADING;

	@Setting(key = "genemons.client.state.saving")
	public static State SAVING;

	/** Singleton instance. */
	private static GenemonsClient instance;

	/**
	 * The state of the Game. It can have three value INIT, MAIN_MENU, PLAYING,
	 * LOADING, SAVING . Default value is INIT.
	 */
	protected State state = INIT;

	protected Gameplay gameplay;

	/**
	 * The current time used to synchronize the function of game. It is updated
	 * in the game clock.
	 * 
	 * Referencing to this instance of time instead of calling
	 * System.currentTimeMills() also helps optimize since that method is rather
	 * slow.
	 */
	public long time;

	/** The session with */
	protected GenemonsSession session;

	/* Game related data. */
	protected MapManager mapManager;

	protected StatisticsManager statisticsManager;

	private GenemonsClient()
	{
		instance = this;
		setState(INIT);

		/*
		 * Endless loop! GenemonsClient constructor calls StatisticsManager
		 * constructor and vice versa.
		 */
		statisticsManager = new StatisticsManager(System.currentTimeMillis());

		mapManager = resources.get("client.mapManager", MapManager.class);
		gameplay = new Gameplay(resources);

		setState(MAIN_MENU);
	}

	public static GenemonsClient getInstance()
	{
		if (instance == null)
		{
			new GenemonsClient();
		}

		return instance;
	}

	@Override
	public void triggerEvent(ActionEvent event)
	{
		if (event == null || event.isDisposed())
			return;

		if (getState() == PLAYING)
		{
			session.sendEvent(event);
		}
	}

	public void render()
	{
		/*
		 * The weird rendering is the result of bad multi-threading, sometimes
		 * position of the character is changed after the offset is calculated
		 * resulting in changing the position on screen for the character.
		 */

		statisticsManager.update();
		statisticsManager.countRender();

		time = System.currentTimeMillis();

		gameplay.render();
	}

	/* Getters and Setters. */

	public State getState()
	{
		return state;
	}

	public void setState(State state)
	{
		this.state = state;
	}

	public World getWorld()
	{
		return gameplay.getWorld();
	}

	public Player getCharacter()
	{
		return gameplay.getCharacter();
	}

	public void setCharacter(Player character)
	{
		gameplay.setCharacter(character);
	}

	public GenemonsSession getSession()
	{
		return session;
	}

	public void setSession(GenemonsSession session)
	{
		this.session = session;
	}

	public long getTime()
	{
		return time;
	}

	public void setTime(long time)
	{
		this.time = time;
	}

	public MapManager getMapManager()
	{
		return mapManager;
	}

	public void setMapManager(MapManager mapManager)
	{
		this.mapManager = mapManager;
	}

	public Gameplay getGameplay()
	{
		return gameplay;
	}

	public void setGameplay(Gameplay gameplay)
	{
		this.gameplay = gameplay;
	}

}
