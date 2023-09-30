package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FetchDataFromExcelUsinMapTest {

	public static void main(String[] args) throws Throwable {
		WebDriver driver=new ChromeDriver();
		
		
		//Fetch data from Excel using Map Interface
		FileInputStream fis=new FileInputStream(".\\src\\main\\resources\\Test.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Organizations");
		int count = sh.getLastRowNum();
		
		
		HashMap<String, String> map=new HashMap<String,String>();
        for (int i = 0; i <=count; i++) {
			
			String key = sh.getRow(i).getCell(0).getStringCellValue();
			String value = sh.getRow(i).getCell(1).getStringCellValue();
			map.put(key,value);
			System.out.println(key+"--->"+value);
		}
        
        for (Entry<String, String> s:map.entrySet()) {
        	
        	
			driver.findElement(By.name(s.getKey())).sendKeys(s.getValue());
		}
		
	}

}
