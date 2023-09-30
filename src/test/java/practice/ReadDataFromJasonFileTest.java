package practice;

import java.io.FileReader;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadDataFromJasonFileTest {

	public static void main(String[] args) throws Throwable {
		JSONParser jp=new JSONParser();
		
		Object obj = jp.parse(new FileReader(".\\src\\main\\resources\\JasonData.json"));
		
		JSONObject map=(JSONObject)obj;
		System.out.println(map.get("username"));
		System.out.println(map.get("url"));
		System.out.println(map.get("browser"));
		System.out.println(map.get("password"));

	}

	

}
