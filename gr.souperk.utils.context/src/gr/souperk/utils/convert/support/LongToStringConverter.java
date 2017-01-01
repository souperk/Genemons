package gr.souperk.utils.convert.support;

import gr.souperk.utils.convert.ConvertException;
import gr.souperk.utils.convert.Converter;

/**
 * @author souperk
 *
 */
// TODO write javadoc.
public class LongToStringConverter
		implements Converter
{

	@Override
	public Object convert(Object value, Class<?> targetType)
	{
		if (targetType.isAssignableFrom(Long.class))
			return ((Long) value).toString();
		throw new ConvertException();
	}

}
