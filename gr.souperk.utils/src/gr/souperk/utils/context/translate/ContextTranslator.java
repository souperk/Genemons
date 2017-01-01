package gr.souperk.utils.context.translate;

import gr.souperk.utils.context.Context;
import gr.souperk.utils.context.wrap.ContextWrapper;

/**
 * 
 * @author kostas
 *
 */
// TODO write javadoc.
public abstract class ContextTranslator
		extends ContextWrapper
		implements Context
{
	protected KeyTranslator translator;

	public ContextTranslator(Context ctx)
	{
		this(ctx, new KeyTranslator());
	}

	public ContextTranslator(Context ctx, KeyTranslator translator)
	{
		super(ctx);
		this.translator = translator;
	}

	@Override
	public <T> void set(String key, T value)
	{
		super.set(key, value);
	}

	@Override
	public <T> T get(String key, Class<T> type)
	{
		return super.get(translator.translateKey(key), type);
	}

}
