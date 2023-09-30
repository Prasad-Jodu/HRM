package testNG;


import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class AnnotationsTest {
	
	@BeforeSuite
	public void configBS() {
		System.out.println("Connect to the DB");
	}
	
	@BeforeClass
	public void configBC() {
		System.out.println("Launch the bowser");
	}
	
	@BeforeMethod
	public void configBM() {
		System.out.println("Login to the Application");
	}
	@Test
	public void testScript() {
		System.out.println("Test Script execution starts");
	}
	
	@AfterMethod
	public void configAM() {
		System.out.println("Logout from the Application");
	}
	
	@AfterClass
	public void configAC() {
		System.out.println("Close the browser");
	}
	
	@AfterSuite
	public void configAS() {
		System.out.println("Disconnect from DB connection");
	}
	

}
