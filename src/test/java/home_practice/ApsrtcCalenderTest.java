package home_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ApsrtcCalenderTest {

	public static void main(String[] args) {
		int date = 25;
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.apsrtconline.in/");
		driver.findElement(By.xpath("//input[@name='txtJourneyDate']")).click();
		driver.findElement(By.xpath("(//table[@class='ui-datepicker-calendar'])[2]/descendant::a[text()='"+date+"']")).click();
		

	}

}
