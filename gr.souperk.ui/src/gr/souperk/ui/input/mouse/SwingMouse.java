package gr.souperk.ui.input.mouse;

import gr.souperk.utils.events.EventObserverManager;

import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public class SwingMouse
		implements Mouse, MouseInputListener
{
	protected EventObserverManager<MouseInputEvent> iom = new EventObserverManager<>();

	@Override
	public void mouseClicked(MouseEvent e)
	{
	}

	@Override
	public void mousePressed(MouseEvent e)
	{
		iom.triggerEvent(new MouseInputEvent(e.getPoint().x, e.getPoint().y, e.getButton(), Mouse.PRESSED));
	}

	@Override
	public void mouseReleased(MouseEvent e)
	{
		iom.triggerEvent(new MouseInputEvent(e.getPoint().x, e.getPoint().y, e.getButton(), Mouse.RELEASED));
	}

	@Override
	public void mouseEntered(MouseEvent e)
	{
	}

	@Override
	public void mouseExited(MouseEvent e)
	{
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		iom.triggerEvent(new MouseInputEvent(e.getPoint().x, e.getPoint().y, e.getButton(), Mouse.RELEASED));
	}

	@Override
	public void registerMouseObserver(MouseObserver mouseObserver)
	{
		iom.addObserver(mouseObserver);
	}

	@Override
	public void unregisterMouseObserver(MouseObserver mouseObserver)
	{
		iom.removeObserver(mouseObserver);
	}

}
