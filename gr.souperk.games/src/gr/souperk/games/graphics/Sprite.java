package gr.souperk.games.graphics;

import gr.souperk.ui.GraphicsDevice;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public class Sprite
{
	private BufferedImage image;

	public Sprite(int size, int color)
	{
		image = new BufferedImage(size, size, BufferedImage.TYPE_INT_ARGB);
		Graphics g = image.getGraphics();

		g.setColor(new Color(color, true));
		g.fillRect(0, 0, size, size);

		g.dispose();
	}

	public Sprite(String path) throws IOException
	{
		this(new File(path));
	}

	public Sprite(File file) throws IOException
	{
		image = ImageIO.read(file);
	}

	public Sprite(BufferedImage image)
	{
		this.image = image;
	}

	public void render(GraphicsDevice graphics, int x, int y)
	{
		System.out.println(x + ", " + y);
		graphics.drawImage(x, y, image);
	}

	public BufferedImage getImage()
	{
		return image;
	}

	public int getSize()
	{
		return image.getHeight();
	}

	public Animation toAnimation()
	{
		AnimationBuilder animationBuilder = new AnimationBuilder();
		animationBuilder.addTimestamp(this);

		return animationBuilder.build();

	}

}
