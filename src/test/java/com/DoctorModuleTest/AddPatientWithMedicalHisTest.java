package com.DoctorModuleTest;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AddPatientWithMedicalHisTest {

	public static void main(String[] args) throws Throwable {
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommomData.properties");
		Properties pObj=new Properties();
		//Get required data from property file
		pObj.load(fis);
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		String ptname = "Karthi";
		String ptcontact = "7876543456";
		String ptmail = "karthi@gmail.com";
		String ptAddress = "Bangalore";
		String ptAge = "30";
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
		
		//Adding medical history
		String bloodPressure = "100";
		String bloodSugar = "70";
		String weight = "100";
		String temparature = "35";
		String mediaclHistory = "Nothing";
		
		driver.findElement(By.xpath("//span[text()=' Search ']")).click();
		driver.findElement(By.name("searchdata")).sendKeys(ptname);
		driver.findElement(By.xpath("//button[@name='search']")).click();
		driver.findElement(By.xpath("//td[text()='"+ptname+"']/ancestor::tr/descendant::a[contains(@href,'view-patient.php?viewid')]")).click();
		driver.findElement(By.xpath("//button[text()='Add Medical History']")).click();
		driver.findElement(By.name("bp")).sendKeys(bloodPressure);
		driver.findElement(By.name("bs")).sendKeys(bloodSugar);
		driver.findElement(By.name("weight")).sendKeys(weight);
		driver.findElement(By.name("temp")).sendKeys(temparature);
		driver.findElement(By.xpath("//textarea[@placeholder='Medical Prescription']")).sendKeys(mediaclHistory);
		driver.findElement(By.xpath("//button[text()='Submit']")).click();
		Alert alt= driver.switchTo().alert();
		String medicalHistory = alt.getText();
		System.out.println(medicalHistory);
		alt.accept();
		


	}

}
