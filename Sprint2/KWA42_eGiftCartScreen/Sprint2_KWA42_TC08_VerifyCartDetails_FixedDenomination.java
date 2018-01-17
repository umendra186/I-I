package KWA42_eGiftCartScreen;

import static org.testng.Assert.assertTrue;

import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
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
* Class : KWA42_TC08_VerifyCartDetails_FixedDenomination - 	Verify Cart Registry shows correct amount and quantity displayed
* Author: Umendra Singh Tomar
* (C) Xavient Information System 2017
* 
*/
public class Sprint2_KWA42_TC08_VerifyCartDetails_FixedDenomination extends GenericClass {
	
	public static boolean flag;
	public static String imagePath;
	int size,AmountFixdenomination,todaysTotalCartScreen;
	int f=0;
	
	@Test
	public void verifyCartDetails_FixedDenomination(){
		
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

			//click on "Add Fixed amount card" button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.fixAmountCard));
			Reports.pass("User successfully clicked on \'add Fixed amount card\' Mock button");
			Log.info("User successfully clicked on \'add Fixed amount card\' Mock button");
			assertTrue(Utility.urlVerification("card-send/fix-denomination"));
			Reports.pass("User Successfully navigated on fix-denomination Screen");	
						
			int size= Utility.getsize(KioskLocatorsMapper.fixedDenCount);
			Log.info("Total number of Fixed Denomination are : " + size);
					
			//Calling function to add fixed denomination to cart and get the Amount of Clicked Fixed denomination
			int AmountFixdenomination = Utility.addFixedAmountCard(size);
			
			//Calling function to get Today's Total of Cart Screen
			int todaysTotalCartScreen = Utility.todaysTotal(Utility.getLocator(KioskLocatorsMapper.todaystotal)); 
			
			//Validation Amount of Fixed denomination and Cart screen
			if(AmountFixdenomination==todaysTotalCartScreen){
				Reports.pass("Todays Total is same on both screen as ------>" +AmountFixdenomination);
				Log.info("Todays Total is same on both screen");
			}else{
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("Execption Occured", imagePath);
				Reports.fail("Todays total is not same on both screen");
			}
			
			//Calling function to verify cart details of Added Card
			Utility.addedCardInfo();
			
					
		}catch(Exception e){
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
			
		}
		
	}

}
