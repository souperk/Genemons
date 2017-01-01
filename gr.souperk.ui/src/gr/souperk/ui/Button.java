package gr.souperk.ui;

import gr.souperk.ui.input.InputEvent;
import gr.souperk.ui.input.mouse.MouseInputEvent;
import gr.souperk.utils.State;

import java.awt.image.BufferedImage;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
/**
 * @author souperk
 *
 */
public class Button
		extends Label
{
	/*
	 * TODO maybe i need to redesign Button class. Particularly the STATE
	 * mechanism and the paint. However, delay this until the LookAndFeel
	 * mechanism is implemented.
	 */

	public static State normalState = new State("gr.souperk.ui.Button.normal");
	public static State pressedState = new State("gr.souperk.ui.Button.pressed");
	public static State hoverState = new State("gr.souperk.ui.Button.hover");

	protected State state = normalState;

	/**
	 * Initiates the Button with just the text variable and sets the showText
	 * variable to true.
	 * 
	 * @param text
	 *            The text of the Button.
	 */
	public Button(String text)
	{
		this(text, null);
		setShowText(true);
	}

	/**
	 * Initiates the Button with just the image variable and sets the showImage
	 * variable to true.
	 * 
	 * @param image
	 *            The image of the Button.
	 */
	public Button(BufferedImage image)
	{
		this(null, image);
		setShowImage(true);
	}

	/**
	 * Initiates the Button with the text and the image variables. Note that the
	 * showText and showImage variables are not alerted.
	 * 
	 * @param text
	 *            The text of the Button.
	 * @param image
	 *            The image of the Button.
	 */
	public Button(String text, BufferedImage image)
	{
		super();

		setText(text);
		setImage(image);
		setEnable(true);
		setShowDecoration(true);
	}

	/**
	 * Initiates the Button with the text and the image variables. Note that the
	 * showText and showImage variables are not alerted.
	 * 
	 * @param ID
	 *            The ID of the Button.
	 * @param text
	 *            The text of the Button.
	 * @param image
	 *            The image of the Button.
	 */
	public Button(String ID, String text, BufferedImage image)
	{
		super(ID, text, image);

		setEnable(true);
		setShowDecoration(true);
	}

	@Override
	public void triggerEvent(InputEvent event)
	{
		State state = getState();

		if (!isEnable() || event == null || event.isDisposed() || !(event instanceof MouseInputEvent))
			return;

		MouseInputEvent me = (MouseInputEvent) event;

		if (isWithin(me))
		{
			if (me.isPressed())
			{
				event.dispose();

				if (state != pressedState)
					setState(pressedState);

				setFocused(true);
			} else if (me.isReleased())
			{
				event.dispose();
				setState(hoverState);
			}
		} else
		{
			setState(normalState);
		}
	}

	public boolean isPressed()
	{
		return getState() == pressedState;
	}

	public boolean isHover()
	{
		return isPressed() || getState() == hoverState;
	}

	/* Getters and Setters */

	public State getState()
	{
		return this.state;
	}

	protected void setState(State state)
	{
		if (this.state != state)
			invalidate();

		if (state == pressedState && getState() != pressedState)
		{
			observerManager.triggerEvent(new ButtonEvent(getID(), pressedState));
		} else if (getState() == pressedState && state != pressedState)
		{
			observerManager.triggerEvent(new ButtonEvent(getID(), normalState));
		}

		this.state = state;

	}

	@Override
	public boolean isFocusable()
	{
		return false;
	}

	public void setShowDecoration(boolean showDecoration)
	{
		this.showDecoration = showDecoration;
		invalidate();
	}

}
