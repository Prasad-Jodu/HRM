package home_practice;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		List<WebElement> links = driver.findElements(By.xpath("//a"));
		System.out.println(links.size());
		ArrayList<String> list=new ArrayList<String>();
		
		for (int i = 0; i < links.size(); i++) {
		String eachLink = links.get(i).getAttribute("href");
		URL url;
		int statusCode=0;
		try {
			url=new URL(eachLink);
			HttpURLConnection httpCon=(HttpURLConnection)url.openConnection();
			statusCode=httpCon.getResponseCode();
			if (statusCode>400) {
				list.add(eachLink+" "+statusCode);
				System.out.println(eachLink+" "+statusCode);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		}
	}

}
