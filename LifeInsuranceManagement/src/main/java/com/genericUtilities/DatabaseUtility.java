package com.genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;
public class DatabaseUtility {
	Connection con=null;
	public void connectToDB() throws SQLException
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection(IPathConstants.dbURL,IPathConstants.dbUsername,IPathConstants.dbPassword);
		
	}
	public String executeQueryAndGetData(String query,String expData,int columnIndex) throws SQLException
	{
		ResultSet result=con.createStatement().executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
			String data=result.getString(columnIndex);
			if(data.equalsIgnoreCase(expData))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println("Data is verified");
			return expData;
		}
		else
		{
			System.out.println("Data is not updated");
			return " ";
			
		}
	}
	public void closeDB() throws SQLException
	{
		con.close();
		System.out.println("Database connection closed");
	}
}
