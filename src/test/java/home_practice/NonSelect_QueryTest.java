package home_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelect_QueryTest {

	public static void main(String[] args) throws Throwable {
		Connection con=null;
		
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
		Statement state = con.createStatement();
		String query = "insert into teammembers values(103,'Sameer','Banashankari');";
		int result = state.executeUpdate(query);
		if(result==1)
		{
			System.out.println("Data is added");
		}
		else {
			System.out.println("Data is not added");
		}
		con.close();
	}

}
