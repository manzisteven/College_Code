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
	 private  Automobile auto;
	 public CarModelOptionsIO ()
	 {
		
	 }
public void connectToServer ()
{
	try {
		socket = new Socket (InetAddress.getByName("172.29.52.148"), 6789);
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
public void requestListOfAutomobiles (String filename)
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
		ArrayList  message = (ArrayList)in.readObject();
		System.out.println("Here is the list of available types of automobiles, choose the one you want to configure");
		for (int i =0; i<message.size(); i++)
		{
			
			System.out.println(message.get(i));
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
		 auto = (Automobile)in.readObject();
		 auto.print();
	
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
	BufferedReader input = new BufferedReader(new InputStreamReader (System.in));
	String userInput = null;
	try {
		userInput = input.readLine();
	} catch (IOException e) {
		
		e.printStackTrace();
	}
    if (userInput.equals("F"))
	{
    	
    	
		System.out.println("Enter a path to a properties file");
	    String filename = null;
		try {
			filename = input.readLine();
		} catch (IOException e) {
		
			e.printStackTrace();
		}
	   createPropertiesObject(filename);
	}
    
    
	if(userInput.equals("Q"))
	{
		
						
						requestListOfAutomobiles("Request1.txt");
						System.out.println("Enter your choice by typing the exact name of the model");
						Scanner input3 = new Scanner (System.in);
						String userChoice = null;
				        userChoice = input3.nextLine();
							
					    if(userChoice.equals("Ford"))
						{
						
							getSelectedAutomobile("ChosenCar1.txt");
							try {
								startServer ();
							} catch (IOException e) {
								
								e.printStackTrace();
							}
							
						}
						if(userChoice.equals("Benz"))
						{
							
							getSelectedAutomobile("ChosenCar2.txt");
							try {
								startServer ();
							} catch (IOException e) {
								
								e.printStackTrace();
							}
							
						}
					}
	
	showMenu();

}
public void startServer () throws IOException
{   

	 server = new ServerSocket(6700, 100);


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
		if (message.equals("Send object"))
		{
			out.writeObject(auto);
		}
	
		
	}while (!message.equals("End"));
}

}

