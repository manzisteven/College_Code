package servletPackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Properties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import client.CarModelOptionsIO;
import Model.Automobile;


@WebServlet("/Myservlet")
public class Myservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private ObjectOutputStream out;
	 private ObjectInputStream in;
	 private Socket socket;
     private CarModelOptionsIO client;
    public Myservlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
PrintWriter write = response.getWriter();
		
		try {
			socket = new Socket (InetAddress.getByName("127.0.0.1"), 6789);
		} catch (UnknownHostException e) {
		
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		try {
			out = new ObjectOutputStream (socket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		Properties serverRequest = new Properties ();
		serverRequest.put("send list of models", "models"); 
		
		out.writeObject(serverRequest);
		try {
			ArrayList auto = (ArrayList)in.readObject();
			String model1 = null;
			String model2 = null;
			String model3 = null;
			for (int i =0; i< auto.size(); i++)
			{
				if (i ==0)
				{
				 model1 = (String)auto.get(i);
				}
				if (i ==1)
				{
				 model2 = (String)auto.get(i);
				}
				if (i ==2)
				{
				 model3 = (String)auto.get(i);
				}
			}
			
			write.println("<HTML><TITLE></TITLE><BODY>");
			write.println("<FORM METHOD=\"post\" ACTION=\"Configure\">");
			write.println("<H2>Choose the model you want to configure and click Start Configuration button </H2>");
			write.println("<B>List of models </B>");
			write.println("<SELECT NAME=title>");
			 for (int i = 0; i < auto.size(); i++) {
	                write.println("<option value=\"" + auto.get(i) + "\">" + auto.get(i) + "</option>");
	            }
			//write.println("<OPTION VALUE=\""+model3+"\">"+model3+"");
			write.println("</SELECT><BR>");
			write.println("<tr><td><input type=\"submit\" value=\"Start Configuration\"></td></tr>");
			write.println("</FORM>");
			write.println("</BODY><HTML>");
		
			out.writeObject("End");
			write.println(
					//"<h4>done</h4>"
					);
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		write.println(
				
				);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
