package gr.genemons.client.ui;

import gr.genemons.client.GenemonsClient;
import gr.genemons.client.SimpleLogger;
import gr.genemons.client.entity.Player;
import gr.souperk.ui.input.InputEvent;
import gr.souperk.ui.input.keyboard.KeyBind;
import gr.souperk.ui.input.keyboard.KeyInputEvent;
import gr.souperk.ui.input.keyboard.TranslatingKeyObserver;
import gr.souperk.utils.configure.Setting;

import java.util.List;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class CharacterComponent
		extends EntityComponent
{
	@Setting(key = "genemons.client.character.binds")
	public static List<KeyBind> characterBinds;

	protected TranslatingKeyObserver tko;

	public CharacterComponent(Player entity)
	{
		super(entity);

		tko = new TranslatingKeyObserver(characterBinds);
		tko.addActionObserver(GenemonsClient.getInstance());
	}

	@Override
	public void triggerEvent(InputEvent event)
	{
		SimpleLogger.assertLog(event == null, "CharacterComponent.triggerEvent(InputEvent) : event is null");
		SimpleLogger.assertLog(tko == null, "CharacterComponent.triggerEvent(InputEvent) : tko is null");

		if (event instanceof KeyInputEvent)
			tko.triggerEvent((KeyInputEvent) event);
	}

}
