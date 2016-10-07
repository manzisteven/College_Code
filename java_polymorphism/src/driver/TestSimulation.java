package driver;

import java.util.Scanner;
import java.util.Set;

import Creatures.*;
import Living_Environment.*;

public class TestSimulation {
public static void main (String [] args)
{


World world = new World ();
String obj = null;
world.insertInsects();
world.insertBirds();
world.InsertCats();



    


do {
	
	if (obj=="ESC")
	{
		System.out.println("Bye bye...");
		System.exit(0);
	}

	
	world.startSimulation();
	world.printGrid();
	// This is to mark all the objects in the hashmap as unmoved, before starting a new iteration
	Set<Creature> keys = World.indexInsects.keySet();
	for (Creature key : keys) {
	    String track = World.indexInsects.get(key);
	    if(track == "moved")
	    {
	    	World.indexInsects.put(key, "unmoved");
	    }
    }
	System.out.println("press [Enter] to continue or ESC to quit");
	 obj = (new Scanner(System.in)).nextLine();

	// create an infinite loop
} while (true);
}

}

