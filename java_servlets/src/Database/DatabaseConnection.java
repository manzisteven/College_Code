package Database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import Controller.EventReviews;
import Controller.EventReviews;
import Controller.FreeFoodEvent;



public class DatabaseConnection {
	private Connection myConnection;
    private Statement statement;
    

    public DatabaseConnection() {
        try {
        	Class.forName("com.mysql.jdbc.Driver");
			String db = "jdbc:mysql://localhost:3306/smanzidb";
			myConnection = DriverManager.getConnection(db, "smanzi", "1234smanzi");
        }  catch (SQLException e) {
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            System.out.println(e);
        }
    }


    public int checkCredentials (String username, String password) {

        String query= "SELECT * FROM `smanzidb`.`login` WHERE username = '" + username + "' AND password = '" + password + "';";
        int noOfResults = 0;
        try {
            statement = myConnection.createStatement() ;
            ResultSet resultSet = statement.executeQuery(query) ;
            while (resultSet.next())
                noOfResults ++ ;
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
        return ( noOfResults == 1) ? 1 : 0 ;
    }

    public int addNewFoodEvent (String topic, String location, Date date) {
        PreparedStatement statement ;
        String query= "INSERT INTO `smanzidb`.`event` (`topic`, `location`,`event_date`) VALUES (?,?,?);";
        try
        {
            statement = myConnection.prepareStatement(query);
            statement.setString(1, topic);
            statement.setString(2, location);
            statement.setTimestamp(3, new Timestamp(date.getTime()));
            statement.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e);
            return 0;
        }
        return 1 ;
    }
    public int updateUserReviews (String id, String picture, String reviewComments, String reviewPoints) {
        PreparedStatement statement ;
        String query = "UPDATE `smanzidb`.`eventReview` SET EventPicture = ?, ReviewComments = ?, ReviewPoints = ? WHERE `EventID`='" + id + "' ;";
        try
        {
        	statement = myConnection.prepareStatement(query);
        	  //statement.setString(1, id);
        	  statement.setString(1, picture);
			   statement.setString(2, reviewComments);
			   statement.setString(3, reviewPoints);
			   statement.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e);
            return 0;
        }
        return 1 ;
    }
    public ArrayList<FreeFoodEvent> getFreeFoodEvents() {
        ArrayList<FreeFoodEvent> freeFoodEvents =  new ArrayList<FreeFoodEvent>() ;

        String query= "SELECT * FROM `smanzidb`.`event`;";
        try {
            statement = myConnection.createStatement() ;
            ResultSet resultSet = statement.executeQuery(query) ;
            while (resultSet.next()) {
                FreeFoodEvent currFreeFoodEvent = new FreeFoodEvent() ;
                currFreeFoodEvent.setId(resultSet.getInt("idUsers"));
                currFreeFoodEvent.setTopic(resultSet.getString("topic"));
                currFreeFoodEvent.setLocation(resultSet.getString("location"));
                Timestamp t = resultSet.getTimestamp("event_date") ;
                Date d = new Date(t.getTime()) ;
                Calendar c = Calendar.getInstance() ;
                c.setTime(d);
                currFreeFoodEvent.setTimestamp(c.get(Calendar.MONTH) + "/" +
                        c.get(Calendar.DAY_OF_MONTH) + "/" +
                        c.get(Calendar.YEAR) + " " +
                        c.get(Calendar.HOUR) + " : " +
                        c.get(Calendar.MINUTE));

                freeFoodEvents.add(currFreeFoodEvent) ;
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
        return freeFoodEvents;
    }
    public int addUserReviews (String eventId, String picture, String reviewComments, String reviewPoints) {
        PreparedStatement statement ;
        String query= "INSERT INTO `smanzidb`.`eventReview` (`EventID`,`EventPicture`, `ReviewComments`, `ReviewPoints`) VALUES (?,?,?,?);";
        try
        {
            statement = myConnection.prepareStatement(query);
            statement.setString(1, eventId);
            statement.setString(2, picture);
            statement.setString(3, reviewComments);
            statement.setString(4, reviewPoints);
           
            statement.executeUpdate();
        }
        catch (SQLException e)
        {
            System.out.println(e);
            return 0;
        }
        return 1 ;
    }
    public ArrayList<EventReviews> getEventsReviews() {
        ArrayList<EventReviews> reviews =  new ArrayList<EventReviews>() ;

        String query= "SELECT * FROM `smanzidb`.`eventReview`;";
        try {
            statement = myConnection.createStatement() ;
            ResultSet resultSet = statement.executeQuery(query) ;
            while (resultSet.next()) {
                EventReviews totalReviews = new EventReviews() ;
                totalReviews.setEventId(resultSet.getString("EventID"));
                totalReviews.setPicture(resultSet.getString("EventPicture"));
                totalReviews.setReviewComments(resultSet.getString("ReviewComments"));
                totalReviews.setReviewPoints(resultSet.getString("ReviewPoints"));
             

                reviews.add(totalReviews) ;
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
        return reviews;
    }
}
