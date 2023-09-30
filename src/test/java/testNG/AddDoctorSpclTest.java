package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.HMS.GenericUtilities.ExcelUtility;
import com.HMS.GenericUtilities.PropertiesUtility;
import com.HMS.GenericUtilities.WebDriverUtility;

public class AddDoctorSpclTest {
	
	WebDriverUtility wUtil=new WebDriverUtility();
	ExcelUtility eUtil=new ExcelUtility();
	PropertiesUtility pUtil=new PropertiesUtility();
	

	
	@Test
	public void addDoctorSpcl() throws Throwable {
	String BROWSER = pUtil.getPropertyKeyValue("browser");
	String URL = pUtil.getPropertyKeyValue("admin_url");
	String USERNAME = pUtil.getPropertyKeyValue("admin_username");
	String PASSWORD = pUtil.getPropertyKeyValue("admin_password");
		
		WebDriver driver=new ChromeDriver();
		driver.get(URL);
		wUtil.maximizeWindow(driver);
		wUtil.implicitWait(driver, 10);
		
		
		
	}
   
}
