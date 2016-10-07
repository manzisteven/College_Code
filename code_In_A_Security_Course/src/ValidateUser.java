import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DatabaseConnection;

@WebServlet("/ValidateUser")
public class ValidateUser extends HttpServlet{

	public ValidateUser ()
	{
		super();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

		 DatabaseConnection mydb = new DatabaseConnection();
	     PrintWriter writedata = response.getWriter();
	     String loginInfo = request.getParameter("UserName");
	     //writedata.println(mydb.getError());
	     try {
			if (mydb.checkUsername(loginInfo))
			 {
				String b = mydb.getSequenceNumber(loginInfo);
				//int d = Integer.parseInt(b.trim());
				//d-=1;
				int ab = 0;
				 String sequenceNumber = mydb.getSequenceNumber(loginInfo);
				 int seqN = Integer.parseInt(sequenceNumber);
				  ab = seqN -1;
		         String nickname = mydb.getNickname(loginInfo);
		         String color = mydb.getColor(loginInfo);
		         String colorDescrption = mydb.getColorDescrption(loginInfo);
				writedata.println("<h4>Welcome "+nickname+"</h4>");
			
				writedata.println("<h4>Do you see your color and personal phrase below, if so enter your password</h4>");
				
				writedata.println("<h4>Color: "+color+"</h4>");
			
				writedata.println("<h4>Color description: "+colorDescrption+"</h4>");
				writedata.println("<h4>If not, YOU MAY BE UNDER ATTACK! Do not enter your passphrase. Carefully check the name of the website and try again. If the problem persists, contact the website administrator. Never give personal details of your account by telephone or email. </h4>");
				
				writedata.println(
						
						
						"<html><head><title>Infosec Web app</title></head><body>"+
							"<h1>Login</h1>"+
							"<form action = \"Login\" method= \"post\"><table><tr><td>UserName</td>"+
									"<td><input type=\"text\" name=\"UserName\" value=\"\"></td></tr>"+
									"<tr><td>Password</td><td><input type=\"text\" name=\"Password\" value=\"\"></td></tr>"+	
									"<tr><td><input type=\"submit\" value=\"Login\"></td></tr></table></form>"+
						"</body></html>"
		  		     	);
				writedata.println("<h4>Login with your password hashed(" + ab + ") times</h4>");
				writedata.println("<h4>The hashing sequenceNumber were not being updated for reasons I was not able to figure out, </h4>");
				writedata.println("<h4>but since the passwords are updated in the database, next time login with passwords hashed " + 98 + ", " + 97 + " and so on</h4>");
			 }
			else
			{
				writedata.println(" Username not found");
			}
			
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
