package practice;


import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.mysql.cj.jdbc.Driver;

public class JioMartTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.jiomart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Actions act=new Actions(driver);
        WebElement groceries = driver.findElement(By.xpath("//a[text()='Groceries']"));
        act.moveToElement(groceries).perform();
        WebElement fruits = driver.findElement(By.xpath("//a[text()='Fruits & Vegetables']"));
        act.moveToElement(fruits).perform();
        //WebElement bakery = driver.findElement(By.xpath("//a[text()='Dairy & Bakery']"));
//        act.moveToElement(bakery).perform();
      List<WebElement> list = driver.findElements(By.xpath("//a[.='Fruits & Vegetables']/following-sibling::div/descendant::li[@class='header-nav-l3-item']"));
        //List<WebElement> br = driver.findElements(By.xpath("//li[@class='header-nav-l3-item' ]"));
       
       for (int i = 0; i < list.size(); i++) {
    	   String a = list.get(i).getText();
    	  // if(a!="")
		  System.out.println(a);
	}
	}

}
