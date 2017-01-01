package gr.souperk.ui.input.keyboard;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public interface Keyboard
{
	public void registerKeyObserver(KeyObserver keyObserver);

	public void unregisterKeyObserver(KeyObserver keyObserver);
}
