package com.DoctorModuleTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddPatientTest {

	public static void main(String[] args) throws Throwable {
		Random rn=new Random();
		int randomNumber = rn.nextInt(10000);
		FileInputStream fis=new FileInputStream(".\\src\\main\\resources\\CommomData.properties");
		Properties pObj=new Properties();
		//Get required data from property file
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		String ptname = "RamaKrishna";
		String ptcontact = "9878764532";
		String ptmail = "krishna@gmail.com";
		String ptAddress = "Bangalore";
		String ptAge = "25";
		String mediHis = "NA";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("username")).sendKeys(USERNAME);
		driver.findElement(By.name("password")).sendKeys(PASSWORD);
		driver.findElement(By.name("submit")).click();
		
		driver.findElement(By.xpath("//span[text()=' Patients ']")).click();
		driver.findElement(By.xpath("//span[text()=' Add Patient']")).click();
		driver.findElement(By.name("patname")).sendKeys(ptname);
		driver.findElement(By.name("patcontact")).sendKeys(ptcontact);
		driver.findElement(By.name("patemail")).sendKeys(ptmail);
		driver.findElement(By.name("pataddress")).sendKeys(ptAddress);
		driver.findElement(By.name("patage")).sendKeys(ptAge);
		driver.findElement(By.xpath("//div[@class='clip-radio radio-primary']/label[@for='rg-male']")).click();
		driver.findElement(By.name("medhis")).sendKeys(mediHis);
		driver.findElement(By.name("submit")).click();
		
		//Validation
		driver.findElement(By.xpath("//span[text()=' Patients ']")).click();
		driver.findElement(By.xpath("//span[text()=' Manage Patient ']")).click();
		List<WebElement> allptns = driver.findElements(By.xpath("//table[@class='table table-hover']/tbody/tr/td[@class='hidden-xs']"));
		for (int i = 0; i < allptns.size(); i++) {
			String ptnames = allptns.get(i).getText();
			if (ptnames.equals(ptname)) {
				System.out.println("Patient added Successfully");
				System.out.println(ptname);
			}
			
		}
		
	}

}
