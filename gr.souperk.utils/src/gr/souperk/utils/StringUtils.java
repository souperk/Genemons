package gr.souperk.utils;

public class StringUtils 
{
	
	
	public static boolean isBlank(final CharSequence cs)
	{
		int length;
		if(cs == null || (length = cs.length()) == 0)
			return true;

		for( int i = 0; i < length; i++)
		{
			if( Character.isWhitespace(cs.charAt(i)) == false)
				return false;
		}
		
		return true;
	}
	
	public static boolean isNotBlank(final CharSequence cs)
	{
		return !isBlank(cs);
	}
}
