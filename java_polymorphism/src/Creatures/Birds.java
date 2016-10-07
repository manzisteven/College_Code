package Creatures;

import java.util.Set;

import Living_Environment.World;

public class Birds extends Creature {
	private String identifierLetter;
	public Birds (String identifierLetter)
	{
		this.identifierLetter = identifierLetter;
	}
	public String getIdentifierLetter ()
	{
		return identifierLetter;
	}
	
	// You can read the documentation of this function in the Insects class (move function)
	public  void move (int x, int y)
	{
		boolean controlVariable = true;
		int row =0;
		int column = 0;
		
		
		while(row<20 && controlVariable )
		{ 
			String track = World.indexInsects.get(World.creatures[x][y]);
			
			if (track != "unmoved")
			{
				break;
			}
			
		for (column = 0; column<20; column++)
		{
			
			
			if (row == x && column == y+1)
			{
				if (World.creatures[x][y+1] == null)
				{
					World.creatures[x][y+1] = 	World.creatures[x][y];
					
					
					Set<Creature> keys2 = World.trackBirdsMovement.keySet();
					for (Creature key : keys2) {
					    if (key == World.creatures[x][y+1])
					    {
					    	Integer a = World.trackBirdsMovement.get(World.creatures[x][y+1]);
					    	if (a==8)
					    	{
					    		breed(x, y+1);
					    		World.trackBirdsMovement.put(key,0);
					    		break;
					    	}
					    	Integer b = a+1;
					    	World.trackBirdsMovement.put(key,b);
					    }
					}
					
					
					
					
					Set<Creature> keys1 = World.trackBirds.keySet();
					for (Creature key : keys1) {
					    if (key == World.creatures[x][y+1])
					    {
					    	Integer a = World.trackBirds.get(World.creatures[x][y+1]);
					    	if (a==3)
					    	{
					    		Starve(x, y+1);
					    		
					    		break;
					    	}
					    	Integer b = a++;
					    	World.trackBirds.put(key,b);
					    }
					}
					
					Set<Creature> keys = World.indexInsects.keySet();
					for (Creature key : keys) {
					    if (key == World.creatures[x][y+1])
					    {
					    	World.indexInsects.put(key,"moved");
					    }
					}
					World.creatures[x][y] = null;
					controlVariable = false;
					break;
				}
				if (World.creatures[x][y+1] instanceof Insects)
				{
	                 World.creatures[x][y+1] = 	World.creatures[x][y];
					
	             	Set<Creature> keys1 = World.trackBirds.keySet();
					for (Creature key : keys1) {
					    if (key == World.creatures[x][y+1])
					    {
					    	World.trackBirds.put(key, 0);
					    }
					}
					Set<Creature> keys2 = World.trackBirdsMovement.keySet();
					for (Creature key : keys2) {
					    if (key == World.creatures[x][y+1])
					    {
					    	Integer a = World.trackBirdsMovement.get(World.creatures[x][y+1]);
					    	if (a==8)
					    	{
					    		breed(x, y+1);
					    		World.trackBirdsMovement.put(key,0);
					    		break;
					    	}
					    	Integer b = a+1;
					    	World.trackBirdsMovement.put(key,b);
					    }
					}
					Set<Creature> keys = World.indexInsects.keySet();
					for (Creature key : keys) {
					    if (key == World.creatures[x][y])
					    {
					    	World.indexInsects.put(key,"moved");
					    }
					}
					World.creatures[x][y] = null;
					controlVariable = false;
					break;
				}
			}
			 if(row == x && column ==y-1)
			 {
					if (World.creatures[x][y-1] == null)
					{
						World.creatures[x][y-1] = World.creatures[x][y];
						Set<Creature> keys2 = World.trackBirdsMovement.keySet();
						for (Creature key : keys2) {
						    if (key == World.creatures[x][y-1])
						    {
						    	Integer a = World.trackBirdsMovement.get(World.creatures[x][y-1]);
						    	if (a==8)
						    	{
						    		breed(x, y-1);
						    		World.trackBirdsMovement.put(key,0);
						    		break;
						    	}
						    	Integer b = a+1;
						    	World.trackBirdsMovement.put(key,b);
						    }
						}
						
						
						Set<Creature> keys1 = World.trackBirds.keySet();
						for (Creature key : keys1) {
						    if (key == World.creatures[x][y-1])
						    {
						    	Integer a = World.trackBirds.get(World.creatures[x][y-1]);
						    	if (a==3)
						    	{
						    		Starve(x, y-1);
						    		
						    		break;
						    	}
						    	Integer b = a++;
						    	World.trackBirds.put(key,b);
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
					if (World.creatures[x][y-1] instanceof Insects)
					{
	                    World.creatures[x][y-1] = World.creatures[x][y];
	                    Set<Creature> keys2 = World.trackBirdsMovement.keySet();
						for (Creature key : keys2) {
						    if (key == World.creatures[x][y-1])
						    {
						    	Integer a = World.trackBirdsMovement.get(World.creatures[x][y-1]);
						    	if (a==8)
						    	{
						    		breed(x, y-1);
						    		World.trackBirdsMovement.put(key,0);
						    		break;
						    	}
						    	Integer b = a+1;
						    	World.trackBirdsMovement.put(key,b);
						    }
						}
	                    
	                    
	                    Set<Creature> keys1 = World.trackBirds.keySet();
						for (Creature key : keys1) {
						    if (key == World.creatures[x][y-1])
						    {
						    	World.trackBirds.put(key, 0);
						    }
						}
						Set<Creature> keys = World.indexInsects.keySet();
						for (Creature key : keys) {
						    if (key == World.creatures[x][y])
						    {
						    	World.indexInsects.put(key,"moved");
						    }
					}
						World.creatures[x][y] = null;
						controlVariable = false;
						break;
					}
			 }
			 if(row == x-1 && column ==y)
			 {
				 if (World.creatures[x-1][y] == null)
					{
						World.creatures[x-1][y] = World.creatures[x][y];
						
						Set<Creature> keys2 = World.trackBirdsMovement.keySet();
						for (Creature key : keys2) {
						    if (key == World.creatures[x-1][y])
						    {
						    	Integer a = World.trackBirdsMovement.get(World.creatures[x-1][y]);
						    	if (a==8)
						    	{
						    		breed(x-1, y);
						    		World.trackBirdsMovement.put(key,0);
						    		break;
						    	}
						    	Integer b = a+1;
						    	World.trackBirdsMovement.put(key,b);
						    }
						}
						
						
						Set<Creature> keys1 = World.trackBirds.keySet();
						for (Creature key : keys1) {
						    if (key == World.creatures[x-1][y])
						    {
						    	Integer a = World.trackBirds.get(World.creatures[x-1][y]);
						    	if (a==3)
						    	{
						    		Starve(x-1, y);
						    		
						    		break;
						    	}
						    	Integer b = a++;
						    	World.trackBirds.put(key,b);
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
				 if (World.creatures[x-1][y] instanceof Insects)
				 {
		                 World.creatures[x-1][y] = World.creatures[x][y];
						
		                 Set<Creature> keys2 = World.trackBirdsMovement.keySet();
							for (Creature key : keys2) {
							    if (key == World.creatures[x-1][y])
							    {
							    	Integer a = World.trackBirdsMovement.get(World.creatures[x-1][y]);
							    	if (a==8)
							    	{
							    		breed(x-1, y);
							    		World.trackBirdsMovement.put(key,0);
							    		break;
							    	}
							    	Integer b = a+1;
							    	World.trackBirdsMovement.put(key,b);
							    }
							}
		                 
		                 
		                 Set<Creature> keys1 = World.trackBirds.keySet();
							for (Creature key : keys1) {
							    if (key == World.creatures[x-1][y])
							    {
							    	World.trackBirds.put(key, 0);
							    }
							}
						Set<Creature> keys = World.indexInsects.keySet();
						for (Creature key : keys) {
						    if (key == World.creatures[x][y])
						    {
						    	World.indexInsects.put(key,"moved");
						    }
					}
						World.creatures[x][y] = null;
						controlVariable = false;
						break;
				 }
			 }
			 if(row == x+1 && column ==y)
			 {
					if (World.creatures[x+1][y] == null)
					{
						World.creatures[x+1][y] = World.creatures[x][y];
						Set<Creature> keys2 = World.trackBirdsMovement.keySet();
						for (Creature key : keys2) {
						    if (key == World.creatures[x+1][y])
						    {
						    	Integer a = World.trackBirdsMovement.get(World.creatures[x+1][y]);
						    	if (a==8)
						    	{
						    		breed(x+1, y);
						    		World.trackBirdsMovement.put(key,0);
						    		break;
						    	}
						    	Integer b = a+1;
						    	World.trackBirdsMovement.put(key,b);
						    }
						}
						
						Set<Creature> keys1 = World.trackBirds.keySet();
						for (Creature key : keys1) {
						    if (key == World.creatures[x+1][y])
						    {
						    	Integer a = World.trackBirds.get(World.creatures[x+1][y]);
						    	if (a==3)
						    	{
						    		Starve(x+1, y);
						    		
						    		break;
						    	}
						    	Integer b = a++;
						    	World.trackBirds.put(key,b);
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
					if (World.creatures[x+1][y] instanceof Insects)
					{
						World.creatures[x+1][y] = World.creatures[x][y];
						Set<Creature> keys2 = World.trackBirdsMovement.keySet();
						for (Creature key : keys2) {
						    if (key == World.creatures[x+1][y])
						    {
						    	Integer a = World.trackBirdsMovement.get(World.creatures[x+1][y]);
						    	if (a==8)
						    	{
						    		breed(x+1, y);
						    		World.trackBirdsMovement.put(key,0);
						    		break;
						    	}
						    	Integer b = a+1;
						    	World.trackBirdsMovement.put(key,b);
						    }
						}
						
						Set<Creature> keys1 = World.trackBirds.keySet();
						for (Creature key : keys1) {
						    if (key == World.creatures[x+1][y])
						    {
						    	World.trackBirds.put(key, 0);
						    }
						}
						Set<Creature> keys = World.indexInsects.keySet();
						for (Creature key : keys) {
						    if (key == World.creatures[x][y])
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
						// This is where I am doing reference assignment
						World.creatures[x][y+1] = 	new Birds("B");
					
						controlVariable = false;
						break;
					}
				}
				// move to the left
				 if(row == x && column ==y-1)
				 {
						if (World.creatures[x][y-1] == null)
						{
							World.creatures[x][y-1] = new Birds ("B");
							controlVariable = false;
							break;
						}
				 }
				 // move up
				 if(row == x -1 && column ==y)
				 {
					 if (World.creatures[x-1][y] == null)
						{
							World.creatures[x-1][y] = new Birds ("B");
							controlVariable = false;
							break;
						}
				 }
				 // move down
				 if(row == x+1 && column ==y)
				 {
						if (World.creatures[x+1][y] == null)
						{
							World.creatures[x+1][y] = new Birds ("B");
							controlVariable = false;
							break;
						}
				 }
			
			}
			  row++;  
			}
	}
	public void Starve (int x, int y)
	{
		World.creatures [x] [y] = null;
	}
}
