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


/* 
* Class : KWA42_TC10_VerifyUserAddOnlyOneCardToCart_VariableDenomination - 	Verify cart should have only card at a time
* Author : Sayed Zeeshan Haidar
* (C) Xavient Information System 2017
* 
*/
public class KWA42_TC10_VerifyUserAddOnlyOneCardToCart_VariableDenomination extends GenericClass {
	
	public static boolean flag;
	public static String imagePath;
	private static int[] minvalueRetrun;
	private static int minvalue, randdomNUM;
	int todaysTotalRangeScreen, todaysTotalCartScreen,size;
	
	@Test
	public void VerifyUserAddOnlyOneCardToCart_VariableDenomination(){
		
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

			//click on "Add Variable amount card" button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.variableAmountCard));
			Reports.pass("User successfully clicked on \'add Variable amount card\' Mock button");
			Log.info("User successfully clicked on \'add Variable amount card\' Mock button");
			assertTrue(Utility.urlVerification("card-send/variable-amount"));
			Reports.pass("User Successfully navigated on variable-amount Screen");	
			
			//Inserting Random Valid Amount for the selected Card
			minvalueRetrun= Utility.infoMinMax();
			randdomNUM = Utility.gengrateRandomValidNumber(minvalueRetrun);
			Utility.keypad(randdomNUM);
			
			//Calling function to get Total Entered Amount in Range screen
			todaysTotalRangeScreen = Utility.todaysTotal(Utility.getLocator(KioskLocatorsMapper.IntailAmountOnRangePage)); 
			
			//click on Next button and Verify Navigation			 
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.nextButton));
			Reports.pass("User successfully clicked on Next button");
			Log.info("User successfully clicked on Next Mock button");
			assertTrue(Utility.urlVerification("card-send/cart"));
			Reports.pass("User Successfully navigated on Cart Screen");	
			
			//Validating Today's Total on Cart Screen
			int todaysTotalCartScreen = Utility.todaysTotal(Utility.getLocator(KioskLocatorsMapper.todaystotal)); 
			
			if(todaysTotalRangeScreen==todaysTotalCartScreen){
				Reports.pass("Todays Total is same on both screen as ------>" +todaysTotalRangeScreen);
				Log.info("Todays Total is same on both screen");
			}else{
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("Execption Occured", imagePath);
				Reports.fail("Todays total is not same on both screen");
			}
			
			//Calling function to verify cart details of Added Card
			Utility.addedCardInfo();
			

			//Navigating  Back to Range Page
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.goBackButtonCC));
			Reports.pass("User successfully clicked on Go Back button");
			Log.info("User successfully clicked on Go Back button");			
			assertTrue(Utility.urlVerification("card-send/variable-amount"));
			Reports.pass("User Successfully navigated back to variable-amount Screen");		
			
			//Navigating  Back to Search Page Page
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.goBackButtonCC));
			Reports.pass("User successfully clicked on Go Back button");
			Log.info("User successfully clicked on Go Back button");			
			assertTrue(Utility.urlVerification("card-send/search"));
			Reports.pass("User Successfully navigated back to search Screen");	
			
			//click on "Add Variable amount card" button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.variableAmountCard));
			Reports.pass("User successfully clicked on \'add Variable amount card\' Mock button");
			Log.info("User successfully clicked on \'add Variable amount card\' Mock button");
			assertTrue(Utility.urlVerification("card-send/variable-amount"));
			Reports.pass("User Successfully navigated on variable-amount Screen");	
			
			//Inserting Random Valid Amount for the selected Card
			minvalueRetrun= Utility.infoMinMax();
			randdomNUM = Utility.gengrateRandomValidNumber(minvalueRetrun);
			Utility.keypad(randdomNUM);
			
			//Calling function to get Total Entered Amount in Range screen
			todaysTotalRangeScreen = Utility.todaysTotal(Utility.getLocator(KioskLocatorsMapper.IntailAmountOnRangePage)); 
			
			//click on Next button and Verify Navigation			 
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.nextButton));
			Reports.pass("User successfully clicked on Next button");
			Log.info("User successfully clicked on Next Mock button");
			assertTrue(Utility.urlVerification("card-send/cart"));
			Reports.pass("User Successfully navigated on Cart Screen");	
			
			//Validating Today's Total on Cart Screen
			todaysTotalCartScreen = Utility.todaysTotal(Utility.getLocator(KioskLocatorsMapper.todaystotal)); 
			
			if(todaysTotalRangeScreen==todaysTotalCartScreen){
				Reports.pass("Todays Total is same on both screen as ------>" +todaysTotalRangeScreen);
				Log.info("Todays Total is same on both screen");
			}else{
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("Execption Occured", imagePath);
				Reports.fail("Todays total is not same on both screen");
			}
			
			//Calling function to verify cart details of Added Card
			Utility.addedCardInfo();
				
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
