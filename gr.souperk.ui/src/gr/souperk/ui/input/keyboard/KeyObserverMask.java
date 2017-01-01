package gr.souperk.ui.input.keyboard;

import gr.souperk.utils.events.EventObserver;
import gr.souperk.utils.events.ObserverMask;

/**
 * 
 * @author souperk
 *
 */
public class KeyObserverMask
		extends ObserverMask<KeyInputEvent>
		implements KeyObserver
{

	public KeyObserverMask(EventObserver<? super KeyInputEvent> observer)
	{
		super(observer);
	}

}
