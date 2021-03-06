package KWA135_ReversalScreen;

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

/* Class : Sprint3_KWA135_TC02_TimeOutFunctionality -- Validate navigation to Home screen after 30sec
*  Author : Sayed Zeeshan Haidar
* (C) Xavient Information System 2017
*/
public class Sprint3_KWA135_TC02_TimeOutFunctionality extends GenericClass {
	
	@Test
	public void TimeOutFunctionality()
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
			
			// Click on Invalid Email Mock button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.addRandomCard));
			Reports.pass("User successfully clicked on Invalid Email button");
			Log.info("User successfully clicked on Invalid Email button");			
			assertTrue(Utility.urlVerification("card-send/email-failure"));
			Reports.pass("User Successfully navigated on email-failure Screen");
			
			// Click on Cancel Button and verify user navigation to Reversal screen
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.cancelButton));
			Reports.pass("User Successfully Clicked on Cancel Button");
			Log.info("User Successfully Clicked on Cancel Button");
			assertTrue(Utility.urlVerification("card-send/notification/error"));
			Reports.pass("User Successfully navigated on Reversal Screen");
			Log.info("User Successfully navigated on Reversal Screen");
			
			//Calling function to Verify Time out functionality
			NotificationScreen.validateScreenTimeOut();				
				
		}catch(Exception e){
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
			
		}
		
	
	}

}
