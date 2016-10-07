<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import = "java.util.*" %>
<%@ page import = "java.io.*" %>
<%@ page import = "java.net.*" %>
<%@ page import = "Model.Automobile" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String model =  request.getParameter("title0");
String transmssionOption = request.getParameter("title1");
String brakeOption = request.getParameter("title2");
String airbagOption =  request.getParameter("title3");
String moonroofOption = request.getParameter("title4");
String colorOption = request.getParameter("title5");
double totalPrice = 0.0;
double basePrice = 0.0;
double transmissionOptionPrice =0.0;
double brakesOptionPrice = 0.0;
double airbagOptionPrice = 0.0;
double moonRoofOptionPrice = 0.0;
double colorOptionPrice = 0.0;

//if (model.equals("Ford"))
//{
	ObjectOutputStream output = null;
	ObjectInputStream in = null;
	Socket socket = null;
	 
	 try {
			socket = new Socket (InetAddress.getByName("127.0.0.1"), 6789);
		} catch (UnknownHostException e) {
		
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		try {
			output = new ObjectOutputStream (socket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		Properties serverRequest = new Properties ();
		serverRequest.put("send object", model);
		output.writeObject(serverRequest);	
		Automobile auto = (Automobile)in.readObject();
		//output.writeObject("End");
		auto.setOptionchoice("Transmission",transmssionOption);
		auto.setOptionchoice("Brakes",brakeOption);
		auto.setOptionchoice("Side impact air bags",airbagOption);
		auto.setOptionchoice("Power moonroof",moonroofOption);
		auto.setOptionchoice("Color",colorOption);
	    basePrice = auto.getBasePrice();
	    transmissionOptionPrice = auto.getOptionChoicePrice("Transmission");
	    brakesOptionPrice = auto.getOptionChoicePrice("Brakes");
	    airbagOptionPrice = auto.getOptionChoicePrice("Side impact air bags");
	    moonRoofOptionPrice = auto.getOptionChoicePrice("Power moonroof");
	    colorOptionPrice = auto.getOptionChoicePrice("Color");
	    totalPrice = auto.getTotalPrice();
//}
/**if (model.equals("Benz"))
{
	ObjectOutputStream output = null;
	ObjectInputStream in = null;
	Socket socket = null;
	 
	 try {
			socket = new Socket (InetAddress.getByName("127.0.0.1"), 6789);
		} catch (UnknownHostException e) {
		
			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}
		
		try {
			output = new ObjectOutputStream (socket.getOutputStream());
			out.flush();
			in = new ObjectInputStream(socket.getInputStream());
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		Properties serverRequest = new Properties ();
		serverRequest.put("send object", "Benz");
		output.writeObject(serverRequest);	
		Automobile auto = (Automobile)in.readObject();
		//output.writeObject("End");
	auto.setOptionchoice("Transmission",transmssionOption);
	auto.setOptionchoice("Brakes",brakeOption);
	auto.setOptionchoice("Side impact air bags",airbagOption);
	auto.setOptionchoice("Power moonroof",moonroofOption);
	auto.setOptionchoice("Color",colorOption);
    basePrice = auto.getBasePrice();
    transmissionOptionPrice = auto.getOptionChoicePrice("Transmission");
    brakesOptionPrice = auto.getOptionChoicePrice("Brakes");
    airbagOptionPrice = auto.getOptionChoicePrice("Side impact air bags");
    moonRoofOptionPrice = auto.getOptionChoicePrice("Power moonroof");
    colorOptionPrice = auto.getOptionChoicePrice("Color");
    totalPrice = auto.getTotalPrice();
}*/
%>
      
<table border="1">
<tr>
<td> <%= model %></td>
<td>Base price</td>
<td><%= basePrice %></td>
</tr>
<tr>
<td>Color</td>
<td><%= colorOption %></td>
<td><%= colorOptionPrice %></td>
</tr>
<tr>
<td>Transmission</td>
<td><%= transmssionOption %></td>
<td><%= transmissionOptionPrice %></td>
</tr>
<tr>
<td>Brakes</td>
<td><%= brakeOption %></td>
<td><%= brakesOptionPrice %></td>
</tr>
<tr>
<td>Side impact air bags</td>
<td><%= airbagOption %></td>
<td><%= airbagOptionPrice %></td>
</tr>
<tr>
<td>Power MoonRoof</td>
<td><%= moonroofOption %></td>
<td><%= moonRoofOptionPrice %></td>
</tr>
<tr>
<td>Total cost</td>
<td></td>
<td><%= totalPrice %></td>
</tr>
</table>    
       
         
</body>
</html>