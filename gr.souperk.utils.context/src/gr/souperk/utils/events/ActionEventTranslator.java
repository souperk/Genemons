package gr.souperk.utils.events;

import java.util.Map;

/**
 * @author souperk
 *
 */
// TODO write javadoc.
public class ActionEventTranslator
		extends EventTranslator<ActionEvent, ActionEvent>
{
	protected Map<String, String> eventMap;

	public ActionEventTranslator(EventObserver<ActionEvent> observer, Map<String, String> eventMap)
	{
		super(observer);

		this.eventMap = eventMap;
	}

	@Override
	public ActionEvent translate(ActionEvent event)
	{
		if (event == null)
			return null;

		if (!eventMap.containsKey(event.name))
			return null;

		return new ActionEvent(eventMap.get(event.name));
	}

}
