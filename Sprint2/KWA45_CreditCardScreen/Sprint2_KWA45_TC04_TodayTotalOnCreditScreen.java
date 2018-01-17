package KWA45_CreditCardScreen;

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

/** Class : KWA17_TC02_TodayTotalOnCreditScreen- Verify the Today Total On Credit Card Screen
 * Author : Kishan Singh Chilwal
 * (C) Xavient Information System 2017
 * 
 */

public class Sprint2_KWA45_TC04_TodayTotalOnCreditScreen extends GenericClass {

	public static boolean flag;
	public static String imagePath;
	Screen sc;

	@Test
	public void todayTotalOnCreditScreen(){

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
			assertTrue(Utility.urlVerification("/card-send/search/category/0"));
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
			Reports.pass("User successfully naviaged on Tender Screen");
			Log.info("User successfully naviaged on Tender Screen");

			//Click on Credit Card Button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.creditCardButton));
			Reports.pass("User Successfully Clicked on Credit Card Button");
			Log.info("User Successfully Clicked on Credit Card Button");
			Utility.urlVerification("/credit-card");
			Reports.pass("User successfully naviaged on Credit card Screen");
			Log.info("User successfully naviaged on  Credit card Screen");

			//Validating Today's Total on Tender Screen
			int todayTotalCreditScreen= Utility.todaysTotal(Utility.getLocator(KioskLocatorsMapper.todaysTotalCC));
			Reports.info("Todays Total on Credit Card screen is as ---->" +todayTotalCreditScreen );

			if(todayTotalMorphScreen==todayTotalCreditScreen){
				Reports.pass("Todays Total is same on both screen as ------>" +todayTotalCreditScreen);
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
