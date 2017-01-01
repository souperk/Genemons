package gr.souperk.games.graphics;

import gr.souperk.games.Timestamp;
import gr.souperk.games.TimestampMap;
import gr.souperk.ui.GraphicsDevice;

/**
 * 
 * author souperk
 *
 */
// TODO write javadoc.
public class Animation
{
	protected TimestampMap map;

	/** The time the animation started. Used to select the sprite to render. */
	protected long startTime = 0;

	/**
	 * Whether the animation should repeat after a the last timestamp or just
	 * continue rendering the last sprite. By default it is set to true.
	 */
	protected boolean repeat = true;

	/**
	 * The duration of the animation. Negative values result to exception and by
	 * default it is set to zero.
	 */
	protected int duration = 0;

	public Animation(TimestampMap map)
	{
		this.map = map;
	}

	public void start(long time)
	{
		this.startTime = time;
	}

	public void stop()
	{
		this.startTime = 0;
	}

	public void animate(GraphicsDevice graphics, int absoluteX, int absoluteY, long time)
	{
		if (startTime < 0)
		{
			return;
		}

		if (startTime == 0)
		{
			start(time);
		}

		long stampTime = (time - startTime);

		if (repeat && duration > 0)
		{
			stampTime %= duration;
		}

		Timestamp stamp = map.getNearest(stampTime);

		if (stamp == null)
		{
			return;
			// TODO yell;
		}

		if (stamp.sprite == null)
		{
			return;
		}

		stamp.sprite.render(graphics, absoluteX + stamp.x, absoluteY + stamp.y);

	}

	public void setRepeat(boolean repeat)
	{
		this.repeat = repeat;
	}

	public void setDuration(int duration)
	{
		this.duration = duration;
	}
}
