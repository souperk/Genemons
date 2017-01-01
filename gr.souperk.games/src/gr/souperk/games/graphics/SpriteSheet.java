package gr.souperk.games.graphics;

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
public class SpriteSheet
{
	protected BufferedImage sheet;
	protected int size;

	public SpriteSheet(String path, int size) throws IOException
	{
		this(new File(path), size);
	}

	public SpriteSheet(File path, int size) throws IOException
	{
		this.size = size;
		sheet = ImageIO.read(path);
	}

	/**
	 * Creates a new {@code Sprite} with an subImage of the {@code SpriteSheet}
	 * located at x, y coordinates.
	 * 
	 * @param x
	 *            The x coordinate of the {@code Sprite}.
	 * @param y
	 *            the y coordinate of the {@code Sprite}.
	 * @return A {@code Sprite} located on x, y and size of the standard size of
	 *         {@code SpriteSheet}
	 */
	public Sprite getSprite(int x, int y)
	{
		return new Sprite(sheet.getSubimage(x * size, y * size, size, size));
	}
}
