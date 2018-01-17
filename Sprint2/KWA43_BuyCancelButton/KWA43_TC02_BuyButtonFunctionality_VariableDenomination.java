package KWA43_BuyCancelButton;

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


/* Class : KWA43_TC02_BuyButtonFunctionality_VariableDenomination- Verify the buy button functionality with Variable denomination flow
*  Author : Umendra Singh Tomar
* (C) Xavient Information System 2017
* 
*/
public class KWA43_TC02_BuyButtonFunctionality_VariableDenomination extends GenericClass{
	
	public static boolean flag;
	public static String imagePath;
	
	
	@Test
	public void buyButtonfunctionality(){
		
		try {
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
			
			//click on "add variable amount card" button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.variableAmountCard));
			Reports.pass("User successfully clicked on \'add Variable amount card\' Mock button");
			Log.info("User successfully clicked on \'add Variable amount card\' Mock button");
			
			//Calling function to add fixed/variable card
			Utility.clickOnFixedRangePage();
						
			//Calling function to get Total Amount of Added card 
			int todaysTotal=Utility.addedCardInfo();
			
			//Click on Buy Button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.buyButton));
			Reports.pass("User successfully clicked on buy button");
			Log.info("User successfully clicked on buy button");
			Utility.urlVerification("card-payment");
			Reports.pass("User successfully navigated on tender screen as expected");
			String[]  todaysTotalTenderScree=Utility.getLocator(KioskLocatorsMapper.todaysTotalTender).getText().split("\\$");
			Reports.pass("Tender screen todays total is -----> "  +Integer.parseInt(todaysTotalTenderScree[1]));
			Assert.assertEquals(Integer.parseInt(todaysTotalTenderScree[1]), todaysTotal);
			Reports.pass("Today's total amount are same for both tender and Cart Screen  as ------->" +Integer.parseInt(todaysTotalTenderScree[1]));					

		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());}
	}
	

}
