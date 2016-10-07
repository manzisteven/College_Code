package server;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Set;

import Model.*;
public interface AutoServer {

	public void createAutomobile (Properties auto);
	public ArrayList<String> returnListOfAutomobiles ();
	public Automobile returnSelectedAutomobile (Properties pros);
	public void updateBasePrice(Properties pros);
	public void deleteModel(Properties pros);
}
