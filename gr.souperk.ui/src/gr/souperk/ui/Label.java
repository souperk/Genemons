package gr.souperk.ui;

import gr.souperk.ui.input.InputEvent;

import java.awt.image.BufferedImage;

/**
 * @author souperk
 *
 */
// TODO write javadoc.
public class Label
		extends AbstractComponent
{
	protected String text;

	/**
	 * Whether to paint the text, when painting the Button. By the default it is
	 * set to false.
	 */
	protected boolean showText = false;

	protected BufferedImage image;

	/**
	 * Whether to paint the image, when painting the Button. By the default it
	 * is set to false.
	 */
	protected boolean showImage = false;

	public Label()
	{
		super();
	}

	/**
	 * Initiates the Button with just the text variable and sets the showText
	 * variable to true.
	 * 
	 * @param text
	 *            The text of the Button.
	 */
	public Label(String text)
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
	public Label(BufferedImage image)
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
	public Label(String text, BufferedImage image)
	{
		super();

		setText(text);
		setImage(image);
		setEnable(true);
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
	public Label(String ID, String text, BufferedImage image)
	{
		super(ID);

		setText(text);
		setImage(image);
		setEnable(true);
	}

	@Override
	public void triggerEvent(InputEvent event)
	{

	}

	/* Getters and Setters */

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
		invalidate();
	}

	public boolean showText()
	{
		return showText;
	}

	public void setShowText(boolean showText)
	{
		this.showText = showText;
		invalidate();
	}

	public BufferedImage getImage()
	{
		return image;
	}

	public void setImage(BufferedImage image)
	{
		this.image = image;
		invalidate();
	}

	public boolean showImage()
	{
		return showImage;
	}

	public void setShowImage(boolean showImage)
	{
		this.showImage = showImage;
		invalidate();
	}

	public void setShowDecoration(boolean showDecoration)
	{
		this.showDecoration = showDecoration;
		invalidate();
	}

}
