/**
 * 
 */
package gr.genemons.client.ui.game;

import gr.genemons.client.GenemonsClient;
import gr.genemons.client.ui.SimpleLayout;
import gr.souperk.ui.Panel;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class GamePanel
		extends Panel
{
	public static final String GAME_PANEL = "game.panel";

	public GamePanel(GenemonsClient client)
	{
		super(GAME_PANEL);

		setLayout(new SimpleLayout());
	}

}
