package gr.genemons.client.entity;

import gr.genemons.client.Camera;
import gr.genemons.client.GenemonsClient;
import gr.genemons.share.bean.EntityBean;
import gr.genemons.share.bean.WorldBean;
import gr.souperk.games.graphics.Animation;
import gr.souperk.ui.GraphicsDevice;
import gr.souperk.utils.State;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public abstract class Entity
{

	/*
	 * What am i actually doing here?
	 * 
	 * Well everything here is pretty bad. So
	 */

	private EntityBean bean;

	public Entity(EntityBean bean)
	{
		if (bean == null)
		{
			throw new IllegalArgumentException("bean argument can not be null.");
		}

		this.bean = bean;
	}

	public void render(GraphicsDevice graphicsDevice, Camera camera)
	{
		Animation anim = getAnimation();

		if (anim == null)
			return;

		int startX = camera.translateX(getX());
		int startY = camera.translateY(getY());

		anim.animate(graphicsDevice, startX, startY, GenemonsClient.getInstance().getTime());
	}

	public abstract Animation getAnimation();

	/* Setters and Getters */

	public EntityBean getBean()
	{
		return bean;
	}

	/*
	 * setBean is protected in order to avoid casting issues.
	 */
	protected void setBean(EntityBean bean)
	{
		this.bean = bean;
	}

	public String getId()
	{
		return bean.getId();
	}

	public State getState()
	{
		return bean.getState();
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
		/*
		 * What is the problem here?
		 */

		return bean.getWorld();
	}

	public EntityBean toBean()
	{
		return bean;
	}

}
