package com.AdminModuleTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.HMS.GenericUtilities.BaseClass;
import com.HMS.GenericUtilities.ListenerImpClass;
import com.HMS.GenericUtilities.WebDriverUtility;
import com.HMS.ObjectRepository.AddDoctorSpecializationPage;
import com.HMS.ObjectRepository.AdminDashboardPage;

public class CreateDoctorSpecializationTest extends BaseClass{
    @Test()
	public void doctorSpcl()  throws Throwable {    
    	
         //fetch data from Excel file
           eUtil.getRowCount("Admin");
           String spcl = eUtil.getDataFromExcel("Admin", 1, 1);

		AdminDashboardPage adb=new AdminDashboardPage(driver);
		
		adb.clickOnDoctorsLink();
		// Assert.fail();
		adb.clickOnDoctorSpclLink();
	
		AddDoctorSpecializationPage adsp=new AddDoctorSpecializationPage(driver);
		adsp.AddDoctorSpecialization(spcl);
	
		String actMsg = driver.findElement(By.xpath("//p[contains(text(),'Doctor Specialization added successfully ')]")).getText();
		String expectedMsg = "Doctor Specialization added successfully !!";
//		
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(actMsg, expectedMsg);
		System.out.println("Specialization added");
		sa.assertAll();
//		if (actMsg.contains(expectedMsg)) {
//			System.out.println("Specialization added");
//			
//		} else {
//			System.out.println(" not added");
//		}

	}

}
