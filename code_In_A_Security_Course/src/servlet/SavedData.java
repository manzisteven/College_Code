package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DatabaseConnection;


@WebServlet("/SavedData")
public class SavedData extends HttpServlet
{
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SavedData()
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//Retrieving the data from the resquest
		String name = request.getParameter("First Name");

		//Connecting to the database and inserting data
		DatabaseConnection db = new DatabaseConnection();
		db.insertInfo(name);

		//Building the http response
		PrintWriter writer = response.getWriter();
		String htmlRespone = "<html> ";
		htmlRespone += "<h1> steven manzi</h1>" +"<h2>" + name + " has been successfully saved." + "</h2>";
		htmlRespone += "</html>";
		writer.println(htmlRespone);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
