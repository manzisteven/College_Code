package Creatures;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import Living_Environment.World;



public class Insects extends Creature {
// The constructor takes one parameter, this will be the string o used in the printed  out grid
public Insects (String identifierLetter)
{
	this.identifierLetter = identifierLetter;
}

public String getIdentifierLetter ()
{   
	return identifierLetter;
}

// @ x = The row number in the grid where the object to be moved resides
//   @ y = The column number in the grid where the object to be moved resides
public  void move (int x, int y)
{
	// this flag is used to break out of the loop once an empty cell has been found 
	//and the reference assignment has been done. 
	boolean controlVariable = true;
	int row =0;
	int column = 0;
	
	
	while(row<20 && controlVariable )
	{ 
		// retrieve the mark (moved or unmoved) of the object to be moved from the hashmap
		String track = World.indexInsects.get(World.creatures[x][y]);
		// if the object has already moved in this iteration, break out of the loop
		if (track != "unmoved")
		{
			break;
		}
		
	for (column = 0; column<20; column++)
	{
		
		// Check the right cell
		if (row == x && column == y+1 )
		{
			if (World.creatures[x][y+1] == null)
			{
				// The track Hashmaps have been used to know the exact time to breed 
				World.creatures[x][y+1] = 	World.creatures[x][y];
				Set<Creature> keys1 = World.trackInsects.keySet();
				for (Creature key : keys1) {
				    if (key == World.creatures[x][y+1])
				    {
				    	Integer a = World.trackInsects.get(World.creatures[x][y+1]);
				    	if (a==3)
				    	{
				    		breed(x, y+1);
				    		World.trackInsects.put(key,0);
				    		break;
				    	}
				    	Integer b = a+1;
				    	World.trackInsects.put(key,b);
				    }
				}
				
				//Put the object that has moved in the hashmap
				Set<Creature> keys = World.indexInsects.keySet();
				for (Creature key : keys) {
				    if (key == World.creatures[x][y+1])
				    {
				    	World.indexInsects.put(key,"moved");
				    }
				}
				
				// break out of the loop
				
				World.creatures[x][y] = null;
				controlVariable = false;
				break;
			}
		}
		// move to the left
		 if(row == x && column ==y-1)
		 {
				if (World.creatures[x][y-1] == null)
				{
					World.creatures[x][y-1] =World.creatures[x][y];
					
					Set<Creature> keys1 = World.trackInsects.keySet();
					for (Creature key : keys1) {
					    if (key == World.creatures[x][y-1])
					    {
					    	Integer a = World. trackInsects.get(World.creatures[x][y-1]);
					    	if (a==3)
					    	{
					    		breed(x, y-1);
					    		World.trackInsects.put(key,0);
					    		break;
					    	}
					    	Integer b = a+1;
					    	World.trackInsects.put(key,b);
					    }
					}
					
					Set<Creature> keys = World.indexInsects.keySet();
					for (Creature key : keys) {
					    if (key == World.creatures[x][y-1])
					    {
					    	World.indexInsects.put(key,"moved");
					    }
				}
					World.creatures[x][y] = null;
					controlVariable = false;
					break;
				}
		 }
		 // move up
		 if(row == x -1 && column ==y)
		 {
			 if (World.creatures[x-1][y] == null)
				{
					World.creatures[x-1][y] = World.creatures[x][y];
				
					Set<Creature> keys1 = World.trackInsects.keySet();
					for (Creature key : keys1) {
					    if (key == World.creatures[x-1][y])
					    {
					    	Integer a = World.trackInsects.get(World.creatures[x-1][y]);
					    	if (a==3)
					    	{
					    		breed(x-1, y);
					    		World.trackInsects.put(key,0);
					    		break;
					    	}
					    	Integer b = a+1;
					    	World.trackInsects.put(key,b);
					    }
					}
					
					Set<Creature> keys = World.indexInsects.keySet();
					for (Creature key : keys) {
					    if (key == World.creatures[x-1][y])
					    {
					    	World.indexInsects.put(key,"moved");
					    }
				}
					World.creatures[x][y] = null;
					controlVariable = false;
					break;
				}
		 }
		 // move down
		 if(row == x+1 && column ==y)
		 {
				if (World.creatures[x+1][y] == null)
				{
					World.creatures[x+1][y] = World.creatures[x][y] ;
					
					Set<Creature> keys1 = World.trackInsects.keySet();
					for (Creature key : keys1) {
					    if (key == World.creatures[x+1][y])
					    {
					    	Integer a = World.trackInsects.get(World.creatures[x+1][y]);
					    	if (a==3)
					    	{
					    		breed(x+1, y);
					    		World.trackInsects.put(key,0);
					    		break;
					    	}
					    	Integer b = a+1;
					    	World.trackInsects.put(key,b);
					    }
					}
					
					Set<Creature> keys = World.indexInsects.keySet();
					for (Creature key : keys) {
					    if (key == World.creatures[x+1][y])
					    {
					    	World.indexInsects.put(key, "moved");
					    }
				}
					World.creatures[x][y] = null;
					controlVariable = false;
					break;
				}
		 }
	
	}
	  row++;  
	}
	
}
	
public void breed (int x, int y)
{
	
	    boolean controlVariable = true;
		int row =0;
		int column = 0;
		
		
		while(row<20&&controlVariable)
		{ 
		
			
		for (column = 0; column<20; column++)
		{
			
			// Check the right cell
			if (row == x && column == y+1 )
			{
				if (World.creatures[x][y+1] == null)
				{
				
					World.creatures[x][y+1] = 	new Insects("o");
				
					controlVariable = false;
					break;
				}
			}
			// move to the left
			 if(row == x && column ==y-1)
			 {
					if (World.creatures[x][y-1] == null)
					{
						World.creatures[x][y-1] = new Insects ("o");
						controlVariable = false;
						break;
					}
			 }
			 // move up
			 if(row == x -1 && column ==y)
			 {
				 if (World.creatures[x-1][y] == null)
					{
						World.creatures[x-1][y] = new Insects ("o");
						controlVariable = false;
						break;
					}
			 }
			 // move down
			 if(row == x+1 && column ==y)
			 {
					if (World.creatures[x+1][y] == null)
					{
						World.creatures[x+1][y] = new Insects ("o");
						controlVariable = false;
						break;
					}
			 }
		
		}
		  row++;  
		}
}
}
