package gr.genemons.server;

import gr.genemons.server.map.World;
import gr.genemons.share.bean.PlayerBean;
import gr.genemons.share.bean.WorldBean;
import gr.souperk.games.physics.PhysicsUtillity;
import gr.souperk.utils.configure.LiveConfigurator;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class StartServer
{
	/*
	 * TODO create a console for managing server.
	 * 
	 * TODO Make first priority to implement MapManager.
	 */

	public static LiveConfigurator gameContext;

	public static void config() throws IOException
	{

		gameContext = new LiveConfigurator();

		/* Advanced settings. */
		gameContext.set("genemons.server.update-frequency", 25);
		gameContext.set("genemons.server.physics-manager", new PhysicsUtillity());
		gameContext.set("genemons.server.port", 1100);
		gameContext.set("genemons.entity.player.mask", ImageIO.read(new File("resources/player_mask.png")));

		/* Temporary Map */

		WorldBean worldBean = new WorldBean();
		worldBean.setId("First World");;
		gameContext.set("genemons.map.first", new World(worldBean));

		PlayerBean p1 = new PlayerBean();
		p1.setId("kostas");
		p1.setWorld(worldBean);
		p1.setX(0); 
		p1.setY(0);

		gameContext.set("genemons.entity.kostas", p1);
		gameContext.set("genemons.player.kostas", p1);
		gameContext.set("genemons.player.kostas.username", "kostas");
		gameContext.set("genemons.player.kostas.password", "kostas");

		PlayerBean p2 = new PlayerBean();
		p2.setId("souperk");
		p2.setWorld(worldBean);
		p2.setX(100); 
		p2.setY(100);

		gameContext.set("genemons.entity.souperk", p2);
		gameContext.set("genemons.player.souperk", p2);
		gameContext.set("genemons.player.souperk.username", "souperk");
		gameContext.set("genemons.player.souperk.password", "souperk");

		gameContext.checkPackage("genemons.server");

	}

	public static void main(String[] args) throws IOException
	{
		config();

		GenemonsServer server = new GenemonsServer(gameContext.subContext("genemons"));

		server.start();

	}
}
