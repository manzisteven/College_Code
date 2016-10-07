package Adapter;
import java.util.LinkedHashMap;
import java.util.Map;

import Model.*;
import Util.*;
public abstract class proxyAutomobile {
private static Automobile automobile;
private ReadSource readdata = new ReadSource();
private static LinkedHashMap<String, Automobile> linkedHashMap = new LinkedHashMap<String, Automobile>();

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

}
