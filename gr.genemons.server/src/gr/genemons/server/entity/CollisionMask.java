/**
 * 
 */
package gr.genemons.server.entity;

import java.awt.image.BufferedImage;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public interface CollisionMask
{
	public boolean collides(CollisionMask mask, int relX, int relY);

	public boolean getPoint(int x, int y);

	public BufferedImage toImage();
}
