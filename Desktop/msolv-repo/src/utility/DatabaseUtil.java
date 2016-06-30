package utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class DatabaseUtil {

	PropertyUtility putility = new PropertyUtility(GUI_Constant.CONFIG_FILEPATH);
	// Connection object
	static Connection con = null;
	// Statement object
	private static Statement stmt;
	
	private ResultSet rs;

	// Constant for Database URL
	public String DB_URL = putility.getEnvironmentProperty("DB_URL");

	// Constant for Database Username	
	public String DB_USER = putility.getEnvironmentProperty("DB_USER");

	// Constant for Database Password
	public String DB_PASSWORD = putility.getEnvironmentProperty("DB_PSD");

	public void DBConnect() {
		try {
			String dbClass = "oracle.jdbc.driver.OracleDriver";
			Class.forName(dbClass).newInstance();
			Connection con = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
			stmt = con.createStatement();
		} 
		catch (Exception e) {
			System.out.println("Staffing :: App DB connection failed () :: Exception:" + e);
		}
	}
	
	public  String DBread(String query) throws ClassNotFoundException, SQLException, InterruptedException
	{
		String status = null;
		try
		{
			DBConnect();
			rs= stmt.executeQuery(query);
			
			System.out.println("the query executed");
			Thread.sleep(20000);
		
			if(rs.next())
			{
				System.out.println("If condition - record has been created");
				Log.info("The record has been created and present in database.");
				status="pass";
			}
			else
			{
				Log.error("There is no record created");
				status="There is no record created in database- Failed";
			}
			return status;
		}
		catch(Exception e )
		{
			e.getMessage();
			Log.error(e.getMessage()+"  There is no record created and query execution failed");
			status="Error while connecting with DB- Failed";
			return status;
		}	
		finally {
			if (con != null)
				con.close();
			if (stmt != null)
				stmt.close();
		}		      	
	}	
	
	public String checkRowForCalloutFunctionality(String trackingNumber ) throws Exception {
		String status = "";
		try {
			DBConnect();
			String query = putility.getEnvironmentProperty("DB_QUERY_CALLOUT_FUNCTIONALITY");
			query = query.replaceAll("@PARAM", trackingNumber);
			if (query != null && query.trim().length() > 0) {
				ResultSet res = stmt.executeQuery(query);
				if(res.next())
					status = "PASS";
				else
					status = "FAIL";
				res.close();
			}
			else
				status = "FAIL";
			
			return status;
		} catch (Exception e) {
			System.out.println("checkRowForCalloutFunctionality:: Error occured in connecting with DB. :: Exception:" + e);
			status = "ERROR";
			return status;
		} finally {
			if (con != null)
				con.close();
			if (stmt != null)
				stmt.close();
		}
	}

}