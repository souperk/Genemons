package gr.souperk.utils.context.support;

import gr.souperk.utils.context.AbstractROContext;
import gr.souperk.utils.context.ROContext;
import gr.souperk.utils.convert.Types;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * 
 * @since 0.1.0
 * @author souperk
 *
 */
// TODO write javadoc.
public class MappedROContext
		extends AbstractROContext
		implements ROContext
{
	protected Map<String, Object> map = new HashMap<String, Object>();

	public MappedROContext()
	{

	}

	public MappedROContext(Map<String, Object> map)
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
	protected boolean matches(String key, String nKey)
	{
		return nKey.startsWith(key);
	}
}