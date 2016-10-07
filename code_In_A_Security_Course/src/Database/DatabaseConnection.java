package Database;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;


public class DatabaseConnection
{
	private Connection myConnection;
	private PreparedStatement statement;

	/**
	 * DatabaseConnection is the default constructor that connects to the database
	 */
	public DatabaseConnection()
	{
	   try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String db = "jdbc:mysql://localhost:3306/smanzidb";
			myConnection = DriverManager.getConnection(db, "smanzi", "1234smanzi");
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		catch (ClassNotFoundException e)
		{
			System.out.println(e);
		}



	/**

	 try
		{
			Class.forName("com.mysql.jdbc.Driver");
			String db = "jdbc:mysql://localhost:3306/smanzi";
			myConnection = DriverManager.getConnection(db, "root", "");
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		catch (ClassNotFoundException e)
		{
			System.out.println(e);
		}
		*/
	}

	/**
	 * insertAuto inserts a new auto into the database
	 * @param make
	 * @param model
	 * @param basePrice
	 */
	public void insertInfo(String information)
	{
		String query= "INSERT INTO `smanzidb`.`information` (`InfoData`,`Date`) VALUES (?,?);";
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		try
		{
			statement = myConnection.prepareStatement(query);
			statement.setString(1, information);
			statement.setString(2, dateFormat.format(date));
			statement.executeUpdate();
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}

	/**
	 * deleteAuto deletes an auto from the databases
	 * @param model
	 */
	public void deleteAuto(String info)
	{
		String query = "DELETE FROM `smanzidb`.`information` WHERE `InfoData`=?;";
		try
		{
			statement = myConnection.prepareStatement(query);
			statement.setString(1,info);
			statement.executeUpdate();
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
	}

	public String retrieveAll()
	{
		Statement myStat;
		String res = "";
		try
		{
			myStat = myConnection.createStatement();
			ResultSet myRs =  myStat.executeQuery("SELECT * FROM smanzidb.information;");
			int i = 1;
			while(myRs.next())
			{
				res = res + "<br>" + i + ". " + (myRs.getString("InfoData") + ", ON " + myRs.getString("Date") ) + "<br>";
				i++;
			}
		}
		catch (SQLException e)
		{
			System.out.println(e);
		}
		return res;

	}
	  public String getHash( String password, byte[] salt ) throws NoSuchAlgorithmException {
		  MessageDigest digest = MessageDigest.getInstance("SHA-256");
	       digest.reset();
	       digest.update(salt);
	       byte[] input = null;
		try {
			input = digest.digest(password.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       StringBuffer buffer = new StringBuffer ();
	       for (byte f: input)
	       {
    		   buffer.append(String.format("%02x", f));
	       }
	     return buffer.toString();


	   }

	  public boolean authenticateUser(String login, String password)
	           throws SQLException, NoSuchAlgorithmException{
		  int numberOfIterations = 1000;
	       boolean authenticated=false;
	       PreparedStatement ps = null;
	       ResultSet rs = null;
	       try {
	           boolean userExist = true;

	           if (login==null||password==null){

	               userExist = false;
	               login="";
	               password="";
	           }

	           ps = myConnection.prepareStatement("SELECT Password FROM `smanzidb`.`userData` WHERE `UserName`=?");

	           ps.setString(1, login);
	           rs = ps.executeQuery();
	           String digest, salt;
	           if (rs.next()) {
	        	   digest = rs.getString("Password");
	               //salt = rs.getString("Salt");

	               if (digest == null ) {
	                   throw new SQLException("Database inconsistant Salt or Digested Password altered");
	               }
	               if (rs.next()) {
	                   throw new SQLException("Database inconsistent two CREDENTIALS with the same LOGIN");
	               }
	           } else {

	               digest = "000000000000000000000000000=";
	               salt = "00000000000=";
	               userExist = false;
	           }

	           //byte[] Digest = base64ToByte(digest);
	           //byte[] Salt =base64ToByte(salt);
	           byte[] Salt =base64ToByte("");

	           //byte[] randomBytes1 = getHash( password, Salt);
	           //String proposedDigest = getHash( password, Salt);
	           byte[] array =password.getBytes();
	           byte[] array1 =digest.getBytes();
	           return Arrays.equals(array, array1) && userExist;
	       } catch (IOException ex){
	           throw new SQLException("Database inconsistant Salt or Digested Password altered");
	       }
	       finally{
	           close(rs);
	           close(ps);
	       }
	   }

	  String error=null;
	  public String getError(){
		  return this.error;
	  }
	  public boolean checkUsername(String username) throws SQLException, NoSuchAlgorithmException
	  {
		  boolean decision = false;
		  String query = "SELECT UserName FROM `smanzidb`.`userData` WHERE `UserName`=?;";
		  String out = "";
		  ResultSet myRs = null;
		  try {
		   statement = myConnection.prepareStatement(query);
		   statement.setString(1, username);
		   myRs = statement.executeQuery();
		   if (myRs.next()) {
		    //out = myRs.getString("UserName");
		    decision = true;
		   } else {
		    decision = false;
		   }
		  }
		  catch (SQLException e)
		  {

		  }
		 return decision;
	  }
	  public static byte[] base64ToByte(String data) throws IOException {
	       BASE64Decoder decoder = new BASE64Decoder();
	       return decoder.decodeBuffer(data);
	   }
	  public void close(Statement ps) {
	       if (ps!=null){
	           try {
	               ps.close();
	           } catch (SQLException ignore) {
	           }
	       }
	   }

	   /**
	    * Closes the current resultset
	    * @param ps Statement
	    */
	   public void close(ResultSet rs) {
	       if (rs!=null){
	           try {
	               rs.close();
	           } catch (SQLException ignore) {
	           }
	       }
	   }
	   public void insertUser(String UserName, String Password)
	   {
		   String query = "INSERT INTO `smanzidb`.`userData`(`UserName`, `Password`) VALUES(?,?);";

		   try
		   {
			   statement = myConnection.prepareStatement(query);
			   statement.setString(1, UserName);
			   statement.setString(2, Password);
			   statement.executeUpdate();
		   }
		   catch(SQLException e)
		   {

		   }
	   }
	   public void updatePassword (String username, String password)
	   {
		   String query = "UPDATE `smanzidb`.`userData` SET Password = ? WHERE `UserName`=? ;";
		  try
		   {
			   statement = myConnection.prepareStatement(query);
			   statement.setString(1, username);
			   statement.setString(2, password);
			  // statement.setInt(3, result);
			   //statement.setString(4, dateformat.format(date));
			   //statement.setString(5, salt);
			   statement.executeUpdate();
		   }
		   catch(SQLException e)
		   {

		   }


	   }
	   public void updateSequenceNumber(String username)
	   {

		   String result = getSequenceNumber(username);
		   int number = Integer.parseInt(result.trim());
		   int ab = number - 1;
		   String mystring = Integer.toString(ab);
		   String query = "UPDATE `smanzidb`.`userData` SET SequenceNumber =  SequenceNumber-1 WHERE `UserName`=? ;";
		   try
		   {
			   statement = myConnection.prepareStatement(query);
			   statement.setString(1, username);
			   //statement.setString(2, Password);
			   statement.setString(6,  mystring );
			   //statement.setString(4, dateformat.format(date));
			   //statement.setString(5, salt);
			   statement.executeUpdate();
		   }
		   catch(SQLException e)
		   {

		   }

	   }
	   public String getSequenceNumber(String username)
	   {

			  String query = "SELECT SequenceNumber FROM `smanzidb`.`userData` WHERE `UserName`=?;";
			  String out = "";
			  ResultSet myRs = null;
			  try {
			   statement = myConnection.prepareStatement(query);
			   statement.setString(1, username);
			   myRs = statement.executeQuery();
			   if (myRs.next()) {
			    out = myRs.getString("SequenceNumber");

			   } else {
			             out = "";
			   }
			  }
			  catch (SQLException e)
			  {

			  }
			 return out;
	   }
	   public void setseq (String username)
	   {
			  String query = "SELECT SequenceNumber FROM `smanzidb`.`userData` WHERE `UserName`=?;";
			  String out = "";
			  ResultSet myRs = null;
			  try {
			   statement = myConnection.prepareStatement(query);
			   statement.setString(1, username);
			   myRs = statement.executeQuery();
			   if (myRs.next()) {
			    out = myRs.getString("SequenceNumber");
			    int a = Integer.parseInt(out);
			    int b = a-1;
			    String str=String.valueOf(b);
			    statement.setString(6, username);
			   } else {
			             out = "";
			   }
			  }


			  catch (SQLException e)
			  {

			  }
	   }
	   public String getColor(String username)
	   {

			  String query = "SELECT Color FROM `smanzidb`.`userData` WHERE `UserName`=?;";
			  String out = "";
			  ResultSet myRs = null;
			  try {
			   statement = myConnection.prepareStatement(query);
			   statement.setString(1, username);
			   myRs = statement.executeQuery();
			   if (myRs.next()) {
			    out = myRs.getString("Color");

			   } else {
			             out = "";
			   }
			  }
			  catch (SQLException e)
			  {

			  }
			 return out;
	   }
	   public String getColorDescrption(String username)
	   {

			  String query = "SELECT ColorDescrption FROM `smanzidb`.`userData` WHERE `UserName`=?;";
			  String out = "";
			  ResultSet myRs = null;
			  try {
			   statement = myConnection.prepareStatement(query);
			   statement.setString(1, username);
			   myRs = statement.executeQuery();
			   if (myRs.next()) {
			    out = myRs.getString("ColorDescrption");

			   } else {
			             out = "";
			   }
			  }
			  catch (SQLException e)
			  {

			  }
			 return out;
	   }
	   public String getNickname(String username)
	   {

			  String query = "SELECT Nickname FROM `smanzidb`.`userData` WHERE `UserName`=?;";
			  String out = "";
			  ResultSet myRs = null;
			  try {
			   statement = myConnection.prepareStatement(query);
			   statement.setString(1, username);
			   myRs = statement.executeQuery();
			   if (myRs.next()) {
			    out = myRs.getString("Nickname");

			   } else {
			             out = "";
			   }
			  }
			  catch (SQLException e)
			  {

			  }
			 return out;
	   }
	   public void insertLogs(String UserName, Date Timestamp, String Status)
	   {
		   String query = "INSERT INTO `smanzidb`.`logs`(`Username`, `TimeStamp`, `Status`) VALUES(?,?,?);";
		   DateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		   Date date = new Date();
		   try
		   {
			   statement = myConnection.prepareStatement(query);
			   statement.setString(1, UserName);
			   statement.setString(2, Timestamp.toString());
			   statement.setString(3, Status);

			   statement.executeUpdate();
		   }
		   catch(SQLException e)
		   {

		   }
	   }
}
