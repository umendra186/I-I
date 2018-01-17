package KWA46_DebitCardScreen;

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

/* Class : KWA46_TC04_FixedAmountCard_TodayTotalOnDebitScreen- Verify the Today Total On Debit Card Screen
*  * Author : Sayed Zeeshan Haidar
* (C) Xavient Information System 2017
* 
*/


public class Sprint3_KWA46_TC04_FixedAmountCard_TodayTotalOnDebitScreen extends GenericClass {
	
	public static boolean flag;
	public static String imagePath;
	Screen sc;
	
	@Test
	public void TodayTotalOnDebitScreen(){
		
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
			
			//Calling function to know added card details
			int todayTotalMorphScreen=Utility.todaysTotal(Utility.getLocator(KioskLocatorsMapper.todaystotal));
			Reports.info("Todays Total on Cart screen is as ---->" +todayTotalMorphScreen );
			
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
			
			//Validating Today's Total on Tender Screen
			int todayTotalDebitScreen= Utility.todaysTotal(Utility.getLocator(KioskLocatorsMapper.todaysTotalCC));
			Reports.info("Todays Total on Debit Card screen is as ---->" +todayTotalDebitScreen );
			
			if(todayTotalMorphScreen==todayTotalDebitScreen){
				Reports.pass("Todays Total is same on both screen as ------>" +todayTotalDebitScreen);
				Log.info("Todays Total is same on both screen");
			}else{
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("Execption Occured", imagePath);
				Reports.fail("Todays total is not same on both screen");
			}	

					
		}catch(Exception e){
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
			
		}
		
	}

}
