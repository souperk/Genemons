package gr.souperk.ui;

import gr.souperk.ui.input.keyboard.KeyObserver;
import gr.souperk.ui.input.keyboard.Keyboard;
import gr.souperk.ui.input.mouse.Mouse;
import gr.souperk.ui.layout.Layout;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public abstract class AbstractWindow
		extends AbstractContainer
		implements Window
{
	protected String title = "";

	protected boolean fullscreen = false;

	protected boolean resizable = false;

	public Mouse mouse;
	public Keyboard keyboard;

	public AbstractWindow()
	{
		super();
	}

	public AbstractWindow(String ID)
	{
		super(ID);
	}

	public AbstractWindow(String ID, String title)
	{
		super(ID);
		setTitle(title);
	}

	public AbstractWindow(Layout layout)
	{
		super(layout);
	}

	public AbstractWindow(String title, Layout layout)
	{
		super(layout);
		setTitle(title);
	}

	public AbstractWindow(String ID, String title, Layout layout)
	{
		super(ID, layout);
		setTitle(title);
	}

	@Override
	public String getTitle()
	{
		return this.title;
	}

	@Override
	public void setTitle(String title)
	{
		this.title = title;
	}

	@Override
	public boolean isResizable()
	{
		return resizable;
	}

	@Override
	public void setResizable(boolean resizable)
	{
		this.resizable = resizable;
	}

	@Override
	public boolean isFullscreen()
	{
		return fullscreen;
	}

	@Override
	public void setFullscreen(boolean fullscreen)
	{
		this.fullscreen = fullscreen;
	}

	@Override
	public void addKeyObserver(KeyObserver keyObserver)
	{
		keyboard.registerKeyObserver(keyObserver);
	}

	@Override
	public void removeKeyObserver(KeyObserver keyObserver)
	{
		keyboard.unregisterKeyObserver(keyObserver);
	}
}
