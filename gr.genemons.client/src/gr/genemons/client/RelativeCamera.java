/**
 * 
 */
package gr.genemons.client;

import gr.genemons.client.entity.Entity;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class RelativeCamera
		extends Camera
{
	protected Entity entity;

	protected int staticXOffset;
	protected int staticYOffset;

	public RelativeCamera(Entity entity, int staticXOffset, int staticYOffset)
	{
		super();

		if (entity == null)
		{
			throw new IllegalArgumentException("entity can't be null.");
		}

		this.entity = entity;
		this.staticXOffset = staticXOffset;
		this.staticYOffset = staticYOffset;
	}

	public int getXOffset()
	{
		return entity.getX() - staticXOffset;
	}

	public int getYOffset()
	{
		return entity.getY() - staticYOffset;
	}

	@Override
	public int translateX(int x)
	{
		return x - getXOffset();
	}

	@Override
	public int translateY(int y)
	{
		return y - getYOffset();
	}

}
