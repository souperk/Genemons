package gr.souperk.ui;

import java.awt.image.BufferedImage;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public interface GraphicsDevice
{
	// TODO find beter name.
	// This creates a graphics device for the specific rectangle so the
	// sub-component can paint it self as it feels like.
	public GraphicsDevice smaller(int x1, int y1, int x2, int y2);

	public void drawImage(int x, int y, BufferedImage img);

	public void drawImage(int x, int y, int width, int height, BufferedImage img);

	public int getWidth();

	public int getHeight();

	public BufferedImage getImage();

	/**
	 * Shows the content of the Graphics device to Screen and then clears it.
	 * 
	 * @return true if flushed succeeded else false.
	 */
	public boolean flush();

	/**
	 * Clears the content of the GraphicsDevice.
	 */
	public void clear();

	public void clear(int x, int y, int width, int height);

	// TODO think about GraphicsDevice
	/*
	 * It must be the most concrete part of the ui since we can't afford to
	 * change it often.
	 */

}
