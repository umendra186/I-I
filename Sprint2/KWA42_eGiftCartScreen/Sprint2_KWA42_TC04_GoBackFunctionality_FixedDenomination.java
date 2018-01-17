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
* Class : KWA42_TC04_GoBackFunctionality_FixedDenomination - Verify the Go Back button functionality on cart screen with fixed Denomination flow
* Author : Umendra Singh Tomar
* (C) Xavient Information System 2017
* 
*/
public class Sprint2_KWA42_TC04_GoBackFunctionality_FixedDenomination extends GenericClass {
	
	public static boolean flag;
	public static String imagePath;

	
	@Test
	public void GoBackFunctionality_FixedDenomination(){
		
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
			assertTrue(Utility.urlVerification("/card-send/search/category/0"));
			Reports.pass("User Successfully navigated on Search Screen");			

			//click on "Add Fix amount card" button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.fixAmountCard));
			Reports.pass("User successfully clicked on \'add fix amount card\' Mock button");
			Log.info("User successfully clicked on \'add fix amount card\' Mock button");
			
			//Calling function to add fixed/variable card
			Utility.clickOnFixedRangePage();		
				
			//Validating Go Back Functionality
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.goBackButtonCC));
			Reports.pass("User successfully clicked on Go Back button");
			Log.info("User successfully clicked on Go Back button");			
			assertTrue(Utility.urlVerification("card-send/fix-denomination"));
			Reports.pass("User Successfully navigated back to fix-denomination Screen");		
			
							
		}catch(Exception e){
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
			
		}
		
	}

}
