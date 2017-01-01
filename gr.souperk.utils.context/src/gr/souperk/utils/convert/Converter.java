package gr.souperk.utils.convert;

/**
 * A Converter's job is to convert an Object (source) to another Object (target) with the same data.<br>
 * <br>
 * A Converter can work in three models :
 * <ul>
 * <li>Convert many source types to one target type.</li>
 * <li>Convert one source type to many target.</li>
 * <li>Convert many source types to many target types.</li>
 * </ul>
 * 
 * @since 0.1.0
 * @author souperk
 *
 */
public interface Converter 
{
	/**
	 * This method creates an Object of targetType with exactly the same data as value.
	 * 
	 * @param value The source object.
	 * @param targetType  The desired type.
	 * @return an new Object with the data of value and type of targetType.
	 * 
	 * @throws ConvertException if sourceType or targetType can be processed by the Converter.
	 */
	public Object convert( Object value, Class<?> targetType) throws ConvertException;
}
