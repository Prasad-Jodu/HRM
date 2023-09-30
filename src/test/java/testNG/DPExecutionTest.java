package testNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.HMS.GenericUtilities.ExcelUtility;

public class DPExecutionTest {
    
    
    @DataProvider
    public Object[][] dataFromExcel() throws Throwable {
    	ExcelUtility eUtil=new ExcelUtility();
    	Object[][] value = eUtil.getMultipleSetOfData("DP");
    	return value;
    }
    
    @Test(dataProvider = "dataFromExcel")
	public void getData(String name,String price,String colour)
	{
		System.out.println(name+"    "+price+"  "+colour);
	}
}
