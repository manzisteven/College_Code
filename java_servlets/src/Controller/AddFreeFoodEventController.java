package Controller;

import java.util.Date;

import Database.DatabaseConnection;

public class AddFreeFoodEventController {
	   private DatabaseConnection databaseConnection ;

	    public AddFreeFoodEventController() {
	        databaseConnection = new DatabaseConnection() ;
	    }

	    public int addFreeFoodEvent(String topic, String location, Date date) {
	        return databaseConnection.addNewFoodEvent (topic, location, date) ;
	    }

}
