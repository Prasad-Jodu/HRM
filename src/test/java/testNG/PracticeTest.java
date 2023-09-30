package testNG;

import org.testng.annotations.Test;

public class PracticeTest {
	@Test()
	public void createTest() {
		
		int a=10;
		int b=0;
		int c=a/b;
				
		System.out.println("data created");
	}
	
	@Test(priority = 1,dependsOnMethods ="createTest" )
    public void editTest() {
    	System.out.println("Modification done successfully");
    }
    
	@Test(priority = 2)
    public void deleteTest() {
    	System.out.println("--- Data deleted successfully--");
    }
}
