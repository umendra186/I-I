package KWA17_DebitCardScreen;

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

/* Class : KWA17_TC03_GoBackFunctionalityDebitCard- Verify the GO BACk functionality for Debit Card Screen
*  * Author : Kishan Singh Chilwal
* (C) Xavient Information System 2017
* 
*/

public class KWA17_TC03_GoBackFunctionalityDebitCard extends GenericClass {
	
	public static boolean flag;
	public static String imagePath;
	Screen sc;
	
	@Test
	public void goBackFunctionalityDebitCard(){
		
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
			
			//Click on Debit Card Button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.debitCardButton));
			Reports.pass("User Successfully Clicked on Debit Card Button");
			Log.info("User Successfully Clicked on Debit Card Button");
			Utility.urlVerification("/debit-card");
			Reports.pass("User successfully naviaged on Debit card Screen");
			Log.info("User successfully naviaged on  Debit card Screen");
			
			//Validating Go Back Functionality
			int expectedtodaysTotal = Utility.todaysTotal(Utility.getLocator(KioskLocatorsMapper.todaysTotalCC));
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.goBackButtonCC));
			Utility.goBackButton(expectedtodaysTotal, Utility.getLocator(KioskLocatorsMapper.todaysTotalTender), "card-payment");			
					
		}catch(Exception e){
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
			
		}
		
	}

	

}
