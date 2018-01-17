package KWA40_FixedDenominationPage;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.kiosk.constant.KioskConfigMapper;
import com.kiosk.constant.KioskLocatorsMapper;
import com.kiosk.modules.GenericClass;
import com.kiosk.modules.Login;
import com.kiosk.reports.Log;
import com.kiosk.reports.Reports;
import com.kiosk.utility.Utility;


/**
 * Class : KWA40_TC02_AppLogoNavigation - Verify app logo navigation
*  Author : Kishan Singh Chilwal
*  (C) Xavient Information System 2017
* 
*/

public class Sprint2_KWA40_TC02_AppLogoNavigation extends GenericClass{
	
	public static boolean flag;
	public static String imagePath;

	
	@Test
	public void appLogoNavigation()
	{
		try{
			Assert.assertTrue(Login.launchURl(KioskConfigMapper.URL),"Unable to navigate to URL");
			Reports.pass("User Successfully launched Home screen");
			Log.info("User Successfully launched Home screen");
			
			// Validating Navigation to eGiftPickup Screen
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.sendACard));
			Reports.pass("User successfully clicked on SEND A CARD button");
			Log.info("User successfully clicked on SEND A CARD button");			
			assertTrue(Utility.urlVerification("card-send"));
			Reports.pass("User Successfully navigated on eGift/Pickup Screen");
			
			//Click on Email button and Verify Navigation			
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.email));
			Reports.pass("User successfully clicked on EMAIL button");
			Log.info("User successfully clicked on EMAIL button");
			assertTrue(Utility.urlVerification("/card-send/search/category/0"));
			Reports.pass("User Successfully navigated on Search Screen");			
			
			//click on "Add fixed amount card" button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.fixAmountCard));
			Reports.pass("User successfully clicked on \'add fix amount card\' Mock button");
			Log.info("User successfully clicked on \'add fix amount card\' Mock button");
			
			//Validate App Logo Functinality 
			Utility.logoFunctionality();
			
						
		}catch(Exception e){
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
			
		}
	}

}
