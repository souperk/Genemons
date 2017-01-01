package gr.genemons.client.ui;

import gr.souperk.utils.configure.Setting;
import gr.souperk.utils.configure.SettingPriority;
import gr.souperk.utils.context.Context;

/**
 * @author souperk
 * @since 0.0.2
 *
 */
// TODO write javadoc.
public class GenemonsUI
{
	/*
	 * Javadoc notes :
	 * 
	 * This class is used for gathering the creation and configuration of all ui
	 * elements in one place. This is a bad practice and eventually it will be
	 * replaced but a more suitable implementation.
	 */

	@Setting(key = "genemons.client.resources.ui", priority = SettingPriority.ERROR)
	public static Context uiResources;

	// public static void addGameMenuPanel(GenemonsClient client)
	// {
	// Window w = genemons.getWindow();
	//
	// Panel gameMenu = new Panel("game-menu.panel");
	// AbsoluteLayout layout = new AbsoluteLayout();
	//
	// Button genepediaButton = new
	// gr.genemons.client.ui.gamemenu.GenepediaButton(genemons);
	// layout.layoutComponent(genepediaButton, new AbsoluteLayoutData(0, 10,
	// 125, 60));
	// gameMenu.add(genepediaButton);
	//
	// Button quitgame = new QuitGameButton(genemons);
	// layout.layoutComponent(quitgame, new AbsoluteLayoutData(0, 80, 125, 60));
	// gameMenu.add(quitgame);
	//
	// gameMenu.setLayout(layout);
	//
	// ((AbsoluteLayout) w.getLayout()).layoutComponent(gameMenu, new
	// AbsoluteLayoutData(600, 0, 200, 600));
	// w.add(gameMenu);
	//
	// }
	//
	// public static void addDialogPanel(GenemonsClient client)
	// {
	// Window w = genemons.getWindow();
	//
	// Panel dialogPanel = new DialogPanel();
	//
	// ((AbsoluteLayout) w.getLayout()).layoutComponent(dialogPanel, new
	// AbsoluteLayoutData(0, 500, 800, 100));
	// w.add(dialogPanel);
	// }
}
