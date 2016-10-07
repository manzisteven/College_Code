package Model;

import java.io.Serializable;
import java.util.ArrayList;

import Model.OptionSet.Option;

public class Automobile implements Serializable {
private String Make; 
private String Model;
private   ArrayList<OptionSet> list = new ArrayList<OptionSet>();
private double baseprice; 


public Automobile (String Model, String Make, double baseprice)
{
	this.Model = Model;
	this.Make = Make;
	this.baseprice = baseprice;
	
}

public synchronized double getBasePrice ()
{
	return baseprice;
}

public synchronized String getMake()
{
	return Make;
}
public synchronized String getModel()
{
	return Model;
}
public synchronized String getOptionChoice(String optionSetName)
{
	int i;
	OptionSet.Option optionChoice = null;
	for ( i =0; i<list.size(); i++)
	{
		if(optionSetName.equals(list.get(i).getOptionsetName()))
		{
			optionChoice = list.get(i).getOptionChoice();
			break;
		}
		
	}
	String optionChoiceName = optionChoice.getName();
	return optionChoiceName;
	
}

public ArrayList getOptionNames (String OptionSetName)
{
	ArrayList<String> names = new ArrayList<String>();
	for (int i =0; i<list.size(); i++)
	{
		if(OptionSetName.equals(list.get(i).getOptionsetName()))
		{
		ArrayList<OptionSet.Option> optionNames = list.get(i).getOptions();
		for (int j =0; j<optionNames.size(); j++)
		{
			
			 String returnedName = optionNames.get(j).getName();
			 names.add(returnedName);
		}
		}
	}
	return names;
}
public ArrayList getAllOptionSetNames ()
{
	ArrayList<String> names = new ArrayList<String>();
	for (int i =0; i<list.size(); i++)
	{
	   String name = list.get(i).getOptionsetName();
	   names.add(name);
	   System.out.println(name);
	}
	return names;
}

public synchronized double getOptionChoicePrice (String optionSetName)
{
	int i;
	OptionSet.Option optionChoice = null;
	for ( i =0; i<list.size(); i++)
	{
		if(optionSetName.equals(list.get(i).getOptionsetName()))
		{
			optionChoice = list.get(i).getOptionChoice();
			break;
		}
		
	}
	String optionChoiceName = optionChoice.getName();
	double optionChoicePrice = optionChoice.getPrice();
	return optionChoicePrice;
}
public synchronized double getTotalPrice()
{
	double transmissionOptionPrice = getOptionChoicePrice("Transmission");
	double brakesOptionPrice = getOptionChoicePrice("Brakes");
	double airBagPrice = getOptionChoicePrice("Side impact air bags");
	double MoonPowerRoofOptionPrice = getOptionChoicePrice("Power moonroof");
	double colorOptionPrice = getOptionChoicePrice("Color");
	double totalPrice = baseprice + transmissionOptionPrice + brakesOptionPrice + airBagPrice + 
			MoonPowerRoofOptionPrice + colorOptionPrice;
	return totalPrice;
}
public synchronized void setMake (String Make)
{
	this.Make = Make;
}
public synchronized void setModel (String Model)
{
	this.Model = Model;
}
public void setBasePrice (double newBasePrice)
{
	baseprice = newBasePrice;
}
public synchronized void setOptionSet (String OptionSetName)
{
	
		OptionSet optionSet = new OptionSet(OptionSetName);
		list.add(optionSet);
	
}
public synchronized void setOptionchoice (String optionSetName, String optionName)
{
	for (int i =0; i<list.size(); i++)
	{
		if(optionSetName.equals(list.get(i).getOptionsetName()))
		{
			ArrayList <Option>options  = list.get(i).getOptions();
			for (int j =0; j<options.size(); j++)
			{
				if(optionName.equals(options.get(j).getName()))
				{
				
					list.get(i).setOptionChoice(options.get(j));
				}
			}
		}
		
		
		
	}
}
public synchronized void addOption(String optionNames, double  optionPrice)
{
	// Use the recently added optionSet in the arrayList, this will be the currently instantiated optionSet object
	// in the readData function inside the readSource java file. 
	for (int i =0; i<list.size(); i++)
	{
		if (i == list.size()-1)
		{
			list.get(i).setOptionName(optionNames, optionPrice);
		}
	}
	
	
	
}
public synchronized void updateOptionSetName(String optionSetName, String newName)
{
	for (int i =0; i<list.size(); i++)
	{
		if(optionSetName.equals(list.get(i).getOptionsetName()))
		{
			
			list.get(i).setOptionSetname(newName);
			break;
		}
		
		}
	
}
public synchronized void updateOptionPrice (String optionSetName, String optionName,  double newPrice)
{

	for (int i =0; i<list.size(); i++)
	{
		if(optionSetName.equals(list.get(i).getOptionsetName()))
		{
			ArrayList <Option>options  = list.get(i).getOptions();
			for (int j =0; j<options.size(); j++)
			{
				if(optionName.equals(options.get(j).getName()))
				{
					options.get(j).setOptionPrice(newPrice);
					
					
					
				}
			}
		}
		
		
		
	}
}
public synchronized void print ()
{
	StringBuffer buffer = new StringBuffer ();
	buffer.append("Car Name: ");
	buffer.append(Model);
	buffer.append('\n');
	buffer.append("Base price: ");
	buffer.append(baseprice);
	
	System.out.println(buffer.toString());
	for (int i = 0; i<list.size(); i++)
	{
		list.get(i).print();
	}
}
}
