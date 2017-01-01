package gr.genemons.client.ui;

import gr.genemons.client.GenemonsClient;
import gr.souperk.ui.input.keyboard.Key;
import gr.souperk.ui.input.keyboard.KeyBind;
import gr.souperk.ui.input.keyboard.KeyInputEvent;
import gr.souperk.ui.input.keyboard.KeyObserver;
import gr.souperk.ui.input.keyboard.TranslatingKeyObserver;
import gr.souperk.utils.State;
import gr.souperk.utils.configure.Setting;
import gr.souperk.utils.configure.SettingPriority;
import gr.souperk.utils.context.Context;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class GenemonsKeyObserver
		implements KeyObserver
{
	// TODO what the fuck is this??

	@Setting(key = "genemons.client.state.init.binds", priority = SettingPriority.ERROR)
	public static List<KeyBind> initStateBinds = new ArrayList<>();

	@Setting(key = "genemons.client.state.main-menu.binds", priority = SettingPriority.ERROR)
	public static List<KeyBind> mainMenuStateBinds = new ArrayList<>();

	@Setting(key = "genemons.client.state.loading.binds", priority = SettingPriority.ERROR)
	public static List<KeyBind> loadingStateBinds = new ArrayList<>();

	@Setting(key = "genemons.client.state.playing.binds", priority = SettingPriority.ERROR)
	public static List<KeyBind> playingStateBinds = new ArrayList<>();

	@Setting(key = "genemons.client.state.saving.binds", priority = SettingPriority.ERROR)
	public static List<KeyBind> savingStateBinds = new ArrayList<>();

	@Deprecated
	public static void config(Context ctx)
	{
		List<KeyBind> binds = new ArrayList<>();

		binds.add(new KeyBind("game-menu", KeyEvent.VK_ESCAPE, Key.PRESSED));

		ctx.set("ui.main-window.binds", binds);
	}

	protected KeyObserver initKeyObserver;

	protected KeyObserver mainMenuKeyObserver;

	protected KeyObserver playingKeyObserver;

	protected KeyObserver loadingKeyObserver;

	protected KeyObserver savingKeyObserver;

	protected GenemonsClient client;

	public GenemonsKeyObserver(GenemonsClient client)
	{
		this.client = client;

		this.initKeyObserver = new TranslatingKeyObserver(initStateBinds, client);
		this.mainMenuKeyObserver = new TranslatingKeyObserver(mainMenuStateBinds, client);
		this.loadingKeyObserver = new TranslatingKeyObserver(loadingStateBinds, client);
		this.playingKeyObserver = new TranslatingKeyObserver(playingStateBinds, client);
		this.savingKeyObserver = new TranslatingKeyObserver(savingStateBinds, client);
	}

	@Override
	public void triggerEvent(KeyInputEvent event)
	{
		if (event == null || event.isDisposed())
			return;
		State state = client.getState();

		if (state == GenemonsClient.INIT)
		{
			initKeyObserver.triggerEvent(event);
		} else if (state == GenemonsClient.MAIN_MENU)
		{
			mainMenuKeyObserver.triggerEvent(event);
		} else if (state == GenemonsClient.PLAYING)
		{
			playingKeyObserver.triggerEvent(event);
		} else if (state == GenemonsClient.LOADING)
		{
			loadingKeyObserver.triggerEvent(event);
		} else if (state == GenemonsClient.SAVING)
		{
			savingKeyObserver.triggerEvent(event);
		}
	}
}
