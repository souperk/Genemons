package gr.souperk.utils.events;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * @author souperk
 *
 */
// TODO write javadoc.
// TODO move.
public class ActionList
		implements List<Action>, ActionEventObserver
{
	protected List<Action> actionList;

	protected Object obj;

	public ActionList(Object obj)
	{
		this(obj, new ArrayList<Action>());
	}

	public ActionList(Object obj, List<Action> actionList)
	{
		this.actionList = actionList;
		this.obj = obj;
	}

	@Override
	public void triggerEvent(ActionEvent event)
	{
		for (Action action : actionList)
		{
			if (action.name.equals(event.name))
				action.perform(obj);
		}
	}

	/* Delegated methods. */

	public boolean add(Action e)
	{
		return actionList.add(e);
	}

	public void add(int index, Action element)
	{
		actionList.add(index, element);
	}

	public boolean addAll(Collection<? extends Action> c)
	{
		return actionList.addAll(c);
	}

	public boolean addAll(int index, Collection<? extends Action> c)
	{
		return actionList.addAll(index, c);
	}

	public void clear()
	{
		actionList.clear();
	}

	public boolean contains(Object o)
	{
		return actionList.contains(o);
	}

	public boolean containsAll(Collection<?> c)
	{
		return actionList.containsAll(c);
	}

	public boolean equals(Object o)
	{
		return actionList.equals(o);
	}

	public Action get(int index)
	{
		return actionList.get(index);
	}

	public int hashCode()
	{
		return actionList.hashCode();
	}

	public int indexOf(Object o)
	{
		return actionList.indexOf(o);
	}

	public boolean isEmpty()
	{
		return actionList.isEmpty();
	}

	public Iterator<Action> iterator()

	{
		return actionList.iterator();
	}

	public int lastIndexOf(Object o)
	{
		return actionList.lastIndexOf(o);
	}

	public ListIterator<Action> listIterator()
	{
		return actionList.listIterator();
	}

	public ListIterator<Action> listIterator(int index)
	{
		return actionList.listIterator(index);
	}

	public Action remove(int index)
	{
		return actionList.remove(index);
	}

	public boolean remove(Object o)
	{
		return actionList.remove(o);
	}

	public boolean removeAll(Collection<?> c)
	{
		return actionList.removeAll(c);
	}

	public boolean retainAll(Collection<?> c)
	{
		return actionList.retainAll(c);
	}

	public Action set(int index, Action element)
	{
		return actionList.set(index, element);
	}

	public int size()
	{
		return actionList.size();
	}

	public List<Action> subList(int fromIndex, int toIndex)
	{
		return actionList.subList(fromIndex, toIndex);
	}

	public Object[] toArray()
	{
		return actionList.toArray();
	}

	public <T> T[] toArray(T[] a)
	{
		return actionList.toArray(a);
	}
}
