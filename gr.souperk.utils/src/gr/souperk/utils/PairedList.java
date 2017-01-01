package gr.souperk.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class PairedList<L, R>
		implements List<Pair<L, R>>
{

	private List<Pair<L, R>> list;

	public PairedList()
	{
		this.list = new ArrayList<>();
	}

	public void add(int arg0, Pair<L, R> arg1)
	{
		list.add(arg0, arg1);
	}

	public boolean add(L left, R right)
	{
		return add(new Pair<L, R>(left, right));
	}

	public boolean add(Pair<L, R> arg0)
	{
		return list.add(arg0);
	}

	public boolean addAll(Collection<? extends Pair<L, R>> arg0)
	{
		return list.addAll(arg0);
	}

	public boolean addAll(int arg0, Collection<? extends Pair<L, R>> arg1)
	{
		return list.addAll(arg0, arg1);
	}

	public void clear()
	{
		list.clear();
	}

	public boolean contains(Object arg0)
	{
		return list.contains(arg0);
	}

	public boolean containsAll(Collection<?> arg0)
	{
		return list.containsAll(arg0);
	}

	public boolean equals(Object arg0)
	{
		return list.equals(arg0);
	}

	public Pair<L, R> get(int arg0)
	{
		return list.get(arg0);
	}

	public L getLeft(R right)
	{
		for (Pair<L, R> p : list)
		{
			if (p.right.equals(right))
				return p.left;
		}

		return null;
	}

	public R getRight(L left)
	{
		for (Pair<L, R> p : list)
		{
			if (p.left.equals(left))
				return p.right;
		}

		return null;
	}

	public int hashCode()
	{
		return list.hashCode();
	}

	public int indexOf(Object arg0)
	{
		return list.indexOf(arg0);
	}

	public boolean isEmpty()
	{
		return list.isEmpty();
	}

	public Iterator<Pair<L, R>> iterator()
	{
		return list.iterator();
	}

	public int lastIndexOf(Object arg0)
	{
		return list.lastIndexOf(arg0);
	}

	public ListIterator<Pair<L, R>> listIterator()
	{
		return list.listIterator();
	}

	public ListIterator<Pair<L, R>> listIterator(int arg0)
	{
		return list.listIterator(arg0);
	}

	public Pair<L, R> remove(int arg0)
	{
		return list.remove(arg0);
	}

	public boolean remove(Object arg0)
	{
		return list.remove(arg0);
	}

	public boolean removeAll(Collection<?> arg0)
	{
		return list.removeAll(arg0);
	}

	public boolean retainAll(Collection<?> arg0)
	{
		return list.retainAll(arg0);
	}

	public Pair<L, R> set(int arg0, Pair<L, R> arg1)
	{
		return list.set(arg0, arg1);
	}

	public int size()
	{
		return list.size();
	}

	public List<Pair<L, R>> subList(int arg0, int arg1)
	{
		return list.subList(arg0, arg1);
	}

	public Object[] toArray()
	{
		return list.toArray();
	}

	public <T> T[] toArray(T[] arg0)
	{
		return list.toArray(arg0);
	}

	public List<L> leftItems()
	{
		return PairUtils.leftItems(this);
	}

	public List<R> rightItems()
	{
		return PairUtils.rightItems(this);
	}
}
