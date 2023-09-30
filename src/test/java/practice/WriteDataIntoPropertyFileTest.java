package practice;

import java.io.FileOutputStream;
import java.util.Properties;

public class WriteDataIntoPropertyFileTest {

	public static void main(String[] args) throws Throwable {
		Properties pObj = new Properties();
		pObj.setProperty("browser", "chrome");
		pObj.setProperty("url", "http://localhost:8888/");
		pObj.setProperty("username", "admin");
		pObj.setProperty("password", "admin");
		
		FileOutputStream fos=new FileOutputStream(".\\src\\main\\resources\\CommomData.properties");
		pObj.store(fos, "write data");
		fos.close();
		
		
		
	}

}
