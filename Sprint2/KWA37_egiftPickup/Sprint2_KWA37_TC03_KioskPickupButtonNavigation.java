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
 * Class : KWA37_TC03_KioskPickupButtonNavigation - Verify KIOSK PICKUP button navigation path
 * Author : Umendra Singh Tomar
 * (C) Xavient Information System 2017
 * 
 */

public class Sprint2_KWA37_TC03_KioskPickupButtonNavigation extends GenericClass {
	
	public static boolean flag;
	public static String imagePath;

	@Test
	public void appLogoNavigation() {

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
			
			//Click on Email button and Verify Navigation			
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.kioskpickup));
			Reports.pass("User successfully clicked on KIOSK button");
			Log.info("User successfully clicked on KIOSK button");
			assertTrue(Utility.urlVerification("/card-send"));
			Reports.pass("User Successfully navigated on Search Screen");
			

		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}

	}



}
