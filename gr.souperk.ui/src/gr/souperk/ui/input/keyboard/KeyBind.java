package gr.souperk.ui.input.keyboard;

import gr.souperk.utils.events.ActionEvent;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public class KeyBind
{

	public final String action;

	public final int keycode;

	public final int status;

	protected boolean active;

	// for combinations
	public KeyBind(int keycode, int status)
	{
		this("bind-activated", keycode, status);
	}

	public KeyBind(String action, int keycode, int status)
	{
		this.action = action;

		this.keycode = keycode;

		this.status = status;

		this.active = status == Key.RELEASED;
	}

	public ActionEvent update(KeyInputEvent keyEvent)
	{
		if (keyEvent.keycode == keycode && keyEvent.status == status)
		{
			active = true;
			return new ActionEvent(action);
		} else if (keyEvent.keycode == keycode)
		{
			active = false;
		}

		return null;
	}

	public boolean isActive()
	{
		return this.active;
	}
}
