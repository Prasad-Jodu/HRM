package testNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HMS.GenericUtilities.ExcelUtility;
import com.HMS.GenericUtilities.JavaUtility;

public class VtigerLoginTest {
	JavaUtility jUtil=new JavaUtility();
	@DataProvider
	public Object[][] getData() throws Throwable {
		ExcelUtility eUtil=new ExcelUtility();
		Object[][] data = eUtil.getMultipleSetOfData("login");
		return data ;
		
	}
	
	@Test(dataProvider = "getData")
    public void login(String username,String password,String org) {
    	WebDriver driver=new ChromeDriver();
    	driver.get("http://localhost:8888/");
    	driver.findElement(By.name("user_name")).sendKeys(username);
    	driver.findElement(By.name("user_password")).sendKeys(password);
    	driver.findElement(By.id("submitButton")).click();
		//System.out.println(username+"   "+password);
        driver.findElement(By.linkText("Organizations")).click();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
		driver.findElement(By.name("accountname")).sendKeys(org+jUtil.randomNumber());
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		
		driver.close();
	}
    }
	
	

