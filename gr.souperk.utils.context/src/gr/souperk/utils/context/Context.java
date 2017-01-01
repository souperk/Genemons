package gr.souperk.utils.context;

/**
 * A context is an object that stores data along with a key to identify that
 * data. It is practically the same with the map and it is usually implemented
 * with the help of the map pattern. However, a context provides additional
 * functionality.<br>
 * 
 * <br>
 * 
 * 
 * @since 0.1.0
 * @author souperk
 */
// TODO write javadoc.
public interface Context
		extends ROContext
{

	/**
	 * Removes a specific key.
	 * 
	 * @param key
	 *            The key to be removed.
	 */
	public void remove(String key);

	/**
	 * Adds if not already created the key and sets the corresponding value.
	 * 
	 * @param key
	 *            The identification key.
	 * @param value
	 *            the value corresponding to the key.
	 */
	public <T> void set(String key, T value);

	public void setString(String key, String str);

	public void setInteger(String key, Integer i);

	public void setDouble(String key, Double d);

	public void setLong(String key, Long l);

	public void clear();

	/**
	 * Removes all keys that match the key.
	 * 
	 * @param key
	 *            Identifying key to remove elements.
	 */
	public void clear(String key);

	public Context subContext(String key);

	public void subContext(String key, Context otherCtx);

	public void merge(ROContext newCtx);

	public void merge(String key, ROContext newCtx);

	public ROContext asReadOnly();

}
