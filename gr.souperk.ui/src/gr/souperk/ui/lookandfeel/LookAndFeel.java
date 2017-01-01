package gr.souperk.ui.lookandfeel;

import gr.souperk.ui.Button;
import gr.souperk.ui.Component;
import gr.souperk.ui.Container;
import gr.souperk.ui.GraphicsDevice;
import gr.souperk.ui.Label;
import gr.souperk.ui.Panel;
import gr.souperk.ui.Window;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;

/**
 * A default empty implementation of LookAndFeel.
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public class LookAndFeel
{
	protected Font defaultFont = new Font("Courier New", 1, 18);

	protected Color textColor = Color.BLACK;

	// protected Color backgroundColor = new Color(0xDEDEDE);
	protected Color backgroundColor = Color.WHITE;

	/* Border */
	protected Color borderColor = Color.BLACK;

	protected int borderSize = 2;

	/* Button params. */

	protected float[] hoverBrightness = new float[] { 0.50f, 0.50f, 0.50f, 1.0f };
	protected float[] hoverOffset = new float[] { 0f, 0f, 0f, 0f };

	protected float[] normalBrightness = new float[] { 1.0f, 1.0f, 1.0f, 1.0f };
	protected float[] normalOffset = new float[] { 0f, 0f, 0f, 0f };

	public void paint(GraphicsDevice graphics, Component component)
	{
		BufferedImage image = null;

		if (component instanceof Button)
		{
			image = paintButton((Button) component);
		} else if (component instanceof Label)
		{
			image = paintLabel((Label) component);
		} else if (component instanceof Window)
		{
			image = paintWindow((Window) component);
		} else if (component instanceof Panel)
		{
			image = paintPanel((Panel) component);
		} else if (component instanceof Container)
		{
			image = paintContainer((Container) component);
		}

		graphics.drawImage(component.getX(), component.getY(), image);
	}

	protected BufferedImage paintPanel(Panel panel)
	{
		BufferedImage image = paintContainer(panel);

		return image;

	}

	protected BufferedImage paintWindow(Window window)
	{
		BufferedImage image = paintContainer(window);

		return image;
	}

	protected BufferedImage paintContainer(Container container)
	{
		BufferedImage image = new BufferedImage(container.getWidth(), container.getHeight(),
				BufferedImage.TYPE_INT_ARGB);

		Graphics2D g = image.createGraphics();

		if (container.showDecoration())
			paintBorder(g, container);

		g.dispose();

		return image;
	}

	protected BufferedImage paintButton(Button button)
	{
		BufferedImage image = paintLabel(button);
		Graphics2D g = image.createGraphics();

		if (button.isHover())
		{
			new RescaleOp(hoverBrightness, hoverOffset, null).filter(image, image);
		} else
		{
			new RescaleOp(normalBrightness, normalOffset, null).filter(image, image);
		}

		g.dispose();

		return image;
	}

	protected BufferedImage paintLabel(Label label)
	{
		BufferedImage image = new BufferedImage(label.getWidth(), label.getHeight(), BufferedImage.TYPE_INT_ARGB);

		Graphics2D g = image.createGraphics();

		g.setColor(backgroundColor);
		g.fillRect(0, 0, label.getWidth(), label.getHeight());

		if (label.showDecoration())
			paintBorder(g, label);

		if (label.getText() != null && label.showText())
			paintText(g, label);

		if (label.getImage() != null && label.showImage())
			g.drawImage(label.getImage(), 0, 0, label.getWidth(), label.getHeight(), null);

		g.dispose();

		return image;
	}

	protected void paintBorder(Graphics2D graphics, Component component)
	{
		graphics.setColor(borderColor);

		graphics.fillRect(0, 0, component.getWidth(), borderSize);
		graphics.fillRect(0, 0, borderSize + 1, component.getHeight());
		graphics.fillRect(0, component.getHeight() - borderSize, component.getWidth(), component.getHeight());
		graphics.fillRect(component.getWidth() - borderSize, 0, component.getWidth(), component.getHeight());
	}

	protected void paintText(Graphics2D graphics, Label button)
	{
		graphics.setColor(textColor);
		graphics.setFont(defaultFont);

		FontMetrics fm = graphics.getFontMetrics();
		Rectangle2D r = fm.getStringBounds(button.getText(), graphics);
		int x = (button.getWidth() - (int) r.getWidth()) / 2;
		int y = (button.getHeight() - (int) r.getHeight()) / 2 + fm.getAscent();
		graphics.drawString(button.getText(), x, y);
	}

	/* Getters and Setters. */

	public Color getBackgroundColor()
	{
		return backgroundColor;
	}

	public void setBackgroundColor(Color backgroundColor)
	{
		this.backgroundColor = backgroundColor;
	}

	public Color getBorderColor()
	{
		return borderColor;
	}

	public void setBorderColor(Color borderColor)
	{
		this.borderColor = borderColor;
	}

	public int getBorderSize()
	{
		return borderSize;
	}

	public void setBorderSize(int borderSize)
	{
		this.borderSize = borderSize;
	}

	public Font getDefaultFont()
	{
		return defaultFont;
	}

	public void setDefaultFont(Font defaultFont)
	{
		this.defaultFont = defaultFont;
	}
}
