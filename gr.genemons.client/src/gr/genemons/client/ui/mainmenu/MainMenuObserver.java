package gr.genemons.client.ui.mainmenu;

import gr.genemons.client.GenemonsClient;
import gr.genemons.client.SimpleLogger;
import gr.genemons.client.networking.GenemonsSession;
import gr.souperk.ui.ButtonEvent;
import gr.souperk.ui.ButtonObserver;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class MainMenuObserver
		extends ButtonObserver
{

	protected GenemonsClient client;

	public MainMenuObserver(GenemonsClient client)
	{
		super();
		this.client = client;
	}

	@Override
	public void released(ButtonEvent event)
	{
		if (event.getButtonID() == MainMenuPanel.QUIT_GAME_BUTTON_ID)
		{
			System.exit(0);
		} else if (event.getButtonID() == MainMenuPanel.NEW_GAME_BUTTON_ID)
		{
			GenemonsSession session = new GenemonsSession("127.0.0.1", 1100, "souperk", "souperk");

			// TODO Obtain data from a form.
			if (session.connect())
			{
				SimpleLogger.log("Successfully connected to Session");
				client.setSession(session);

				client.setState(GenemonsClient.PLAYING);
			} else
			{
				SimpleLogger.log("Unable to connect.");
			}
		}
	}
}
