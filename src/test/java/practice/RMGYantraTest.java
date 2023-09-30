package practice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.mysql.cj.jdbc.Driver;

public class RMGYantraTest {

	public static void main(String[] args) throws Throwable {
	   
		String expdata = "QSpiders";
		Random r=new Random();
	    int rn=r.nextInt(1000);
		Connection con=null;
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://rmgtestingserver:8084/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.id("usernmae")).sendKeys("rmgyantra");
		driver.findElement(By.id("inputPassword")).sendKeys("rmgy@9999");
		driver.findElement(By.xpath("//button[text()='Sign in']")).click();
		driver.findElement(By.xpath("//a[text()='Projects']")).click();
		driver.findElement(By.xpath("//span[text()='Create Project']")).click();
		driver.findElement(By.xpath("//input[@name='projectName']")).sendKeys(expdata+rn);
		driver.findElement(By.xpath("//input[@name='createdBy']")).sendKeys("TYSS");
		WebElement ele = driver.findElement(By.xpath("(//select[@name='status'])[2]"));
		Select sel =new Select(ele);
		sel.selectByVisibleText("Created");
		driver.findElement(By.xpath("//input[@value='Add Project']")).click();
		
		Driver driver1=new Driver();
		//Step1:Register the driver
		DriverManager.registerDriver(driver1);
		//Step2:Connect to database
		con=DriverManager.getConnection("jdbc:mysql://rmgtestingserver:3333/projects", "root@%", "root");
		//Step3:Create statement
		Statement state = con.createStatement();
		//Step4:Execute query
		String query = "select * from project;";
		ResultSet result = state.executeQuery(query);
		boolean flag=false;
		while(result.next())
		{
		String actual = result.getString(4);
		if(actual.equalsIgnoreCase(expdata)) {
			flag=true;
			break;
		}
		}
		if (flag==true) {
			System.out.println("Project is created");
		} else {
			System.out.println("Project is not created");
		}
		
		}
	}


