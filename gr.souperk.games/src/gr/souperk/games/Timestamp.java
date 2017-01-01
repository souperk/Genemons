package gr.souperk.games;

import gr.souperk.games.graphics.Sprite;

/**
 * {@code Timestamp} represents a time of the Animation and contains the
 * appropriate Sprite to render on that time as well as and the relative
 * position to render the sprite.
 * 
 * The relative position of the Sprite is the difference of sprite location and
 * the actual entity location.
 * 
 * @author souperk
 */
public class Timestamp
{
	/** The time to display the time-stamp. */
	public final Long time;

	/** The sprite to render. */
	public final Sprite sprite;

	/** The relative position to render the sprite. */
	public final int x, y;

	/**
	 * 
	 * @param time
	 *            The time to display the time-stamp.
	 * @param sprite
	 *            The Sprite to render.
	 * @param relX
	 *            The relative x coordinate to render the sprite.
	 * 
	 * @param relY
	 *            The relative y coordinate to render the sprite.
	 */
	public Timestamp(Long time, Sprite sprite, int relX, int relY)
	{
		this.time = time;
		this.sprite = sprite;
		this.x = relX;
		this.y = relY;
	}

}
