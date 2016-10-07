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


@WebServlet("/AddFreeFoodEvent")
public class AddFreeFoodEvent extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String TOPIC = "topic" ;
	private final String LOCATION = "location" ;
	private final String DATE = "time" ;
    private AddFreeFoodEventController addFreeFoodEventController ;
   
    public AddFreeFoodEvent() {
       
    	addFreeFoodEventController = new AddFreeFoodEventController() ;
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   int addResult = 1 ;
	        PrintWriter out = null ;
	        try {
	            String topic = request.getParameter(TOPIC);
	            String location = request.getParameter(LOCATION);
	            Date date = new SimpleDateFormat("MM/dd/yyyy HH : mm").parse(request.getParameter(DATE));

	            out = response.getWriter();
	            addResult = addFreeFoodEventController.addFreeFoodEvent(topic, location, date) ;

	        } catch (IOException ex) {
	            ex.printStackTrace();
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }

	        out.println(addResult);
	    }
		
	

}
