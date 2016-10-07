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

import Controller.AddFreeFoodEventController;
import Controller.AddUpdatedReviewsController;

/**
 * Servlet implementation class UpdateReviews
 */
@WebServlet("/UpdateReviews")
public class UpdateReviews extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String EventId = "ID" ;
	private final String picture = "Picture" ;
	private final String reviewsComments = "ReviewComments" ;
	private final String reviewsPoints = "ReviewPoints" ;
    private AddUpdatedReviewsController updatedReviews ;
   
    public UpdateReviews() {
       
    	updatedReviews  = new AddUpdatedReviewsController() ;
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   int addResult = 1 ;
	        PrintWriter out = null ;
	        try {
	            String id = request.getParameter(EventId);
	            String userPicture = request.getParameter(picture);
	            String comments = request.getParameter(reviewsComments);
	            String points = request.getParameter(reviewsPoints);
	            

	            out = response.getWriter();
	            addResult = updatedReviews.addUpdatedInformation(id, userPicture, comments, points) ;

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        } 

	        out.println(addResult);
	    }

}
