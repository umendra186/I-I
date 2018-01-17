package KWA25_DenominationPage;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.Test;

import bsh.util.Util;

import com.kiosk.constant.KioskConfigMapper;
import com.kiosk.constant.KioskLocatorsMapper;
import com.kiosk.modules.GenericClass;
import com.kiosk.modules.Login;
import com.kiosk.reports.Log;
import com.kiosk.reports.Reports;
import com.kiosk.utility.Utility;

/* Class : KWA25_TC05_MinValueValidationOnDenominationPage-Verify that app highlights the mix/max label for value below the min range.
*  * Author : Sayed Zeeshan Haidar
* (C) Xavient Information System 2017
* 
*/
public class KWA25_TC05_MinValueValidationOnDenominationPage extends GenericClass{
	
	public static boolean flag;
	public static String imagePath;
	
	@Test
	public void minValueValidationOnDenominationPage(){
		
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
			int GeneratedMaxValue = Utility.generateRandomNumberlessThenMinValue(MaxMinValue);
			Utility.keypad(GeneratedMaxValue);
			
			//Click on Next Button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.nextButton));
			Reports.pass("User Successfully Clicked on Next Button");
			Utility.errorMessageHanlderOnVariableRangeCard();			
				
			
		}catch(Exception e){
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
			
		}
		
	}
	
	

}
