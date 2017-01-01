package gr.souperk.ui;

import java.awt.image.BufferedImage;

/**
 * @author souperk
 *
 */
// TODO write javadoc.
public class GraphicsDevicePointer
		implements GraphicsDevice
{
	// TODO this is wrong...

	protected GraphicsDevice device;

	protected int x, y, width, height;

	public GraphicsDevicePointer(GraphicsDevice device, int x, int y, int width, int height)
	{
		super();
		this.device = device;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public GraphicsDevice smaller(int x1, int y1, int x2, int y2)
	{
		return new GraphicsDevicePointer(this, x1, y1, x2 - x1, y2 - y1);
	}

	@Override
	public void drawImage(int x, int y, BufferedImage img)
	{
		int tX = this.x + x;
		int tY = this.y + y;

		device.drawImage(tX, tY, img.getWidth(), img.getHeight(), img);
	}

	@Override
	public void drawImage(int x, int y, int width, int height, BufferedImage img)
	{
		int tX = this.x + x;
		int tY = this.y + y;
		int tWidth = Math.min(width, this.width);
		int tHeight = Math.min(height, this.height);

		device.drawImage(tX, tY, tWidth, tHeight, img);

	}

	@Override
	public int getWidth()
	{
		return this.width;
	}

	@Override
	public int getHeight()
	{
		return this.height;
	}

	@Override
	public boolean flush()
	{
		return device.flush();
	}

	@Override
	public void clear()
	{
		device.clear(x, y, width, height);
	}

	@Override
	public void clear(int x, int y, int width, int height)
	{
		if (x < 0 || x >= this.width || y < 0 || y >= this.height)
		{
			// TODO yell.
			return;
		}
		int tX = this.x + x;
		int tY = this.y + y;
		int tWidth = Math.min(width, this.width);
		int tHeight = Math.min(height, this.height);
		device.clear(tX, tY, tWidth, tHeight);
	}

	@Override
	public BufferedImage getImage()
	{
		BufferedImage img = device.getImage();

		return img.getSubimage(x, y, width, height);
	}

}
