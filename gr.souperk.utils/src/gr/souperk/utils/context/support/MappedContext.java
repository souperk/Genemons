package gr.souperk.utils.context.support;

import gr.souperk.utils.context.AbstractContext;
import gr.souperk.utils.context.Context;
import gr.souperk.utils.convert.Types;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * A java.util.Map based implementation of Context.
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public class MappedContext
		extends AbstractContext
		implements Context
{
	private Map<String, Object> map = new HashMap<String, Object>();

	public MappedContext()
	{

	}

	public MappedContext(Map<String, Object> map)
	{
		this.map = map;
	}

	@Override
	public <T> T get(String key, Class<T> type)
	{
		return Types.convert(map.get(key), type);
	}

	@Override
	public Iterator<String> keyIterator()
	{
		return map.keySet().iterator();
	}

	@Override
	public void remove(String key)
	{
		map.remove(map);
	}

	@Override
	public <T> void set(String key, T value)
	{
		map.put(key, value);
	}

	@Override
	public void clear()
	{
		map.clear();
	}

	@Override
	public boolean contains(String key)
	{
		return map.containsKey(key);
	}

	@Override
	protected boolean matches(String key, String nKey)
	{
		return nKey.startsWith(key);
	}

}
