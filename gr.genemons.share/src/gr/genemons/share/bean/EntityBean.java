package gr.genemons.share.bean;

import java.io.Serializable;

import gr.souperk.utils.State;

/**
 * 
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class EntityBean
		implements Serializable
{
	private static final long serialVersionUID = 1232329867266504829L;

	private String id;

	private int x;
	private int y;

	private WorldBean world;

	private State state;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public int getX()
	{
		return x;
	}

	public void setX(int x)
	{
		this.x = x;
	}

	public int getY()
	{
		return y;
	}

	public void setY(int y)
	{
		this.y = y;
	}

	public WorldBean getWorld()
	{
		return world;
	}

	public void setWorld(WorldBean world)
	{
		this.world = world;
	}

	public State getState()
	{
		return state;
	}

	public void setState(State state)
	{
		this.state = state;
	}
}
