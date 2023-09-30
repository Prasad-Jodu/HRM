package home_practice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TokyoOlympicMedalsTableTest {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://olympics.com/en/olympic-games/tokyo-2020/medals");
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		List<WebElement> allCountries = driver.findElements(By.xpath("//div[@data-cy='table-content']/descendant::span[@data-cy='country-name']"));
		List<WebElement> goldMedals = driver.findElements(By.xpath("//div[@data-cy='table-content']/descendant::div[@title='Gold']"));
		List<WebElement> silverMedals = driver.findElements(By.xpath("//div[@data-cy='table-content']/descendant::div[@title='Silver']"));
		List<WebElement> bronzeMedals = driver.findElements(By.xpath("//div[@data-cy='table-content']/descendant::div[@title='Bronze']"));
	//	System.out.println("CountyName--->Gold Medals--->Silver Medals--->Bronze Medals");
		String county = "India";
		for (int i = 0; i < allCountries.size(); i++) {
			String countyName = allCountries.get(i).getText();
			//if(countyName.equalsIgnoreCase(county)) {
			String medalsTable = allCountries.get(i).getText()+"  Gold->"+goldMedals.get(i).getText()+"  Silver->"+silverMedals.get(i).getText()+"  Bronze->"+bronzeMedals.get(i).getText();
			System.out.println(medalsTable);
			//}
		}

	}

}
