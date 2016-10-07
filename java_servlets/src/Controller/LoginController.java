package Controller;

import Database.DatabaseConnection;

public class LoginController {
	private DatabaseConnection databaseConnection ;
	public LoginController () 
	{
		 databaseConnection = new DatabaseConnection() ;
	}
	 public int checkCredentials (String username, String password) {
	        return databaseConnection.checkCredentials(username, password) ;
	    }
	 
}
