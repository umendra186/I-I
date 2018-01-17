package KWA18_MobileWalletScreen;

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

/* Class : KWA18_TC02_TodayTotalOnMobileWalletScreen- Verify the Today Total On Mobile Wallet Screen
*  * Author : Umendra Singh Tomar
* (C) Xavient Information System 2017
* 
*/

public class KWA18_TC02_TodayTotalOnMobileWalletScreen extends GenericClass {
	
	public static boolean flag;
	public static String imagePath;
	Screen sc;
	
	@Test
	public void todayTotalOnMobileWalletScreen(){
		
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
			
			//Calling function to know added card details
			int todayTotalMorphScreen=Utility.todaysTotal(Utility.getLocator(KioskLocatorsMapper.todaystotal));
			Reports.info("Todays Total on Morph screen is as ---->" +todayTotalMorphScreen );
			
			//Click on Buy Button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.buyButton));
			Reports.pass("User Successfully Clicked on Buy Button");
			Log.info("User Successfully Clicked on Buy Button");
			Utility.urlVerification("/card-payment");
			Reports.pass("User successfully naviaged on Tender Screen");
			Log.info("User successfully naviaged on Tender Screen");
			
			//Click on Mobile Wallet Card Button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.mobileWalletCardButton));
			Reports.pass("User Successfully Clicked on Mobile Wallet Button");
			Log.info("User Successfully Clicked on Mobile Wallet Button");
			Utility.urlVerification("/mobile-wallet");
			Reports.pass("User successfully naviaged on Mobile Wallet Screen");
			Log.info("User successfully naviaged on  Mobile Wallet Screen");
			
			//Validating Today's Total on Tender Screen
			int todayTotalMobileWalletScreen= Utility.todaysTotal(Utility.getLocator(KioskLocatorsMapper.todaysTotalCC));
			Reports.info("Todays Total on Mobile Wallet screen is as ---->" +todayTotalMobileWalletScreen);
			
			if(todayTotalMorphScreen==todayTotalMobileWalletScreen){
				Reports.pass("Todays Total is same on both screen as ------>" +todayTotalMobileWalletScreen);
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
