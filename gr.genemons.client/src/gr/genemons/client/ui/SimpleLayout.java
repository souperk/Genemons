package gr.genemons.client.ui;

import gr.souperk.ui.Component;
import gr.souperk.ui.Container;
import gr.souperk.ui.GraphicsDevice;
import gr.souperk.ui.layout.Layout;

/**
 * SimpleL layout that lets components decide their locations.
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
// TODO move to gr.souperk.ui
public class SimpleLayout
		implements Layout
{
	@Override
	public void layout(Container container, GraphicsDevice graphics)
	{
		for (Component comp : container.getChilds())
		{
			comp.paint(graphics);
		}
	}
}
