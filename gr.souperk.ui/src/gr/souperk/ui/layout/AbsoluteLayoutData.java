package gr.souperk.ui.layout;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public class AbsoluteLayoutData
{
	public final int x;
	public final int y;

	public final int width;
	public final int height;

	public final int layer;

	public AbsoluteLayoutData(int width, int height)
	{
		this(0, 0, width, height);
	}

	public AbsoluteLayoutData(int x, int y, int width, int height)
	{
		this(x, y, width, height, 0);
	}

	public AbsoluteLayoutData(int x, int y, int width, int height, int layer)
	{
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.layer = layer;
	}

}
