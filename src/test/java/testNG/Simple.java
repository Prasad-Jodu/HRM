package testNG;

import org.testng.annotations.Test;

import com.HMS.GenericUtilities.BaseClass;

public class Simple extends BaseClass {
	
	@Test
	public void simple() {
		System.out.println("--simple--");
	}

}
