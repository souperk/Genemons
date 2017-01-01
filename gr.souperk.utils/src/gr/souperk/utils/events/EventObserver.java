package gr.souperk.utils.events;

/**
 * @author souperk
 *
 */
// TODO write javadoc.
public interface EventObserver<E extends Event>
{
	public void triggerEvent(E event);
}
