package testServer;

import java.io.IOException;
import java.util.Scanner;

import dbAdapter.database;
import server.AutoServer;
import server.BuildCarModelOptions;
import server.DbBuildcarModelOptions;
import server.serverSockets;

public class TestServer {
 
	public static void main(String[] args) {
		
		System.out.println("Press 1 for local server and 2 for database");
		Scanner obj = new Scanner (System.in);
		int option = obj.nextInt();
		
		AutoServer cars = null;
		if (option == 1)
		{
			cars = new BuildCarModelOptions ();
		}
		else if (option == 2)
		{
			cars = new DbBuildcarModelOptions ();
		}
		else
		{
			System.exit(1);
		}
		serverSockets test = new serverSockets (cars);
	
		
			test.start();
		}

}
