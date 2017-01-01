package gr.souperk.ui.input.keyboard;

import gr.souperk.utils.events.ActionEvent;
import gr.souperk.utils.events.ActionEventObserver;
import gr.souperk.utils.events.EventObserverManager;

import java.util.List;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public class TranslatingKeyObserver
		implements KeyObserver
{

	protected List<KeyBind> binds;
	protected EventObserverManager<ActionEvent> actionObserverManager = new EventObserverManager<>();

	public TranslatingKeyObserver(List<KeyBind> binds, ActionEventObserver... observers)
	{
		this.binds = binds;

		for (ActionEventObserver observer : observers)
			actionObserverManager.addObserver(observer);
	}

	@Override
	public void triggerEvent(KeyInputEvent event)
	{
		if (event == null || event.isDisposed() || !(event instanceof KeyInputEvent))
			return; // nothing to do dead event

		for (KeyBind bind : binds)
		{
			ActionEvent actionEvent = bind.update((KeyInputEvent) event);

			if (actionEvent != null)
			{
				actionObserverManager.triggerEvent(actionEvent);
			}
		}
	}

	public void addActionObserver(ActionEventObserver actionEventObserver)
	{
		actionObserverManager.addObserver(actionEventObserver);
	}

	public void removeActionObserver(ActionEventObserver actionEventObserver)
	{
		actionObserverManager.removeObserver(actionEventObserver);
	}

}
