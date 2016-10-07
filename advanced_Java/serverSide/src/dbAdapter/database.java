package dbAdapter;

import java.beans.Statement;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashSet;
public class database {
	private Connection connect;
	private HashSet <String> hash = new HashSet <String> ();
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
		
		String query = "INSERT INTO `smanzi`.`models`(`model`, `make`, `BasePrice` ) VALUES(?,?,?);";
		
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
		hash.add(make);
	}
	public void insertOptionSet (String modelName, String optionSetName)
	{
		int modelId = getModelId(modelName);
		String query = "INSERT INTO `smanzi`.`optionsets`(`modelId`, `OptionSetName`) VALUES(?,?);";
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
		String query = "INSERT INTO `smanzi`.`dboption`(`optionSetId`,`OptionName`, `optinPrice`) VALUES(?,?,?);";
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
	public ArrayList getListOfmodels(String make)
	{
		ArrayList <String >hash  = new ArrayList <String>();
		String query = "SELECT model FROM `smanzi`.`models` WHERE `make`=?;";
		ResultSet myRs = null;

		  try 
		   {
			  
			   
			   PreparedStatement statement = connect.prepareStatement(query);
			   statement.setString(1, make);
			   myRs = statement.executeQuery();
			   while (myRs.next()) {
				  hash.add(myRs.getString("model"));
				   
				   }
			  
		   }
		   catch(SQLException e)
		   {
			   e.printStackTrace();
		   }
		  return hash;
	}
  public int getModelId (String modelName)
  {
	  String query = "SELECT modelId FROM `smanzi`.`models` WHERE `model`=?;";
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
	  String query = "SELECT optionSetId FROM `smanzi`.`optionsets` WHERE `OptionSetName`=?;";
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
  public String getModelName (int modelId)
  {
	  String query = "SELECT model FROM `smanzi`.`models` WHERE `modelId`=?;";
	  ResultSet myRs = null;
	  String modelName = null;
	  try 
	   {
		  
		   
		   PreparedStatement statement = connect.prepareStatement(query);
		   statement.setInt(1, modelId);
		   myRs = statement.executeQuery();
		   if (myRs.next()) {
			    modelName = myRs.getString("model");
			   
			   }
		  
	   }
	   catch(SQLException e)
	   {
		   e.printStackTrace();
	   }
	  return modelName;
  }
  public String getMake(String modelName)
  {
	  String query = "SELECT make FROM `smanzi`.`models` WHERE `model`=?;";
	  ResultSet myRs = null;
	  String make = null;
	  try 
	   {
		  
		   
		   PreparedStatement statement = connect.prepareStatement(query);
		   statement.setString(1, modelName);
		   myRs = statement.executeQuery();
		   if (myRs.next()) {
			    make = myRs.getString("make");
			   
			   }
		  
	   }
	   catch(SQLException e)
	   {
		   e.printStackTrace();
	   }
	  return make;
  }
  public double getPrice (String modelName)
  {
	  String query = "SELECT BasePrice FROM `smanzi`.`models` WHERE `model`=?;";
	  ResultSet myRs = null;
	  double basePrice = 0.0;
	  try 
	   {
		  
		   
		   PreparedStatement statement = connect.prepareStatement(query);
		   statement.setString(1, modelName);
		   myRs = statement.executeQuery();
		   if (myRs.next()) {
			   basePrice = myRs.getDouble("BasePrice");
			   
			   }
		  
	   }
	   catch(SQLException e)
	   {
		   e.printStackTrace();
	   }
	  return basePrice;
  }
  public ArrayList getOptionSet (int modelid)
  {
	  ArrayList <String >hash  = new ArrayList <String>();
	  String query = "SELECT OptionSetName FROM `smanzi`.`optionsets` WHERE `modelId`=?;";
	  ResultSet myRs = null;
	  PrintWriter pw = null;
	  String file = "logs.txt";
	  try {
		
			pw = new PrintWriter(new FileWriter(file));
	  }
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	  try 
	   {
		  
		   
		   PreparedStatement statement = connect.prepareStatement(query);
		   statement.setInt(1, modelid);
		   myRs = statement.executeQuery();
		   while (myRs.next()) {
			 String optionSet =myRs.getString("OptionSetName");
			 pw.println(optionSet);
		    
			 hash.add(optionSet);
			   }
		  pw.close();
	   }
	   catch(SQLException e)
	   {
		   e.printStackTrace();
	   }
	  return hash;
	  
  }
  public ArrayList getOption (int modelId)
  {
	  ArrayList <String >hash  = new ArrayList <String>();
	  String query = "SELECT OptionName FROM `smanzi`.`dboption` WHERE `optionSetId`=?;";
	  ResultSet myRs = null;

	  try 
	   {
		  
		   
		   PreparedStatement statement = connect.prepareStatement(query);
		   statement.setInt(1, modelId);
		   myRs = statement.executeQuery();
		   while (myRs.next()) {
			  hash.add(myRs.getString("OptionName"));
			   
			   }
		  
	   }
	   catch(SQLException e)
	   {
		   e.printStackTrace();
	   }
	  return hash;
  }
  public double getOptionPrice (String optionName)
  {
	  String query = "SELECT optinPrice FROM `smanzi`.`dboption` WHERE `OptionName`=?;";
	  ResultSet myRs = null;
	  double basePrice = 0.0;
	  try 
	   {
		  
		   
		   PreparedStatement statement = connect.prepareStatement(query);
		   statement.setString(1, optionName);
		   myRs = statement.executeQuery();
		   if (myRs.next()) {
			   basePrice = myRs.getDouble("optinPrice");
			   
			   }
		  
	   }
	   catch(SQLException e)
	   {
		   e.printStackTrace();
	   }
	  return basePrice;
  }
  public void deleteModel (String modelName)
  {
	  String query = "delete from models where model = ?";
	  PreparedStatement statement;
	try {
		statement = connect.prepareStatement(query);
		statement.setString(1, modelName);
		statement.executeUpdate();
	} catch (SQLException e) {
		
		e.printStackTrace();
	}
	  
  }
  public void updateModelBaseprice (String model, double basePrice)
  {
	  String query = "UPDATE `smanzi`.`models` SET BasePrice = ? WHERE `model`=? ;";
	  PreparedStatement statement;
	  try
	   {
		   statement = connect.prepareStatement(query);
	
		   statement.setDouble(1, basePrice);
		   statement.setString(2, model);
		   statement.executeUpdate();
	   }
	   catch(SQLException e)
	   {
		   e.printStackTrace();
	   }
  }
}
