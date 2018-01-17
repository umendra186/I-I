package KWA44_TenderScreen;

import static org.testng.Assert.assertTrue;

import java.util.Properties;

import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

import com.google.common.base.Verify;
import com.kiosk.constant.Constant;
import com.kiosk.constant.KioskConfigMapper;
import com.kiosk.constant.KioskLocatorsMapper;
import com.kiosk.modules.Login;
import com.kiosk.modules.GenericClass;
import com.kiosk.reports.Log;
import com.kiosk.reports.Reports;
import com.kiosk.utility.Utility;

/**
 * Class : KWA44_TC01_TenderScreenUI-Verify content of Tender Screen
 * Author : Umendra Singh Tomar
 * (C) Xavient Information System 2017
 * 
 */


public class KWA44_TC01_TenderScreenUI extends GenericClass {
	
	public static boolean flag;
	public static String imagePath;
	Screen sc;
	
	
	@Test
	public void tenderScreenUI(){
		
		try{
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
			
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.email));
			Reports.pass("User successfully clicked on EMAIL button");
			Log.info("User successfully clicked on EMAIL button");
			assertTrue(Utility.urlVerification("card-send/search"));
			Reports.pass("User Successfully navigated on Search Screen");
			
			
			//click on "Add Fix amount card" button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.fixAmountCard));
			Reports.pass("User successfully clicked on \'add fix amount card\' Mock button");
			Log.info("User successfully clicked on \'add fix amount card\' Mock button");
			
			//Calling function to add fixed/variable card
			Utility.clickOnFixedRangePage();							
			
			//Click on Buy Button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.buyButton));
			Reports.pass("User Successfully Clicked on Buy Button");
			Log.info("User Successfully Clicked on Buy Button");
			Utility.urlVerification("/card-payment");
			Reports.pass("User successfully naviaged on Tender Screen");
			Log.info("User successfully naviaged on Tender Screen");
			
			//Validating the content of Tender Screen
			
			//Validating Static SEND A CARD - EGIFT image
			Utility.validateInvalidImages();
			
			//Validating Go Back button on UI
					
			Utility.getLocator(KioskLocatorsMapper.goBackButtonTender).isDisplayed();
			Reports.pass("Go Back Button is displayed as expected");
			Log.info("Go Back Button is displayed as expected");
			
			//Validating Payment Option on UI
			Utility.getLocator(KioskLocatorsMapper.creditCardButton).isDisplayed();
			Reports.pass("Credit Card Button is displayed as expected");
			Log.info("Credit Card Button is displayed as expected");
			
			Utility.getLocator(KioskLocatorsMapper.debitCardButton).isDisplayed();
			Reports.pass("Debit Card Button is displayed as expected");
			Log.info("Debit Card Button is displayed as expected");
			
			Utility.getLocator(KioskLocatorsMapper.mobileWalletCardButton).isDisplayed();
			Reports.pass("Mobile Wallet Button is displayed as expected");
			Log.info("Mobile Wallet Button is displayed as expected");
			
			Utility.getLocator(KioskLocatorsMapper.cashButton).isDisplayed();
			Reports.pass("Cash Button is displayed as expected");
			Log.info("Cash Button is displayed as expected");
			
			//Validating 'Please Select a Method of Payment' Text on UI
			
			Utility.getLocator(KioskLocatorsMapper.tenderLabel).isDisplayed();
			Reports.pass("Tender Sreen Heading is displayed as expected");
			Log.info("Tender Sreen Heading is displayed as expected");
			
			//Validating 'Today's Total is $' Text on UI
			String todayTotalText=Utility.getLocator(KioskLocatorsMapper.todaysTotalText).getText();
			todayTotalText=todayTotalText.substring(0, todayTotalText.indexOf('$')+1);
			if(todayTotalText.equalsIgnoreCase("Today's Total is $"))
			{
				Reports.pass("\"Today's Total is $\" text is displayed as expected");
				Log.info("\"Today's Total is $\" text is displayed as expected");
			}
			else
			{
				Reports.fail("\"Today's Total is $\" text is not displayed as expected");
				Log.fail("\"Today's Total is $\" text is not displayed as expected");
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("Execption Occured", imagePath);
			}
				
					
		}catch(Exception e){
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
			
		}
		
	}

	
}
