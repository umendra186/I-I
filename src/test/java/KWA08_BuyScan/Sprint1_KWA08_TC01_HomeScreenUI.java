package KWA08_BuyScan;

import java.util.Properties;

import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.kiosk.constant.Constant;
import com.kiosk.constant.KioskConfigMapper;
import com.kiosk.constant.KioskLocatorsMapper;
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

public class Sprint1_KWA08_TC01_HomeScreenUI extends GenericClass {	
	
	public static boolean flag;
	public static String imagePath;
	
	@Test
	public void homeScreenContent(){
		
		try{
			Assert.assertTrue(Login.launchURl(KioskConfigMapper.URL),"Unable to navigate to URL");
			Reports.pass("User Successfully LaunchedURL");
			Log.info("User Successfully LaunchedURL");
			
			//Validating the content of home page
			Reports.info("Calling function to validate the image HTTP Response");
			Utility.validateInvalidImages();
			
			//Validating the QUICK SELECT text
			Utility.getLocator(KioskLocatorsMapper.quickSelect).isDisplayed();
			Reports.pass("As Expected, Quick Select Text div is displayed");			
			
			
		}catch(Exception e){
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
			
		}
		
	}

}
