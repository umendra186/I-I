package Test_Runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.TestNG;
import org.testng.xml.XmlClass;
import org.testng.xml.XmlSuite;
import org.testng.xml.XmlTest;


/**
 * Class : XmlCreator- This class is use to run the test Cases as per Excel Sheet
 * Author : Umendra Singh Tomar
 * (C) Xavient Information System 2017
 * 
 */
public class TestExecutor {

public static void main(String[] args) throws IOException  {
		
		
		XmlSuite xS = new XmlSuite(); // suite object
		xS.setName("Suite1"); // name set

		XmlTest xT = new XmlTest(xS); // test object
		
		// Read Input Resources 
		File f = new File(System.getProperty("user.dir")+ "\\src\\test\\resources\\testdata\\ExcelData\\Automation_TCs.xlsx"); 


		FileInputStream fin = new FileInputStream(f);
		
		XSSFWorkbook wk = new XSSFWorkbook(fin);
		
		//XSSFSheet s = wk.getSheetAt(4);
		XSSFSheet s = wk.getSheet("Kiosk_AutomationTCs");
		
		int rows = s.getLastRowNum();
		

		ArrayList<XmlClass> al = new ArrayList();

		for (int i = 1; i <= rows; i++) {

			String Status = s.getRow(i).getCell(9).getStringCellValue();
					
			if (Status.equals("Y")){
				String pkg_name   = s.getRow(i).getCell(7).getStringCellValue();
				String class_name = s.getRow(i).getCell(8).getStringCellValue();

				String v = pkg_name + "." + class_name;
			

				XmlClass c1 = new XmlClass(v); // xmlclass

				al.add(c1);

			}

		}

		System.out.println("Total Number of TestCases will Execute is :- "+al.size());

		xT.setClasses(al);

		ArrayList<XmlTest> al2 = new ArrayList<XmlTest>();

		al2.add(xT);

		xS.setTests(al2);

		ArrayList<XmlSuite> al3 = new ArrayList<XmlSuite>();
		al3.add(xS);

		TestNG t = new TestNG();
		t.setXmlSuites(al3);
		t.run();

	}
}
