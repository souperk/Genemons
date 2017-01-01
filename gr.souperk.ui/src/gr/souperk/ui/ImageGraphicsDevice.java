package gr.souperk.ui;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

/**
 * @author souperk
 *
 */
// TODO write javadoc.
public class ImageGraphicsDevice
		implements GraphicsDevice
{
	public BufferedImage image;

	public ImageGraphicsDevice(int width, int height)
	{
		image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
	}

	@Override
	public GraphicsDevice smaller(int x1, int y1, int x2, int y2)
	{
		return new GraphicsDevicePointer(this, x1, y1, x2 - x1, y2 - y1);
	}

	@Override
	public void drawImage(int x, int y, BufferedImage img)
	{
		drawImage(x, y, img.getWidth(), img.getHeight(), img);
	}

	@Override
	public void drawImage(int x, int y, int width, int height, BufferedImage img)
	{
		Graphics g = image.getGraphics();

		g.drawImage(img, x, y, width, height, null);

		g.dispose();
	}

	@Override
	public int getWidth()
	{
		return image.getWidth();
	}

	@Override
	public int getHeight()
	{
		return image.getHeight();
	}

	@Override
	public boolean flush()
	{
		return false;
	}

	@Override
	public void clear()
	{
		image = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());
	}

	@Override
	public void clear(int x, int y, int width, int height)
	{
		Graphics g = image.getGraphics();

		g.clearRect(x, y, width, height);

		g.dispose();
	}

	@Override
	public BufferedImage getImage()
	{
		return image;
	}

}
