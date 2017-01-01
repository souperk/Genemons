package gr.genemons.client.ui.mainmenu;

import gr.genemons.client.GenemonsClient;
import gr.souperk.ui.Button;
import gr.souperk.ui.Label;
import gr.souperk.ui.Panel;
import gr.souperk.ui.layout.AbsoluteLayout;
import gr.souperk.ui.layout.AbsoluteLayoutData;
import gr.souperk.utils.configure.Setting;
import gr.souperk.utils.configure.SettingPriority;
import gr.souperk.utils.events.ActionEventObserver;

import java.awt.image.BufferedImage;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class MainMenuPanel
		extends Panel
{
	public static final String QUIT_GAME_BUTTON_ID = "gr.genemons.ui.main-menu.quit-game";

	public static final String LOAD_GAME_BUTTON_ID = "gr.genemons.ui.main-menu.load-game";

	public static final String NEW_GAME_BUTTON_ID = "gr.genemons.ui.main-menu.new-game";

	public static final String MAIN_MENU_PANEL = "main-menu.panel";

	@Setting(key = "genemons.client.ui.main-menu.background", priority = SettingPriority.WARNING)
	public static BufferedImage background;

	protected ActionEventObserver uiObserver;

	public MainMenuPanel(GenemonsClient client)
	{
		super(MAIN_MENU_PANEL);

		this.uiObserver = new MainMenuObserver(client);

		AbsoluteLayout layout = new AbsoluteLayout();

		Button newGameButton = new Button(NEW_GAME_BUTTON_ID, "New Game", null);
		newGameButton.setShowText(true);
		newGameButton.addActionObserver(uiObserver);
		layout.layoutComponent(newGameButton, new AbsoluteLayoutData(350, 270, 125, 60, 1));
		add(newGameButton);

		Button loadGameButton = new Button(LOAD_GAME_BUTTON_ID, "Load Game", null);
		loadGameButton.setShowText(true);
		loadGameButton.addActionObserver(uiObserver);
		layout.layoutComponent(loadGameButton, new AbsoluteLayoutData(350, 340, 125, 60, 1));
		add(loadGameButton);

		Button quitGameButton = new Button(QUIT_GAME_BUTTON_ID, "Quit Game", null);
		quitGameButton.setShowText(true);
		quitGameButton.addActionObserver(uiObserver);
		layout.layoutComponent(quitGameButton, new AbsoluteLayoutData(350, 410, 125, 60, 1));
		add(quitGameButton);

		Label backgroundLabel = new Label(background);
		layout.layoutComponent(backgroundLabel,
				new AbsoluteLayoutData(0, 0, background.getWidth(), background.getHeight(), 0));
		add(backgroundLabel);

		setLayout(layout);

	}

}
