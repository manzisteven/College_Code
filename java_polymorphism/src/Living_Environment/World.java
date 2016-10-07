package Living_Environment;

import java.util.HashMap;

import Creatures.Birds;
import Creatures.Cat;
import Creatures.Creature;
import Creatures.Insects;

public class World {
	
	public static Creature creatures [][] = new Creature[20][20];
	
	// These hashmaps are used to track creatures in the grid 
	public static HashMap<Creature, String> indexInsects = new HashMap<Creature, String>();
	public static HashMap<Creature, Integer> trackInsects = new HashMap<Creature, Integer>();
	public static HashMap<Creature, Integer> trackBirds = new HashMap<Creature, Integer>();
	public static HashMap<Creature, Integer> trackCats = new HashMap<Creature, Integer>();
	public static HashMap<Creature, Integer> trackBirdsMovement = new HashMap<Creature, Integer>();
	public static HashMap<Creature, Integer> trackCatsMovement = new HashMap<Creature, Integer>();
	
	public  void insertInsects ()
	{
		
		   for (int row = 0; row<20; row++)
		{ 
			
	    // Insert Insect in the grids in the specified rows
		if (row == 0 || row == 5 || row == 13 || row == 17 || row == 10)
		{
		 for (int column = 0; column<20; column++)
		{
			
			
			 creatures[row][column] = new Insects ("o");
			 // Mark every insect as unmoved 
			 indexInsects.put(creatures[row][column], "unmoved");
			 // Initialize this hashmap with 0 for all objects
			 trackInsects.put(creatures[row][column], 0);
			 
		}
		}
		}
		
		
	
		
		
		
		
		   
	}
	public void insertBirds ()
	{
		for (int row = 0; row<20; row++)
		{ 
			
		if ( row == 7)	
		{
		 for (int column = 0; column<20; column++)
		{
			// Insert only fifteen birds objects. 
			 if (column == 15)
			 {
				 break;
			 }
			 creatures[row][column] = new Birds ("B");
			 // Mark all birds as unmoved 
			 indexInsects.put(creatures[row][column], "unmoved");
			 
			 trackBirds.put(creatures[row][column], 0);
			 trackBirdsMovement.put(creatures[row][column], 0);
		}
		}    
		}
	}
	
	public void InsertCats ()
	{
		   for (int row = 0; row<20; row++)
			{ 
				
				
			if (row == 3)
			{
			 for (int column = 0; column<20; column++)
			{
				 if (column == 10)
				 {
					 break;
				 }
				
				 creatures[row][column] = new Cat ("C");
				 indexInsects.put(creatures[row][column], "unmoved");
				 
				 trackCats.put(creatures[row][column], 0);
				 trackCatsMovement.put(creatures[row][column], 0);
				
			}
			}
			}
	}
	
	public  void startSimulation ()
	{
		for (int row = 0; row<20; row++)
		{ 
			
			for (int column = 0; column<20; column++)
		{
			
				
			     if ( creatures[row][column] != null)
			     {
			     creatures[row][column].move(row, column);
			     
			     
			     }
			    
			     }
		     
		}
	}
	// This function prints the grid
	public void printGrid ()
	{
		for (int row = 0; row<20; row++)
		{ 
			
		for (int column = 0; column<20; column++)
		{
			if ( creatures[row][column] != null)
			{
				System.out.print(creatures[row][column].getIdentifierLetter()+"\t");
			}
			
			if (creatures[row][column] == null)
			{
			 System.out.print(creatures[row][column]+"\t");
			}
		
		}
		 System.out.println();
		}
	}
	}
		
		
	



