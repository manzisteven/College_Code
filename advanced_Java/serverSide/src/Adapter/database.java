package Adapter;

import java.beans.Statement;
import java.sql.*;
public class database {
	private Connection connect;
	public database()
	{
		String databaseLink = "jdbc:mysql://localhost:3306/smanzi";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			
			e1.printStackTrace();
		}
		try {
			connect = DriverManager.getConnection(databaseLink, "root", "");
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
	}
	
	public void insertModel (String make, String model, double basePrice)
	{
		
		String query = "INSERT INTO `smanzi`.`model`(`model`, `make`, `BasePrice` ) VALUES(?,?,?);";
		
			   try 
			  {
				 
				   PreparedStatement statement = connect.prepareStatement(query);
				   statement.setString(1, make);
				   statement.setString(2, model);
				   statement.setDouble(3, basePrice);
				   
				   statement.executeUpdate();
			   }
			   catch(SQLException e)
			   {
				   e.printStackTrace();
			   }
		
	}
	public void insertOptionSet (String modelName, String optionSetName)
	{
		int modelId = getModelId(modelName);
		String query = "INSERT INTO `smanzi`.`optionset`(`modelId`, `OptionSetName`) VALUES(?,?);";
		   try 
			  {
				 
				   PreparedStatement statement = connect.prepareStatement(query);
				   statement.setInt(1, modelId);
				   statement.setString(2, optionSetName);
				   
				   
				   statement.executeUpdate();
			   }
			   catch(SQLException e)
			   {
				   e.printStackTrace();
			   }
		
		
	}
	public void insertOptions (String optionSetName, String optionName, double optionPrice)
	{
		int optionSetId = getOptionSetId(optionSetName);
		String query = "INSERT INTO `smanzi`.`options`(`optionSetId`,`OptionName`, `optinPrice`) VALUES(?,?,?);";
		   try 
			  {
				 
				   PreparedStatement statement = connect.prepareStatement(query);
				   statement.setInt(1, optionSetId);
				   statement.setString(2, optionName);
				   statement.setDouble(3, optionPrice);
				   
				   statement.executeUpdate();
			   }
			   catch(SQLException e)
			   {
				   e.printStackTrace();
			   }
		
	}
  public int getModelId (String modelName)
  {
	  String query = "SELECT modelId FROM `smanzi`.`model` WHERE `model`=?;";
	  ResultSet myRs = null;
	  String modelId = null;
	  try 
	   {
		  
		   
		   PreparedStatement statement = connect.prepareStatement(query);
		   statement.setString(1, modelName);
		   myRs = statement.executeQuery();
		   if (myRs.next()) {
			    modelId = myRs.getString("modelId");
			   
			   }
		  
	   }
	   catch(SQLException e)
	   {
		   e.printStackTrace();
	   }
	  return Integer.parseInt(modelId);
  }
  public int getOptionSetId (String optionSetname)
  {
	  String query = "SELECT optionSetId FROM `smanzi`.`optionset` WHERE `OptionSetName`=?;";
	  ResultSet myRs = null;
	  String optionSetId = null;
	  try 
	   {
		  
		   
		   PreparedStatement statement = connect.prepareStatement(query);
		   statement.setString(1, optionSetname);
		   myRs = statement.executeQuery();
		   if (myRs.next()) {
			   optionSetId = myRs.getString("optionSetId");
			   
			   }
		  
	   }
	   catch(SQLException e)
	   {
		   e.printStackTrace();
	   }
	  return Integer.parseInt( optionSetId);
  }
}
