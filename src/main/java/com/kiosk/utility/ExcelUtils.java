package com.kiosk.utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.kiosk.constant.Constant;
import com.kiosk.reports.Log;
import com.kiosk.reports.Reports;

public class ExcelUtils {
	
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFCell excelData;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static InputStream file;
	public static String value, data, filepath;
	public static FileOutputStream fout;
	public static HashMap<String, String> map;
	
	public static void setExcelPath(String sheetname, String Excelpath) {
		file = null;
		try {
			file = new FileInputStream(Excelpath);
		} catch (FileNotFoundException e) {
			Reports.fail(e.toString());
			e.printStackTrace();

		}
		try {
			workbook = new XSSFWorkbook(file);
			sheet = workbook.getSheet(sheetname);
		} catch (IOException e) {
			Reports.fail(e.toString());
			e.printStackTrace();
		}	}

	public static String getExcelData(int rownum, int colnum) throws IOException {
		data = null;
		excelData = sheet.getRow(rownum).getCell(colnum);
		try {
			data = excelData.getStringCellValue();

		} catch (Exception e) {
			// e.printStackTrace();
			DataFormatter formatter = new DataFormatter(); // creating formatter
															// using the default
															// locale
			Cell cell = sheet.getRow(rownum).getCell(colnum);
			data = formatter.formatCellValue(cell);
		}
		
		
		return data;
	}

	/*public static void SetExcelData(String Result, int rownum, int colnum) {
		row = sheet.getRow(rownum);
		cell = row.createCell(colnum);
		cell.setCellValue(Result);
		try {
			fout = new FileOutputStream(Constant.tc_data_path);

		} catch (FileNotFoundException e) {
			Reports.fail(e.toString());
			System.out.println("Unable to locate Excel ");
			e.printStackTrace();

		}
		try {
			workbook.write(fout);
		} catch (IOException e) {
			Reports.fail(e.toString());
			System.out.println("unable to set Excel Data");
		}
	}*/
	
	public static Object[][] readData(String filepath, String sheetname) throws IOException {

		Object[][] Exceldata = null;
		file = null;
	try {
			try {
				file = new FileInputStream(filepath);
			}
				catch(FileNotFoundException e)
				{
					Reports.fail(e.toString());
					e.printStackTrace();
				}
				try{
				workbook = new XSSFWorkbook(file);
				sheet = workbook.getSheet(sheetname);
			} catch (IOException e) {
				Reports.fail(e.toString());
				e.printStackTrace();
			}
			int startrow = 1;
			int startcol = 0;
			int totalrow = sheet.getLastRowNum();
			System.out.println("Totalrow:" + totalrow);
			int totalcol = sheet.getRow(0).getPhysicalNumberOfCells() ;
			 System.out.println(totalcol);
			int ci, cj;
			Exceldata = new Object[totalrow][totalcol];
			ci = 0;
			for (int i = startrow; i <= totalrow; i++, ci++) {
				cj = 0;
				for (int j = startcol; j < totalcol; j++, cj++) {

					Exceldata[ci][cj] = getExcelData(i, j);
					System.out.println("Data store at index-- " + "Data[" + ci + "]" + "[" + cj + "]==>>" + "[" + i
							+ "]" + "[" + j + "]" + "--->" + Exceldata[ci][cj]);

				}

			}
	} catch (Exception e) {
			Reports.fail(e.toString());
			e.printStackTrace();
		}
		return (Exceldata);

	}
	
	
/********** Fetching data form excel for Personalization Screen and return it to map ***************/	
	
	public static HashMap<String, String> readDataForPersonalization() {
		try {
			file = null;
			try {
				file = new FileInputStream(System.getProperty("user.dir")
						+ "/src/test/resources/testdata/ExcelData/TestData.xlsx");
				

			} catch (FileNotFoundException e) {
				Reports.fail(e.toString());
				e.printStackTrace();

			}
			try {
				workbook = new XSSFWorkbook(file);
				sheet = workbook.getSheet("Personalization");
			} catch (IOException e) {
				Reports.fail(e.toString());
				e.printStackTrace();
			}

			int totalrow = sheet.getLastRowNum();
			System.out.println("Totalrow:" + totalrow);
			int totalcol = sheet.getRow(0).getPhysicalNumberOfCells();
			Log.info("TotalCol:" + totalcol);
			String[] stringkey = new String[totalrow];
			int k = 0;
			for (int i = 1; i <= totalrow; i++) {
				String keys = sheet.getRow(i).getCell(0).getStringCellValue();
				Log.info("Key--------->" + keys);
				stringkey[k++] = keys;
			}
			int startrow = 1;
			int startcol = 1;
			int ci, cj;
			Object[][] Exceldata = new Object[totalrow][totalcol];
			ci = 0;
			map = new LinkedHashMap<String, String>();
			DataFormatter formatter = new DataFormatter();

			for (int i = startrow; i <= totalrow; i++, ci++) {
				cj = 0;
				for (int j = startcol; j < totalcol; j++, cj++) {
					/*Log.info("stringkey[ci] ------>" + stringkey[ci]);
					Log.info("key value ----------->"
							+ sheet.getRow(i).getCell(j).getStringCellValue());*/
					map.put(stringkey[ci],formatter.formatCellValue(sheet.getRow(i).getCell(j)));

				}
			}

			for (Map.Entry m : map.entrySet()) {
				Log.info("map value" + m.getKey() + " " + m.getValue());
			}

		} catch (Exception e) {
			Reports.fail(e.toString());
			e.printStackTrace();
		}
		return map;

	}
}
