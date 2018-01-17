package KWA15_TenderScreen;

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
 * Class : KWA15_TC01_TenderScreenUI-Verify content of Tender Screen
 * Author : Umendra Singh Tomar
 * (C) Xavient Information System 2017
 * 
 */


public class Sprint1_KWA15_TC01_TenderScreenUI extends GenericClass {
	
	public static boolean flag;
	public static String imagePath;

	@Test
	public void tenderScreenUI(){
		
		try{
			Assert.assertTrue(Login.launchURl(KioskConfigMapper.URL),"Unable to navigate to URL");
			Reports.pass("User Successfully LaunchedURL");
			Log.info("User Successfully LaunchedURL");
			
			// Validating the content of Buy Content Screen
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.buyCard));
			Reports.pass("User successfully clicked on BUY A CARD button");
			Log.info("User successfully clicked on BUY A CARD button");			
			assertTrue(Utility.urlVerification("card-buy"));
			Reports.pass("User Successfully navigated on Seach/Scran Screen");
			
			//Click on Scan button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.scanCardButton));
			Reports.pass("User successfully clicked on SCAN button");
			Log.info("User successfully clicked on SCAN button");
			assertTrue(Utility.urlVerification("/card-buy/scan"));
			Reports.pass("User Successfully navigated on  Instruction prompt screen");
			
			
			//Calling function to add some card
			Utility.addCards();
			
			//Click on Buy Button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.buyButton));
			Reports.pass("User Successfully Clicked on Buy Button");
			Log.info("User Successfully Clicked on Buy Button");
			Utility.urlVerification("/card-payment");
			Reports.pass("User successfully naviaged on Tender Screen");
			Log.info("User successfully naviaged on Tender Screen");
			
			//Validating the content of Tender Screen
			Utility.getLocator(KioskLocatorsMapper.creditCardText).isDisplayed();
			Reports.pass("CREDIT CARD Div Text is visible as expected");
			Log.info("CREDIT CARD Div Text is visible as expected");
			
			
			Utility.getLocator(KioskLocatorsMapper.debitCardText).isDisplayed();
			Reports.pass("DEBIT CARD Div Text is visible as expected");
			Log.info("DEBIT CARD Div Text is visible as expected");
			
			Utility.getLocator(KioskLocatorsMapper.cashText).isDisplayed();
			Reports.pass("CASH Div Text is visible as expected");
			Log.info("CASH CARD Div Text is visible as expected");
			
			Utility.getLocator(KioskLocatorsMapper.mobileWalletText).isDisplayed();
			Reports.pass("MOBILE WALLET Div Text is visible as expected");
			Log.info("MOBILE WALLET Div Text is visible as expected");
			
			//Validating Go Back  and today todays
			Utility.getLocator(KioskLocatorsMapper.todaysTotalTender).isDisplayed();
			Reports.pass("As Expected, Today's Toatal is displayed");
			Log.info("As Expected, Today's Toatal is displayed");
			
			Utility.getLocator(KioskLocatorsMapper.goBackButtonTender).isDisplayed();
			Reports.pass("Go Back Button is displayed as expected");
			Log.info("Go Back Button is displayed as expected");
					
		}catch(Exception e){
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
			
		}
		
	}

	
}
