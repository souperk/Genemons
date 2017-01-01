package gr.genemons.share.networking;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class Encoder
{
	private ObjectOutputStream outStream;

	public Encoder(OutputStream output) throws IOException
	{
		outStream = new ObjectOutputStream(output);
	}

	public <T extends Serializable> void serialize(Object obj)
	{
		try
		{
			outStream.writeObject(obj);
		} catch (IOException i)
		{
			return ; //TODO manager exception
		}
	}
	
	public void close() throws IOException
	{
		outStream.close();
	}

}
