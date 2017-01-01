package gr.genemons.server.map;

import gr.genemons.server.entity.Entity;
import gr.genemons.share.bean.WorldBean;
import gr.souperk.utils.context.Context;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * World represents a sub-system of the game with (optionally) unique physics.
 * 
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class World
{
	private WorldBean bean;
	
	private List<Entity> entityList;

	public World(WorldBean bean)
	{
		this.bean = bean;
		
		this.entityList = new ArrayList<>();
	}

	public void update(Context ctx)
	{
		Iterator<Entity> it = entityIterator();

		while (it.hasNext())
		{
			Entity entity = it.next();

			entity.update(ctx);
		}
	}

	public boolean collides(Entity entity)
	{
		if (!this.equals(entity.getWorld()))
		{
			// TODO throw an error.
			return false;
		}

		Iterator<Entity> it = entityIterator();
		/*
		 * TODO Create an event for every collision.
		 */
		boolean result = false;

		while (it.hasNext())
		{
			Entity se = it.next();
			if (collide(se, entity))
			{
				result = true;
			}
		}

		return result;
	}

	public boolean collide(Entity e1, Entity e2)
	{
		/*
		 * TODO write a collision detection system.
		 */

		if (e1.equals(e2))
			return false;

		return false;
		// return e1.getCollisionMask().collides(e2.getCollisionMask(),
		// e1.getX() - e2.getX(), e1.getY() - e2.getY());
	}

	public String getId()
	{
		return bean.getId();
	}
	
	public Iterator<Entity> entityIterator()
	{
		if(entityList == null)
			return null; // TODO log unexpected behavior.
		
		return entityList.iterator();
	}

	public boolean add(Entity e)
	{
		if(entityList == null)
			return false; // TODO log unexpected behavior.

		
		e.setWorld(bean);
		
		return entityList.add(e);
	}

	public boolean addAll(Collection<? extends Entity> c)
	{
		if(entityList == null)
			return false; // TODO log unexpected behavior.
		
		boolean result =  false;
		for(Entity e : c)
			result = add(e) || result;
		return result;
	}

	public void clear()
	{
		if(entityList == null)
			return ; // TODO log unexpected behavior.

		entityList.clear();
	}

	public boolean contains(Object o)
	{
		if(entityList == null)
			return false; // TODO log unexpected behavior.
		
		return entityList.contains(o);
	}

	public boolean containsAll(Collection<?> c)
	{
		if(entityList == null)
			return false; // TODO log unexpected behavior.

		return entityList.containsAll(c);
	}

	public boolean isEmpty()
	{
		if(entityList == null)
			return true; // TODO log unexpected behavior.

		return entityList.isEmpty();
	}

	public boolean remove(Object o)
	{
		if(entityList == null)
			return false; // TODO log unexpected behavior.
		
		return entityList.remove(o);
	}

	public boolean removeAll(Collection<?> c)
	{
		if(entityList == null)
			return false; // TODO log unexpected behavior.
		
		return entityList.removeAll(c);
	}

	public boolean retainAll(Collection<?> c)
	{
		if(entityList == null)
			return false; // TODO log unexpected behavior.

		return entityList.retainAll(c);
	}

	public int size()
	{
		if(entityList == null)
			return 0; // TODO log unexpected behavior.

		return entityList.size();
	}

	public Object[] toArray()
	{
		if(entityList == null)
			return null; // TODO log unexpected behavior.
		
		return entityList.toArray();
	}

	public <T> T[] toArray(T[] a)
	{
		if(entityList == null)
			return null; // TODO log unexpected behavior.

		return entityList.toArray(a);
	}

}
