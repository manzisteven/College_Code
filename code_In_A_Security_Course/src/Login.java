import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Database.DatabaseConnection;

@WebServlet("/Login")
public class Login extends HttpServlet {
	int counter = 0;
	int i;
	private static final long serialVersionUID = 1L;
	public Login()
    {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
	     DatabaseConnection mydb = new DatabaseConnection();
	     PrintWriter writedata = response.getWriter();
	     //writedata.println("Testing");
	     String loginInfo = request.getParameter("UserName");
	     String passwordInfo = request.getParameter("Password");
	     //writedata.println(loginInfo);
	     //writedata.println(passwordInfo);
	    
	    	 
			
					try {
						
						if(mydb.authenticateUser( loginInfo, passwordInfo))
						 {
							 //writedata.println("Successfull logged in ");
							 HttpSession session = request.getSession();
					            session.setAttribute("user", loginInfo);
					            //setting session to expiry in  mins
					            session.setMaxInactiveInterval(10);
					            Cookie userName = new Cookie("user", loginInfo);
					            userName.setMaxAge(10);
					            response.addCookie(userName);
					            //response.sendRedirect("loginSucceded.jsp");
					            String encodedURL = response.encodeRedirectURL("loginSucceded.jsp");
					            response.sendRedirect(encodedURL);
							
						 }
						 else 
						 {  
							
							
							 response.sendRedirect("Login1.html");
							 
							 
						 }
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	     
	   
	     
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
