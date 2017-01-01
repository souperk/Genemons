package gr.genemons.server.entity;

import gr.genemons.share.bean.EntityBean;
import gr.genemons.share.bean.WorldBean;
import gr.souperk.utils.State;
import gr.souperk.utils.context.Context;

/**
 * An {@code Entity} object represents a part of the game state. Some example of
 * entities are the time and the mobs of the game.
 * 
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class Entity
{

	private EntityBean bean;

	protected CollisionMask collisionMask;

	public Entity(EntityBean bean)
	{
		this.bean = bean;
	}

	public void update(Context ctx)
	{

	}

	/* Setters and Getters */

	public CollisionMask getCollisionMask()
	{
		return collisionMask;
	}

	protected void setCollisionMask(CollisionMask collisionMask)
	{
		this.collisionMask = collisionMask;
	}

	public String getId()
	{
		return bean.getId();
	}

	public int getX()
	{
		return bean.getX();
	}

	public int getY()
	{
		return bean.getY();
	}

	public WorldBean getWorld()
	{
		return bean.getWorld();
	}

	public State getState()
	{
		return bean.getState();
	}

	public void setX(int x)
	{
		bean.setX(x);
	}

	public void setY(int y)
	{
		bean.setY(y);
	}

	public void setWorld(WorldBean world)
	{
		bean.setWorld(world);
	}

	public void setState(State state)
	{
		bean.setState(state);
	}

}
