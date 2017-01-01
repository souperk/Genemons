package gr.souperk.utils.convert;

import java.util.ArrayList;
import java.util.List;

/**
 * A {@code ConverterChain} is a chain of {@code Converter}s aiming to convert
 * from one object to another.
 * 
 * @author souperk
 *
 */
public class ConverterChain
		implements Converter
{
	/** The ordered list of {@code Converter}s on the chain. */
	private List<TypedConverter> cnvList = new ArrayList<TypedConverter>();

	/**
	 * An empty constructor.
	 */
	public ConverterChain()
	{

	}

	@Override
	public Object convert(Object value, Class<?> targetType)
	{
		Object target = value;

		for (TypedConverter cnv : cnvList)
		{
			target = cnv.convert(target, null);
		}

		return target;
	}

	/**
	 * Inserts an new {@code Converter} in the chain.
	 * 
	 * @param cnv
	 *            The {@code Converter} to insert.
	 * @param targetType
	 *            The type the {@code Converter} should return.
	 */
	public void add(Converter cnv, Class<?> targetType)
	{
		cnvList.add(new TypedConverter(cnv, targetType));
	}

	// TODO see if i really need this.
	public void reverse()
	{
		List<Converter> newList = new ArrayList<Converter>();
		for (int i = 0; i < cnvList.size(); i++)
		{
			newList.add(cnvList.get(cnvList.size() - 1));
		}
	}

	/**
	 * A simple warper to another {@code Converter}. {@code TypedConverter} is
	 * meant to be used only as a part of a {@code ConverterChain}.
	 * 
	 * @author souperk
	 *
	 */
	public static class TypedConverter
			implements Converter
	{
		Converter cnv;
		Class<?> type;

		public TypedConverter(Converter cnv, Class<?> type)
		{
			super();
			this.cnv = cnv;
			this.type = type;
		}

		@Override
		public Object convert(Object value, Class<?> targetType)
		{
			return cnv.convert(value, type);
		}

	}

	/**
	 * Gives the size of the {@code ConverterChain}
	 * 
	 * @return The size of the chain.
	 */
	public int size()
	{
		return cnvList.size();
	}
}
