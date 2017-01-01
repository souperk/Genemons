package gr.souperk.games.physics;

import gr.souperk.games.entity.Entity;

import java.awt.image.BufferedImage;

/**
 * @author souperk
 * @since 0.0.2
 */
// TODO write javadoc.
public class PhysicsUtillity
{

	public static int distance(Entity e1, Entity e2)
	{
		return distance(e1.getX(), e1.getY(), e2.getX(), e2.getY());
	}

	public static int distance(int x1, int y1, int x2, int y2)
	{
		int A = (x1 - x2);
		int B = (y1 - y2);

		double res = Math.sqrt((A * A) + (B * B));

		return (int) res;
	}

	// TODO write javadoc 3.
	// TODO rename.
	public static boolean cmp(BufferedImage img1, BufferedImage img2, int x, int y)
	{
		if (img1 == null || img2 == null)
			return false;

		int dist1 = distance(0, 0, x, y);
		int dist2 = distance(0, 0, img1.getWidth() + img2.getWidth(), img1.getHeight() + img2.getHeight());

		if (dist1 > dist2)
			return false;

		for (int tx = Math.max(0, x); tx < Math.min(img1.getWidth(), x + img2.getWidth()); tx++)
		{
			for (int ty = Math.max(0, y); ty < Math.min(img1.getHeight(), y + img2.getHeight()); ty++)
			{
				if (img1.getRGB(tx, ty) == 0xFF000000 && img2.getRGB(tx - x, ty - y) == 0xFF000000)
				{
					return true;
				}
			}
		}

		return false;
	}

}
