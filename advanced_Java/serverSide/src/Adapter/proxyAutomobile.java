package Adapter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;




import dbAdapter.database;
import Model.*;
import Util.*;
public abstract class proxyAutomobile {
private static Automobile automobile;
private ReadSource readdata = new ReadSource();
private static LinkedHashMap<String, Automobile> linkedHashMap = new LinkedHashMap<String, Automobile>();
private database db = new database ();
public void buildAuto (String filename)
{
	automobile = readdata.readData(filename);
	String modelName = automobile.getModel();
	linkedHashMap.put(modelName, automobile);
	
}
public void printAuto (String modelName)
{
	automobile = linkedHashMap.get(modelName);
	automobile.print();
}
public void updateOptionSetName(String modelName, String optionSetName, String newName)
{
	automobile = linkedHashMap.get(modelName);
	automobile.updateOptionSetName(optionSetName, newName);
}
public void updateOptionPrice (String modelName, String optionSetName, String optionName, double newPrice)
{
	automobile = linkedHashMap.get(modelName);
	automobile.updateOptionPrice(optionSetName, optionName, newPrice);
}

//server
public void createAutomobile (Properties auto)
{
	
	String carMake = auto.getProperty("CarMake");
	
	Automobile automotive = null;
	if (!carMake.equals(null))
	{
		String CarModel = auto.getProperty("CarModel");
		double BasePrice =   Double.parseDouble(auto.getProperty("BasePrice"));
		
		// Create automobile object
	   automotive = new Automobile (CarModel.trim(), carMake.trim(), BasePrice);
	   String option1 = auto.getProperty("Option1");
	  
	    // optionSet: Transmission
	    automotive.setOptionSet(option1);
	    String optionValue1a = auto.getProperty("OptionValue1a");
	    double price1a = Double.parseDouble(auto.getProperty("OptionValue1aPrice").trim());
	   
	    automotive.addOption( optionValue1a, price1a);
	    String optionValue1b = auto.getProperty("OptionValue1b");
	    double price1b = Double.parseDouble(auto.getProperty("OptionValue1bPrice").trim());
	    
	    automotive.addOption( optionValue1b, price1b);
	    // optionSet: Brakes
	    String option2 = auto.getProperty("Option2");
	    
	    automotive.setOptionSet(option2);
	    String optionValue2a = auto.getProperty("OptionValue2a");
	    double price2a = Double.parseDouble(auto.getProperty("OptionValue2aPrice").trim());
	    
	    automotive.addOption( optionValue2a, price2a);
	    String optionValue2b = auto.getProperty("OptionValue2b");
	    double price2b = Double.parseDouble(auto.getProperty("OptionValue2bPrice").trim());
	   
	    automotive.addOption( optionValue2b, price2b);
	    String optionValue2c = auto.getProperty("OptionValue2c");
	    double price2c = Double.parseDouble(auto.getProperty("OptionValue2cPrice").trim());
	   
	    automotive.addOption(optionValue2c, price2c);
	    // OptionSet: airbag
	    String option3 = auto.getProperty("Option3");
	    
	    automotive.setOptionSet(option3);
	    String optionValue3a = auto.getProperty("OptionValue3a");
	    double price3a = Double.parseDouble(auto.getProperty("OptionValue3aPrice").trim());
	    
	    automotive.addOption(optionValue3a, price3a);
	    String optionValue3b = auto.getProperty("OptionValue3b");
	    double price3b = Double.parseDouble(auto.getProperty("OptionValue3bPrice").trim());
	   
	    automotive.addOption(optionValue3b, price3b);
	    
	    // OptionSet : Power moonRoof 
	    String option4 = auto.getProperty("Option4");
	    
	    automotive.setOptionSet(option4);
	    String optionValue4a = auto.getProperty("OptionValue4a");
	    double price4a = Double.parseDouble(auto.getProperty("OptionValue4aPrice").trim());
	   
	    automotive.addOption(optionValue4a, price4a);
	    String optionValue4b = auto.getProperty("OptionValue4b");
	    double price4b = Double.parseDouble(auto.getProperty("OptionValue4bPrice").trim());
	  
	    automotive.addOption(optionValue4b, price4b);
	    
	    // OptionSet: Color
	    String option5 = auto.getProperty("Option5");
	  
	    automotive.setOptionSet(option5);
	    String optionValue5a = auto.getProperty("Option5a");
	    double price5a = Double.parseDouble(auto.getProperty("OptionValue5aPrice").trim());
	   
	    automotive.addOption(optionValue5a, price5a);
	    String optionValue5b = auto.getProperty("Option5b");
	    double price5b = Double.parseDouble(auto.getProperty("OptionValue5bPrice").trim());
	    
	    automotive.addOption(optionValue5b, price5b);
	    String optionValue5c = auto.getProperty("Option5c");
	    double price5c = Double.parseDouble(auto.getProperty("OptionValue5cPrice").trim());
	    
	    automotive.addOption(optionValue5c, price5c);
	    String optionValue5d = auto.getProperty("Option5d");
	    double price5d = Double.parseDouble(auto.getProperty("OptionValue5dPrice").trim());
	    
	    automotive.addOption(optionValue5d, price5d);
	    String optionValue5e = auto.getProperty("Option5e");
	    double price5e = Double.parseDouble(auto.getProperty("OptionValue5ePrice").trim());
	   
	    automotive.addOption(optionValue5e, price5e);
	    String optionValue5f = auto.getProperty("Option5f");
	    double price5f = Double.parseDouble(auto.getProperty("OptionValue5fPrice").trim());
	   ;
	    automotive.addOption(optionValue5f, price5f);
	    String optionValue5g = auto.getProperty("Option5g");
	    double price5g = Double.parseDouble(auto.getProperty("OptionValue5gPrice").trim());
	  
	    automotive.addOption(optionValue5g, price5g);
	    String optionValue5h = auto.getProperty("Option5h");
	    double price5h = Double.parseDouble(auto.getProperty("OptionValue5hPrice").trim());
	   
	    automotive.addOption(optionValue5h, price5h);
	    String optionValue5i = auto.getProperty("Option5i");
	    double price5i = Double.parseDouble(auto.getProperty("OptionValue5iPrice").trim());
	  
	    automotive.addOption(optionValue5i, price5i);
	    String optionValue5j = auto.getProperty("Option5j");
	    double price5j = Double.parseDouble(auto.getProperty("OptionValue5jPrice").trim());
	   
	    automotive.addOption(optionValue5j, price5j);
	    String optionValue5k = auto.getProperty("Option5k");
	    double price5k = Double.parseDouble(auto.getProperty("OptionValue5kPrice").trim());
	   
	    automotive.addOption(optionValue5k, price5k);
	    String optionValue5l = auto.getProperty("Option5l");
	    double price5l = Double.parseDouble(auto.getProperty("OptionValue5lPrice").trim());
	    
	    automotive.addOption(optionValue5l, price5l);
	    String optionValue5m = auto.getProperty("Option5m");
	    double price5m = Double.parseDouble(auto.getProperty("OptionValue5mPrice").trim());
	   
	    automotive.addOption(optionValue5m, price5m);
	}
	linkedHashMap.put(carMake , automotive);
}
public ArrayList<String> returnListOfAutomobiles ()
{
	ArrayList <String>array = new ArrayList <String> ();
	for (String key : linkedHashMap.keySet())
	{
		array.add(key);
	}
	return array;
}
public Automobile returnSelectedAutomobile (Properties pros)
{
	String key = pros.getProperty("send object");
	System.out.println(key);
	Automobile auto = linkedHashMap.get(key);
	return auto;
}
public void deleteModel (Properties pros)
{
	String model = pros.getProperty("DeleteModel");
	linkedHashMap.remove(model);
}
public void updateBasePrice (Properties pros)
{
	String ModelName = pros.getProperty("ChangedModel");
	String price = pros.getProperty("New Price");
	double newPrice = Double.parseDouble(price);
	Automobile auto = linkedHashMap.get(ModelName);
	auto.setBasePrice(newPrice);
}
}
