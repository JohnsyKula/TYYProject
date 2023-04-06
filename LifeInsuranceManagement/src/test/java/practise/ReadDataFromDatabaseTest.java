package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabaseTest {

	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
		
		//step1 create object for driver class
		Driver driver=new Driver();//--->should select the import com.mysql.cj.jdbc.Driver;
		
		//step2 register the database
		DriverManager.registerDriver(driver);
		
		//step3 get connection for the database
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/johnsy", "root","root");
		
		//create statement
		Statement state = con.createStatement();
		String query="select * from trainee where tname='nila';";
	   
		//execute query
	    ResultSet result = state.executeQuery(query);
		while(result.next())
		{
			System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3)+" "+result.getString(4));
		}
		}
		catch(Exception e){
			
		}
		finally
		{
			con.close();
		}
		
	}

}
