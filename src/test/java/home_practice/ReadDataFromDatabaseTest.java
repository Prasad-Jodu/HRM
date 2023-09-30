package home_practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class ReadDataFromDatabaseTest {

	public static void main(String[] args) throws Throwable {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter name");
		String uname = sc.next();
		Connection con = null;
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
			Statement state = con.createStatement();
			String query = "select * from tyss;";
			ResultSet result = state.executeQuery(query);
			
			boolean flag = false;
			while (result.next()) {
				String data = result.getString(2);
				if (data.equalsIgnoreCase(uname)) {
					flag = true;

				}
			}
			if (flag) {
				System.out.println(uname + " is already exists");
			} else {
				System.out.println(uname+" is not present in the table");
				String insertData = "insert into tyss values(100," + "'" + uname + "'" + ");";
				Statement state1 = con.createStatement();
				int resultUpdate = state1.executeUpdate(insertData);

				if (resultUpdate >= 1) {
					System.out.println(uname + " is inserted");
				}

			}
		} finally {
			con.close();
		}

	}
}
