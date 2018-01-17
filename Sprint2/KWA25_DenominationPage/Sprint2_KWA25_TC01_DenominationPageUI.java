package KWA25_DenominationPage;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.interactions.touch.TouchActions;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.kiosk.constant.KioskConfigMapper;
import com.kiosk.constant.KioskLocatorsMapper;
import com.kiosk.modules.Login;
import com.kiosk.modules.GenericClass;
import com.kiosk.modules.PaymentScreen;
import com.kiosk.reports.Log;
import com.kiosk.reports.Reports;
import com.kiosk.utility.Utility;

/* Class : KWA25_TC01_DenominationPageUI -- Verify content of Range page of the KIOSK app
*  * Author : Umendra Singh Tomar
* (C) Xavient Information System 2017
* 
*/


public class Sprint2_KWA25_TC01_DenominationPageUI extends GenericClass {
	
	public static boolean flag;
	public static String imagePath;
	
	
	@Test
	public void denominationPageUI(){
		
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
			assertTrue(Utility.urlVerification("card-send/search/category/0"));
			Reports.pass("User Successfully navigated on Search Screen");
			
			
			//click on "Add Denomination amount card" button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.variableAmountCard));
			Reports.pass("User successfully clicked on \'add variable amount card\' Mock button");
			Log.info("User successfully clicked on \'add variable amount card\' Mock button");
			
			// Validating  Go Back button on Range Screen			
			Utility.getLocator(KioskLocatorsMapper.goBackButtonCC).isDisplayed();
			Reports.info("Go Back button is displayed as expected");	
			
			// Validating  Next button on Range Screen			
			Utility.getLocator(KioskLocatorsMapper.nextButton).isDisplayed();
			Reports.info("Next button is displayed as expected");
			
			// Validating Next button on Range Screen			
			if(Utility.getLocator(KioskLocatorsMapper.IntailAmountOnRangePage).getText().equals("$0")){
				Reports.info("Intial Value on Range Page is ---->" +Utility.getLocator(KioskLocatorsMapper.IntailAmountOnRangePage).getText());	
			}else{
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("Itial Value on Range Page is not  Zero Doller", imagePath);
			}
			Reports.info("Next button is displayed as expected");
					
			//Validation of Min/Max Value
			int[] IntialMinMaxValue=Utility.infoMinMax();
			Reports.info("Intial Min Value is  --->" +  IntialMinMaxValue[0] +"       Intial Max Value is  --->" +IntialMinMaxValue[1]);
			
			//validate images
			Utility.validateInvalidImages();
			
		}catch(Exception e){
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
			
		}
		
	}


}
