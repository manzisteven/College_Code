package graph;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
//import java.security.acl.LastOwnerException;
import java.util.LinkedList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Queue;
import java.io.*;
import java.util.Arrays;
import java.util.Scanner;
public class main {

	public static void main(String[] args) {
	String actor2_ = null;
	String actor1_ = null;
	String movie =  null;

    Queue <String> myqueue = new LinkedList <String>();
	LinkedList <String> a = new LinkedList<String>();
	LinkedList <Data> c = new LinkedList<Data>();
	HashMap <String, Integer> hashmap = new HashMap<String, Integer>();
	HashMap <String, Integer> newhashmap = new HashMap<String, Integer>();
	Set<String> b = new HashSet<String>();
	int size1 = b.size();
	String[] array = null;
	int count1 = 0;
	int i = 1;
	int count2 = 0;
	int count3 = 0;
	int w = 0;
	int levelOfSeparation = 0;
	String removedActor = null;
	int u = 1;
	int specialIndex;
	boolean condition = true;
	int previous = 0;
	
	
	String matrix [][]= null;
	
    
		
				BufferedReader br = null;
			
				try{
					
					br = new BufferedReader(new FileReader("MovieData.txt"));
					String line;
					
					while((line = br.readLine()) != null){																		
						
					
						 movie = line.substring(0,line.indexOf("("));
						 
						String names = line.substring(line.lastIndexOf("("), line.lastIndexOf(")"));
						if (names.contains(","))
						{
							actor1_ = names.substring(1, names.indexOf(","));
	
							actor2_ = names.substring(names.indexOf(",")+2, names.length());
							
							b.add(actor1_);
							b.add(actor2_);
							count1++;
						}
						else 
						{
							actor2_ = null;
							actor1_ = names.substring(1, names.length());
							
							b.add(actor1_);
							b.add(actor2_);
							count2++;
						}
						Data object = new Data(movie, actor1_, actor2_);
						c.add(object);
						//System.out.println(movie);
						//System.out.println(actor1_);
						//System.out.println(actor2_);
						
					}
					matrix= new String[b.size()+1][b.size()+1];
					array = new String [b.size()];
				
				
					count3 = (2*count1) + count2;
					 
					
					
				
					br.close();
					
				}
				catch(IOException e){
					e.printStackTrace();
				}
				  for(String s: b)
			      {  
					  matrix[0][i] = s;
					  matrix[i][0] = s;
					  hashmap.put(s, i);
					  i++;
			      }
				  
				 
				  for (int p = 0; p<c.size(); p++)
				  {
				     String actor11 = c.get(p).actor1;
				     String actor22 = c.get(p).actor2;
				     int index1 = hashmap.get(actor11);
				     int index2 = hashmap.get(actor22);
				     matrix[index1][index2] = c.get(p).Movie_name;
					 
				  }
				  
				 
				
					
				for (int row =0; row< 10; row++)
				{
					
					for (int column = 0; column<10; column++)
					{
						//System.out.print(matrix[row][column]+"\t");
					}
				//System.out.println();
				}
				
				
				
				System.out.println("Enter the source actor");
				Scanner obj = new Scanner(System.in);
				String sourceActor = obj.nextLine();
				System.out.println("Enter the destination actor");
				String destinationActor = obj.nextLine();
				specialIndex  = hashmap.get(sourceActor);
			
				int index2_ = hashmap.get(destinationActor);	
				
				
				for (int row_ = 0; row_<b.size(); row_++)
				{ 
					int column_;
					
					
		         for ( column_ = 0; column_<b.size(); column_++)
					{
		        	 if (condition == false)
						{
							break;
						}
						
						if (matrix[specialIndex][column_]!= null)
						{
						
							if (matrix[0][column_] == matrix[0][index2_])
							{  
								System.out.println(matrix[specialIndex][0]+"->"+ matrix[0][column_]+ ": o degree of separation");
								System.out.println(matrix[specialIndex][column_]+ ":"+matrix[specialIndex][0] + ","+matrix[0][column_]);
								condition = false;
								
							}
							else 
							{    //System.out.println("ok");
								myqueue.add(matrix[0][column_]);
								if (matrix[specialIndex][column_]!= null || matrix[specialIndex][column_] == null)
								{
									 if (column_ == b.size())
										{
										     while(!myqueue.isEmpty())
										     {
											 removedActor = myqueue.remove();
											 specialIndex = hashmap.get(removedActor);
										     }
										}
								
								}
							
								
							}
							
							
							
						}
				
			
				}
				
				}
				}
	
}
				
					
				



	


