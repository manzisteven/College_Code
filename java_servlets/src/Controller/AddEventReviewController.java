package Controller;

import java.util.Date;

import Database.DatabaseConnection;

public class AddEventReviewController {
	   private DatabaseConnection databaseConnection ;

	    public AddEventReviewController() {
	        databaseConnection = new DatabaseConnection() ;
	    }

	    public int addEventReviews(String eventId, String picture, String reviewComments, String reviewPoints)
	    {
	        return databaseConnection.addUserReviews (eventId, picture, reviewComments, reviewPoints) ;
	    }
}
