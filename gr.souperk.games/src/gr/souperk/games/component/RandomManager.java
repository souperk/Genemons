package gr.souperk.games.component;

import java.util.Random;

/**
 * {@code RandomManager} manages the
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public class RandomManager
{
	/**
	 * An instance of {@code RandomManager} for implementing the Singleton
	 * patern.
	 */
	private static RandomManager instance;

	/** An instance of java.util.Random . */
	protected Random random;

	/**
	 * A private constructor to make sure that no other instance is created
	 * except the ones from the within the {@code RandomManager}.
	 */
	private RandomManager()
	{
		random = new Random();
	}

	public static RandomManager getInstance()
	{
		if (instance == null)
		{
			instance = new RandomManager();
		}

		return instance;
	}

	/**
	 * 
	 * @param limit
	 *            The upper limit to the return value.
	 * @return A random integer greater or equal to zero and less or equal to
	 *         limit.
	 */
	public int getInt(int limit)
	{
		return random.nextInt(limit);
	}

	/**
	 * 
	 * @param p
	 *            A probability from zero to one.
	 * @return true if the probability happens else false.
	 */
	public boolean willHappen(double p)
	{
		return random.nextDouble() - p < 0;
	}
}
