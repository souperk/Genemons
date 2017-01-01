/**
 * 
 */
package gr.souperk.utils.configure;

import gr.souperk.utils.context.Context;
import gr.souperk.utils.context.ROContext;
import gr.souperk.utils.context.support.MappedContext;

import java.util.Iterator;
import java.util.List;

/**
 * @author souperk
 *
 */
// TODO write javadoc.
public class LiveConfigurator
		implements Context
{

	protected Context ctx;
	protected Configurator configurator;

	public LiveConfigurator()
	{
		this.configurator = new Configurator();
		this.ctx = new MappedContext();
	}

	public LiveConfigurator(Context ctx, Configurator configurator)
	{
		super();
		this.ctx = ctx;
		this.configurator = configurator;
	}

	public void init()
	{
		configurator.init();
	}

	public void check()
	{
		configurator.check();
	}

	public void checkPackage(String packageName)
	{
		configurator.checkPackage(packageName);
	}

	public void configureSetting(String key, Object value)
	{
		configurator.configureSetting(key, value);
	}

	public void configure(ROContext ctx)
	{
		configurator.configure(ctx);
	}

	public void configurePackage(String packageName, ROContext context)
	{
		configurator.configurePackage(packageName, context);
	}

	public <T> T get(String key, Class<T> type)
	{
		return ctx.get(key, type);
	}

	public String getString(String key)
	{
		return ctx.getString(key);
	}

	public Integer getInteger(String key)
	{
		return ctx.getInteger(key);
	}

	public Double getDouble(String key)
	{
		return ctx.getDouble(key);
	}

	public Long getLong(String key)
	{
		return ctx.getLong(key);
	}

	public boolean contains(String key)
	{
		return ctx.contains(key);
	}

	public void remove(String key)
	{
		ctx.remove(key);
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

	public void setString(String key, String str)
	{
		ctx.setString(key, str);
	}

	public void setInteger(String key, Integer i)
	{
		ctx.setInteger(key, i);
	}

	public void setDouble(String key, Double d)
	{
		ctx.setDouble(key, d);
	}

	public void setLong(String key, Long l)
	{
		ctx.setLong(key, l);
	}

	public void clear()
	{
		ctx.clear();
	}

	public void clear(String key)
	{
		ctx.clear(key);
	}

	public Context subContext(String key)
	{
		return ctx.subContext(key);
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

	public <T> void set(String key, T value)
	{
		ctx.set(key, value);
		configurator.configureSetting(key, value);
	}

	public void logKeys()
	{
		configurator.logKeys();
	}

	public void logKeys(String packageName)
	{
		configurator.logKeys(packageName);
	}

	public List<String> keyList()
	{
		return configurator.keyList();
	}
}
