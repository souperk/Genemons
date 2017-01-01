package gr.souperk.utils.convert;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @author souperk
 *
 */
// TODO create facade on Types.
// TODO write javadoc.
/*
 * Fast documentation :
 * 
 * Keeps a registry of Converters and pairs of source, target types they
 * convert.
 */
public class CnvRegistry
{
	/**
	 * Map with source Class as key and value a Map with target Class as key and
	 * Converter as value.
	 */
	protected Map<Class<?>, Map<Class<?>, Converter>> registry;

	public CnvRegistry()
	{
		init();
	}

	/**
	 * Searches for a way to convert value to targetType.<br>
	 * <br>
	 * Note : this method assumes the graph is already traversed and simply
	 * returns the first result.
	 * 
	 * @param value
	 *            The object to be converted.
	 * @param targetType
	 *            The desired type.
	 * @return if possible an object with the same data as value and Class as
	 *         targetType else throws ConvertException.
	 * 
	 * @throws ConvertException
	 *             if there isn't a Converter that can process source type and
	 *             targetType.
	 */
	@SuppressWarnings("unchecked")
	public <T> T convert(Object value, Class<T> targetType) throws ConvertException
	{
		if (value == null)
			return null;

		Class<?> sourceType = value.getClass();

		if (sourceType.equals(targetType))
		{
			return (T) value;// this is safe.
		} else if (targetType.isAssignableFrom(sourceType)) // for interfaces
		{
			return (T) value; // safe
		}

		Class<?> superTypes[] = Types.superTypes(sourceType);

		for (Class<?> type : superTypes)
		{

			if (registry.containsKey(type))
			{
				return convert(value, type, targetType);
			}
		}

		throw new ConvertException(sourceType, targetType);
	}

	@SuppressWarnings("unchecked")
	public <T> T convert(Object value, Class<?> sourceType, Class<T> targetType) throws ConvertException
	{
		Map<Class<?>, Converter> targetMap = registry.get(sourceType);

		Class<?> superTypes[] = Types.superTypes(targetType);
		for (Class<?> type : superTypes)
		{
			if (targetMap.containsKey(type))
				return (T) targetMap.get(type).convert(value, targetType);
		}
		throw new ConvertException(sourceType, targetType);
	}

	/**
	 * 
	 * @param reg
	 *            The ConverterRegister to register.
	 */
	public void register(ConvertRegister reg)
	{
		if (reg == null)
			return;
		if (reg.sourceTypes() == null || reg.sourceTypes().length == 0)
			return;
		if (reg.targetTypes() == null || reg.targetTypes().length == 0)
			return;

		for (int s = 0; s < reg.sourceTypes().length; s++)
		{
			for (int t = 0; t < reg.targetTypes().length; t++)
			{
				register(reg, reg.sourceTypes()[s], reg.targetTypes()[t]);
			}
		}
	}

	public void register(Converter cnv, Class<?> sourceType, Class<?> targetType)
	{
		Map<Class<?>, Converter> targetMap = null;

		if (!registry.containsKey(sourceType))
		{
			targetMap = new HashMap<Class<?>, Converter>();
			registry.put(sourceType, targetMap);
		}

		targetMap = registry.get(sourceType);
		targetMap.put(targetType, cnv);
	}

	protected void init()
	{
		registry = new HashMap<Class<?>, Map<Class<?>, Converter>>();
	}

	public Map<Class<?>, Map<Class<?>, Converter>> getMap()
	{
		return registry;
	}

}
