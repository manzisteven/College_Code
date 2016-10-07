package Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controller.LoginController;

/**
 * 
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final String USERNAME = "username" ;
    private final String PASSWORD = "password" ;
    private LoginController loginController ;
 
    public Login() {
    	this.loginController = new LoginController() ;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       
		
	    }
		
	

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	       
		int loginCheck = 0 ;
	        PrintWriter out = null ;
	        try {
	            String username = request.getParameter(USERNAME);
	            String password = request.getParameter(PASSWORD);
	            out = response.getWriter();
	            loginCheck = loginController.checkCredentials(username, password) ;
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	        out.println(loginCheck);
	    }
		
	

}
