package KWA40_FixedDenominationPage;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.kiosk.constant.KioskConfigMapper;
import com.kiosk.constant.KioskLocatorsMapper;
import com.kiosk.modules.GenericClass;
import com.kiosk.modules.Login;
import com.kiosk.reports.Log;
import com.kiosk.reports.Reports;
import com.kiosk.utility.Utility;


/**
 * Class : KWA40_TC01_FixedDenominationPageUI - Verify content of Fixed Denomination Page of the KIOSK app
*  Author : Kishan Singh Chilwal
*  (C) Xavient Information System 2017
* 
*/

public class Sprint2_KWA40_TC01_FixedDenominationPageUI extends GenericClass{
	
	public static boolean flag;
	public static String imagePath;

	
	@Test
	public void eGiftPickupScreenUI()
	{
		try{
			Assert.assertTrue(Login.launchURl(KioskConfigMapper.URL),"Unable to navigate to URL");
			Reports.pass("User Successfully LaunchedURL");
			Log.info("User Successfully LaunchedURL");
			
			// Validating Navigation to eGiftPickup Screen
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
			
			//	Validating Send a card - eGift Page images			
			Utility.validateInvalidImages();
			
			// Validating EMAIL button on eGiftPickup Screen			
			Utility.getLocator(KioskLocatorsMapper.goBackButtonCC).isDisplayed();
			Reports.info("GO Back button is displayed as expected");	
	
			//Available Card Details 
			WebElement denominationContainer=Utility.getLocator(KioskLocatorsMapper.fixedCards);
			List<WebElement> denominatiaon= denominationContainer.findElements(By.tagName("span"));
			Reports.info("Total Available Cards of 'Fix-Denomination' are -----------> " + denominatiaon.size());
			 for(int i=0;i<denominatiaon.size();i++){
				Reports.pass(+i+1 +" - Card Denomination is ----->" +denominatiaon.get(i).getText());
			 }
			 
			
						
		}catch(Exception e){
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
			
		}
	}

}
