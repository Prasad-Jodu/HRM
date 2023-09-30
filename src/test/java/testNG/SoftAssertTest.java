package testNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertTest {
	@Test
	public void softassert() {
		
		String expected="vtiger CRM 5 - Commercial Open Source CRM";
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888");
		String actual = driver.getTitle();
		System.out.println(actual);
		SoftAssert sa=new SoftAssert();
		sa.assertEquals(actual, expected);
		System.out.println("Application launched");
		System.out.println("Execution ends");
		sa.assertAll();
		
	}

}
