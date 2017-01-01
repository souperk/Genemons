package gr.souperk.utils.convert.support;

import gr.souperk.utils.convert.ConvertException;
import gr.souperk.utils.convert.ConvertRegister;


public class SwtColorConverter 
	implements ConvertRegister
{

	@Override
	public Object convert(Object value, Class<?> targetType) 
	{
		throw new ConvertException();
	}

	@Override
	public Class<?>[] sourceTypes() 
	{
		return new Class<?>[]{};
	}

	@Override
	public Class<?>[] targetTypes() 
	{
		return new Class<?>[]{};
	}


}
