package KWA49_Personalization;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kiosk.constant.KioskConfigMapper;
import com.kiosk.constant.KioskLocatorsMapper;
import com.kiosk.modules.GenericClass;
import com.kiosk.modules.Login;
import com.kiosk.modules.PaymentScreen;
import com.kiosk.reports.Log;
import com.kiosk.reports.Reports;
import com.kiosk.utility.Utility;

/* Class : Sprint3_KWA49_TC01_NaviagationValidationOfPersonalizationScreen -- Verify the navigation to the personalization screen after successful payment
*  * Author : Umendra Singh Tomar
* (C) Xavient Information System 2017
* 
*/
public class Sprint3_KWA49_TC02_NaviagationValidationOfPersonalizationScreen extends GenericClass {
	
	public static boolean flag;
	public static String imagePath;
	
	
	@Test
	public void navigationValidation(){
		
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
			
			//Click on Buy Button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.buyButton));
			Reports.pass("User Successfully Clicked on Buy Button");
			Log.info("User Successfully Clicked on Buy Button");
			Utility.urlVerification("/card-payment");
			Reports.pass("User successfully naviaged on Tender Screen");
			Log.info("User successfully naviaged on Tender Screen");

			
			//Click on Credit Card Button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.creditCardButton));
			Reports.pass("User successfully clicked on Credit Card button");
			Log.info("User successfully clicked on Credit Card button");
			assertTrue(Utility.urlVerification("card-send/credit-card"));
			Reports.pass("User Successfully navigated on Credit Card Screen");
			
			//Validate the Navigation of Personalization Screen
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.mockButtonToMoveOnPersonalizationPage));
			Reports.pass("User successfully clicked on Mock Button to Move on Personalization Page");
			Log.info("User successfully clicked on Mock Button to Move on Personalization Page");
			assertTrue(Utility.urlVerification("/card-personalization/address"));
			Reports.pass("User Successfully navigated on Personalization Page");
								
					
		}catch(Exception e){
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
			
		}
	}

}
