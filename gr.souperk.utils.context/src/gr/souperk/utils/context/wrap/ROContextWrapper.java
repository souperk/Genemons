package gr.souperk.utils.context.wrap;

import gr.souperk.utils.context.ROContext;

import java.util.Iterator;

public class ROContextWrapper 
	implements ROContext
{
	
	private ROContext ctx;
	
	public ROContextWrapper(ROContext theCtx) 
	{
		this.ctx = theCtx;
	}

	@Override
	public <T> T get(String key, Class<T> type) 
	{
		return ctx.get(key, type);
	}

	@Override
	public boolean contains(String key) 
	{
		return ctx.contains(key);
	}

	@Override
	public int count() 
	{
		return ctx.count();
	}

	@Override
	public int count(String key) 
	{
		return ctx.count(key);
	}

	@Override
	public Iterator<String> keyIterator() 
	{
		return ctx.keyIterator();
	}

	@Override
	public Iterator<String> keyIterator(String key) 
	{
		return ctx.keyIterator(key);
	}

	@Override
	public String getString( String key )
	{
		return ctx.getString(key);
	}

	@Override
	public Integer getInteger( String key )
	{
		return ctx.getInteger(key);
	}

	@Override
	public Double getDouble( String key )
	{
		return ctx.getDouble(key);
	}

	@Override
	public Long getLong( String key )
	{
		return ctx.getLong(key);
	}

}
