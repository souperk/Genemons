package gr.souperk.utils.convert;

/**
 * 
 * @author souperk
 *
 */
public class CnvLookupRegistry
	extends CnvRegistry
{
	public CnvLookupRegistry()
	{
		init();

		lookup();
	}

	public void lookup()
	{
		CnvLookup lookup = new CnvLookup(getMap());

		lookup.lookup();

		registry = lookup.getMap();
	}

	@Override
	public void register( Converter cnv, Class<?> sourceType, Class<?> targetType )
	{
		super.register(cnv, sourceType, targetType);
		lookup();
	}

	@Override
	public void register( ConvertRegister reg )
	{
		super.register(reg);
		lookup();
	}

}
