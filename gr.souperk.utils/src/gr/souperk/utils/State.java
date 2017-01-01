package gr.souperk.utils;

import java.io.Serializable;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public class State
	implements Serializable
{
	private static final long serialVersionUID = -8128155722013439542L;
	
	private String name;

	public State(String name)
	{
		this.name = name;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (obj instanceof State && ((State) obj).name.equals(name))
			return true;

		return false;
	}

	@Override
	public int hashCode()
	{
		return name.hashCode();
	}

	@Override
	public String toString()
	{
		return name;
	}

	public String getName()
	{
		return name;
	}

}
