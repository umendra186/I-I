package KWA10_ScanInstructionPrompt;

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
 * Class : KWA10_TC05_AppLogoNavigation - Verify app logo navigation 
 * Author : Kishan Singh Chilwal 
 * (C) Xavient Information System 2017
 * 
 */

public class KWA10_TC05_AppLogoNavigation extends GenericClass {

	public static boolean flag;
	public static String imagePath;
	Screen sc;

	@Test
	public void appLogoNavigation() {

		try {
			Assert.assertTrue(Login.launchURl(KioskConfigMapper.URL), "Unable to navigate to URL");
			Reports.pass("User Successfully LaunchedURL");
			Log.info("User Successfully LaunchedURL");

			// Click on BUY A CARD
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.buyCard));
			Reports.pass("User successfully clicked on BUY A CARD button");
			Log.info("User successfully clicked on BUY A CARD button");
			assertTrue(Utility.urlVerification("card-buy"));
			Reports.pass("User Successfully navigated on Seach/Scran Screen");

			// Click on Scan button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.scanCardButton));
			Reports.pass("User successfully clicked on SCAN button");
			Log.info("User successfully clicked on SCAN button");
			assertTrue(Utility.urlVerification("/card-buy/scan"));
			Reports.pass("User Successfully navigated on  Instruction prompt screen");

			// Validate app logo navigation
			Utility.logoFunctionality();
			

		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}

	}

}
