/**
 * 
 */
package gr.genemons.client;

import gr.genemons.client.entity.Player;
import gr.genemons.client.map.World;
import gr.genemons.client.ui.GenemonsKeyObserver;
import gr.genemons.client.ui.mainmenu.MainMenuPanel;
import gr.souperk.ui.Panel;
import gr.souperk.ui.Window;
import gr.souperk.ui.layout.AbsoluteLayout;
import gr.souperk.ui.layout.AbsoluteLayoutData;
import gr.souperk.ui.swing.SwingWindow;
import gr.souperk.utils.State;
import gr.souperk.utils.configure.Setting;
import gr.souperk.utils.configure.SettingPriority;
import gr.souperk.utils.context.Context;

/**
 * Gameplay handles the communication with the user and delivers the gaming
 * experience.
 * 
 * GUI is the component of the game that controls the visual elements of the
 * game. It is responsible the gameplay experience of the user.
 * 
 * 
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class Gameplay
{
	/* Settings. */

	@Setting(key = "genemons.client.main-window.title", priority = SettingPriority.ERROR)
	public static String windowTitle;

	@Setting(key = "genemons.client.main-window.width", priority = SettingPriority.ERROR)
	public static int windowWidth = 800;

	@Setting(key = "genemons.client.main-window.height", priority = SettingPriority.ERROR)
	public static int windowHeight = 600;

	public static int windowWidthOffest = windowWidth / 2;
	public static int windowHeightOffest = windowHeight / 2;

	/* Fields. */

	protected State windowState;

	protected GenemonsClient client = GenemonsClient.getInstance();

	protected Window window;

	protected Camera camera;

	protected Panel mainMenuPanel;

	protected EntityManager entityManager;

	protected World world;

	protected Player character;

	public Gameplay(Context resources)
	{
		loadMainWindow();
	}

	public void render()
	{
		State state = client.getState();

		if (!state.equals(state))
		{
			updateState(state);
		}

		window.setEnable(true);
		window.render();
	}

	private void updateState(State state)
	{
		if (state.equals(windowState))
		{
			/* The component is updated, no need for update. */
			return;
		}

		if (windowState.equals(GenemonsClient.PLAYING))
		{
			removeGamePanel();
		} else if (windowState.equals(GenemonsClient.MAIN_MENU))
		{
			removeMainMenuPanel();
		}

		if (state.equals(GenemonsClient.MAIN_MENU))
		{
			loadMainMenuPanel();
		} else if (state.equals(GenemonsClient.PLAYING))
		{
			loadGamePanel();
		}
	}

	protected void renderPlaying()
	{
		Player character = client.getCharacter();

		if (character == null)
		{
			SimpleLogger.log("WARNING : player is null, stopping rendering.");
			return;
		}

		if (world == null || !world.toBean().equals(character.getWorld()))
		{
			// TODO load world;
		}

		if (world == null)
		{
			SimpleLogger.log("WARNING : world is null, stopping rendering.");
			return;
		}

		if (camera == null)
		{
			// TODO every time window size changes the camera should be updated.
			camera = new RelativeCamera(character, (window.getWidth() / 2), (window.getHeight() / 2));
		}

		world.render(window.getGraphics(), camera);
	}

	public void setCharacter(Player character)
	{
		if (character == this.character)
			return;

		this.character = character;
		this.camera = new RelativeCamera(character, windowWidthOffest, windowHeightOffest);
	}

	protected void loadMainWindow()
	{
		window = new SwingWindow(windowTitle, windowWidth, windowHeight);

		window.setLayout(new AbsoluteLayout());
		window.setEnable(true);

		window.addKeyObserver(new GenemonsKeyObserver(client));
	}

	protected void loadMainMenuPanel()
	{
		if (windowState.equals(GenemonsClient.MAIN_MENU))
		{
			/* Main menu panel is already loaded, nothing to do. */
			return ;
		}
		mainMenuPanel = new MainMenuPanel(client);

		((AbsoluteLayout) window.getLayout()).layoutComponent(mainMenuPanel,
				new AbsoluteLayoutData(0, 0, window.getWidth(), window.getHeight()));
		window.add(mainMenuPanel);
		
		windowState = GenemonsClient.PLAYING;
	}

	protected void removeMainMenuPanel()
	{
		window.remove(mainMenuPanel);
		mainMenuPanel = null;
	}

	protected void loadGamePanel()
	{
		if(windowState.equals(GenemonsClient.PLAYING))
		{
			return ;
		}

		/* TODO implements GamePanel. */
	}

	protected void removeGamePanel()
	{
		
	}

	public Camera getCamera()
	{
		return camera;
	}

	public World getWorld()
	{
		return world;
	}

	public Player getCharacter()
	{
		return character;
	}

}
