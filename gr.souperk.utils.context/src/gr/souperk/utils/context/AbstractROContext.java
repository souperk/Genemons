package gr.souperk.utils.context;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * 
 * @since 0.1.0
 * @author souperk
 *
 */
// TODO write javadoc.
public abstract class AbstractROContext
		implements ROContext
{

	protected abstract boolean matches(String key, String nKey);

	@Override
	public boolean contains(String key)
	{
		Iterator<String> it = keyIterator();

		while (it.hasNext())
		{
			String nKey = it.next();

			if (nKey.equals(key))
			{
				return true;
			}
		}

		return false;
	}

	@Override
	public int count()
	{
		return count(null);
	}

	@Override
	public int count(String key)
	{
		Iterator<String> it = keyIterator(key);
		int count = 0;

		while (it.hasNext())
		{
			String nKey = it.next();

			if (matches(key, nKey))
			{
				count++;
			}
		}

		return count;
	}

	@Override
	public Iterator<String> keyIterator(String key)
	{
		Iterator<String> it = keyIterator();

		if (key == null)
		{
			return it;
		}

		Set<String> results = new HashSet<String>();

		while (it.hasNext())
		{
			String nKey = it.next();

			if (matches(key, nKey))
			{
				results.add(nKey);
			}
		}

		return results.iterator();
	}

	@Override
	public String getString(String key)
	{
		return get(key, String.class);
	}

	@Override
	public Integer getInteger(String key)
	{
		return get(key, Integer.class);
	}

	@Override
	public Double getDouble(String key)
	{
		return get(key, Double.class);
	}

	@Override
	public Long getLong(String key)
	{
		return get(key, Long.class);
	}
}
