package Controller;

import java.util.Date;

import Database.DatabaseConnection;

public class AddUpdatedReviewsController {
	   private DatabaseConnection databaseConnection ;

	    public AddUpdatedReviewsController() {
	        databaseConnection = new DatabaseConnection() ;
	    }

	    public int addUpdatedInformation(String id, String picture, String reviewComments, String reviewPoints) {
	        return databaseConnection.updateUserReviews (id, picture, reviewComments, reviewPoints);
	    }
}
