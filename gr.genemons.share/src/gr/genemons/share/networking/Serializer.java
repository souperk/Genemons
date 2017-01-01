package gr.genemons.share.networking;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;

public class Serializer
{
	
	private ObjectInputStream input;
	private ObjectOutputStream output;
	
	private Object discarded;
	
	public Serializer(Socket socket) throws IOException
	{
		input = new ObjectInputStream(socket.getInputStream());
		output = new ObjectOutputStream(socket.getOutputStream());
	}
	
	public <T extends Serializable> void  send(T object) throws IOException
	{
		output.writeObject(object);
	}
	
	public Object receive() throws ClassNotFoundException, IOException
	{
		Object obj;
		
		if(discarded != null)
		{
			obj = discarded;
			discarded = null;
		}else
		{
			obj = input.readObject();
		}
		
		return obj;
	}
	
	@SuppressWarnings("unchecked")
	public <T extends Serializable> T receive(Class<T> type) throws ClassNotFoundException, IOException
	{
		Object obj = receive();
		
		if(type.isAssignableFrom(obj.getClass()))
			return (T)obj;
		
		discarded = obj;
		
		return null;
	}
	
}
