package KWA25_DenominationPage;

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

/* Class : KWA25_TC08_NextButtonFunctionalityOnDenominationPage-Verify the functionality of next button on the range page.
*  * Author : Sayed Zeeshan Haidar
* (C) Xavient Information System 2017
* 
*/
public class KWA25_TC08_NextButtonFunctionalityOnDenominationPage extends GenericClass{
	
	public static boolean flag;
	public static String imagePath;
	
	@Test
	public void nextButtonFunctionalityOnDenominationPage(){
		
		try{
			Assert.assertTrue(Login.launchURl(KioskConfigMapper.URL),"Unable to navigate to URL");
			Reports.pass("User Successfully LaunchedURL");
			Log.info("User Successfully LaunchedURL");
			
			// Click on send a card
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.sendACard));
			Reports.pass("User successfully clicked on SEND A CARD button");
			Log.info("User successfully clicked on SEND A CARD button");			
			assertTrue(Utility.urlVerification("/card-send"));
			Reports.pass("User Successfully navigated on 'Send Type Selection'  Screen");
			
			//click on Email
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.emailEGiftPickUp));
			Reports.pass("User successfully clicked on EMAI button");
			Log.info("User successfully clicked on EMAI button");			
			assertTrue(Utility.urlVerification("/card-send/search"));
			Reports.pass("User Successfully navigated on 'Search'  Screen");	
			
			//click on "Add Denomination amount card" button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.variableAmountCard));
			Reports.pass("User successfully clicked on \'add variable amount card\' Mock button");
			Log.info("User successfully clicked on \'add variable amount card\' Mock button");
			
			//Max value Validation
			int[] MaxMinValue= Utility.infoMinMax();		
			int GeneratedMaxValue = Utility.gengrateRandomValidNumber(MaxMinValue);
			Utility.keypad(GeneratedMaxValue);
			
			//Click On Next Button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.nextButton));
			Reports.pass("User successfully clicked on Next button");
			
			//Next Button Validation
			if(Utility.currentURL().endsWith("/card-send/cart")){
				Reports.pass("User Successfully navigated on 'E-Gift Cart' Screen after click on Next Button" );
			}else{
				Reports.fail("User unable to redirected on 'E-Gift Cart' Screen after click on Next Button");
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("", imagePath);
			}		
			
		}catch(Exception e){
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
			
		}
		
	}
	
	

}
