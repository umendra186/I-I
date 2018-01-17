package KWA42_eGiftCartScreen;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
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


/* 
* Class : KWA42_TC09_VerifyUserAddOnlyOneCardToCart_FixedDenomination - Verify cart should have only card at a time
* Author : Sayed Zeeshan Haidar
* (C) Xavient Information System 2017
* 
*/
public class KWA42_TC09_VerifyUserAddOnlyOneCardToCart_FixedDenomination extends GenericClass {
	
	public static boolean flag;
	public static String imagePath;
	int size,AmountFixdenomination,todaysTotalCartScreen;
	
	@Test
	public void VerifyUserAddOnlyOneCardToCart_FixedDenomination(){
		
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

			//click on "Add Fixed amount card" button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.fixAmountCard));
			Reports.pass("User successfully clicked on \'add Fixed amount card\' Mock button");
			Log.info("User successfully clicked on \'add Fixed amount card\' Mock button");
			assertTrue(Utility.urlVerification("card-send/fix-denomination"));
			Reports.pass("User Successfully navigated on fix-denomination Screen");	
						
			size= Utility.getsize(KioskLocatorsMapper.fixedDenCount);
			Log.info("Total number of Fixed Denomination are : " + size);
					
			AmountFixdenomination = Utility.addFixedAmountCard(size);
			
			//Validating Today's Total on Cart Screen
			todaysTotalCartScreen = Utility.todaysTotal(Utility.getLocator(KioskLocatorsMapper.todaystotal)); 
			
			if(AmountFixdenomination==todaysTotalCartScreen){
				Reports.pass("Todays Total is same on both screen as ------>" +AmountFixdenomination);
				Log.info("Todays Total is same on both screen");
			}else{
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("Execption Occured", imagePath);
				Reports.fail("Todays total is not same on both screen");
			}
			
			//Calling function to verify cart details of Added Card
			Utility.addedCardInfo();
			
			
			//Navigating  Back to fix-denomination Page
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.goBackButtonCC));
			Reports.pass("User successfully clicked on Go Back button");
			Log.info("User successfully clicked on Go Back button");			
			assertTrue(Utility.urlVerification("card-send/fix-denomination"));
			Reports.pass("User Successfully navigated back to fix-denomination Screen");		
			
			//Navigating  Back to Search Page Page
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.goBackButtonCC));
			Reports.pass("User successfully clicked on Go Back button");
			Log.info("User successfully clicked on Go Back button");			
			assertTrue(Utility.urlVerification("card-send/search"));
			Reports.pass("User Successfully navigated back to search Screen");	
			
			//click on "Add Fixed amount card" button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.fixAmountCard));
			Reports.pass("User successfully clicked on \'add Fixed amount card\' Mock button");
			Log.info("User successfully clicked on \'add Fixed amount card\' Mock button");
			assertTrue(Utility.urlVerification("card-send/fix-denomination"));
			Reports.pass("User Successfully navigated on fix-denomination Screen");	
						
			size= Utility.getsize(KioskLocatorsMapper.fixedDenCount);
			Log.info("Total number of Fixed Amount are : " + size);
			
			AmountFixdenomination = Utility.addFixedAmountCard(size);
			
			Thread.sleep(2000);
			//Validating Today's Total on Cart Screen
			todaysTotalCartScreen = Utility.todaysTotal(Utility.getLocator(KioskLocatorsMapper.todaystotal)); 
			
			if(AmountFixdenomination==todaysTotalCartScreen){
				Reports.pass("Todays Total is same with chosen Fixed denomination as ------>" +AmountFixdenomination);
				Log.info("Todays Total is same with chosen Fixed denomination chosen");
			}else{
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("Execption Occured", imagePath);
				Reports.fail("Todays total is not same on both screen");
			}
			
			//Calling function to verify cart details of Added Card
			Utility.addedCardInfo();
			
			//Validating count of card should be 1
			size = Utility.getsize(KioskLocatorsMapper.cardFigure);
			if(size==1)
			{
				Reports.pass("Total count of card on cart screen is as Expected i.e. " + size);
				Log.info("Total count of card on cart screen is as Expected i.e. " + size);
			}
			else
			{
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("Execption Occured", imagePath);
				Reports.fail("Count of added card on Cart screen is more than 1 ");
			}
					
		}catch(Exception e){
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
			
		}
		
	}

	
}
