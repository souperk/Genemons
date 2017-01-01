package gr.souperk.ui;

import gr.souperk.ui.input.InputObserver;
import gr.souperk.ui.input.mouse.MouseInputEvent;
import gr.souperk.ui.lookandfeel.LookAndFeel;
import gr.souperk.utils.SouperkRandom;
import gr.souperk.utils.events.ActionEvent;
import gr.souperk.utils.events.ActionEventObserver;
import gr.souperk.utils.events.EventObserverManager;

import java.awt.image.BufferedImage;

/**
 * {@code public abstract class AbstractComponent implements Component} <br>
 * <br>
 * 
 * An abstract implementation of Component interface.
 *
 * @author souperk
 *
 */
// TODO write javadoc.
public abstract class AbstractComponent
		implements Component, InputObserver
{

	/**
	 * The ID of the Component is used for identifying UIEvents. Can be accessed
	 * with the Component.getID:String and can not be changed.
	 */
	public final String ID;

	/**
	 * Whether the Component has been painted. Default value is false and can be
	 * changed only inside the Component.
	 */
	protected boolean valid = false;

	/**
	 * The Component containing this Component. By default the value is null and
	 * changes when the Component is added to another Component.
	 */
	protected Container parent = null;

	/**
	 * Whether the {@code Component} is focused. By default the value is false
	 * and can be changed with the Component.setFocused(boolean focus).
	 */
	protected boolean focus = false;

	/**
	 * Whether the {@code Component} can be focused. By default the value is
	 * false and can be changed with the Component.setFocusable(boolean focus).
	 */
	protected boolean focusable = false;

	/**
	 * Whether the Component is enabled. The default value is false and can be
	 * changed from Component.setEnable(boolean enable).
	 */
	protected boolean enable = false;

	/**
	 * Whether to show Component decoration.The default value is false.
	 */
	protected boolean showDecoration = false;

	/**
	 * The x coordinate of the Component. Used to paint the Component. It is
	 * recommended to be accessed with the appropriate get and set methods.
	 */
	protected int x;

	/**
	 * The y coordinate of the Component. Used to paint the Component. It is
	 * recommended to be accessed with the appropriate get and set methods.
	 */
	protected int y;

	/**
	 * The width of the Component. Used to paint the Component. It is
	 * recommended to be accessed with the appropriate get and set methods.
	 */
	protected int width;

	/**
	 * The height of the Component. Used to paint the Component. It is
	 * recommended to be accessed with the appropriate get and set methods.
	 */
	protected int height;

	/**
	 * The LookAndFeel of the Component.
	 */
	// TODO change to some default variable.
	protected LookAndFeel lookAndFeel = new LookAndFeel();

	/**
	 * An {@code InputObserverManager} for managing {@code InputObserver}s
	 * registered on the {@code Component}
	 */
	protected EventObserverManager<ActionEvent> observerManager = new EventObserverManager<>();

	/**
	 * The cached state of the Component, by default no value is assigned so be
	 * cautious.
	 */
	protected BufferedImage cache;

	/**
	 * Initiates a Component with a random ID.
	 * 
	 */
	public AbstractComponent()
	{
		this(SouperkRandom.randomString());
	}

	/**
	 * Initiates the Component with the specified ID.
	 * 
	 * @param ID
	 *            The ID of the Component. It must be unique else there will be
	 *            no way to distinct UIEvents of the same type.
	 */
	public AbstractComponent(String ID)
	{
		this.ID = ID;
	}

	@Override
	public String getID()
	{
		return ID;
	}

	@Override
	public Container getParent()
	{
		return parent;
	}

	@Override
	public void setParent(Container parent)
	{
		this.parent = parent;
	}

	@Override
	public boolean isFocusable()
	{
		return focusable;
	}

	@Override
	public void setFocusable(boolean focusable)
	{
		this.focusable = focusable;
		invalidate();
	}

	@Override
	public boolean isFocused()
	{
		return focus;
	}

	@Override
	public void setFocused(boolean focus)
	{
		if (!isFocusable())
			return; // TODO may print some debug info

		if (this.focus != focus)
		{
			this.focus = focus;

			if (focus)
			{
				parent.setFocusedComponent(this);
			} else
			{
				parent.setFocusedComponent(null);
			}
		}

	}

	@Override
	public boolean isEnable()
	{
		return enable;
	}

	@Override
	public void setEnable(boolean enable)
	{
		this.enable = enable;
		invalidate();
	}

	@Override
	public void addActionObserver(ActionEventObserver actionObserver)
	{
		observerManager.addObserver(actionObserver);
	}

	@Override
	public void removeActionObserver(ActionEventObserver actionObserver)
	{
		observerManager.removeObserver(actionObserver);
	}

	protected boolean isWithin(MouseInputEvent me)
	{
		if (me.x >= x && me.x <= x + width - 1 && me.y >= y && me.y <= y + height - 1)
		{
			return true;
		}

		return false;
	}

	@Override
	public boolean isValid()
	{
		return valid;
	}

	@Override
	public void invalidate()
	{
		this.valid = false;
		cache = null;

		if (parent != null)
		{
			parent.invalidate();
		}
	}

	@Override
	public void paint(GraphicsDevice graphics)
	{
		if (isValid())
		{
			graphics.drawImage(0, 0, cache);
		} else
		{
			if (getLookAndFeel() != null)
				getLookAndFeel().paint(graphics, (Component) this);
			// repaint(graphics);
			cache = graphics.getImage();
			this.valid = true;
		}
	}

	@Override
	public boolean showDecoration()
	{
		return showDecoration;
	}

	// public abstract void repaint(GraphicsDevice graphics);

	/* Getters and Setters. */

	@Override
	public InputObserver getInputObserver()
	{
		return this;
	}

	@Override
	public int getX()
	{
		return x;
	}

	@Override
	public void setX(int x)
	{
		this.x = x;
		invalidate();
	}

	@Override
	public int getY()
	{
		return y;
	}

	@Override
	public void setY(int y)
	{
		this.y = y;
		invalidate();
	}

	@Override
	public int getWidth()
	{
		return width;
	}

	@Override
	public void setWidth(int width)
	{
		this.width = width;
		invalidate();
	}

	@Override
	public int getHeight()
	{
		return height;
	}

	@Override
	public void setHeight(int height)
	{
		this.height = height;
		invalidate();
	}

	public LookAndFeel getLookAndFeel()
	{
		return lookAndFeel;
	}

	public void setLookAndFeel(LookAndFeel lookAndFeel)
	{
		this.lookAndFeel = lookAndFeel;
		invalidate();
	}
}
