package gr.souperk.ui.input;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public interface InputDevice
{
	public void register(InputObserver inputObserver);

	public void unregister(InputObserver inputObserver);
}
