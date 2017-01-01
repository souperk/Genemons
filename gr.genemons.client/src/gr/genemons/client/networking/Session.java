/**
 * 
 */
package gr.genemons.client.networking;

import gr.souperk.utils.events.ActionEvent;

/**
 * The component of the Game that handles the communication with the server.
 * 
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public interface Session
{
	/**
	 * Establishes the connection with the server.
	 * 
	 * @return true only if the connection is established successfully, else
	 *         false.
	 */
	public boolean connect();

	public void sendEvent(ActionEvent event);

	public void update();

}
