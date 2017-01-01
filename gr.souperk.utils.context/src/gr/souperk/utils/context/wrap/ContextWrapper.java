package gr.souperk.utils.context.wrap;

import gr.souperk.utils.context.Context;
import gr.souperk.utils.context.ROContext;

import java.util.Iterator;

/**
 * @since 0.1.0
 * @author souperk
 *
 */
// TODO write javadoc.
public class ContextWrapper
		implements Context
{
	private Context ctx;

	public ContextWrapper(Context theContext)
	{
		super();
		this.ctx = theContext;
	}

	public <T> T get(String key, Class<T> type)
	{
		return ctx.get(key, type);
	}

	public boolean contains(String key)
	{
		return ctx.contains(key);
	}

	public int count()
	{
		return ctx.count();
	}

	public int count(String key)
	{
		return ctx.count(key);
	}

	public Iterator<String> keyIterator()
	{
		return ctx.keyIterator();
	}

	public Iterator<String> keyIterator(String key)
	{
		return ctx.keyIterator(key);
	}

	public void remove(String key)
	{
		ctx.remove(key);
	}

	public <T> void set(String key, T value)
	{
		ctx.set(key, value);
	}

	public void clear()
	{
		ctx.clear();
	}

	public void clear(String key)
	{
		ctx.clear(key);
	}

	public void subContext(String key, Context otherCtx)
	{
		ctx.subContext(key, otherCtx);
	}

	public void merge(ROContext newCtx)
	{
		ctx.merge(newCtx);
	}

	public void merge(String key, ROContext newCtx)
	{
		ctx.merge(key, newCtx);
	}

	public ROContext asReadOnly()
	{
		return ctx.asReadOnly();
	}

	@Override
	public String getString(String key)
	{
		return ctx.getString(key);
	}

	@Override
	public Integer getInteger(String key)
	{
		return ctx.getInteger(key);
	}

	@Override
	public Double getDouble(String key)
	{
		return ctx.getDouble(key);
	}

	@Override
	public Long getLong(String key)
	{
		return ctx.getLong(key);
	}

	@Override
	public void setString(String key, String str)
	{
		ctx.setString(key, str);
	}

	@Override
	public void setInteger(String key, Integer i)
	{
		ctx.setInteger(key, i);
	}

	@Override
	public void setDouble(String key, Double d)
	{
		ctx.setDouble(key, d);
	}

	@Override
	public void setLong(String key, Long l)
	{
		ctx.setLong(key, l);
	}

	@Override
	public Context subContext(String key)
	{
		return ctx.subContext(key);
	}

}
