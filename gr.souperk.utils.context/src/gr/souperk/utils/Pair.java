package gr.souperk.utils;

/**
 * 
 * @author souperk
 *
 * @param <L>
 * @param <R>
 */
// TODO write javadoc.
public class Pair<L, R>
{
	public final L left;
	public final R right;

	public Pair(L left, R right)
	{
		this.left = left;
		this.right = right;
	}

	public Pair<R, L> reverse()
	{
		return new Pair<R, L>(right, left);
	}
	

	public static <R, L> Pair<R, L> makePair(R left, L right)
	{
		return new Pair<R, L>(left, right);
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((right == null) ? 0 : right.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		@SuppressWarnings("unchecked")
		Pair<L, R> other = (Pair<L, R>) obj;
		if (left == null)
		{
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (right == null)
		{
			if (other.right != null)
				return false;
		} else if (!right.equals(other.right))
			return false;
		return true;
	}
}
