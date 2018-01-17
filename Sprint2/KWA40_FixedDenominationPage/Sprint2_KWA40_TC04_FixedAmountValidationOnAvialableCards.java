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
 * Class : KWA40_TC04_FixedAmountValidationOnAvialableCards - Verify fixed amount values of the selected card are visible on the denomination page.
*  Author : Kishan Singh Chilwal
*  (C) Xavient Information System 2017
* 
*/

public class Sprint2_KWA40_TC04_FixedAmountValidationOnAvialableCards extends GenericClass{
	
	public static boolean flag;
	public static String imagePath;

	
	@Test
	public void fixedAmountValidationOnAvialableCards()
	{
		try{
			Assert.assertTrue(Login.launchURl(KioskConfigMapper.URL),"Unable to navigate to URL");
			Reports.pass("User Successfully launched Home screen");
			Log.info("User Successfully launched Home screen");
			
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
