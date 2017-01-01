/**
 * 
 */
package gr.souperk.utils.events;

/**
 * @author souperk
 *
 */
// TODO write javadoc.
public interface Observable<E extends Event>
{

	public void addObserver(EventObserver<E> observer);

	public void removeObserver(EventObserver<E> observer);

}
