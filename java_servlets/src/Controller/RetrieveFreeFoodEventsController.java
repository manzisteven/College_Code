package Controller;

import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import Database.DatabaseConnection;

public class RetrieveFreeFoodEventsController {
	 private DatabaseConnection databaseConnection ;

	    public RetrieveFreeFoodEventsController () {
	        databaseConnection = new DatabaseConnection() ;
	    }

	    public JSONArray getFreeFoodEvents () {
	        ArrayList<FreeFoodEvent> freeFoodEvents = new ArrayList<FreeFoodEvent>() ;
	        freeFoodEvents = databaseConnection.getFreeFoodEvents() ;
	        return convertToJSON (freeFoodEvents) ;
	    }

	    private JSONArray convertToJSON (ArrayList<FreeFoodEvent> freeFoodEvents) {

	        JSONArray freeFoodEventsArray = new JSONArray() ;
	        for (FreeFoodEvent freeFoodEvent : freeFoodEvents) {
	            JSONObject freeFoodEventJson = new JSONObject() ;
	            freeFoodEventJson.put("id", freeFoodEvent.getId()) ;
	            freeFoodEventJson.put("topic", freeFoodEvent.getTopic());
	            freeFoodEventJson.put("location", freeFoodEvent.getLocation()) ;
	            freeFoodEventJson.put("timestamp", freeFoodEvent.getTimestamp()) ;

	            freeFoodEventsArray.add(freeFoodEvent) ;
	        }

	        return  freeFoodEventsArray ;
	    }

}
