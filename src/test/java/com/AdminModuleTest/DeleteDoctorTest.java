package com.AdminModuleTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.HMS.GenericUtilities.WebDriverUtility;

public class DeleteDoctorTest {

	@Test
	public  void deleteDoctorTest() throws Throwable {
		WebDriver driver = null;

		
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\CommomData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("admin_url");
		String USERNAME = pObj.getProperty("admin_username");
		String PASSWORD = pObj.getProperty("admin_password");

		
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\Test.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("AddDoctor");
		int count = sh.getLastRowNum();
		
		

		// launching the browser
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid browser");
		}

		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//span[text()=' Doctors ']")).click();
		driver.findElement(By.xpath("//span[text()=' Manage Doctors ']")).click();  
		driver.findElement(By.xpath("//a[@href='manage-doctors.php?id=215&del=delete']")).click();
		Alert alt=driver.switchTo().alert();
		//alt.getText();
		alt.accept();
		String actmsg = driver.findElement(By.xpath("//p[contains(text(),'data deleted !!')]")).getText();
		String expectmsg = "data deleted !!";
//		SoftAssert sa=new SoftAssert();
//		sa.assertEquals(actmsg, expectmsg);
		
		//sa.assertAll();
		Assert.assertEquals(actmsg, expectmsg);
		System.out.println("Doctor deleted Successfully");
//		System.out.println(actmsg);
//		if(actmsg.contains(expectmsg))
//		{
//			System.out.println("Doctor deleted Successfully");
//		}
//		else {
//			System.out.println("fail");
//		}
	}

}
