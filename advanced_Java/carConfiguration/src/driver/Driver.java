// Student name: Manzi Steven.    
package driver;
import Util.ReadSource;

import java.io.*;
import java.util.Scanner;

import client.CarModelOptionsIO;
import scale.EditOptions;
import exception.AutoException;
import Adapter.BuildAuto;
import Model.Automobile;
import Model.OptionSet;
public class Driver {
public static void main (String [] args)
{
	/**ReadSource readData = new ReadSource ();
	Automobile automotive ;
	
    automotive = readData.readData("datafile.txt");
	
	//System.out.println("                  Before serialization                       ");
	//System.out.println("...............................................................");
	//automotive.print();
	try 
	{
	ObjectOutputStream out = new ObjectOutputStream (new FileOutputStream ("A.dat"));
	out.writeObject(automotive);
	out.flush();
	out.close();
	}
	catch (IOException e)
	{
		System.out.println("Error: "+ e);
	}
	try 
	{
		Automobile automotive1;
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("A.dat"));
		automotive1 = (Automobile)in.readObject();
		in.close();
		//System.out.println("                  After deserialization"                        );
		//System.out.println("...............................................................");
		//automotive1.print();
		
	}
	catch (Exception e)
	{
		System.out.println("Error: "+ e);
		System.exit(1);
	}*/
	/**
	BuildAuto auto = new BuildAuto ();
	System.out.println("       Print an Auto instance from CreateAuto interface");
	System.out.println("...............................................................");
	auto.buildAuto("datafile.txt");
	auto.printAuto("Focus Wagon ZTW");
	auto.updateOptionSetName("Focus Wagon ZTW", "Transmission", "Transmission_type");
	auto.updateOptionPrice("Focus Wagon ZTW", "Transmission_type", "automatic", 1000.0);
	System.out.println("       Print an Auto instance from CreateAuto interface after changing optionSet "
			+ "transmission to transmission_type and one of transmission option's price"
			+ "(automatic) to 1000");
	System.out.println("...............................................................");
	auto.printAuto("Focus Wagon ZTW");
	automotive.setOptionchoice("Transmission", "standard");
	String optionChoice = automotive.getOptionChoice("Transmission");
	
	double optionChoicePrice = automotive.getOptionChoicePrice("Transmission");
	//System.out.println(optionChoicePrice);
	automotive.setOptionchoice("Brakes", "ABS with advance trac");
	automotive.setOptionchoice("Side impact air bags", "selected");
	automotive.setOptionchoice("Power moonroof", "selected");
	automotive.setOptionchoice("Color", "Fort Knox Gold Clearcoat Metallic");
	double totalPrice = automotive.getTotalPrice();
	System.out.println ("After handling exceptions (Total price not including base price and transmission option's price");
	System.out.println("Check the loggedData file");
	System.out.println("       Printing the total price of the automobile according to the "
			+ "selected optionSets and options");
	System.out.println("...............................................................");
	System.out.println("The total price is: " +totalPrice); */
	
	/**BuildAuto auto = new BuildAuto ();
	auto.buildAuto("datafile.txt");
	EditOptions thread1 = new EditOptions ("Focus Wagon ZTW", "Brakes", "ABS with advance trac", 1500.0);
	EditOptions thread2 = new EditOptions ("Focus Wagon ZTW", "Brakes", "ABS with advance trac", 1800.0);*/
	
	CarModelOptionsIO auto = new CarModelOptionsIO ();
	//auto.connectToServer();
	//auto.setUpStreams();
	auto.showMenu();
    auto.closeConnection();
   
}   

}
