package gr.souperk.ui.input.mouse;

import gr.souperk.ui.input.InputEvent;

/**
 * @author souperk
 *
 */
// TODO write javadoc.
public class MouseInputEvent
		extends InputEvent
{

	public final int x;
	public final int y;
	public final int button;
	public final int status;

	public MouseInputEvent(int x, int y, int button, int status)
	{
		this.x = x;
		this.y = y;
		this.button = button;
		this.status = status;
	}

	public boolean isReleased()
	{
		return status == Mouse.RELEASED;
	}

	public boolean isPressed()
	{
		return status == Mouse.PRESSED;
	}

	@Override
	public String toString()
	{
		return "[class = " + this.getClass().getName() + ", button = " + button + ", x = " + x + ", y = " + y + "]";
	}

}
