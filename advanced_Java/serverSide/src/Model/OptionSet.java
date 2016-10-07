package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class OptionSet implements Serializable {
	private String name;
	private Option optionChoice;
	private ArrayList<Option> list = new ArrayList<Option>();
	  protected OptionSet(String name)
	    {
	    	this.name = name;
	    	
	    }
  
    protected ArrayList <Option> getOptions ()
    {
    	return list;
    }
    protected String getOptionsetName ()
    {
    	return name;
    }
    protected void setOptionChoice (Option optionChoice)
    {
    	this.optionChoice = optionChoice;
    }
    protected Option getOptionChoice()
    {
    	return this.optionChoice;
    }
    protected void setOptionSetname(String name)
    {
    	this.name = name;
    }
    protected void setOptionName(String optionName, double  optionPrice)
    {
         Option option = new Option (optionName, optionPrice);
         this.list.add(option);
    }

    protected void print ()
    {
    	StringBuffer buffer = new StringBuffer ();
    	buffer.append('\n');
    	buffer.append("Name of property: ");
    	buffer.append(name);
    	buffer.append('\n');
    	buffer.append("options for "+ name+ ":");
    	buffer.append('\n');
    	System.out.println(buffer.toString());
    	for (int i =0; i<list.size(); i++)
    	{
    		this.list.get(i).print();
    	}
    }
	class Option implements Serializable 
	{
		private String name;
		private double price;
		protected Option(String name, double price)
		{
			this.name = name;
			this.price = price;
		}
		protected String getName ()
		{
			return name;
		}
		protected double getPrice ()
		{
			return price;
		}
		protected void setOptionPrice (double price)
		{
			this.price = price;
		}
		protected void print ()
		{
			StringBuffer buffer = new StringBuffer ();
			buffer.append(name);
			buffer.append('\n');
			buffer.append("Price: ");
			buffer.append(price);
		
			System.out.println(buffer.toString());
		}
		
	}
}
