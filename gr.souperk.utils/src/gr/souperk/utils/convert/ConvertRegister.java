package gr.souperk.utils.convert;

/**
 * 
 * @author souperk
 *
 */
public interface ConvertRegister
	extends Converter
{
	/**
	 * @return the source types the Converter will accept.
	 */
	public Class<?>[] sourceTypes();
	
	/**
	 * @return the target types the Converter will accept.
	 */
	public Class<?>[] targetTypes();
}
