package gr.souperk.ui;

import gr.souperk.utils.events.ActionEvent;
import gr.souperk.utils.events.ActionEventObserver;

/**
 * @author souperk
 *
 */
// TODO write javadoc.
public class ButtonObserver
		implements ActionEventObserver
{
	public void pressed(ButtonEvent event)
	{

	}

	public void released(ButtonEvent event)
	{

	}

	@Override
	public void triggerEvent(ActionEvent event)
	{
		if (event == null || event.isDisposed())
			return;

		if (!(event instanceof ButtonEvent))
			return;

		ButtonEvent buttonEvent = (ButtonEvent) event;

		if (buttonEvent.buttonState == Button.pressedState)
			pressed(buttonEvent);

		if (buttonEvent.buttonState == Button.normalState)
			released(buttonEvent);
	}
}
