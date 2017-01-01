package gr.souperk.utils.path;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractPath
		implements Path
{
	protected List<String> list = new ArrayList<String>();

	public AbstractPath()
	{
		super();
	}

	public AbstractPath(String pathName)
	{
		super();
		list = parse(pathName);
	}

	public AbstractPath(List<String> theList)
	{
		super();
		for (String part : theList)
			list.add(part);
	}

	protected abstract List<String> parse(String pathName);

	protected abstract Path createPath();

	@Override
	public Path head(int depth)
	{
		return sub(0, depth);
	}

	@Override
	public Path tail(int depth)
	{
		return sub(size() - depth - 1, depth);
	}

	@Override
	public Path sub(int start, int depth)
	{
		Path path = createPath();
		List<String> newList = new ArrayList<String>();
		for (int i = 0; i < depth; i++)
			newList.add(list.get(start + i));
		path.add(newList);
		return path;
	}

	@Override
	public Path reverse()
	{
		List<String> newList = new ArrayList<String>();
		for (int i = size() - 1; i >= 0; i--)
			newList.add(list.get(i));
		Path newPath = createPath();
		newPath.add(newList);
		return newPath;
	}

	@Override
	public int add(List<String> newList)
	{
		return add(size() - 1, newList);
	}

	@Override
	public int add(Path path)
	{
		return add(size() - 1, path);
	}

	@Override
	public int add(String path)
	{
		return add(size() - 1, path);
	}

	@Override
	public int size()
	{
		return list.size();
	}

	@Override
	public Iterator<String> iterator()
	{
		return toList().iterator();
	}

	@Override
	public String get(int level)
	{
		return list.get(level);
	}

	@Override
	public int add(int level, List<String> newList)
	{
		int size = 0;
		for (String part : newList)
			size += add(level + size, part);
		return size;
	}

	@Override
	public int add(int level, Path path)
	{
		list.addAll(level, path.toList());
		return path.size();
	}

	@Override
	public int add(int level, String path)
	{
		List<String> newList = parse(path);
		list.addAll(level, newList);
		return newList.size();
	}

	@Override
	public List<String> toList()
	{
		return list.subList(0, size() - 1);
	}
}
