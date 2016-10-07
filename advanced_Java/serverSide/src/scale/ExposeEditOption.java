package scale;

public interface ExposeEditOption {
	public void buildAuto (String filename);
	public void printAuto (String modelName);
	public void updateOptionSetName(String modelName, String optionSetName, String newName);
	public void updateOptionPrice (String modelname, String optionSetName, String option, double newPrice);
}
