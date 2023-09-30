package home_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Select_QueryTest {

	public static void main(String[] args) throws Throwable {
		Connection con=null;
		try {
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
		Statement state = con.createStatement();
		ResultSet result = state.executeQuery("select * from teammembers");
		while(result.next()) {
		System.out.println(result.getString(1)+" "+result.getString(2)+" "+result.getString(3));
		}
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			con.close();
		}
		
	}

}
