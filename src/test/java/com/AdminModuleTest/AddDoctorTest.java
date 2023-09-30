package com.AdminModuleTest;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.HMS.GenericUtilities.ExcelUtility;
import com.HMS.GenericUtilities.JavaUtility;
import com.HMS.GenericUtilities.PropertiesUtility;
import com.HMS.GenericUtilities.WebDriverUtility;
import com.HMS.ObjectRepository.AddDoctorPage;
import com.HMS.ObjectRepository.AdminDashboardPage;
import com.HMS.ObjectRepository.AdminLoginPage;

public class AddDoctorTest {

	public static void main(String[] args) throws Throwable {

		WebDriver driver = null;
        // create object for all the utilities
		JavaUtility jUtil=new JavaUtility();
		ExcelUtility eUtil=new ExcelUtility();
		PropertiesUtility pUtil=new PropertiesUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		
		// fetch data from property file

		String BROWSER = pUtil.getPropertyKeyValue("browser");
		String URL = pUtil.getPropertyKeyValue("admin_url");
		String USERNAME = pUtil.getPropertyKeyValue("admin_username");
		String PASSWORD = pUtil.getPropertyKeyValue("admin_password");

		// fetch data from Excel file
//		String spcl = eUtil.getDataFromExcel("Admin", 1, 1);
//		String name = eUtil.getDataFromExcel("AddDoctor", 1, 1);
//		String clinicAddress = eUtil.getDataFromExcel("AddDoctor", 2, 1);
//		String fee = eUtil.getDataFromExcel("AddDoctor", 3, 1);
//		String contact = eUtil.getDataFromExcel("AddDoctor", 4, 1);
//		String mail = eUtil.getDataFromExcel("AddDoctor", 5, 1);
//		String password = eUtil.getDataFromExcel("AddDoctor", 6, 1);
//		String cnfmpwd = eUtil.getDataFromExcel("AddDoctor", 7, 1);
		
		// launching the browser
		if (BROWSER.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equalsIgnoreCase("firefox")) {

			driver = new FirefoxDriver();
		} else {
			System.out.println("Invalid browser");
		}

		wUtil.maximizeWindow(driver);
		driver.get(URL);
		wUtil.implicitWait(driver, 10);
		AdminLoginPage alp=new AdminLoginPage(driver);
		alp.adminLogin(USERNAME, PASSWORD);

		AdminDashboardPage adbp=new AdminDashboardPage(driver);
		adbp.clickOnDoctorsLink();
		adbp.clickOnAddDoctorLink();
		
		HashMap<String, String> map = eUtil.getMultipleDataFromExcel("AddDoctor", 0, 1, driver);
		
		
		AddDoctorPage adp=new AddDoctorPage(driver);
		adp.AddDoctor(driver, map, "Dentist");
		
		wUtil.sendTextToAlert(driver, "Doctor info added Successfully");

    	wUtil.acceptAlert(driver);
	}

}
