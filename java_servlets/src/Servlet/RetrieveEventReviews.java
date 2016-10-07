package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONValue;

import Controller.RetrieveEventsReviewsController;
import Controller.RetrieveFreeFoodEventsController;

/**
 * Servlet implementation class RetrieveEventReviews
 */
@WebServlet("/RetrieveEventReviews")
public class RetrieveEventReviews extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    private RetrieveEventsReviewsController controller ;
   
    public RetrieveEventReviews() {
    	controller = new RetrieveEventsReviewsController() ;
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  PrintWriter out  ;
	        String jsonFreeFoodEvents = "{}"  ;

	        try {
	            out = response.getWriter();
	            jsonFreeFoodEvents = convertToString(controller.getFreeFoodEvents()) ;
	            out.println(jsonFreeFoodEvents) ;
	        } catch (IOException ex) {
	            ex.printStackTrace() ;
	        }
	}
	 private String convertToString(JSONArray freeFoodEventsJson) {
	        return JSONValue.toJSONString(freeFoodEventsJson) ;
	    }

}
