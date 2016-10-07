package Creatures;

import java.util.Set;

import Living_Environment.World;

public class Cat extends Creature {
	private String identifierLetter;
	public Cat (String identifierLetter)
	{
		this.identifierLetter = identifierLetter;
	}
	public String getIdentifierLetter ()
	{
		return identifierLetter;
	}
	public void move (int x, int y)
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
					
					
					Set<Creature> keys2 = World.trackCatsMovement.keySet();
					for (Creature key : keys2) {
					    if (key == World.creatures[x][y+1])
					    {
					    	Integer a = World.trackCatsMovement.get(World.creatures[x][y+1]);
					    	if (a==10)
					    	{
					    		breed(x, y+1);
					    		World.trackCatsMovement.put(key,0);
					    		break;
					    	}
					    	Integer b = a+1;
					    	World.trackCatsMovement.put(key,b);
					    }
					}
					
					
					
					
					Set<Creature> keys1 = World.trackCats.keySet();
					for (Creature key : keys1) {
					    if (key == World.creatures[x][y+1])
					    {
					    	Integer a = World.trackCats.get(World.creatures[x][y+1]);
					    	if (a==12)
					    	{
					    		Starve(x, y+1);
					    		
					    		break;
					    	}
					    	Integer b = a++;
					    	World.trackCats.put(key,b);
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
				if (World.creatures[x][y+1] instanceof Birds)
				{
	                 World.creatures[x][y+1] = 	World.creatures[x][y];
					
	             	Set<Creature> keys1 = World.trackCats.keySet();
					for (Creature key : keys1) {
					    if (key == World.creatures[x][y+1])
					    {
					    	World.trackCats.put(key, 0);
					    }
					}

					Set<Creature> keys2 = World.trackCatsMovement.keySet();
					for (Creature key : keys2) {
					    if (key == World.creatures[x][y+1])
					    {
					    	Integer a = World.trackCatsMovement.get(World.creatures[x][y+1]);
					    	if (a==10)
					    	{
					    		breed(x, y+1);
					    		World.trackCatsMovement.put(key,0);
					    		break;
					    	}
					    	Integer b = a+1;
					    	World.trackCatsMovement.put(key,b);
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
						Set<Creature> keys2 = World.trackCatsMovement.keySet();
						for (Creature key : keys2) {
						    if (key == World.creatures[x][y-1])
						    {
						    	Integer a = World.trackCatsMovement.get(World.creatures[x][y-1]);
						    	if (a==10)
						    	{
						    		breed(x, y-1);
						    		World.trackCatsMovement.put(key,0);
						    		break;
						    	}
						    	Integer b = a+1;
						    	World.trackCatsMovement.put(key,b);
						    }
						}
						
						
						Set<Creature> keys1 = World.trackCats.keySet();
						for (Creature key : keys1) {
						    if (key == World.creatures[x][y-1])
						    {
						    	Integer a = World.trackCats.get(World.creatures[x][y-1]);
						    	if (a==12)
						    	{
						    		Starve(x, y-1);
						    		
						    		break;
						    	}
						    	Integer b = a++;
						    	World.trackCats.put(key,b);
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
					if (World.creatures[x][y-1] instanceof Birds)
					{
	                    World.creatures[x][y-1] = World.creatures[x][y];
	                    Set<Creature> keys2 = World.trackCatsMovement.keySet();
						for (Creature key : keys2) {
						    if (key == World.creatures[x][y-1])
						    {
						    	Integer a = World.trackCatsMovement.get(World.creatures[x][y-1]);
						    	if (a==10)
						    	{
						    		breed(x, y-1);
						    		World.trackCatsMovement.put(key,0);
						    		break;
						    	}
						    	Integer b = a+1;
						    	World.trackCatsMovement.put(key,b);
						    }
						}
	                    
	                    
	                    Set<Creature> keys1 = World.trackCats.keySet();
						for (Creature key : keys1) {
						    if (key == World.creatures[x][y-1])
						    {
						    	World.trackCats.put(key, 0);
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
						
						Set<Creature> keys2 = World.trackCatsMovement.keySet();
						for (Creature key : keys2) {
						    if (key == World.creatures[x-1][y])
						    {
						    	Integer a = World.trackCatsMovement.get(World.creatures[x-1][y]);
						    	if (a==10)
						    	{
						    		breed(x-1, y);
						    		World.trackCatsMovement.put(key,0);
						    		break;
						    	}
						    	Integer b = a+1;
						    	World.trackCatsMovement.put(key,b);
						    }
						}
						
						
						Set<Creature> keys1 = World.trackCats.keySet();
						for (Creature key : keys1) {
						    if (key == World.creatures[x-1][y])
						    {
						    	Integer a = World.trackCats.get(World.creatures[x-1][y]);
						    	if (a==12)
						    	{
						    		Starve(x-1, y);
						    		
						    		break;
						    	}
						    	Integer b = a++;
						    	World.trackCats.put(key,b);
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
				 if (World.creatures[x-1][y] instanceof Birds)
				 {
		                 World.creatures[x-1][y] = World.creatures[x][y];
						
		             	Set<Creature> keys2 = World.trackCatsMovement.keySet();
						for (Creature key : keys2) {
						    if (key == World.creatures[x-1][y])
						    {
						    	Integer a = World.trackCatsMovement.get(World.creatures[x-1][y]);
						    	if (a==10)
						    	{
						    		breed(x-1, y);
						    		World.trackCatsMovement.put(key,0);
						    		break;
						    	}
						    	Integer b = a+1;
						    	World.trackCatsMovement.put(key,b);
						    }
						}
		                 
		                 
		                 Set<Creature> keys1 = World.trackCats.keySet();
							for (Creature key : keys1) {
							    if (key == World.creatures[x-1][y])
							    {
							    	World.trackCats.put(key, 0);
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
						Set<Creature> keys2 = World.trackCatsMovement.keySet();
						for (Creature key : keys2) {
						    if (key == World.creatures[x+1][y])
						    {
						    	Integer a = World.trackCatsMovement.get(World.creatures[x+1][y]);
						    	if (a==10)
						    	{
						    		breed(x+1, y);
						    		World.trackCatsMovement.put(key,0);
						    		break;
						    	}
						    	Integer b = a+1;
						    	World.trackCatsMovement.put(key,b);
						    }
						}
						
						Set<Creature> keys1 = World.trackCats.keySet();
						for (Creature key : keys1) {
						    if (key == World.creatures[x+1][y])
						    {
						    	Integer a = World.trackCats.get(World.creatures[x+1][y]);
						    	if (a==12)
						    	{
						    		Starve(x+1, y);
						    		
						    		break;
						    	}
						    	Integer b = a++;
						    	World.trackCats.put(key,b);
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
					if (World.creatures[x+1][y] instanceof Birds)
					{
						World.creatures[x+1][y] = World.creatures[x][y];
						World.creatures[x+1][y] = World.creatures[x][y];
						Set<Creature> keys2 = World.trackCatsMovement.keySet();
						for (Creature key : keys2) {
						    if (key == World.creatures[x+1][y])
						    {
						    	Integer a = World.trackCatsMovement.get(World.creatures[x+1][y]);
						    	if (a==10)
						    	{
						    		breed(x+1, y);
						    		World.trackCatsMovement.put(key,0);
						    		break;
						    	}
						    	Integer b = a+1;
						    	World.trackCatsMovement.put(key,b);
						    }
						}
						
						Set<Creature> keys1 = World.trackCats.keySet();
						for (Creature key : keys1) {
						    if (key == World.creatures[x+1][y])
						    {
						    	World.trackCats.put(key, 0);
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
	public void Starve (int x, int y)
	{
		World.creatures [x] [y] = null;
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
						World.creatures[x][y+1] = 	new Cat("C");
					
						controlVariable = false;
						break;
					}
				}
				// move to the left
				 if(row == x && column ==y-1)
				 {
						if (World.creatures[x][y-1] == null)
						{
							World.creatures[x][y-1] = new Cat ("C");
							controlVariable = false;
							break;
						}
				 }
				 // move up
				 if(row == x -1 && column ==y)
				 {
					 if (World.creatures[x-1][y] == null)
						{
							World.creatures[x-1][y] = new Cat ("C");
							controlVariable = false;
							break;
						}
				 }
				 // move down
				 if(row == x+1 && column ==y)
				 {
						if (World.creatures[x+1][y] == null)
						{
							World.creatures[x+1][y] = new Cat ("C");
							controlVariable = false;
							break;
						}
				 }
			
			}
			  row++;  
			}
	}
}
