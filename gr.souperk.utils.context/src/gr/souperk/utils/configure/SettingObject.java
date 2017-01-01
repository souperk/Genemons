/**
 * 
 */
package gr.souperk.utils.configure;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.Set;

/**
 * @author souperk
 *
 */
// TODO rename
// TODO write javadoc.
public class SettingObject
{
	protected SettingPriority priority = SettingPriority.INFO;

	public final String key;

	public Set<Field> fields = new HashSet<>();

	public SettingObject(String key)
	{
		this.key = key;
	}

	public SettingObject(String key, SettingPriority priority)
	{
		this.key = key;
		this.priority = priority;
	}

	public SettingPriority getPriority()
	{
		return priority;
	}

	public void setPriority(SettingPriority priority)
	{
		// this.priority is never null because cmp never returns null
		this.priority = this.priority.cmp(priority);
	}
}
