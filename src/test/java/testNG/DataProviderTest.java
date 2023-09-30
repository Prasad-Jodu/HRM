package testNG;

import org.testng.annotations.DataProvider;

public class DataProviderTest {
	@DataProvider
	public Object[][] tv()
	{
		Object[][] obj=new Object[2][2];
		
		obj[0][0]="Redmi";
		obj[0][1]=13500;
		
		
		obj[1][0]="vivo";
		obj[1][1]=15000;
	
		return obj ;
		
	}
	@DataProvider
	public Object[][] car()
	{
		Object[][] obj=new Object[3][3];
		
		obj[0][0]="Tata";
		obj[0][1]=1500000;
		obj[0][2]="White";
		
		obj[1][0]="Mahendra Thar";
		obj[1][1]=2000000;
		obj[1][2]="Black";
		
		obj[2][0]="Kia";
		obj[2][1]=1800000;
		obj[2][2]="Black";
		return obj;
	}

}
