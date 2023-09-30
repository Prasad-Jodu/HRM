package com.DoctorModuleTest;

import java.util.HashMap;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.HMS.GenericUtilities.BaseClass;
import com.HMS.GenericUtilities.ExcelUtility;
import com.HMS.GenericUtilities.JavaUtility;
import com.HMS.GenericUtilities.PropertiesUtility;
import com.HMS.GenericUtilities.WebDriverUtility;
import com.HMS.ObjectRepository.AddPatientPage;
import com.HMS.ObjectRepository.DoctorDashBoardPage;
import com.HMS.ObjectRepository.DoctorLoginPage;

public class AddPatientUsingGenericUtilityTest extends BaseClass{

	@Test
	public void addPatientTest() throws Throwable {
		
//        //Read data from Excel sheet
//		String ptName = eUtil.getDataFromExcel("Patient",1, 1);
//		String ptContact = eUtil.getDataFromExcel("Patient", 2, 1);
//		String ptMail = eUtil.getDataFromExcel("Patient", 3, 1);
//		String ptAddress = eUtil.getDataFromExcel("Patient", 4, 1);
//		String ptAge = eUtil.getDataFromExcel("Patient", 5, 1);
//		String mediHis = eUtil.getDataFromExcel("Patient", 6, 1);
//		
//		//launch the bowser
//		
        
		driver.findElement(By.xpath("//span[text()=' Patients ']")).click();
		driver.findElement(By.xpath("//span[text()=' Add Patient']")).click();
		
		HashMap<String, String> map = eUtil.getMultipleDataFromExcel("Patient", 0, 1, driver);
		//Add Patient details
		AddPatientPage app=new AddPatientPage(driver);
		app.AddPatient(driver, map);
		
		
	    
	    

		// Validation
//		driver.findElement(By.xpath("//span[text()=' Patients ']")).click();
//		driver.findElement(By.xpath("//span[text()=' Manage Patient ']")).click();
//		List<WebElement> allptns = driver
//				.findElements(By.xpath("//table[@class='table table-hover']/tbody/tr/td[@class='hidden-xs']"));
//		for (int i = 0; i < allptns.size(); i++) {
//			String ptnames = allptns.get(i).getText();
//			if (ptnames.equals(ptName)) {
//				System.out.println("Patient added Successfully");
//				System.out.println(ptName);
//			}

//		}
	}

}
