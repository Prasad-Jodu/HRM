package test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJasonData {
	
public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
	JSONParser jp=new JSONParser();
	Object obj = jp.parse(new FileReader(".\\src\\test\\resources\\Jdata.json"));
	
	JSONObject jo=(JSONObject)obj;
	System.out.println(jo.get("name"));
	System.out.println(jo.get("id"));
	System.out.println(jo.get("company"));
	


}
}
