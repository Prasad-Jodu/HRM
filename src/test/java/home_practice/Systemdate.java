package home_practice;

import java.util.Date;

public class Systemdate {

	public static void main(String[] args) {
		Date dateAndTime = new Date();
		System.out.println(dateAndTime);
		
		String[] d = dateAndTime.toString().split(" ");
		String day = d[0];
		String month = d[1];
		String date = d[2];
		String time = d[3];
		String year = d[5];
		String finalFormat = date+" "+day+" "+month+" "+time+" "+year;
		System.out.println(finalFormat);
	}

}
