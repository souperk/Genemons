/**
 * 
 */
package gr.genemons.share.networking;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

/**
 * @author souperk
 * @since 0.1.0
 *
 */
// TODO write javadoc.
public class Parser
{
	
	/*
	 * TODO Consider combining Parser and Encoder.
	 */

	protected ObjectInputStream inStream;

	public Parser(InputStream input) throws IOException
	{
		inStream = new ObjectInputStream(input);
	}

	public Object deserialize() throws ClassNotFoundException
	{
		Object obj;
		
		try
		{
			obj = inStream.readObject();
		} catch (IOException i)
		{
			return null;
		}

		return obj;

	}

	public <T> T deserialize(Class<T> type) throws ClassNotFoundException
	{
		Object obj = deserialize();

		if (!obj.getClass().equals(type))
		{
			/*
			 * TODO throw exception if Object is not of the right type.
			 */
		}

		return (T) obj;
	}
	
	public void close() throws IOException
	{
		inStream.close();
	}

}
