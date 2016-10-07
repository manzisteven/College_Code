package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.*;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

import javax.swing.SwingUtilities;

import Model.Automobile;
public class serverSockets extends Thread{

 private ObjectOutputStream out;
 private ObjectInputStream in;
 private ServerSocket server = null;
 private Socket socket;
 private AutoServer cars;
 

 public serverSockets (AutoServer cars)
 {
    this.cars = cars;
 }
 
 
 public void run () 
 {   

	 try {
		server = new ServerSocket(6789, 100);
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
 

 while (true)
 {
	 try {
		 WaitForClientRequest();
		 setUpStreams();
		 receiveClientRequest();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally 
	{
		closeConnection();
		
	}
	 
 }
 
 }
 public boolean checkSocket ()
 {
	 boolean flag = false;
	 if (server != null)
		 flag = true;
		 
	 return flag;
	 
 }
 public void closeConnection ()
 {
	 if (server!=null)
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
 public void WaitForClientRequest () throws IOException
 {
	    //System.out.println ("waiting for someone to connect");
		socket = server.accept();
	
 }
 public void setUpStreams () throws IOException
 {
	
		out = new ObjectOutputStream (socket.getOutputStream());
		out.flush();
		in = new ObjectInputStream(socket.getInputStream());
		
	
 }
 public void receiveClientRequest () throws IOException
 { 
	// Keep receiving requests from this connection as long as a properties file of 
     // size 4 is not sent
	 Properties pros = null;
	 //do
	 //{
	
	 try {
		 
	 pros= (Properties)in.readObject();
		
		
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}
	 // Since I cast all incoming requests to properties' object, I had to find ways to distinguish 
	 // client requests. in this case if I sent a properties file whose size is 1, I mean that I want a list of 
	 // models to be sent to the client. 
	 if (pros.get("ChangedModel")!= null && pros.get("New Price")!= null)
	 {
		 cars.updateBasePrice(pros);
		 
	 }
	 
	 else if (pros.get("DeleteModel") != null )
	 {
		 cars.deleteModel(pros);
		 
	 }
	 
	 
	 else if (pros.get("send list of models") != null)
	 {

		 try {
				ArrayList<String> message = cars.returnListOfAutomobiles();
				out.writeObject(message);
			} catch (IOException e) {
			
				e.printStackTrace();
			}

	
	 }
	 // Here I want the server to send the requested object. the first line of the object will contain 
	 // the name of the requested model.
	 else if(pros.get("send object")!=null)
	 {
		
			try {
				
				Automobile auto = cars.returnSelectedAutomobile(pros);
				out.writeObject(auto);
				
			} catch (IOException e) {
			
				e.printStackTrace();
			}

	 }
	 //if (pros.size() == 52)
	  else if (pros.size() == 52 )
	 {
	
		  try {
			  cars.createAutomobile(pros);
			  String message = "Object built successfully";
			out.writeObject(message);
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	 }
	
	 }

 

}
