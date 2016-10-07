package client;

import java.awt.List;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;
import java.util.Set;

import javax.swing.SwingUtilities;

import Model.Automobile;

public class CarModelOptionsIO {
	 private ObjectOutputStream out;
	 private ObjectInputStream in;
	 private Socket socket;
	 private Properties properties;
	 private ServerSocket server;
	 private boolean boo = false;
	 // Instance to hold the automobile from the server 
	 private  Automobile auto_Ford;
	 private  Automobile auto_Benz;
	 private ArrayList  ListofModels;
	 public CarModelOptionsIO ()
	 {
		
	 }
public void connectToServer ()
{
	try {
		socket = new Socket (InetAddress.getByName("127.0.0.1"), 6789);
	} catch (UnknownHostException e) {
	
		e.printStackTrace();
	} catch (IOException e) {

		e.printStackTrace();
	}
}
public void setUpStreams ()
{
	try {
		out = new ObjectOutputStream (socket.getOutputStream());
		out.flush();
		in = new ObjectInputStream(socket.getInputStream());
	} catch (IOException e) {
	
		e.printStackTrace();
	}
	
}
public void createPropertiesObject (String filename)
{
	properties = new Properties ();
	try {
		FileInputStream in = new FileInputStream (filename);
		try {
			properties.load(in);
			
			out.writeObject(properties);
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {

		e.printStackTrace();
	}
	try {
		String message = (String)in.readObject();
		System.out.println(message);
	
	} catch (ClassNotFoundException e) {
	
		e.printStackTrace();
	} catch (IOException e) {
	
		e.printStackTrace();
	}
}
public synchronized void requestListOfAutomobiles (String filename)
{
	Properties property = new Properties ();
	try {
		FileInputStream in = new FileInputStream (filename);
		try {
			property.load(in);
			
			out.writeObject(property);
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {

		e.printStackTrace();
	}
	try {
		 ListofModels = (ArrayList)in.readObject();
		System.out.println("Here is the list of available types of automobiles, choose the one you want to configure");
		for (int i =0; i< ListofModels.size(); i++)
		{
			
			System.out.println( ListofModels.get(i));
		}
		
	
		
	
	} catch (ClassNotFoundException e) {
	
		e.printStackTrace();
	} catch (IOException e) {
	
		e.printStackTrace();
	}
}
public void getSelectedAutomobile (String filename)
{
	
	Properties property1 = new Properties ();
	try {
		FileInputStream in = new FileInputStream (filename);
		try {
			property1.load(in);
			out.writeObject(property1);
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {

		e.printStackTrace();
	}
	try {
		 auto_Ford = (Automobile)in.readObject();
		 //auto_Ford.print();
	
	} catch (ClassNotFoundException e) {
	
		e.printStackTrace();
	} catch (IOException e) {
	
		e.printStackTrace();
	}
	
}
public void getSelectedAutomobile_ (String filename)
{
	
	Properties property1 = new Properties ();
	try {
		FileInputStream in = new FileInputStream (filename);
		try {
			property1.load(in);
			out.writeObject(property1);
		
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	} catch (FileNotFoundException e) {

		e.printStackTrace();
	}
	try {
		 auto_Benz = (Automobile)in.readObject();
		 //auto_Benz.print();
		 
		 
	
	} catch (ClassNotFoundException e) {
	
		e.printStackTrace();
	} catch (IOException e) {
	
		e.printStackTrace();
	}
	
}
public void closeConnection ()
{
	try {
		out.close();
		in.close();
		socket.close();
	} catch (IOException e) {
		
		e.printStackTrace();
	}
}
public void showMenu ()
{
	
	
	System.out.println("Press F to upload a properties file");
	System.out.println("Then after Press Q to configure a car");
	System.out.println("Press D to delete a model");
	System.out.println("Press P to update a model");
	BufferedReader input = new BufferedReader(new InputStreamReader (System.in));
	String userInput = null;
	try {
		userInput = input.readLine();
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	if (userInput.equals("P"))
	{
		System.out.println("Enter the name of the model you want to update");
		BufferedReader input1 = new BufferedReader(new InputStreamReader (System.in));
		String userInput1 = null;
		String userInput2 = null;
		try {
			userInput1 = input1.readLine();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		System.out.println("Enter the new price");
		try {
			userInput2 = input1.readLine();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		Properties property1 = new Properties ();
		property1.put("ChangedModel", userInput1);
		property1.put("New Price", userInput2);
		connectToServer();
    	setUpStreams();
    	try {
			out.writeObject(property1);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
    	 closeConnection ();
	}
	if (userInput.equals("D"))
	{
		System.out.println("Enter the name of the model you want to delete");
		BufferedReader input1 = new BufferedReader(new InputStreamReader (System.in));
		String userInput1 = null;
		try {
			userInput1 = input.readLine();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		Properties property1 = new Properties ();
		property1.put("DeleteModel", userInput1);
		connectToServer();
    	setUpStreams();
    	try {
			out.writeObject(property1);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
    	 closeConnection ();
	}
    if (userInput.equals("F"))
	{
    	
    	connectToServer();
    	setUpStreams();
		System.out.println("Enter a path to a properties file");
	    String filename = null;
		try {
			filename = input.readLine();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	   createPropertiesObject(filename);
	   closeConnection ();
	}
    
    
	if(userInput.equals("Q"))
	{
		
		                connectToServer();
    	                setUpStreams();
						requestListOfAutomobiles("Request1.txt");
						closeConnection ();
						connectToServer();
	    	            setUpStreams();
						getSelectedAutomobile("ChosenCar1.txt");
						closeConnection ();
						connectToServer();
	    	            setUpStreams();
						getSelectedAutomobile_("ChosenCar2.txt");
						closeConnection ();
						
						try {
							startServer ();
						} catch (IOException e) {
							
							e.printStackTrace();
						}
						System.out.println("The program is now working as a client and server, the servlet can connect to client and retrieve the list of models");
					
					}
	
	showMenu();

}
public void startServer () throws IOException
{   
SwingUtilities.invokeLater(
		new Runnable()
		{
			public void run ()
			{
				 try {
					server = new ServerSocket(6700, 100);
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}


				 while (true)
				 {
				 	 try {
				 		 WaitForClientRequest();
				 		 setUpServerStreams();
				 		 receiveClientRequest();
				 		
				 	} catch (IOException e) {
				 		// TODO Auto-generated catch block
				 		e.printStackTrace();
				 	}
				 	finally 
				 	{
				 		try {
				 			out.close();
				 			in.close();
				 			socket.close();
				 		} catch (IOException e) {
				 			// TODO Auto-generated catch block
				 			e.printStackTrace();
				 		}
				 		
				 	}
				 	 
				 }
			}
		}
		);


}
public void WaitForClientRequest() throws IOException
{
	socket = server.accept();
}
public void setUpServerStreams() throws IOException
{
	out = new ObjectOutputStream (socket.getOutputStream());
	out.flush();
	in = new ObjectInputStream(socket.getInputStream());
}
public void  receiveClientRequest() throws IOException
{
	String message = null;
	do 
	{
		try {
			
			message = (String)in.readObject();
		
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
		if (message.equals("Send list of models"))
		{
			
			
			out.writeObject( ListofModels);
			
		}
	    if (message.equals("Send Ford object"))
	    {
	    	out.writeObject(auto_Ford);
	    }
	    if (message.equals("Send Benz object"))
	    {
	    	out.writeObject(auto_Benz);
	    }
		
	}while (!message.equals("End"));
}

}

