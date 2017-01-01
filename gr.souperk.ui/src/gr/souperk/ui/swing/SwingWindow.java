package gr.souperk.ui.swing;

import gr.souperk.ui.AbstractWindow;
import gr.souperk.ui.GraphicsDevice;
import gr.souperk.ui.ImageGraphicsDevice;
import gr.souperk.ui.Window;
import gr.souperk.ui.input.keyboard.KeyObserverMask;
import gr.souperk.ui.input.keyboard.SwingKeyboard;
import gr.souperk.ui.input.mouse.MouseObserverMask;
import gr.souperk.ui.input.mouse.SwingMouse;

import java.awt.Canvas;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JFrame;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public class SwingWindow
		extends AbstractWindow
		implements Window
{
	protected ImageGraphicsDevice screenGraphicsDevice;
	protected ImageGraphicsDevice uiGraphicsDevice;

	protected JFrame frame = new JFrame();
	protected Canvas canvas = new Canvas();

	// TODO create tests for changing size.

	public SwingWindow(String title, int width, int height)
	{
		super();

		setTitle(title);
		setWidth(width);
		setHeight(height);

		keyboard = SwingUtility.getKeyboard();
		keyboard.registerKeyObserver(new KeyObserverMask(this));
		mouse = SwingUtility.getMouse();
		mouse.registerMouseObserver(new MouseObserverMask(this));

		canvas.setSize(width, height);
		canvas.setFocusable(true);
		canvas.addKeyListener((SwingKeyboard) keyboard);
		canvas.addMouseListener((SwingMouse) mouse);
		canvas.addMouseMotionListener((SwingMouse) mouse);

		frame.setResizable(resizable);
		frame.setFocusable(false);
		frame.addKeyListener((SwingKeyboard) keyboard);
		frame.addMouseListener((SwingMouse) mouse);
		frame.addMouseMotionListener((SwingMouse) mouse);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(canvas);

	}

	@Override
	public void setFullscreen(boolean fullscreen)
	{
		super.setFullscreen(fullscreen);

		if (fullscreen)
		{
			frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
			frame.setUndecorated(true);
		} else
		{
			frame.setExtendedState(JFrame.NORMAL);
			frame.setUndecorated(false);
		}
	}

	@Override
	public void setEnable(boolean enable)
	{
		super.setEnable(enable);
		if (enable)
		{
			frame.setVisible(true);
		} else
		{
			frame.setVisible(false);
		}
	}

	@Override
	public void setResizable(boolean resizable)
	{
		super.setResizable(resizable);
		frame.setResizable(resizable);
	}

	/**
	 * Note : The first time called will create the BufferStrategy and from the
	 * second will try to render.
	 */
	@Override
	public void render()
	{
		if (!isEnable())
			return;

		BufferStrategy buffer = canvas.getBufferStrategy();
		if (buffer == null)
		{
			canvas.createBufferStrategy(3);
			return;
		}

		Graphics graphics = buffer.getDrawGraphics();
		uiGraphicsDevice.clear();

		paint(uiGraphicsDevice);

		graphics.clearRect(0, 0, width, height);
		graphics.drawImage(screenGraphicsDevice.image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
		graphics.drawImage(uiGraphicsDevice.image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);

		graphics.dispose();
		buffer.show();

	}

	@Override
	public Window copy(String title)
	{
		Window w = new SwingWindow(title, getHeight(), getWidth());

		w.setX(getX());
		w.setY(getY());

		w.setEnable(frame.isVisible());
		w.setFullscreen(isFullscreen());

		return w;
	}

	@Override
	public void setTitle(String title)
	{
		super.setTitle(title);
		frame.setTitle(title);
	}

	@Override
	public GraphicsDevice getGraphics()
	{
		return screenGraphicsDevice;
	}

	@Override
	public void setX(int x)
	{
		super.setX(x);
		frame.setLocation(x, y);
	}

	@Override
	public void setY(int y)
	{
		super.setY(y);
		frame.setLocation(x, y);
	}

	@Override
	public void setWidth(int width)
	{
		super.setWidth(width);
		frame.setSize(width, height);

		// checks whether both are non negative
		if (width > 0 && height > 0)
		{
			screenGraphicsDevice = new ImageGraphicsDevice(width, height);
			uiGraphicsDevice = new ImageGraphicsDevice(width, height);
			canvas.setSize(width, height);
		}
	}

	@Override
	public void setHeight(int height)
	{
		super.setHeight(height);
		frame.setSize(width, height);

		screenGraphicsDevice = new ImageGraphicsDevice(width, height);
		uiGraphicsDevice = new ImageGraphicsDevice(width, height);
	}
}
