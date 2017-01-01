package gr.souperk.ui;

import gr.souperk.ui.input.InputObserver;
import gr.souperk.utils.events.ActionEventObserver;

/**
 * {@code Component} is the base of the User Interface, representing everything
 * that exists.</br> </br>
 * 
 * For managing different {@code Component} instances, in everyone a unique
 * identifier(ID) is assigned. For purposes of convenience the ID is represented
 * in the form of {@code String}, since it can take human readable form. The ID
 * can be accessed with the getID() method.
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
/*
 * Things to include in the javadoc.
 * 
 * * the parent of the Component.
 * 
 * * how the "enabled" is intended to be used.
 * 
 * * the focus mechanism.
 * 
 * * the validation mechanism..
 * 
 * * the painting mechanism.
 */
public interface Component
{

	/**
	 * A unique identifier used for managing the Component. It can be used for
	 * sorting, mapping, indexing etc Components.
	 * 
	 * @return The ID of the Component.
	 */
	public String getID();

	/**
	 * @return The parent of the Component.
	 */
	public Container getParent();

	/**
	 * Sets the parent of the Component.
	 * 
	 * @param parent
	 *            The new parent.
	 */
	public void setParent(Container parent);

	/**
	 * If the Component is not enabled it will be ignored by it's parent.
	 * 
	 * @return Whether the Component is enabled.
	 */
	public boolean isEnable();

	/**
	 * Sets the Component enabled state.
	 * 
	 * @param enable
	 *            Whether to enable the Component.
	 */
	public void setEnable(boolean enable);

	public boolean isFocusable();

	public void setFocusable(boolean focusable);

	public boolean isFocused();

	public void setFocused(boolean focus);

	public void paint(GraphicsDevice graphics);

	// TODO pay attention on documenting this methods.
	public boolean isValid();

	public void invalidate();

	public boolean showDecoration();

	/* Size and coordinates. */

	public int getX();

	public void setX(int x);

	public int getY();

	public void setY(int y);

	public int getWidth();

	public void setWidth(int width);

	public int getHeight();

	public void setHeight(int height);

	/* Event Observers */

	public void addActionObserver(ActionEventObserver actionObserver);

	public void removeActionObserver(ActionEventObserver actionObserver);

	public InputObserver getInputObserver();

}
