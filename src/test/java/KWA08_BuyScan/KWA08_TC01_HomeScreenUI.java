package KWA08_BuyScan;

import java.util.Properties;

import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.kiosk.constant.Constant;
import com.kiosk.constant.KioskConfigMapper;
import com.kiosk.modules.Login;
import com.kiosk.modules.GenericClass;
import com.kiosk.reports.Log;
import com.kiosk.reports.Reports;
import com.kiosk.utility.Utility;

/**
 * Class : TC01_HomeScreenContent-Verify content of Home Screen 
 * Author : Umendra Singh Tomar
 * (C) Xavient Information System 2017
 * 
 */

public class KWA08_TC01_HomeScreenUI extends GenericClass {
	
	
	public static boolean flag;
	public static String imagePath;
	Screen sc;
	
	
	@Test
	public void homeScreenContent(){
		
		try{
			Assert.assertTrue(Login.launchURl(KioskConfigMapper.URL),"Unable to navigate to URL");
			Reports.pass("User Successfully LaunchedURL");
			Log.info("User Successfully LaunchedURL");
			
			//Validating the content of home page
			sc= new Screen();
			sc.find(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\SikuliImages\\Brand.PNG");
			Reports.pass("BUY A CARD button is visible as expected");
			Log.info("BUY A CARD button is visible as expected");
			
			sc.find(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\SikuliImages\\SendButton.PNG");
			Reports.pass("SEND A CARD button is visible as expected");
			Log.info("SEND A CARD button is visible as expected");
			
			sc.find(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\SikuliImages\\ExchangeButton.PNG");
			Reports.pass("EXCHANGE OR RELOAD button is visible as expected");
			Log.info("EXCHANGE OR RELOAD button is visible as expected");
			
			sc.find(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\SikuliImages\\QuickSelect.PNG");
			Reports.pass("QUICK SELECT cards are visible as expected");
			Log.info("QUICK SELECT cards are visible as expected");			
			Utility.validateInvalidImages();
			
		}catch(Exception e){
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
			
		}
		
	}

}
