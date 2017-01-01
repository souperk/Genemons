package gr.genemons.client;

import gr.souperk.games.graphics.AnimationBuilder;
import gr.souperk.games.graphics.SpriteSheet;
import gr.souperk.ui.input.keyboard.CombineKeyBind;
import gr.souperk.ui.input.keyboard.Key;
import gr.souperk.ui.input.keyboard.KeyBind;
import gr.souperk.utils.State;
import gr.souperk.utils.configure.LiveConfigurator;
import gr.souperk.utils.context.Context;
import gr.souperk.utils.context.ContextUtils;
import gr.souperk.utils.context.support.MappedContext;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

/**
 * @author souperk
 * @since 0.1.0
 */
// TODO write javadoc.
public class StartClient
{

	public static void main(String[] args) throws IOException, InterruptedException
	{
		LiveConfigurator conf = new LiveConfigurator();

		SimpleLogger.log("Loading Configuration.");

		/* General settings. */
		conf.set("genemons.client.version", "0.1.0-prealpha");
		conf.set("genemons.client.title", "Genemons : Legends of Adia");

		/* GenemonsClient settings. */
		conf.set("genemons.client.state.init", new State("init"));
		conf.set("genemons.client.state.main-menu", new State("main-menu"));
		conf.set("genemons.client.state.playing", new State("playing"));
		conf.set("genemons.client.state.loading", new State("loading"));
		conf.set("genemons.client.state.saving", new State("saving"));

		/* Main Window. */
		conf.set("genemons.client.ui.main-window.title", "Genemons : Legends of Adia");
		conf.set("genemons.client.ui.main-window.width", 800);
		conf.set("genemons.client.ui.main-window.height", 600);

		/* Main Menu. */
		conf.set("genemons.client.ui.main-menu.background",
				ImageIO.read(new File("resources/gui/main-menu_background.jpg")));

		SimpleLogger.log("Loading Sprites.");
		/* Sprites. */
		configPlayerSprites(conf);
		configPlayerBinds(conf);

		conf.set("client.mapManager", new MapManager());

		conf.set("genemons.client.resources.ui",
				ContextUtils.subcontext("genemons.client.ui.", conf, new MappedContext()));
		conf.set("genemons.client.resources", conf);

		// conf.checkPackage("genemons.client");
		conf.checkPackage("genemons.client.");

		SimpleLogger.log("Finished Configuration.");

		GenemonsClient client = GenemonsClient.getInstance();

		/*
		 * TODO change delegate loop mechanic to an object.
		 */
		while (true)
		{
			client.time = System.currentTimeMillis();
			client.render();
		}
	}

	@Deprecated
	public static void configPlayerBinds(Context ctx)
	{
		List<KeyBind> binds = new ArrayList<>();

		binds.add(new KeyBind("up", KeyEvent.VK_UP, Key.PRESSED));
		binds.add(new KeyBind("down", KeyEvent.VK_DOWN, Key.PRESSED));
		binds.add(new KeyBind("right", KeyEvent.VK_RIGHT, Key.PRESSED));
		binds.add(new KeyBind("left", KeyEvent.VK_LEFT, Key.PRESSED));

		binds.add(new CombineKeyBind("idle", new KeyBind(KeyEvent.VK_UP, Key.RELEASED), new KeyBind(KeyEvent.VK_DOWN,
				Key.RELEASED), new KeyBind(KeyEvent.VK_LEFT, Key.RELEASED),
				new KeyBind(KeyEvent.VK_RIGHT, Key.RELEASED)));

		binds.add(new KeyBind("talk", KeyEvent.VK_SPACE, Key.PRESSED));

		ctx.set("genemons.client.character.binds", binds);
	}

	@Deprecated
	public static void configPlayerSprites(Context ctx) throws IOException
	{
		SpriteSheet sheet = new SpriteSheet("resources/player.png", 32);

		int interval = 200;

		AnimationBuilder upBuilder = new AnimationBuilder(interval);
		upBuilder.addTimestamp(sheet.getSprite(0, 3));
		upBuilder.addTimestamp(sheet.getSprite(1, 3));
		upBuilder.addTimestamp(sheet.getSprite(2, 3));
		upBuilder.addTimestamp(sheet.getSprite(3, 3));

		AnimationBuilder downBuilder = new AnimationBuilder(interval);
		downBuilder.addTimestamp(sheet.getSprite(0, 0));
		downBuilder.addTimestamp(sheet.getSprite(1, 0));
		downBuilder.addTimestamp(sheet.getSprite(2, 0));
		downBuilder.addTimestamp(sheet.getSprite(3, 0));

		AnimationBuilder leftBuilder = new AnimationBuilder(interval);
		leftBuilder.addTimestamp(sheet.getSprite(0, 1));
		leftBuilder.addTimestamp(sheet.getSprite(1, 1));
		leftBuilder.addTimestamp(sheet.getSprite(2, 1));
		leftBuilder.addTimestamp(sheet.getSprite(3, 1));

		AnimationBuilder rightBuilder = new AnimationBuilder(interval);
		rightBuilder.addTimestamp(sheet.getSprite(0, 2));
		rightBuilder.addTimestamp(sheet.getSprite(1, 2));
		rightBuilder.addTimestamp(sheet.getSprite(2, 2));
		rightBuilder.addTimestamp(sheet.getSprite(3, 2));

		AnimationBuilder idleUpBuilder = new AnimationBuilder();
		idleUpBuilder.addTimestamp(sheet.getSprite(0, 3));
		AnimationBuilder idleDownBuilder = new AnimationBuilder();
		idleDownBuilder.addTimestamp(sheet.getSprite(0, 0));
		AnimationBuilder idleRightBuilder = new AnimationBuilder();
		idleRightBuilder.addTimestamp(sheet.getSprite(0, 2));
		AnimationBuilder idleLeftBuilder = new AnimationBuilder();
		idleLeftBuilder.addTimestamp(sheet.getSprite(0, 1));

		ctx.set("genemons.client.entity.player.animation.walking.up", upBuilder.build());
		ctx.set("genemons.client.entity.player.animation.walking.down", downBuilder.build());
		ctx.set("genemons.client.entity.player.animation.walking.right", rightBuilder.build());
		ctx.set("genemons.client.entity.player.animation.walking.left", leftBuilder.build());
		ctx.set("genemons.client.entity.player.animation.idle-up", idleUpBuilder.build());
		ctx.set("genemons.client.entity.player.animation.idle-down", idleDownBuilder.build());
		ctx.set("genemons.client.entity.player.animation.idle-right", idleRightBuilder.build());
		ctx.set("genemons.client.entity.player.animation.idle-left", idleLeftBuilder.build());
	}

}
