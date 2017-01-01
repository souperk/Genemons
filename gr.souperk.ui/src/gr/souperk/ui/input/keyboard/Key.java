package gr.souperk.ui.input.keyboard;

/**
 * {@code Key} represents a key on the keyboard. It contains information as the
 * keycode, the status of the key and the time it is held pressed.
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public class Key
{
	// TODO update lastTime.

	public static final int PRESSED = 1;
	public static final int RELEASED = 2;

	/** The keycode based on the KeyEvent keycodes. */
	public int keycode;

	/**
	 * The absolute value of this is amount of time the key is in the same
	 * phase. If it is positive is means that the key is pressed else if it is
	 * negative it means the key is not pressed.
	 */
	public int status;

	public long lastTime;

	/**
	 * 
	 * @param keycode
	 *            The keycode of the key based on the {@code KeyEvent} keycodes.
	 */
	public Key(Integer keycode)
	{
		this.keycode = keycode;
		this.status = RELEASED;
		this.lastTime = -1;
	}

	/**
	 * Presses the key.
	 */
	public void press()
	{
		status = PRESSED;
	}

	/**
	 * Releases the key.
	 */
	public void release()
	{
		status = RELEASED;
	}

	/**
	 * 
	 * @return whether the key is pressed.
	 */
	public boolean isPressed()
	{
		return status == PRESSED;
	}

}
