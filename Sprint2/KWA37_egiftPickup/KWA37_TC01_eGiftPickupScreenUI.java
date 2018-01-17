package KWA37_egiftPickup;

import static org.testng.Assert.assertTrue;

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
 * Class : KWA37_TC01_eGiftPickupScreenUI - Verify UI content of eGiftPickup
 * Author : Umendra Singh Tomar
 * (C) Xavient Information System 2017
 * 
 */

public class KWA37_TC01_eGiftPickupScreenUI extends GenericClass{
	
	public static boolean flag;
	public static String imagePath;
	Screen sc;
	
	@Test
	public void eGiftPickupScreenUI()
	{
		try{
			Assert.assertTrue(Login.launchURl(KioskConfigMapper.URL),"Unable to navigate to URL");
			Reports.pass("User Successfully LaunchedURL");
			Log.info("User Successfully LaunchedURL");
			
			// Validating Navigation to eGiftPickup Screen
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.sendACard));
			Reports.pass("User successfully clicked on SEND A CARD button");
			Log.info("User successfully clicked on SEND A CARD button");			
			assertTrue(Utility.urlVerification("card-send"));
			Reports.pass("User Successfully navigated on eGift/Pickup Screen");
			
			
			//	Validating Send a card - eGift Page images			
			Utility.validateInvalidImages();
			
			// Validating EMAIL button on eGiftPickup Screen			
			Utility.getLocator(KioskLocatorsMapper.email).isDisplayed();
			Reports.info("Email button is displayed as expected");
			
			// Validating definition for EMAIL button on eGiftPickup Screen			
			Utility.getLocator(KioskLocatorsMapper.emailDef).isDisplayed();
			Reports.info("Email button definition is displayed as expected");
			
						
			// Validating KISOK PICKUP button on eGiftPickup Screen
			
			Utility.getLocator(KioskLocatorsMapper.kioskpickup).isDisplayed();
			Reports.info("Kioskpickup button is displayed as expected");
			
			// Validating definition for EMAIL button on eGiftPickup Screen
			
			Utility.getLocator(KioskLocatorsMapper.kioskpickupDef).isDisplayed();
			Reports.info("Kioskpickup button definition is displayed as expected");
			
						
		}catch(Exception e){
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
			
		}
	}

}
