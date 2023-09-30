package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.HMS.GenericUtilities.BaseClass;

public class SampleRetryTest extends BaseClass {
	@Test(retryAnalyzer = com.HMS.GenericUtilities.RetryImpli.class)
	public void retrytest() {
		
		Assert.assertEquals("A", "B");
	}

}
