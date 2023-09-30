package com.AdminModuleTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class EditDoctorDetailsTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=null;
		FileInputStream fis =new FileInputStream(".\\src\\main\\resources\\CommomData.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("admin_url");
		String USERNAME = pObj.getProperty("admin_username");
		String PASSWORD = pObj.getProperty("admin_password");
		
		FileInputStream fi=new FileInputStream(".\\src\\main\\resources\\Test.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet sh = wb.getSheet("Admin");
		int count = sh.getLastRowNum();
		String spcl = sh.getRow(1).getCell(1).getStringCellValue();
		if (BROWSER.equalsIgnoreCase("chrome")) {
			 
			driver=new ChromeDriver();
		} else if(BROWSER.equalsIgnoreCase("firefox")){

			driver=new FirefoxDriver();
		}
		else {
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
		driver.findElement(By.xpath("//a[@href='edit-doctor.php?id=841']")).click();
        WebElement spDD = driver.findElement(By.xpath("//select[@name='Doctorspecialization']"));
        Select sel=new Select(spDD);
        sel.selectByVisibleText(spcl);
        driver.findElement(By.name("submit")).click();
        String conformsg = driver.findElement(By.xpath("//h5[contains(text(),'Doctor Details updated')]")).getText();
        System.out.println(conformsg);
		
		
	}

}
