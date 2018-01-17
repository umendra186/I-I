


package KWA09_SearchScan;

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
 * Class : KWA09_TC01_SearchScanScreenUI - Verify content of Search Scan screen
 * Author : Umendra Singh Tomar
 * (C) Xavient Information System 2017
 * 
 */

public class Sprint1_KWA09_TC01_SearchScanScreenUI extends GenericClass{

	public static boolean flag;
	public static String imagePath;

	@Test
	public void searchScanScreenContent(){
		
		try {
			Assert.assertTrue(Login.launchURl(KioskConfigMapper.URL),"Unable to navigate to URL");
			Reports.pass("User successfully launched Home screen");
			Log.info("User successfully launched Home screen");
			
			// Tap on the Buy a Card button on home screen
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.buyCard));
			Reports.pass("User successfully clicked on BUY A CARD button");
			Log.info("User successfully clicked on BUY A CARD button");			
			assertTrue(Utility.urlVerification("card-buy"));

			// Validating category button 
			Utility.getLocator(KioskLocatorsMapper.categoryText).isDisplayed();
			Reports.pass("Category button is visible as expected");
			Log.info("Category button is visible as expected");

			// Validating Scan button 
			Utility.getLocator(KioskLocatorsMapper.scanText).isDisplayed();
			Reports.pass("Scan button is visible as expected");
			Log.info("Scan button is visible as expected");

			// Validating Store Name button 
			Utility.getLocator(KioskLocatorsMapper.storeNameText).isDisplayed();
			Reports.pass("Store Name button is visible as expected");
			Log.info("Store Name button is visible as expected");

			// Validating Brand button 
			Utility.getLocator(KioskLocatorsMapper.brandText).isDisplayed();
			Reports.pass("Brand button is visible as expected");
			Log.info("Brand button is visible as expected");
			
			//Validating the QUICK SELECT text
			Utility.getLocator(KioskLocatorsMapper.quickSelect).isDisplayed();
			Reports.pass("As Expected, Quick Select Text div is displayed");
			
			//Validating the content of home page
			Log.info("Calling function to validate the image HTTP Response");
			Utility.validateInvalidImages();

		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot(e.getMessage(), imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());

		}

	}
	
}
