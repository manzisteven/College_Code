package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DatabaseConnection;

Servlet("/Outputpage")
public class Outputpage extends HttpServlet
{
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Outputpage()
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		DatabaseConnection db = new DatabaseConnection();
		String info = db.retrieveAll();
		PrintWriter writer = response.getWriter();
		String htmlRespone = "<html>";
		htmlRespone += "<h1> steven manzi</h1>" +"<h1>Data from database</h1>" ;
		htmlRespone += "<p>" + info + "</p>";
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
