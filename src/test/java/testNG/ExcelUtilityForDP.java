package testNG;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.HMS.GenericUtilities.IConstantUtility;

public class ExcelUtilityForDP {
	@DataProvider
	public  Object[][] getMultipleSetOfData() throws Throwable {
		
		FileInputStream fis =new FileInputStream(IConstantUtility.excelFilePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("DP");
		int lastRow = sh.getLastRowNum();
		int lastCell = sh.getRow(0).getLastCellNum();
		Object[][] obj=new Object[lastRow+1][lastCell];
		
		for(int i=0;i<=lastRow;i++) {
			for(int j=0;j<lastCell;j++) {
				obj [i][j] =sh.getRow(i).getCell(j).getStringCellValue();
			}
		}
		return obj;
	}

}
