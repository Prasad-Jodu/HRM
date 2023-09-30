package practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertyFileTest {

	public static void main(String[] args) throws Throwable {
		
	    //Step1:Object representation of physical file
		FileInputStream fis=new FileInputStream(".\\src\\main\\resources\\CommomData.properties");
		//Step2: object to property class
		Properties pObj=new Properties();
		//Step3:load the keys
		pObj.load(fis);
		//Step4: use the getProperty to fetch the values
		String BROWSER = pObj.getProperty("browser");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		
		System.out.println(BROWSER);
		System.out.println(URL);
		System.out.println(USERNAME);
		System.out.println(PASSWORD);

	}

}
