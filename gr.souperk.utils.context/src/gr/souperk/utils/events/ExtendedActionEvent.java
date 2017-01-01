/**
 * 
 */
package gr.souperk.utils.events;

/**
 * @author souperk
 *
 */
// TODO rename.
// TODO write javadoc.
public class ExtendedActionEvent<O>
		extends ActionEvent
{

	public final O actionData;

	public ExtendedActionEvent(String name, O actionData)
	{
		super(name);

		this.actionData = actionData;
	}

}
