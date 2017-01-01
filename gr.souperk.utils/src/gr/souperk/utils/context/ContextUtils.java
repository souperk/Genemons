package gr.souperk.utils.context;

import java.util.Iterator;

import gr.souperk.utils.context.wrap.DefaultContext;

/**
 * @author souperk
 *
 */
// TODO write javadoc.
public class ContextUtils
{
	public static Context subcontext(String key, ROContext ctx)
	{
		return subcontext(key, ctx, new DefaultContext());
	}

	public static Context subcontext(String key, ROContext ctx, Context newCtx)
	{
		Iterator<String> it = ctx.keyIterator(key);

		while (it.hasNext())
		{
			String tKey = it.next();
			newCtx.set(tKey.substring(key.length()), ctx.get(tKey, Object.class));
		}

		return newCtx;
	}
}