package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Goibibo {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.goibibo.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("//span[@role='presentation']")).click();
		
		driver.findElement(By.xpath("//p[@class='sc-jlwm9r-1 ewETUe']")).click();
		
		 driver.findElement(By.xpath("//span[.='Departure']")).click();
		 driver.findElement(By.xpath("//div[text()='October 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[.='12']"));
		Actions act=new Actions(driver);
	//	act.moveToElement(ele).click();
//		ele.click();
//		ele.sendKeys("Hyderabad");
		//driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Bangalore");
	}

}
