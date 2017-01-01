package gr.souperk.utils.convert.support;

import gr.souperk.utils.convert.Converter;

import java.awt.Color;

/**
 * Implementation of Converter.
 * 
 * @author stathis
 *
 */
public class AwtColorConverter 
	implements Converter
{


	@Override
	public Object convert(Object value, Class<?> targetType) 
	{
		if( targetType.isAssignableFrom( Integer.class))
			return new Color((Integer)value);
		if( targetType.isAssignableFrom( Long.class))
			return new Color(((Long)value).intValue());
		
		throw new IllegalArgumentException();
	}


}
