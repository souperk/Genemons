/**
 * 
 */
package gr.genemons.client.networking;

import gr.genemons.client.GenemonsClient;
import gr.genemons.client.entity.Player;
import gr.genemons.share.bean.PlayerBean;
import gr.genemons.share.networking.AuthQuery;
import gr.genemons.share.networking.AuthResponse;
import gr.genemons.share.networking.Serializer;
import gr.genemons.share.networking.WorldQuery;
import gr.souperk.utils.events.ActionEvent;

import java.io.IOException;
import java.net.ConnectException;
import java.net.Socket;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class GenemonsSession
		implements Session
{
	/*
	 * What does this do?
	 * 
	 * It seems it has an instance of the client, a socket and a parser.
	 * 
	 * What is this intended to do?
	 * 
	 * Session should handle the communication with the server and update
	 * periodically the client with any new data.
	 * 
	 * Note :
	 * 
	 * The client has-a Session type of relationship is between client and
	 * Session. Thus, the Session shouldn't need an instance of the client?
	 * However, the flow of data bi-directed meaning the client sends to and
	 * receives from the session, so the need for a client instance.
	 */

	protected GenemonsClient client = GenemonsClient.getInstance();

	protected Socket socket;
	
	protected Serializer serializer;

	protected String address;
	protected int port;
	protected String username;
	protected String password;

	public GenemonsSession(String address, int port, String username, String password)
	{
		super();
		this.address = address;
		this.port = port;
		this.username = username;
		this.password = password;
	}

	@Override
	public boolean connect()
	{
		try
		{
			Socket socket = new Socket(address, port);

			this.socket = socket;
			
			this.serializer = new Serializer(socket);

			serializer.send(new AuthQuery().setUsername(username).setPassword(password));
			
			if (serializer.receive(AuthResponse.class).getStatus() == AuthResponse.SUCCESS)
			{
				PlayerBean playerBean = serializer.receive(PlayerBean.class);

				if (playerBean == null)
				{
					return false;
				}

				Player player = new Player(playerBean);
				client.setCharacter(player);

				return true;
			}

		} catch (ConnectException e)
		{
			e.printStackTrace(); // TODO remove debug.
		} catch (IOException e)
		{
			e.printStackTrace(); // TODO remove debug.
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace(); //TODO remove debug.
		}

		return false;
	}

	@Override
	public void sendEvent(ActionEvent event)
	{
		try
		{
			serializer.send(event);
		} catch (IOException e)
		{
			/* TODO handle exception. */
		}
	}

	@Override
	public void update()
	{
		// TODO Implement
		WorldQuery wq = new WorldQuery().setWorldId(client.getCharacter().getWorld().getId());

		try
		{
			serializer.send(wq);
		} catch (IOException e)
		{
			/* TODO handle exception. */
		}
	}
}
