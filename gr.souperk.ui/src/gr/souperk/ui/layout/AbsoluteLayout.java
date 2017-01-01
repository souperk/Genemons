package gr.souperk.ui.layout;

import gr.souperk.ui.Component;
import gr.souperk.ui.Container;
import gr.souperk.ui.GraphicsDevice;
import gr.souperk.ui.ImageGraphicsDevice;

import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author souperk
 *
 */
// TODO write javadoc.
public class AbsoluteLayout
		implements Layout
{
	protected Map<String, AbsoluteLayoutData> idMap = new ConcurrentHashMap<>();;

	public void layoutComponent(Component comp, AbsoluteLayoutData layoutData)
	{
		idMap.put(comp.getID(), layoutData);
	}

	@Override
	public void layout(Container container, GraphicsDevice graphics)
	{

		TreeMap<Integer, GraphicsDevice> layers = new TreeMap<>();

		for (Component comp : container.getChilds())
		{

			AbsoluteLayoutData data = idMap.get(comp.getID());

			if (!layers.containsKey(data.layer))
			{
				layers.put(data.layer, new ImageGraphicsDevice(graphics.getWidth(), graphics.getHeight()));
			}

			comp.setX(data.x);
			comp.setY(data.y);
			comp.setWidth(data.width);
			comp.setHeight(data.height);

			comp.paint(layers.get(data.layer));
		}

		while (!layers.isEmpty())
		{
			int layer = layers.firstKey();
			GraphicsDevice gd = layers.get(layer);

			graphics.drawImage(0, 0, gd.getImage());

			layers.remove(layer);
		}

	}
}
