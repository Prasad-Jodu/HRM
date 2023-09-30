package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MakeMyTripTest {

	public static void main(String[] args) throws InterruptedException {
		String MonthAndYear="November 2023";
		int date=5;
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().window().maximize();
//		Thread.sleep(3000);
//		driver.navigate().refresh();
		Actions act =new Actions(driver);
		act.doubleClick().perform();
		Thread.sleep(3000);
		act.moveByOffset(10, 80).click().perform();
		driver.findElement(By.xpath("//span[text()='Departure']")).click();
		Thread.sleep(3000);
String actual="//div[text()='"+MonthAndYear+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']";
String nextArrow="//span[@aria-label='Next Month']";
for(;;)
	try{
	driver.findElement(By.xpath(actual)).click();
	break;
	}
	catch(Exception e)
	{
	driver.findElement(By.xpath(nextArrow)).click();
	}
	driver.findElement(By.xpath("//span[text()='Done']")).click();
		
	}

}
