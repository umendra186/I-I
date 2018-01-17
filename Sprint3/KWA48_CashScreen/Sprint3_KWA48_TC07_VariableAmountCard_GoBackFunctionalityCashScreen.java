package KWA48_CashScreen;

import static org.testng.Assert.assertTrue;


import org.testng.Assert;
import org.testng.annotations.Test;
import com.kiosk.constant.KioskConfigMapper;
import com.kiosk.constant.KioskLocatorsMapper;
import com.kiosk.modules.Login;
import com.kiosk.modules.GenericClass;
import com.kiosk.reports.Log;
import com.kiosk.reports.Reports;
import com.kiosk.utility.Utility;

/* Class : KWA48_TC07_VariableAmountCard_GoBackFunctionalityCashScreen- Verify the GO BACk functionality for Cash Screen
*  * Author : Sayed Zeeshan Haidar
* (C) Xavient Information System 2017
* 
*/


public class Sprint3_KWA48_TC07_VariableAmountCard_GoBackFunctionalityCashScreen extends GenericClass {
	
	public static boolean flag;
	public static String imagePath;

	@Test
	public void VariableAmountCard_GoBackFunctionalityCashScreen(){
		
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
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.variableAmountCard));
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
			
			//Click on Cash Button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.cashButton));
			Reports.pass("User Successfully Clicked on Cash Button");
			Log.info("User Successfully Clicked on Cash Button");
			Utility.urlVerification("/cash-payment");
			Reports.pass("User successfully navigated on Cash Screen");
			Log.info("User successfully navigated on Cash Screen");	
			
			//Validating Go Back Functionality
			int expectedtodaysTotal = Utility.todaysTotal(Utility.getLocator(KioskLocatorsMapper.todaysTotalCC));
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.goBackButtonCC));
			Reports.pass("User successfully clicked on Go Back button");
			Log.info("User successfully clicked on Go Back button");
			Utility.goBackButton(expectedtodaysTotal, Utility.getLocator(KioskLocatorsMapper.todaysTotalTender), "card-payment");			
					
		}catch(Exception e){
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
			
		}
		
	}

	

}
