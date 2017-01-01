package gr.souperk.utils.context;

import java.util.Iterator;

/**
 * An Read-Only context.
 * 
 * @since 0.1.0
 * @author souperk
 *
 */
// TODO write javadoc.
public interface ROContext
{
	public <T> T get(String key, Class<T> type);

	public String getString(String key);

	public Integer getInteger(String key);

	public Double getDouble(String key);

	public Long getLong(String key);

	public boolean contains(String key);

	public int count();

	public int count(String key);

	public Iterator<String> keyIterator();

	public Iterator<String> keyIterator(String key);

}
