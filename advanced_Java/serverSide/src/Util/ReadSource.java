package Util;

import java.io.BufferedReader;

import  Model.Automobile;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import exception.AutoException;
import exception.FixAuto;
// This class is coded according to the format of the data file, the indexOf function defined in the string class
// was used to locate specific lines in the file. when the while loop exits the automobile object is fully populated
// and it is returned to the the function caller (Main function) where the properties of the object are printed and the 
// object itself is serialized and deserialized. 
public class ReadSource {
	
	Automobile automotive = null;
	
	
	
	
	
	public Automobile readData (String filename) 
	{
		try {
			FileReader file = new FileReader (filename);
			BufferedReader buff = new BufferedReader (file);
			String line = " ";
			try {
				while ((line =buff.readLine())!= null)
				{
					
				
					
					int index1 = line.indexOf("CarName and price");
					
					if (index1 != -1)
					{
						String name;
						String make;
						int size;
						double basePrice = 0.0;
						String [] terms= line.split(":");
						name = terms[1].trim();
						make = terms[2].trim();
					
						try
						{
					     
						 basePrice = Double.parseDouble(terms[3].trim());
						 
						
						}
						catch(Exception e)
						{
							FixAuto auto = new AutoException ();
							auto.setErrorMessage(1);
							String handler = auto.fix(1);
							basePrice = Double.parseDouble(handler.trim());
							auto.addLogs();
						}
					
					
						
						automotive = new Model.Automobile(name, make, basePrice);
					}
					
					int index2 = line.indexOf("Transmission");
					if (index2 != -1)
					{
						String OptionSetName = line.trim();
						automotive.setOptionSet(OptionSetName);
					}
					int index3 = line.indexOf("->");
					if (index3 != -1)
					{
						String [] terms= line.split(":");
						String OptionName = terms[1].trim();
						double Price = Double.parseDouble(terms[2].trim());
						automotive.addOption(OptionName, Price);
					}
					int index4 = line.indexOf("Brakes");
					if (index4 != -1)
					{
						String OptionSetName = line.trim();
						automotive.setOptionSet(OptionSetName);
					}
					int index5 = line.indexOf("+");
					if (index5 != -1)
					{
						String [] terms= line.split(":");
						String OptionName = terms[1].trim();
						double Price = Double.parseDouble(terms[2].trim());
						automotive.addOption(OptionName, Price);
					}
					int index6 = line.indexOf("Side impact air bags");
					if (index6 != -1)
					{
						String OptionSetName = line.trim();
						automotive.setOptionSet(OptionSetName);
					}
					int index7 = line.indexOf("=>");
					if (index7 != -1)
					{
						String [] terms= line.split(":");
						String OptionName = terms[1].trim();
						double Price = Double.parseDouble(terms[2].trim());
						automotive.addOption(OptionName, Price);
					}
					int index8 = line.indexOf("Power moonroof");
					if (index8 != -1)
					{
						String OptionSetName = line.trim();
						automotive.setOptionSet(OptionSetName);
					}
					int index9 = line.indexOf("/");
					if (index9 != -1)
					{
						String [] terms= line.split(":");
						String OptionName = terms[1].trim();
						double Price = Double.parseDouble(terms[2].trim());
						automotive.addOption(OptionName, Price);
					}
					int index10 = line.indexOf("Color");
					if (index10 != -1)
					{
						String OptionSetName = line.trim();
						automotive.setOptionSet(OptionSetName);
					}
					int index11 = line.indexOf("]");
					if (index11 != -1)
					{
						String [] terms= line.split(":");
						String OptionName = terms[1].trim();
						double Price = Double.parseDouble(terms[2].trim());
						automotive.addOption(OptionName, Price);
					}
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			
		}
	
		return automotive;
	
	}


}
