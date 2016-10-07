package Controller;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Database.DatabaseConnection;

public class RetrieveEventsReviewsController {
	private DatabaseConnection databaseConnection ;

    public RetrieveEventsReviewsController () {
        databaseConnection = new DatabaseConnection() ;
    }

    public JSONArray getFreeFoodEvents () {
        ArrayList<EventReviews> EventReviews = new ArrayList<EventReviews>() ;
        EventReviews = databaseConnection.getEventsReviews() ;
        return convertToJSON (EventReviews) ;
    }

    private JSONArray convertToJSON (ArrayList<EventReviews> reviews) {

        JSONArray freeFoodEventsArray = new JSONArray() ;
        for (EventReviews userReviews : reviews) {
            JSONObject freeFoodEventJson = new JSONObject() ;
            freeFoodEventJson.put("id", userReviews.getEventId()) ;
            freeFoodEventJson.put("picture", userReviews.getPictuture());
            freeFoodEventJson.put("reviewComments", userReviews.getReviewComments()) ;
            freeFoodEventJson.put("reviewPoints", userReviews.getReviewPoints()) ;

            freeFoodEventsArray.add(userReviews) ;
        }

        return  freeFoodEventsArray ;
    }
	

}
