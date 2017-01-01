package gr.souperk.utils.events;

/**
 * An {@code Event} is everything worth noticing to the game. (they need senpai
 * to notice them)
 * 
 * @author souperk
 */
// TODO write javadoc.
public class Event
{
	protected boolean dispose = false;

	public boolean isDisposed()
	{
		return this.dispose;
	}

	public void dispose()
	{
		this.dispose = true;
	}

	/**
	 * Compares this event to the specified object. The result is true if and
	 * only if the argument is not null and is of the same class of the event.
	 * 
	 * @param obj
	 *            An Object obj to compare to the Event.
	 * 
	 * @return true if and only if obj is not null and of the same class as
	 *         event else false.
	 */
	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
			return false;

		if (!obj.getClass().equals(this.getClass()))
			return false;

		return true;
	}

	@Override
	public String toString()
	{
		return "[class = " + this.getClass().getName() + "]";
	}

	@Override
	public int hashCode()
	{
		return toString().hashCode();
	}
}
