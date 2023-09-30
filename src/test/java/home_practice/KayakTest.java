package home_practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class KayakTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.get("https://www.kayak.co.in/");
		driver.findElement(By.xpath("//div[@aria-label='Remove']")).click();
		driver.findElement(By.xpath("//input[@aria-label='Flight origin input']")).sendKeys("Bengaluru, Karnataka, India (BLR)");
		driver.findElement(By.xpath("//input[@placeholder='To?']")).sendKeys("Goa, India");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h2[@class='title dark']")).click();
		driver.findElement(By.xpath("//div[@class='sR_k-input sR_k-mod-responsive']/span[@aria-label='Start date calendar input']")).click();
        driver.findElement(By.xpath("//div[@data-month='2023-10']/descendant::div[text()='10']")).click();
        driver.findElement(By.xpath("//div[@data-month='2023-10']/descendant::div[text()='15']"));
        Thread.sleep(3000);
        driver.findElement(By.xpath("//button[@type='submit' and @aria-label='Search']")).click();
        
	}

}
