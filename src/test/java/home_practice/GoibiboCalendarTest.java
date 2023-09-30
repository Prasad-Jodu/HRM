package home_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoibiboCalendarTest {

	public static void main(String[] args) {
		String MonAndYear="December 2023";
		int date=23;
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.goibibo.com/");
		driver.findElement(By.xpath("//span[@class='logSprite icClose']")).click();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
//		driver.findElement(By.xpath("//span[@aria-label='Next Month']")).click();
		String nxtmonth="//span[@aria-label='Next Month']";
		String actdate="//div[text()='"+MonAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
//		driver.findElement(By.xpath("//div[text()='November 2023']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='23']")).click();
		for(;;) 
			try {
				driver.findElement(By.xpath(actdate)).click();
				break;
			}
		       catch (Exception e) {
				driver.findElement(By.xpath(nxtmonth)).click();
				
			}
		driver.findElement(By.xpath("//span[text()='Done']")).click();

		
	}
	}


