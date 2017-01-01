package gr.souperk.ui.input.mouse;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public interface Mouse
{
	public static final int PRESSED = 1;
	public static final int RELEASED = 2;

	public void registerMouseObserver(MouseObserver mouseObserver);

	public void unregisterMouseObserver(MouseObserver mouseObserver);
}
