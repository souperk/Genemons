package gr.souperk.utils.events;

/**
 * @author souperk
 *
 * @param <S>
 *            The source Event Type.
 * @param <T>
 *            The target Event Type.
 */
// TODO write javadoc.
public abstract class EventTranslator<S extends Event, T extends Event>
		implements EventObserver<S>
{
	protected EventObserver<T> observer;

	public EventTranslator(EventObserver<T> observer)
	{
		this.observer = observer;
	}

	public abstract T translate(S event);

	@Override
	public void triggerEvent(S event)
	{
		observer.triggerEvent(translate(event));
	}
}
