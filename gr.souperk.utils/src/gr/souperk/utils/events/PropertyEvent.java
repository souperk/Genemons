package gr.souperk.utils.events;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public class PropertyEvent
		extends Event
{
	/** The bean that contains the changed property. */
	public final Object bean;

	/** The name of the change property. */
	public final String propertyName;

	/** The old value of the property. */
	public final Object oldValue;

	/** The new value of the property. */
	public final Object newValue;

	/**
	 * 
	 * @param bean
	 *            The bean that contains the changed property.
	 * @param propertyName
	 *            The name of the change property.
	 * @param oldValue
	 *            The old value of the property.
	 * @param newValue
	 *            The new value of the property.
	 */
	public PropertyEvent(Object bean, String propertyName, Object oldValue, Object newValue)
	{
		super();
		this.bean = bean;
		this.propertyName = propertyName;
		this.oldValue = oldValue;
		this.newValue = newValue;
	}

}
