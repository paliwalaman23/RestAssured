package utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteToExcel {

	public void writetoexcel(String api, int statuscode, String responsetime) throws IOException {
		String path = ".//TestData/Api_Details.xlsx";

		FileInputStream fis = new FileInputStream(path);

		Workbook workbook = new XSSFWorkbook(fis);

		Sheet sheet = workbook.getSheetAt(0);
		
			
			int lastRow = sheet.getLastRowNum()+1;

			sheet.createRow(lastRow ).createCell(0).setCellValue(api);
			sheet.getRow(lastRow ).createCell(1).setCellValue(statuscode);
			sheet.getRow(lastRow ).createCell(2).setCellValue(responsetime);
		
		

		FileOutputStream fos = new FileOutputStream(path);

		workbook.write(fos);

		fos.close();
	}
}
