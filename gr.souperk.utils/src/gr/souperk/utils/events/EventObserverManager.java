package gr.souperk.utils.events;

import java.util.ArrayList;
import java.util.List;

/****
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public class EventObserverManager<E extends Event>
		implements EventObserver<E>
{
	protected List<EventObserver<E>> observers = new ArrayList<>();

	public EventObserverManager()
	{
		this.observers = new ArrayList<>();
	}

	public void triggerEvent(E event)
	{
		for (EventObserver<E> observer : observers)
		{
			observer.triggerEvent(event);
		}
	}

	public void addObserver(EventObserver<E> observer)
	{
		if (observer == null)
		{
			return;
		}
		observers.add(observer);
	}

	public void removeObserver(EventObserver<E> observer)
	{
		observers.remove(observer);
	}

}
