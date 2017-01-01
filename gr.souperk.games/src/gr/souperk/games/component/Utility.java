package gr.souperk.games.component;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public class Utility
{

	public static long time;

	public static long getTime()
	{
		return getNanoTime() / 1000;
	}

	public static long getNanoTime()
	{
		if (time == 0)
			updateTime();

		return time;
	}

	public static void updateTime()
	{
		time = System.nanoTime();
	}

	public static int getRandomInt(int limit)
	{
		return RandomManager.getInstance().getInt(limit);
	}

	public static <T> boolean isContained(T value, T[] args)
	{
		for (T t : args)
		{
			if (t.equals(value))
				return true;
		}

		return false;
	}

}
