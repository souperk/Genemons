package gr.souperk.utils.configure;

import gr.souperk.utils.context.ROContext;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

/**
 * 
 * @author souperk
 *
 */
// TODO write javadoc.
// TODO this class needs heavy optimization.
public class Configurator
{

	protected List<String> keyList = new ArrayList<>();
	protected Map<String, SettingObject> settingMap = new HashMap<>();

	protected boolean visited[];

	public Configurator()
	{
		init();
	}

	public void init()
	{
		try
		{
			scanClasspath();
		} catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}

		if (keyList.size() != settingMap.size())
		{
			// TODO report error.
			// Houston, we have a problem.
		}

		visited = new boolean[settingMap.size()];
	}

	public void logKeys()
	{
		logKeys("");
	}

	public void logKeys(String packageName)
	{
		for (String key : keyList)
		{
			if (key.startsWith(packageName))
				System.out.println(key);
		}
	}

	public List<String> keyList()
	{
		return keyList;
	}

	public void check()
	{
		checkPackage("");
	}

	public void checkPackage(String packageName)
	{
		for (int i = 0; i < keyList.size(); i++)
		{
			if (!visited[i] && keyList.get(i).startsWith(packageName))
			{
				SettingObject so = settingMap.get(keyList.get(i));

				if (so.getPriority() == SettingPriority.ERROR)
				{
					System.out.println("ERROR : " + so.key + " not configured.");
				} else if (so.getPriority() == SettingPriority.WARNING)
				{
					System.out.println("WARNING : " + so.key + " not configured.");
				} else if (so.getPriority() == SettingPriority.INFO)
				{
					System.out.println("INFO : " + so.key + " not configured.");
				}

				for (Field field : so.fields)
				{
					System.out.println(field.getDeclaringClass().getName() + " : " + field.getName());
				}
			}
		}
	}

	/**
	 * Scans the classpath of classes containing the @Setting annotation.
	 * 
	 * @throws ClassNotFoundException
	 */
	protected void scanClasspath() throws ClassNotFoundException
	{
		for (Class<?> type : getClasses())
		{
			scanClass(type);
		}
	}

	protected void scanClass(Class<?> type)
	{
		for (Field field : type.getFields())
		{
			scanField(field);
		}
	}

	protected void scanField(Field field)
	{
		if (!field.isAnnotationPresent(Setting.class))
			return;

		if (!Modifier.isStatic(field.getModifiers()))
			return; // TODO maybe log that.

		String key = field.getAnnotation(Setting.class).key();

		SettingObject so = settingMap.get(key);

		if (so == null)
		{
			so = new SettingObject(key);
			settingMap.put(key, so);
			keyList.add(key);
		}

		so.fields.add(field);
		so.setPriority(field.getAnnotation(Setting.class).priority());
	}

	public void configureSetting(String key, Object value)
	{
		if (!settingMap.containsKey(key))
		{
			return;
		}

		for (Field field : settingMap.get(key).fields)
		{
			try
			{
				field.set(null, value);
			} catch (IllegalArgumentException | IllegalAccessException e)
			{
				// TODO log the error.
				e.printStackTrace();
			}
		}

		visited[keyList.indexOf(key)] = true;
	}

	public void configure(ROContext ctx)
	{
		configurePackage("", ctx);
		check();
	}

	/**
	 * Configures all settings that start with packageName.
	 * 
	 * @param packageName
	 * @param context
	 */
	public void configurePackage(String packageName, ROContext context)
	{
		for (String key : keyList)
		{
			if (key.startsWith(packageName))
			{
				if (!context.contains(key))
				{
					// TODO log and maybe throw error.
					/*
					 * Note that null in some cases is the desired value.
					 */
				} else
				{
					configureSetting(key, context.get(key, Object.class));
				}
			}
		}
	}

	public static Set<Class<?>> getClasses() throws ClassNotFoundException
	{
		return getClassesForPackage("");
	}

	public static Set<Class<?>> getClassesForPackage(String pckgname) throws ClassNotFoundException
	{
		ArrayList<File> directories = new ArrayList<File>();
		try
		{
			ClassLoader cld = Thread.currentThread().getContextClassLoader();
			if (cld == null)
			{
				throw new ClassNotFoundException("Can't get class loader.");
			}
			String path = pckgname.replace('.', '/');

			Enumeration<URL> resources = cld.getResources(path);
			while (resources.hasMoreElements())
			{
				directories.add(new File(URLDecoder.decode(resources.nextElement().getPath(), "UTF-8")));
			}
		} catch (NullPointerException x)
		{
			throw new ClassNotFoundException(pckgname
					+ " does not appear to be a valid package (Null pointer exception)");
		} catch (UnsupportedEncodingException encex)
		{
			throw new ClassNotFoundException(pckgname + " does not appear to be a valid package (Unsupported encoding)");
		} catch (IOException ioex)
		{
			throw new ClassNotFoundException("IOException was thrown when trying to get all resources for " + pckgname);
		}

		Set<Class<?>> classes = new HashSet<>();
		for (File directory : directories)
		{
			if (directory.exists())
			{
				String[] files = directory.list();
				for (String file : files)
				{
					if (file.endsWith(".class"))
					{
						try
						{
							classes.add(Class.forName(pckgname + '.' + file.substring(0, file.length() - 6)));
						} catch (NoClassDefFoundError e)
						{
							// do nothing. this class hasn't been found by the
							// loader, and we don't care.
						}
					} else if (file.endsWith(".jar"))
					{
						try
						{
							classes.addAll(getClassesForJar(directory.getPath() + "/" + file));
						} catch (IOException e)
						{
							e.printStackTrace();
						}
					} else
					{
						String tPath = pckgname;
						if (pckgname.length() > 0)
							tPath += ".";

						classes.addAll(getClassesForPackage(tPath + file));
					}
				}
			}
		}
		return classes;
	}

	public static Set<Class<?>> getClassesForJar(String path) throws IOException, ClassNotFoundException
	{
		Set<Class<?>> classes = new HashSet<>();

		JarFile jarFile = new JarFile(path);
		Enumeration<?> e = jarFile.entries();

		URL[] urls = { new URL("jar:file:" + path + "!/") };
		URLClassLoader cl = URLClassLoader.newInstance(urls);

		while (e.hasMoreElements())
		{
			JarEntry je = (JarEntry) e.nextElement();
			if (je.isDirectory() || !je.getName().endsWith(".class"))
			{
				continue;
			}
			// -6 because of .class
			String className = je.getName().substring(0, je.getName().length() - 6);
			className = className.replace('/', '.');
			classes.add(cl.loadClass(className));
		}

		jarFile.close();
		return classes;
	}

}
