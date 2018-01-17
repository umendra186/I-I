package KWA37_egiftPickup;

import static org.testng.Assert.assertTrue;

import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.kiosk.constant.KioskConfigMapper;
import com.kiosk.constant.KioskLocatorsMapper;
import com.kiosk.modules.Login;
import com.kiosk.modules.GenericClass;
import com.kiosk.reports.Log;
import com.kiosk.reports.Reports;
import com.kiosk.utility.Utility;

/**
 * Class : KWA37_TC05_PathDefinitionValidation - Verify screen path definition  for EMAIL and KIOSK PICKUP
 * Author : Umendra Singh Tomar
 * (C) Xavient Information System 2017
 * 
 */

public class KWA37_TC05_PathDefinitionValidation extends GenericClass {

	public static boolean flag;
	public static String imagePath;


	@Test
	public void pathDefinitionValidation() {

		try {
			Assert.assertTrue(Login.launchURl(KioskConfigMapper.URL),"Unable to navigate to URL");
			Reports.pass("User Successfully LaunchedURL");
			Log.info("User Successfully LaunchedURL");
			
			// Click on SEND A CARD button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.sendACard));
			Reports.pass("User successfully clicked on SEND A CARD button");
			Log.info("User successfully clicked on SEND A CARD button");			
			assertTrue(Utility.urlVerification("card-send"));
			Reports.pass("User Successfully navigated on eGift/Pickup Screen");
			
			// Validate app logo navigation
			Utility.getLocator(KioskLocatorsMapper.emailDef).isDisplayed();
			Reports.info("Email Defination is displayed as expected ---->" +Utility.getLocator(KioskLocatorsMapper.emailDef).getText());
			Utility.getLocator(KioskLocatorsMapper.kioskpickupDef).isDisplayed();
			Reports.info("Kioskpickup Defination is displayed as expected ---->" +Utility.getLocator(KioskLocatorsMapper.kioskpickupDef).getText());

		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}

	}

}
