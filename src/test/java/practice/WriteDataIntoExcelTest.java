package practice;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelTest {

	public static void main(String[] args) throws Throwable {
		int a=10;
		String s=Integer.toString(a);
		FileInputStream fis =new FileInputStream(".\\src\\main\\resources\\Test.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Organizations");
		
		sh.createRow(6).createCell(0).setCellValue("Capgemini");
		sh.getRow(6).createCell(1).setCellValue("Flipkart");
//		sh.getRow(10).createCell(0).setCellValue("Alibaba");
//		
//		sh.createRow(8).createCell(1).setCellValue("Capgemini");
//		sh.getRow(8).createCell(2).setCellValue("Amazon");
//		sh.getRow(8).createCell(3).setCellValue("Flipkart");
//		sh.getRow(8).createCell(4).setCellValue(s);
       FileOutputStream fos=new FileOutputStream(".\\src\\main\\resources\\Test.xlsx");
       wb.write(fos);
       wb.close();
	}

}
