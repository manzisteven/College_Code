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

import Model.Automobile;
import Model.OptionSet;


@WebServlet("/Configure")
public class Configure extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ObjectOutputStream out;
	private ObjectInputStream in;
	private Socket socket; 
   
    public Configure() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter write = response.getWriter();
		String model = request.getParameter("title");
		try {
			socket = new Socket (InetAddress.getByName("127.0.0.1"),  6789);
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
		//if (model.equals("Ford"))
		//{
			Properties serverRequest = new Properties ();
			serverRequest.put("send object", model); 
			out.writeObject(serverRequest);
			try {
				 Automobile auto = (Automobile)in.readObject();
				 ArrayList <String>optionSetNames = auto.getAllOptionSetNames();
				 ArrayList Transmission = null;
				 ArrayList Brake = null;
				 ArrayList airBag = null;
				 ArrayList MoonRoof = null;
				 ArrayList Color = null;
			
				 for (int i =0; i<optionSetNames.size(); i++)
				 {
					if (i==0)
					{
						Transmission = auto.getOptionNames(optionSetNames.get(i));
					}
					if (i==1)
					{
						Brake = auto.getOptionNames(optionSetNames.get(i));
					}
					if (i==2)
					{
						airBag = auto.getOptionNames(optionSetNames.get(i));
					}
					if (i==3)
					{
						MoonRoof = auto.getOptionNames(optionSetNames.get(i));
					}
					if (i==4)
					{
						Color = auto.getOptionNames(optionSetNames.get(i));
					}
				 }
				 write.println("<HTML><TITLE>Basic car choice</TITLE><BODY>");
				 write.println("<FORM METHOD=\"post\" ACTION=\"myJsp.jsp\">");
				 write.println("<B>Model </B>");
				 write.println("<SELECT NAME=title0>");
				 write.println("<OPTION VALUE=\""+model+"\">"+model+"");
				 write.println("</SELECT><BR>");
				 write.println("<B>Transmision </B>");
				 write.println("<SELECT NAME=title1>");
				 for (int i = 0; i < Transmission.size(); i++) {
		                write.println("<option value=\"" + Transmission.get(i) + "\">" + Transmission.get(i) + "</option>");
		            }
				 write.println("</SELECT><BR>");
				 write.println("<B>Brake </B>");
				 write.println("<SELECT NAME=title2>");
				 for (int i = 0; i < Brake.size(); i++) {
		                write.println("<option value=\"" + Brake.get(i) + "\">" + Brake.get(i) + "</option>");
		            }
				 write.println("</SELECT><BR>");
				 write.println("<B>Air Bag </B>");
				 write.println("<SELECT NAME=title3>");
				 for (int i = 0; i < airBag.size(); i++) {
		                write.println("<option value=\"" + airBag.get(i) + "\">" + airBag.get(i) + "</option>");
		            }
				 write.println("</SELECT><BR>");
				 write.println("<B>Moon Roof </B>");
				 write.println("<SELECT NAME=title4>");
				 for (int i = 0; i < MoonRoof.size(); i++) {
		                write.println("<option value=\"" + MoonRoof.get(i) + "\">" + MoonRoof.get(i) + "</option>");
		            }
				 write.println("</SELECT><BR>");
				 write.println("<B>Color</B>");
				 write.println("<SELECT NAME=title5>");
				 for (int i = 0; i < Color.size(); i++) {
		                write.println("<option value=\"" + Color.get(i) + "\">" + Color.get(i) + "</option>");
		            }
				 write.println("</SELECT><BR>");
				 write.println("<tr><td><input type=\"submit\" value=\"Configuration done\"></td></tr>");
				 write.println("</FORM>");
				 write.println("</BODY><HTML>");
				 	
				 //out.writeObject("End");
			} catch (ClassNotFoundException e) {
			
				e.printStackTrace();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		//}
		/**if (model.equals("Benz"))
		{
			Properties serverRequest = new Properties ();
			serverRequest.put("send object", "Benz"); 
			out.writeObject(serverRequest);
			try {
				 Automobile auto = (Automobile)in.readObject();
				 ArrayList <String>optionSetNames = auto.getAllOptionSetNames();
				 ArrayList Transmission = null;
				 ArrayList Brake = null;
				 ArrayList airBag = null;
				 ArrayList MoonRoof = null;
				 ArrayList Color = null;
			
				 for (int i =0; i<optionSetNames.size(); i++)
				 {
					if (i==0)
					{
						Transmission = auto.getOptionNames(optionSetNames.get(i));
					}
					if (i==1)
					{
						Brake = auto.getOptionNames(optionSetNames.get(i));
					}
					if (i==2)
					{
						airBag = auto.getOptionNames(optionSetNames.get(i));
					}
					if (i==3)
					{
						MoonRoof = auto.getOptionNames(optionSetNames.get(i));
					}
					if (i==4)
					{
						Color = auto.getOptionNames(optionSetNames.get(i));
					}
				 }
				 write.println("<HTML><TITLE>Basic car choice</TITLE><BODY>");
				 write.println("<FORM METHOD=\"post\" ACTION=\"myJsp.jsp\">");
				 write.println("<B>Model </B>");
				 write.println("<SELECT NAME=title0>");
				 write.println("<OPTION VALUE=\""+model+"\">"+model+"");
				 write.println("</SELECT><BR>");
				 write.println("<B>Transmision </B>");
				 write.println("<SELECT NAME=title1>");
				 for (int i = 0; i < Transmission.size(); i++) {
		                write.println("<option value=\"" + Transmission.get(i) + "\">" + Transmission.get(i) + "</option>");
		            }
				 write.println("</SELECT><BR>");
				 write.println("<B>Brake </B>");
				 write.println("<SELECT NAME=title2>");
				 for (int i = 0; i < Brake.size(); i++) {
		                write.println("<option value=\"" + Brake.get(i) + "\">" + Brake.get(i) + "</option>");
		            }
				 write.println("</SELECT><BR>");
				 write.println("<B>Air Bag </B>");
				 write.println("<SELECT NAME=title3>");
				 for (int i = 0; i < airBag.size(); i++) {
		                write.println("<option value=\"" + airBag.get(i) + "\">" + airBag.get(i) + "</option>");
		            }
				 write.println("</SELECT><BR>");
				 write.println("<B>Moon Roof </B>");
				 write.println("<SELECT NAME=title4>");
				 for (int i = 0; i < MoonRoof.size(); i++) {
		                write.println("<option value=\"" + MoonRoof.get(i) + "\">" + MoonRoof.get(i) + "</option>");
		            }
				 write.println("</SELECT><BR>");
				 write.println("<B>Color</B>");
				 write.println("<SELECT NAME=title5>");
				 for (int i = 0; i < Color.size(); i++) {
		                write.println("<option value=\"" + Color.get(i) + "\">" + Color.get(i) + "</option>");
		            }
				 write.println("</SELECT><BR>");
				 write.println("<tr><td><input type=\"submit\" value=\"Configuration done\"></td></tr>");
				 write.println("</FORM>");
				 write.println("</BODY><HTML>");
				 //out.writeObject("End");
			} catch (ClassNotFoundException e) {
			
				e.printStackTrace();
			} catch (IOException e) {
			
				e.printStackTrace();
			}
		}*/
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
