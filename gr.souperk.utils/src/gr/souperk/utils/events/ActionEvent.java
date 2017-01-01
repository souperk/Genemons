package gr.souperk.utils.events;

import java.io.Serializable;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public class ActionEvent
		extends Event
		implements Serializable
{
	private static final long serialVersionUID = 6630705147906138403L;

	public final String name;

	public ActionEvent(String name)
	{
		super();

		if (name == null)
			throw new IllegalArgumentException("The name of ActionEvent(String name) should not be null.");

		this.name = name;
	}

	@Override
	public boolean equals(Object obj)
	{

		if (obj == null)
			return false;

		if (obj instanceof String)
			return name.equals(obj);

		if (!(obj instanceof ActionEvent))
			return false;

		ActionEvent event = (ActionEvent) obj;

		if (event.name == null && name == null)
			return true;

		return event.name.equals(name);
	}

	@Override
	public String toString()
	{
		return "[class = " + this.getClass().getName() + ", name = " + name + "=";
	}

	@Override
	public int hashCode()
	{
		return name.hashCode();
	}
}
