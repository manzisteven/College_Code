package exception;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.Timestamp;
import java.sql.Date;

public class AutoException extends Exception  implements FixAuto {
	
	int errorNumber_;
	String errorMessage_;
	
	enum error {basePriceMissing (1,"Base price is missing"), transmissionPriceMissing(2, "Transmission price is missing");
	private int errorNumber;
	private String errorMessage;
	error (int number, String message)
	{
		errorNumber = number;
		errorMessage = message;
	}
	public int getErrorNumber()
	{
		return errorNumber;
	}
	public String getErrorMessage ()
	{
		return errorMessage;
	}
	}
	public void setErrorMessage (int errorNumber)
	{
		for(error a: error.values())
		{
			if (errorNumber == a.getErrorNumber())
			{
				errorMessage_ = a.getErrorMessage();
			}
		}
	}
	public String fix (int erno) 
	{
		error ERROR = null;
		for(error a: error.values())
		{
			if (erno == a.getErrorNumber())
			{
				ERROR = a;
			}
		}
		String handler = null;
		Fix1to100 obj = new Fix1to100 ();
		switch (ERROR)
		{
		case basePriceMissing:
		    handler = obj.fix1();
		   break;
		case transmissionPriceMissing:
			 handler = obj.fix2();
			 break;
		}
		return handler;
	}
 public void addLogs ()
 {
	 try 
	 {
		 PrintWriter print = new PrintWriter(new BufferedWriter(new FileWriter("loggedData.txt", true)));
		 java.util.Date time = new java.util.Date();
		  print.println(errorMessage_);
		  print.println(time);
		  print.close();
		 
	 }catch (IOException e)
	 {
		 
	 }
	 
 }
}
