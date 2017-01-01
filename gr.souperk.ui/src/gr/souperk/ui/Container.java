package gr.souperk.ui;

import java.util.Collection;

import gr.souperk.ui.layout.Layout;

/**
 * @author souperk
 *
 */
// TODO write javadoc.
public interface Container
		extends Component
{
	/*
	 * H idea me to Container einai oti exw ena component pou pernei alla
	 * component. Gia paradeigma ena para8uro.
	 */

	/**
	 * @return A list with the components in the container.
	 */
	// TODO rename this.
	public Collection<Component> getChilds();

	public Layout getLayout();

	public void setLayout(Layout layout);

	public void add(Component component);

	public void remove(Component component);

	public void remove(String ID);

	public boolean contains(String ID);

	public void clear();

	public Component getFocusedComponent();

	public void setFocusedComponent(Component component);
}
