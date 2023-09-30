package home_practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Sample {

	public static void main(String[] args) {
		WebDriver driver= new ChromeDriver();
		Actions act =new Actions(driver);
        act.click();
        Select sel=new Select(null);
        sel.selectByIndex(0);
	}

}
