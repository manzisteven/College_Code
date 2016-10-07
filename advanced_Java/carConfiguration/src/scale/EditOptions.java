package scale;
import java.util.LinkedHashMap;
import java.util.Map;

import Adapter.BuildAuto;
import Model.Automobile;
public class EditOptions extends BuildAuto implements ExposeEditOption, Runnable {
    private String modelName;
    private String optionSetName;
    private String optionName;
    private double newPrice;
    private Thread t;
	public EditOptions (String modelName, String optionSetName, String optionName, double newPrice)
	{
	     this.modelName = modelName;
	     this.optionSetName = optionSetName;
	     this.optionName = optionName;
	     this.newPrice = newPrice;
	     t = new Thread (this);
	     t.start();
	}
	// To avoid data corruption all methods in the automobile class are synchronized
	
	public void run ()
	{
		updateOptionPrice (modelName, optionSetName, optionName, newPrice );
		printAuto(modelName);
		
	}
}
