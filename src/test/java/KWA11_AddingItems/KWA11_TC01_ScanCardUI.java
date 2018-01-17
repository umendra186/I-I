package KWA11_AddingItems;

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


/**
 * Class : KWA11_TC01_ScanCardContent-Verify the content of scan card 
 *  * Author : Umendra Singh Tomar
 * (C) Xavient Information System 2017
 * 
 */
public class KWA11_TC01_ScanCardUI extends GenericClass {
	
	public static boolean flag;
	public static String imagePath;
	Screen sc;
	int k=1;
	
	@Test
	public void scanCardUI(){
		
		try {
			Assert.assertTrue(Login.launchURl(KioskConfigMapper.URL),"Unable to navigate to URL");
			Reports.pass("User Successfully LaunchedURL");
			Log.info("User Successfully LaunchedURL");

			//Click on BUY A CARD
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.buyCard));
			Reports.pass("User successfully clicked on BUY A CARD button");
			Log.info("User successfully clicked on BUY A CARD button");			
			assertTrue(Utility.urlVerification("card-buy"));
			
			//Click on Scan button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.scanCardButton));
			Reports.pass("User successfully clicked on SCAN button");
			Log.info("User successfully clicked on SCAN button");
			assertTrue(Utility.urlVerification("/card-buy/scan"));
			Reports.pass("User Successfully navigated on  Instruction prompt screen");
			
			//Adding Cards and validating the content
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.addRandomCard));
			Reports.pass("Successfully added one random card");
			
			Utility.getLocator(KioskLocatorsMapper.scanMore).isDisplayed();
			Reports.info("Scan More button is displayed as expected");
			
			Utility.getLocator(KioskLocatorsMapper.cancelButton).isDisplayed();
			Reports.info("Cancel button is displayed as expected");
			
			Utility.getLocator(KioskLocatorsMapper.buyButton).isDisplayed();
			Reports.info("Buy button is displayed as expected");
			
			Utility.getLocator(KioskLocatorsMapper.brandName).isDisplayed();
			Reports.pass("brand Name is displayed as expected--->"   +Utility.getLocator(KioskLocatorsMapper.brandName).getText());
			
			Utility.getLocator(KioskLocatorsMapper.denomination).isDisplayed();
			Reports.pass("Denomination is displayed as expected--->" +Utility.getLocator(KioskLocatorsMapper.denomination).getText());
			
			Utility.getLocator(KioskLocatorsMapper.quantity).isDisplayed();
			Reports.pass("Quantity is displayed as expected--->" +Utility.getLocator(KioskLocatorsMapper.quantity).getText());
			
			Utility.getLocator(KioskLocatorsMapper.lineTotal).isDisplayed();
			Reports.pass("Line Total is displayed as expected--->" +Utility.getLocator(KioskLocatorsMapper.lineTotal).getText());
			
			Utility.getLocator(KioskLocatorsMapper.todaystotal).isDisplayed();
			Reports.pass("Total Amount is displayed as expected--->" +Utility.getLocator(KioskLocatorsMapper.todaystotal).getText());
			
			


			Thread.sleep(1000);

		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());

		}
	}
	

}
