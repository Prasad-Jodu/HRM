package testNG;

import org.testng.annotations.Test;

import com.HMS.GenericUtilities.BaseClass;

public class Sample extends BaseClass{
	
	@Test(groups = "Smoke")
	public void sample() {
		System.out.println("--Sample--");
	}
	
	
	@Test
	public void Sample2() {
		System.out.println("--Sample2--");
	}

}
