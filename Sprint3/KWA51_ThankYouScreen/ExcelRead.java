package KWA51_ThankYouScreen;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class ExcelRead {

	@Test
	public void m() throws IOException, InvalidFormatException {
		File inputfile = new File("C:\\Users\\utomar\\Desktop\\charmy.xlsx");
		XSSFWorkbook  Workbook  =  new XSSFWorkbook(inputfile);
		XSSFSheet inputsheet = Workbook.getSheet("Sheet1");

		int inputrow = inputsheet.getPhysicalNumberOfRows();
		int inputcol = inputsheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Row" + inputrow + "col" + inputcol);

		for (int i = 0; i < inputrow; i++) {
			for (int j = 0; j < inputcol; j++) {

				String strValue=inputsheet.getRow(i).getCell(j).getStringCellValue();
			
				System.out.println("Excel Values-----> "+i+strValue );
			}
		}


	}

}
