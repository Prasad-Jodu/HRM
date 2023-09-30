package practice;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;


public class SelectQueryTest {

	public static void main(String[] args) throws Throwable {
		Connection con=null;
		try {
		
		Driver driver=new Driver();
		//Step1:Register the driver
		DriverManager.registerDriver(driver);
		//Step2:Connect to database
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
		//Step3:Create statement
		Statement state = con.createStatement();
		//Step4:Execute query
		String query = "select * from teammembers;";
		ResultSet result = state.executeQuery(query);
		while(result.next())
		{
		System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
	finally {
		//Step5:Close the database
		con.close();
	}
	}

}
