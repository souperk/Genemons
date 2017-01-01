package gr.souperk.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
public class PairUtils
{

	public static <L, R> List<Pair<L, R>> fillLeft(List<R> list, L l)
	{
		return fillLeft(list, l, new ArrayList<Pair<L, R>>());
	}

	public static <L, R> List<Pair<L, R>> fillLeft(List<R> list, L l, List<Pair<L, R>> temp)
	{
		for (R r : list)
		{
			temp.add(new Pair<L, R>(l, r));
		}

		return temp;
	}

	public static <L, R> List<Pair<L, R>> fillRight(List<L> list, R r)
	{
		return fillRight(list, r, new ArrayList<Pair<L, R>>());
	}

	public static <L, R> List<Pair<L, R>> fillRight(List<L> list, R r, List<Pair<L, R>> temp)
	{
		for (L l : list)
		{
			temp.add(new Pair<L, R>(l, r));
		}

		return temp;
	}

	public static <L, R> List<L> leftItems(List<Pair<L, R>> list)
	{
		return leftItems(list, new ArrayList<L>());
	}

	public static <L, R> List<L> leftItems(List<Pair<L, R>> list, List<L> temp)
	{
		for (Pair<L, R> p : list)
		{
			temp.add(p.left);
		}

		return temp;
	}

	public static <L, R> List<R> rightItems(List<Pair<L, R>> list)
	{
		return rightItems(list, new ArrayList<R>());
	}

	public static <L, R> List<R> rightItems(List<Pair<L, R>> list, List<R> temp)
	{
		for (Pair<L, R> p : list)
		{
			temp.add(p.right);
		}

		return temp;
	}

	public static <L, R> List<Pair<R, L>> reverseList(List<Pair<L, R>> list)
	{
		return reverseList(list, new ArrayList<Pair<R, L>>());
	}

	public static <L, R> List<Pair<R, L>> reverseList(List<Pair<L, R>> list, List<Pair<R, L>> temp)
	{
		for (Pair<L, R> p : list)
		{
			temp.add(p.reverse());
		}

		return temp;
	}

}
