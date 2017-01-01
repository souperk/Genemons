package gr.souperk.utils.convert;

/**
 * 
 * @author souperk
 */
public class ConvertException
		extends RuntimeException
{

	private static final long serialVersionUID = -6879038526958146046L;

	public ConvertException()
	{
	}

	public ConvertException(Class<?> source, Class<?> target)
	{
		super("Unable to convert type " + source.getCanonicalName() + " to " + target.getCanonicalName() + ".");
	}

	public ConvertException(String message)
	{
		super(message);
	}

	public ConvertException(Throwable cause)
	{
		super(cause);
	}

	public ConvertException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public ConvertException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
