package gr.souperk.utils.events;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public class ObserverMask<E extends Event>
		implements EventObserver<E>
{

	protected EventObserver<? super E> observer;

	public ObserverMask(EventObserver<? super E> observer)
	{
		this.observer = observer;
	}

	@Override
	public void triggerEvent(E event)
	{
		observer.triggerEvent(event);
	}

}
