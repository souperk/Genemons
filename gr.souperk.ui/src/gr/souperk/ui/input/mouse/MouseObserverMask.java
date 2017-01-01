package gr.souperk.ui.input.mouse;

import gr.souperk.utils.events.EventObserver;
import gr.souperk.utils.events.ObserverMask;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public class MouseObserverMask
		extends ObserverMask<MouseInputEvent>
		implements MouseObserver
{

	public MouseObserverMask(EventObserver<? super MouseInputEvent> observer)
	{
		super(observer);
	}
}
