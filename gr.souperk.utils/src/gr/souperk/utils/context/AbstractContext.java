package gr.souperk.utils.context;

import gr.souperk.utils.context.wrap.DefaultContext;

import java.util.Iterator;

/**
 * 
 * @since 0.1.0
 * @author souperk
 *
 */
// TODO write javadoc.
public abstract class AbstractContext
		extends AbstractROContext
		implements Context
{

	@Override
	public void clear()
	{
		clear(null);
	}

	@Override
	public void clear(String key)
	{
		Iterator<String> it = keyIterator(key);

		while (it.hasNext())
		{
			remove(it.next());
		}
	}

	@Override
	public Context subContext(String key)
	{
		Context ctx = new DefaultContext();
		subContext(key, ctx);

		return ctx;
	}

	@Override
	public void subContext(String key, Context otherCtx)
	{
		Iterator<String> it = keyIterator(key);

		while (it.hasNext())
		{
			String nKey = it.next();

			otherCtx.set(nKey, get(nKey, Object.class));
		}

	}

	@Override
	public void merge(ROContext newCtx)
	{
		merge(null, newCtx);
	}

	@Override
	public void merge(String key, ROContext newCtx)
	{
		Iterator<String> it = newCtx.keyIterator(key);

		while (it.hasNext())
		{
			String nKey = it.next();

			set(nKey, newCtx.get(nKey, Object.class));
		}
	}

	@Override
	public ROContext asReadOnly()
	{
		return this;
	}

	@Override
	public void setString(String key, String str)
	{
		set(key, str);
	}

	@Override
	public void setInteger(String key, Integer i)
	{
		set(key, i);
	}

	@Override
	public void setDouble(String key, Double d)
	{
		set(key, d);
	}

	@Override
	public void setLong(String key, Long l)
	{
		set(key, l);
	}

}
