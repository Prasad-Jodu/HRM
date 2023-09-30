package home_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class JDBC_AssignmentTest {

	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name");
		String name = sc.next();
		String Squery = "select * from tyss;";
		String NSquery = "insert into tyss values(102,'"+name+"');";
		
		Connection con=null;	
		
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
		Statement state = con.createStatement();
        ResultSet result = state.executeQuery(Squery);
		//System.out.println(result.getString(2));
        boolean flag=false;
		while(result.next())
		{
			if (flag=true) {
				System.out.println(name+"  is inserted in database");
				
			} else {
				System.out.println(name+ " not inserted");
                Statement upstate = con.createStatement();
                
               int upresult = upstate.executeUpdate(NSquery);
                if (upresult>=1) {
					System.out.println("inserted into db");
				}
			}
		}
		

	}

}
