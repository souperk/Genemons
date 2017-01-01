package gr.souperk.ui.layout;

import gr.souperk.ui.Container;
import gr.souperk.ui.GraphicsDevice;

/**
 * The {@code Layout} is responsible for positioning {@code Component} inside a
 * {@code Container}. Besides the positioning, the rendering is also handled by
 * {@code Layout} for convenience.</br>
 * </br>
 *
 * @author souperk
 *
 */
// TODO write javadoc.
public interface Layout
{
	public void layout(Container container, GraphicsDevice graphics);
}
