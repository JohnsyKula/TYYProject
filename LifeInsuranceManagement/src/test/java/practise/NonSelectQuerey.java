package practise;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQuerey {

	public static void main(String[] args) throws Throwable {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/johnsy", "root","root");
		Statement state=con.createStatement();
		String query="insert into trainee values(101,'nila','Baby',5000);";
		state.executeUpdate(query);
		con.close();
		
	}

}
