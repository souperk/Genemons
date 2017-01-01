package gr.souperk.games.graphics;

import gr.souperk.games.Timestamp;
import gr.souperk.games.TimestampMap;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public class AnimationBuilder
{
	protected TimestampMap timestamps;

	protected Animation animation;

	/**
	 * The time difference in milliseconds between time stamps if no time is
	 * specified. Default value is 50 milliseconds.
	 */
	protected int interval = 50;

	protected int duration = 0;

	public AnimationBuilder()
	{
		timestamps = new TimestampMap();
		animation = new Animation(timestamps);
	}

	public AnimationBuilder(int interval)
	{
		timestamps = new TimestampMap();
		animation = new Animation(timestamps);

		setInterval(interval);
	}

	public AnimationBuilder(boolean repeat)
	{
		timestamps = new TimestampMap();
		animation = new Animation(timestamps);

		setRepeat(repeat);
	}

	public AnimationBuilder(int interval, boolean repeat)
	{
		timestamps = new TimestampMap();
		animation = new Animation(timestamps);

		setInterval(interval);
		setRepeat(repeat);
	}

	public void setInterval(int interval)
	{
		this.interval = interval;
	}

	public void addTimestamp(Sprite sprite)
	{
		addTimestamp(sprite, 0, 0);
	}

	public void addTimestamp(Sprite sprite, int relX, int relY)
	{
		if (timestamps.isEmpty())
		{
			addTimestamp(0, sprite, relX, relY);
		} else
		{
			addTimestamp(timestamps.lastKey() + interval, sprite, relX, relY);
		}

		// if (animation.duration == 0)
		// animation.setDuration(interval);
		animation.setDuration(animation.duration + interval);
	}

	public void addTimestamp(long time, Sprite sprite, int relX, int relY)
	{
		addTimestamp(new Timestamp(time, sprite, relX, relY));
	}

	public void addTimestamp(Timestamp timestamp)
	{
		timestamps.put(timestamp);
	}

	public void setRepeat(boolean repeat)
	{
		animation.setRepeat(repeat);
	}

	public Animation build()
	{
		return animation;
	}
}
