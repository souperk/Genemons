package gr.souperk.utils.convert.support;

import gr.souperk.utils.convert.ConvertRegister;

public class IntegerConverter 
	implements ConvertRegister
{

	@Override
	public Object convert(Object value, Class<?> targetType) 
	{
		if( value == null)
			return null;
		if( value instanceof Number)
			return ((Number)value).intValue();
		if( value instanceof String)
			return Integer.valueOf((String )value);
		throw new IllegalArgumentException();
	}

	@Override
	public Class<?>[] sourceTypes() 
	{
		return new Class[]{ Long.class, String.class};
	}

	@Override
	public Class<?>[] targetTypes() 
	{
		return new Class[]{ Integer.class};
	}


}
