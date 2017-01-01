package gr.souperk.ui.input.keyboard;

import gr.souperk.ui.input.InputEvent;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public class KeyInputEvent
		extends InputEvent
{
	public final int keycode;
	public final int status;

	public KeyInputEvent(int keycode, int status)
	{
		this.keycode = keycode;
		this.status = status;
	}

	@Override
	public String toString()
	{
		String sStatus = "";

		switch (status)
		{
		case Key.PRESSED:
			sStatus = "PRESSED";
			break;
		case Key.RELEASED:
			sStatus = "RELEASED";
			break;

		}

		return "[class = " + this.getClass().getName() + ", keycode = " + keycode + ", status = " + sStatus + "]";
	}

}
