package KWA42_eGiftCartScreen;

import static org.testng.Assert.assertTrue;

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
 * Class : KWA42_TC01_eGiftCartUI-Verify the content of eGift cart screen fixed Denomination flow
 *  * Author : Umendra Singh Tomar
 * (C) Xavient Information System 2017
 * 
 */
public class Sprint2_KWA42_TC01_eGiftCartUI_FixedDenomination extends GenericClass {
	
	public static boolean flag;
	public static String imagePath;
	
	@Test
	public void eGiftCartUI(){
		
		try {
			Assert.assertTrue(Login.launchURl(KioskConfigMapper.URL),"Unable to navigate to URL");
			Reports.pass("User Successfully LaunchedURL");
			Log.info("User Successfully LaunchedURL");

			// Click on SEND A CARD button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.sendACard));
			Reports.pass("User successfully clicked on SEND A CARD button");
			Log.info("User successfully clicked on SEND A CARD button");			
			assertTrue(Utility.urlVerification("card-send"));
			
			//Click on Email button and Verify Navigation			
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.email));
			Reports.pass("User successfully clicked on EMAIL button");
			Log.info("User successfully clicked on EMAIL button");
			assertTrue(Utility.urlVerification("/card-send/search/category/0"));
			Reports.pass("User Successfully navigated on Search Screen");
			
			//click on "Add Fix amount card" button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.fixAmountCard));
			Reports.pass("User successfully clicked on \'add fix amount card\' Mock button");
			Log.info("User successfully clicked on \'add fix amount card\' Mock button");
			
			//Calling function to add fixed/variable card
			Utility.clickOnFixedRangePage();				
			
			Utility.getLocator(KioskLocatorsMapper.cancelButton).isDisplayed();
			Reports.info("Cancel button is displayed as expected");
			
			Utility.getLocator(KioskLocatorsMapper.buyButton).isDisplayed();
			Reports.info("Buy button is displayed as expected");
			
			Utility.getLocator(KioskLocatorsMapper.brandName).isDisplayed();
			Reports.pass("brand Name is displayed as expected--->"   +Utility.getLocator(KioskLocatorsMapper.brandName).getText());
			
			Utility.getLocator(KioskLocatorsMapper.denomination).isDisplayed();
			Reports.pass("Denomination is displayed as expected--->" +Utility.getLocator(KioskLocatorsMapper.denomination).getText());
			
			Utility.getLocator(KioskLocatorsMapper.quantity).isDisplayed();
			Reports.pass("Quantity is displayed as expected--->" +Utility.getLocator(KioskLocatorsMapper.quantity).getText());
			
			Utility.getLocator(KioskLocatorsMapper.lineTotal).isDisplayed();
			Reports.pass("Line Total is displayed as expected--->" +Utility.getLocator(KioskLocatorsMapper.lineTotal).getText());
			
			Utility.getLocator(KioskLocatorsMapper.todaystotal).isDisplayed();
			Reports.pass("Total Amount is displayed as expected--->" +Utility.getLocator(KioskLocatorsMapper.todaystotal).getText());
			
			Utility.getLocator(KioskLocatorsMapper.goBackButtonCC).isDisplayed();
			Reports.info("Go Back button is displayed as expected");

			//validate images
			Utility.validateInvalidImages();

		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());

		}
	}
	

}
