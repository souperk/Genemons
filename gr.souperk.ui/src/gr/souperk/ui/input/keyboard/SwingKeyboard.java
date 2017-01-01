package gr.souperk.ui.input.keyboard;

import gr.souperk.utils.events.EventObserverManager;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public class SwingKeyboard
		implements KeyListener, Keyboard
{
	protected EventObserverManager<KeyInputEvent> keyObserverManager = new EventObserverManager<>();

	protected Key keyList[];

	public SwingKeyboard()
	{
		keyList = new Key[1024];

		for (int i = 1; i < 1024; i++)
		{
			SwingLinuxKey key = new SwingLinuxKey(i);

			key.setObserver(new KeyObserverMask(keyObserverManager));

			keyList[i] = key;
		}
	}

	@Override
	public void keyPressed(KeyEvent e)
	{
		keyList[e.getKeyCode()].press();
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
		keyList[e.getKeyCode()].release();
	}

	@Override
	public void keyTyped(KeyEvent e)
	{

	}

	@Override
	public void registerKeyObserver(KeyObserver keyObserver)
	{
		keyObserverManager.addObserver(keyObserver);
	}

	@Override
	public void unregisterKeyObserver(KeyObserver keyObserver)
	{
		keyObserverManager.removeObserver(keyObserver);
	}
}
