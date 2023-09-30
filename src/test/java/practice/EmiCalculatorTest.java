package practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


public class EmiCalculatorTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://emicalculator.net/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement element = driver.findElement(By.xpath("//*[name()='path' and @class='highcharts-point' and @d='M 17 60.52579855318584 A 4 4 0 1 1 17.003999999333335 60.525796553186005 Z']"));
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
		//act.perform();
		
		
	}

}
