
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Database.DatabaseConnection;
import sun.misc.BASE64Encoder;
@WebServlet("/Register")
public class Register extends HttpServlet{

private static final long serialversionUID = 1L;
static ArrayList<String> list = new ArrayList<String>(); 
static ArrayList<String> list1 = new ArrayList<String>(); 
	public Register ()
	{
		super();
	}
	public static String ChangeByteToBase64 (byte [] data)
	{
		BASE64Encoder encodedata  = new BASE64Encoder();
		return encodedata.encode(data);
	}
	public static String getHexadecimalString(byte[] ba)  {
		StringBuilder sb = new StringBuilder();
	       for(byte b: ba)
	            sb.append(String.format("%02x", b));
	         return sb.toString();
		}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{

	
	
	String userName_ = request.getParameter("UserName");
	String password_ = request.getParameter("Password");
	/**String Color_ = request.getParameter("select");

	String ColorDescription = request.getParameter("ColorDescrption");
	String nickname =  request.getParameter("Nickname");
	String sequenceNumber = request.getParameter("SequenceNumber");
	String address = request.getParameter("Address");
	String lastLogintime = request.getParameter("LastloginTime");
	String salt = request.getParameter("salt");*/
	int numberOfIterations = 1000;
    SecureRandom rand = null;
	try
	{
		rand = SecureRandom.getInstance("SHA1PRNG");
	}
	catch (NoSuchAlgorithmException d)
	{
		d.printStackTrace();
	}
	
	byte[] randomBytes1 = new byte[8];
	rand.nextBytes(randomBytes1);
	DatabaseConnection obj = new DatabaseConnection ();
	//byte [] hashedValue = null;
	String hashedValue = null;
	
		//hashedValue = obj.getHash( password_, randomBytes1);
		try {
			hashedValue = obj.getHash( password_, randomBytes1);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	//String printableASCII = getHexadecimalString(hashedValue);
    String randomPrintableASCII = ChangeByteToBase64(randomBytes1);
	DatabaseConnection mydb1 = new DatabaseConnection();
	PrintWriter writedata = response.getWriter();
    //writedata.println(hashedValue+randomPrintableASCII);
    //writedata.println(userName_+password_+address+lastLogintime);
    
	/**switch (Color_)
	{
	case "1":
		Color_ = "blue";
		break;
	case "2":
		Color_ = "green";
		break;
	case "3":
		Color_ = "yellow";
		break;
		
	}
	list.add(Color_);
	list1.add(ColorDescription);**/
	writedata.println("<h4> Your data has been successfully saved</h4>");
     mydb1.insertUser(userName_, password_ );
	//mydb1.insertUser(userName_,hashedValue,address,"", randomPrintableASCII);
	
     writedata.println("<h4> Your data has been successfully saved</h4>");
    
}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		doGet(request, response);
	}
}
