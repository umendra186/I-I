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

/* Class : KWA43_TC04_CancelButtonFunctionality_VariableDenomination- Verify the cancel button functionality with Variable denomination flow
 *  * Author : Umendra Singh Tomar
 * (C) Xavient Information System 2017
 * 
 */

public class Sprint2_KWA43_TC04_CancelButtonFunctionality_VariableDenomination extends GenericClass {
	
	public static boolean flag;
	public static String imagePath;

	
	@Test
	public void cancelButtonFunctionality(){
		
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
			assertTrue(Utility.urlVerification("/card-send/search/category/0"));
			Reports.pass("User Successfully navigated on Search Screen");
			
			//click on "add variable amount card" button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.variableAmountCard));
			Reports.pass("User successfully clicked on \'add Variable amount card\' Mock button");
			Log.info("User successfully clicked on \'add Variable amount card\' Mock button");
			
			//Calling function to add fixed/variable card
			Utility.clickOnFixedRangePage();
		
			//Check Cancel Button Functionality
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.cancelButton));
			if(Utility.urlVerification("/home")){
				Reports.pass("As Expected,User is navigated on Home screen after click on cancel button ");
			}else{
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("Execption Occured", imagePath);
				Reports.fail("User Unable to navigated on home screen");
				
			}			

		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot(e.getMessage(), imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());}
	}
	

}
