package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class ProkabaddiTest {

	@Test
	public  void prokabaddiTest() {
		String teamName = "Tamil Thalaivas";
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.prokabaddi.com/standings");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebElement team = driver.findElement(By.xpath("//p[.='"+teamName+"']"));
		WebElement dataform = driver.findElement(By.xpath("//p[.='"+teamName+"']/ancestor::div[@class='row-head']/descendant::ul[@class='form-listing']"));
		WebElement points = driver.findElement(By.xpath("//p[.='"+teamName+"']/ancestor::div[@class='row-head']/descendant::div[@class='table-data points']"));
		System.out.println("Team Name-->"+team.getText());
        System.out.println("form-->"+dataform.getText());
        System.out.println("Points-->"+points.getText());
	}

}
