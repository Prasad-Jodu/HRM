package home_practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcelTest {

	public static void main(String[] args) throws Throwable {
//		FileInputStream fis=new FileInputStream(".\\src\\main\\resources\\Test.xlsx");
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet("Organizations");
//		sh.createRow(15).createCell(0).setCellValue("Jailer");
//		sh.getRow(15).createCell(1).setCellValue("Jawan");
//		sh.getRow(15).createCell(2).setCellValue("Patan");
//		
//		FileOutputStream fos=new FileOutputStream(".\\src\\main\\resources\\Test.xlsx");
//		wb.write(fos);
//		wb.close();

		
		FileInputStream fis=new FileInputStream(".\\src\\main\\resources\\Test.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.createSheet("Sample Sheet");
		sh.createRow(0).createCell(0).setCellValue("Name");
		sh.getRow(0).createCell(1).setCellValue("Branch");
		sh.getRow(0).createCell(2).setCellValue("Location");
		
		FileOutputStream fos=new FileOutputStream(".\\src\\main\\resources\\Test.xlsx");
		wb.write(fos);
		wb.close();
		
	}

}
