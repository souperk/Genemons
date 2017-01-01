package gr.souperk.utils.convert;

import gr.souperk.utils.convert.support.AwtColorConverter;
import gr.souperk.utils.convert.support.IntegerConverter;
import gr.souperk.utils.convert.support.LongConverter;
import gr.souperk.utils.convert.support.LongToStringConverter;
import gr.souperk.utils.convert.support.SwtColorConverter;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A utility for converting between types.<br>
 * <br>
 * 
 * Types is mainly a facade for CnvRegistry and CnvLookup.
 * 
 * @author souperk
 *
 */
// TODO finish javadoc.
public class Types
{
	private static CnvLookupRegistry reg;

	/**
	 * Constructs a list with the super class of the {@code type} and it's super
	 * classes.
	 * 
	 * @param type
	 * @return all the super classes of {@code type}
	 */
	public static Class<?>[] superTypes(Class<?> type)
	{
		List<Class<?>> list = new ArrayList<Class<?>>();

		if (type.equals(Object.class)) // no superclasses for empty array.
		{
			return new Class<?>[] {};
		}

		Class<?> superType = type.getSuperclass();
		Class<?>[] superTypes = superTypes(superType);

		list.add(type);
		list.addAll(Arrays.asList(superTypes));

		return list.toArray(new Class<?>[] {});
	}

	public static CnvRegistry getRegistry()
	{
		if (reg == null)
		{
			reg = new CnvLookupRegistry();

			reg.register(new LongConverter());
			reg.register(new AwtColorConverter(), Integer.class, Color.class);
			reg.register(new AwtColorConverter(), Long.class, Color.class);
			reg.register(new SwtColorConverter());
			reg.register(new IntegerConverter());
			reg.register(new LongToStringConverter(), Long.class, String.class);
		}

		return reg;
	}

	public static void register(ConvertRegister cnvRegister)
	{
		getRegistry().register(cnvRegister);
	}

	public static void register(Converter cnv, Class<?> sourceType, Class<?> targetType)
	{
		getRegistry().register(cnv, sourceType, targetType);
	}

	/**
	 * Merely a proxy for CnvRegistry.convert(Object value, Class<T>
	 * targetType).
	 * 
	 * @param value
	 * @param targetType
	 * @return
	 */
	public static <T> T convert(Object value, Class<T> targetType)
	{
		try
		{
			return getRegistry().convert(value, targetType);
		} catch (ConvertException e)
		{
			e.printStackTrace();
			return null;
		}
	}

}
