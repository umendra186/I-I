package KWA51_ThankYouScreen;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kiosk.constant.KioskConfigMapper;
import com.kiosk.constant.KioskLocatorsMapper;
import com.kiosk.modules.EmailFailureScreen;
import com.kiosk.modules.GenericClass;
import com.kiosk.modules.Login;
import com.kiosk.modules.NotificationScreen;
import com.kiosk.reports.Log;
import com.kiosk.reports.Reports;
import com.kiosk.utility.Utility;

/* Class : Sprint3_KWA51_TC01_ThankYouScreenUI -- Validate the UI of Success Screen
*  Author : Sayed Zeeshan Haidar
* (C) Xavient Information System 2017
*/
public class Sprint3_KWA51_TC01_ThankYouScreenUI extends GenericClass {
	
	@Test
	public void ThankYouScreenUI()
	{
	
		try{
			Assert.assertTrue(Login.launchURl(KioskConfigMapper.URL), "Unable to navigate to URL");
			Reports.pass("User Successfully LaunchedURL");
			Log.info("User Successfully LaunchedURL");

			// Click on SEND A CARD button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.sendACard));
			Reports.pass("User successfully clicked on SEND A CARD button");
			Log.info("User successfully clicked on SEND A CARD button");			
			assertTrue(Utility.urlVerification("card-send"));
			Reports.pass("User Successfully navigated on eGift/Pickup Screen");
						
			//Click on Email button and Verify Navigation			
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.email));
			Reports.pass("User successfully clicked on EMAIL button");
			Log.info("User successfully clicked on EMAIL button");
			assertTrue(Utility.urlVerification("card-send/search"));
			Reports.pass("User Successfully navigated on Search Screen");
			
			
			//click on "Add fixed amount card" button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.fixAmountCard));
			Reports.pass("User successfully clicked on \'add fix amount card\' Mock button");
			Log.info("User successfully clicked on \'add fix amount card\' Mock button");
			
			//Calling function to add some card
			Utility.clickOnFixedRangePage();						
			
			//Click on Buy Button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.buyButton));
			Reports.pass("User Successfully Clicked on Buy Button");
			Log.info("User Successfully Clicked on Buy Button");
			Utility.urlVerification("/card-payment");
			Reports.pass("User successfully navigated on Tender Screen");
			Log.info("User successfully navigated on Tender Screen");
			
			//Click on Debit Card Button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.debitCardButton));
			Reports.pass("User Successfully Clicked on Debit Card Button");
			Log.info("User Successfully Clicked on Debit Card Button");
			Utility.urlVerification("/debit-card");
			Reports.pass("User successfully navigated on Debit card Screen");
			Log.info("User successfully navigated on  Debit card Screen");
			
			//Click on Card Personalization Mock Button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.fixAmountCard));
			Reports.pass("User Successfully Clicked on Personalization Mock Button");
			Log.info("User Successfully Clicked on Personalization Mock Button");
			Utility.urlVerification("card-send/card-personalization/address");
			Reports.pass("User successfully navigated to First page of Personalization Screen");
			Log.info("User successfully navigated to First page of Personalization Screen");
			
			// Feed Data on first Screen of Personalization screen
			EmailFailureScreen.FeedDataPersonalizationOne();
			
			// Feed Data on Second Screen of Personalization screen and move to Confirmation screen
			EmailFailureScreen.FeedDataPersonalizationTwo();
			
			// Click on Send successfull Mock button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.fixAmountCard));
			Reports.pass("User successfully clicked on Send Successfull Mock button");
			Log.info("User successfully clicked on Send Successfull Mock button");			
			assertTrue(Utility.urlVerification("card-send/notification/success"));
			Reports.pass("User Successfully navigated on success Screen");
								
			//Calling function to verify UI content
			NotificationScreen.successScreenUI();				
				
		}catch(Exception e){
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
			
		}
		
	
	}

}
