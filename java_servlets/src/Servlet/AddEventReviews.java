package Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.AddEventReviewController;
import Controller.AddFreeFoodEventController;

/**
 * Servlet implementation class AddEventReviews
 */
@WebServlet("/AddEventReviews")
public class AddEventReviews extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String EventID = "eventID";
	private final String userPicture = "eventPicture" ;
	private final String reviewComments = "reviewComments" ;
	private final String reviewpoints = "reviewPoints";
    private AddEventReviewController AddEventReviewController ;
   
    public AddEventReviews() {
    	AddEventReviewController  = new AddEventReviewController () ;
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int addResult = 1 ;
	        PrintWriter out = null ;
	        try {
	            String eventId = request.getParameter(EventID);
	            String picture = request.getParameter(userPicture);
	            String Comments = request.getParameter(reviewComments);
	            String points = request.getParameter(reviewpoints);
	            

	            out = response.getWriter();
	            addResult = AddEventReviewController.addEventReviews(eventId, picture, Comments, points) ;

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        } 

	        out.println(addResult);
	}

}
