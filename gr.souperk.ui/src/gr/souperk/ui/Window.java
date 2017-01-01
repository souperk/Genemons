package gr.souperk.ui;

import gr.souperk.ui.input.keyboard.KeyObserver;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public interface Window
		extends Container
{
	public String getTitle();

	public void setTitle(String title);

	public boolean isResizable();

	public void setResizable(boolean resizable);

	public boolean isFullscreen();

	public void setFullscreen(boolean fullscreen);

	public GraphicsDevice getGraphics();

	public void render();

	public Window copy(String title);

	public void addKeyObserver(KeyObserver keyObserver);

	public void removeKeyObserver(KeyObserver keyObserver);
}
