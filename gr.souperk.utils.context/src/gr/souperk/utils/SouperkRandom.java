package gr.souperk.utils;

import java.util.Random;

/**
 * 
 * @author kostas
 *
 */
// TODO write javadoc.
// Maybe rename.
public class SouperkRandom
{
	private static Random random;

	public static String randomString()
	{
		char text[] = new char[getRandom().nextInt(100)];

		for (int i = 0; i < text.length; i++)
		{
			text[i] = (char) getRandom().nextInt(255);
		}

		return new String(text);
	}

	public static double randomDouble()
	{
		return getRandom().nextDouble();
	}

	public static int randomInt()
	{
		return getRandom().nextInt();
	}

	public static int randomInt(int limit)
	{
		return getRandom().nextInt(limit);
	}

	public static Random getRandom()
	{
		if (random == null)
			random = new Random();

		return random;
	}
}
