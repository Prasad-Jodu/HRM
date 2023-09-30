package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class NonSelectQuery {

	public static void main(String[] args) throws Throwable {
		Connection con=null;
		
		
		
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
		
		Statement state = con.createStatement();
		String query = "insert into teammembers values(104,'Kumar','Hyderabad'),(102,'Kaythik','Nellore');";
		int result = state.executeUpdate(query);
		
		if(result==2)
		{
			System.out.println("data is created");
		}
		else {
			System.out.println("data is not created");
		}
		con.close();
	}
	}

