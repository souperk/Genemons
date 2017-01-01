package gr.genemons.client.ui;

import gr.genemons.client.GenemonsClient;
import gr.genemons.client.entity.Entity;
import gr.souperk.ui.AbstractComponent;
import gr.souperk.ui.GraphicsDevice;
import gr.souperk.ui.input.InputEvent;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class EntityComponent
		extends AbstractComponent
{
	protected Entity entity;

	/**
	 * Holds the time (in milliseconds) from the last time the component was
	 * updated.<br>
	 * <br>
	 * Default value is -1, and indicate the component has yet to be updated.
	 * 
	 */
	protected long lastUpdateTime = -1;

	public EntityComponent(Entity entity)
	{
		super("" + entity.hashCode());

		this.entity = entity;
	}

	@Override
	public void paint(GraphicsDevice graphics)
	{
		GenemonsClient client = GenemonsClient.getInstance();

		synchronized (entity)
		{
			entity.render(graphics, client.getGameplay().getCamera());
		}

		this.valid = true;
	}

	@Override
	public int getX()
	{
		return entity.getX();
	}

	@Override
	public int getY()
	{
		return entity.getY();
	}

	@Override
	public void triggerEvent(InputEvent event)
	{

	}

	public long getLastUpdateTime()
	{
		return lastUpdateTime;
	}

	public void setLatUpdateTime(long time)
	{
		this.lastUpdateTime = time;
	}

	public Entity getEntity()
	{
		return entity;
	}

	public void setEntity(Entity entity)
	{
		this.entity = entity;
	}

	public String getEntityId()
	{
		return entity.getId();
	}
}
