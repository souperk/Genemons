package gr.souperk.games.map;

import gr.souperk.games.entity.Entity;
import gr.souperk.games.entity.Identified;

import java.util.Collection;
import java.util.Iterator;

/**
 * 
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class World
		implements Identified, Collection<Entity>
{
	protected String id;

	protected Collection<Entity> coll;

	/**
	 * Constructor of the World.
	 * 
	 * @param id
	 */
	public World(String id)
	{
		this.id = id;
	}

	/* Getters and Setters. */

	@Override
	public String getId()
	{
		return id;
	}

	/* Delegated Methods. */

	@Override
	public boolean add(Entity e)
	{
		return coll.add(e);
	}

	@Override
	public boolean addAll(Collection<? extends Entity> c)
	{
		return coll.addAll(c);
	}

	@Override
	public void clear()
	{
		coll.clear();
	}

	@Override
	public boolean contains(Object o)
	{
		return coll.contains(o);
	}

	@Override
	public boolean containsAll(Collection<?> c)
	{
		return coll.containsAll(c);
	}

	@Override
	public boolean isEmpty()
	{
		return coll.isEmpty();
	}

	@Override
	public Iterator<Entity> iterator()
	{
		return coll.iterator();
	}

	@Override
	public boolean remove(Object o)
	{
		return coll.remove(o);
	}

	@Override
	public boolean removeAll(Collection<?> c)
	{
		return coll.removeAll(c);
	}

	@Override
	public boolean retainAll(Collection<?> c)
	{
		return coll.retainAll(c);
	}

	@Override
	public int size()
	{
		return coll.size();
	}

	@Override
	public Object[] toArray()
	{
		return coll.toArray();
	}

	@Override
	public <T> T[] toArray(T[] a)
	{
		return coll.toArray(a);
	}

}