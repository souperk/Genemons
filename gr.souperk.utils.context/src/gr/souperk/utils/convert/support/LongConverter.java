package gr.souperk.utils.convert.support;

import gr.souperk.utils.convert.ConvertException;
import gr.souperk.utils.convert.ConvertRegister;

public class LongConverter 
	implements ConvertRegister
{



	@Override
	public Object convert(Object value, Class<?> targetType) 
	{
		if( value == null)
			return null;
		
		if( targetType.isAssignableFrom(Number.class))
			return ((Number)value).longValue();
		
		if( targetType.isAssignableFrom(String.class))
			return Long.valueOf((String )value);
		
		throw new ConvertException();
	}

	@Override
	public Class<?>[] sourceTypes() 
	{
		return new Class[]{ Integer.class, String.class};
	}

	@Override
	public Class<?>[] targetTypes() 
	{
		return new Class[]{ Long.class };
	}


}
