package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Guest
 */
@WebServlet("/Guest")
public class Guest extends HttpServlet {
	private static final long serialVersionUID = 1L;
   private HashSet <String> array = new HashSet <String> ();
   private HashSet <String> array1 = new HashSet <String> ();
    
     
	
	
	
    public Guest() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writedata = response.getWriter();
		String name = request.getParameter("Names");
		array.add(name);
		String message = request.getParameter("Message");
		array1.add(message);
		writedata.print("<h4> Names </h4>");
		for (String key: array)
		{
			
			writedata.print("<h4>"+key+"</h4>");
			
			
		}
		writedata.print("<h4> Messages </h4>");
		for (String key: array1)
		{
			
			writedata.print("<h4>"+key+"</h4>");
			
			
		}
		writedata.println("<h4>ok</h4>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
