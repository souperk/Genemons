package gr.genemons.server;

import gr.genemons.server.entity.Player;
import gr.souperk.utils.context.Context;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class PlayerManager
{
	protected Map<String, Player> playerMap;
	protected Map<String, String> passwordMap;

	public PlayerManager()
	{

	}

	public void load(Context resources)
	{
		this.playerMap = new HashMap<>();
		this.passwordMap = new HashMap<>();

		Iterator<String> it = resources.keyIterator("genemons.player");

		while (it.hasNext())
		{
			String key = it.next();

			if (key.substring("genemons.player".length() + 1).contains("."))
				continue;

			Player player = resources.get(key, Player.class);

			String username = resources.getString("genemons.player." + player.getId() + ".username");
			String password = resources.getString("genemons.player." + player.getId() + ".password");

			addPlayer(player, username, password);
		}
	}

	protected void addPlayer(Player player, String username, String password)
	{
		playerMap.put(username, player);
		passwordMap.put(username, password);
	}

	public Player getPlayer(String username, String password)
	{
		if (passwordMap.containsKey(username) && passwordMap.get(username).equals(password))
			return playerMap.get(username);

		return null;
	}
}
