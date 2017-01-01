/**
 * 
 */
package gr.genemons.client;

/**
 * Temporary utility class for debugging.
 * 
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class SimpleLogger
{
	public static boolean enabledLog = true;
	public static boolean enabledInfo = false;

	public static void assertLog(boolean condition, String message)
	{
		if (enabledLog && condition)
		{
			System.out.println(message);
		}
	}

	public static void log(String message)
	{
		assertLog(true, message);
	}

	public static void assertInfo(boolean condition, String message)
	{
		if (enabledInfo && condition)
		{
			System.out.println(message);
		}
	}

	public static void info(String message)
	{
		assertInfo(true, message);
	}

}
