package gr.souperk.utils.events;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public abstract class Action
{

	public final String name;

	public Action(String name)
	{
		this.name = name;
	}

	public abstract void perform(Object obj);

	@Override
	public boolean equals(Object obj)
	{
		if (obj == null)
			return false;

		if (obj instanceof ActionEvent)
			return ((ActionEvent) obj).name.equals(name);

		if (obj instanceof Action)
			return ((Action) obj).name.equals(name);

		return false;
	}

	@Override
	public int hashCode()
	{
		return name.hashCode();
	}
}
