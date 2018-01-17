package KWA10_ScanInstructionPrompt;

import static org.testng.Assert.assertTrue;
import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.kiosk.constant.KioskConfigMapper;
import com.kiosk.constant.KioskLocatorsMapper;
import com.kiosk.modules.Login;
import com.kiosk.modules.GenericClass;
import com.kiosk.reports.Log;
import com.kiosk.reports.Reports;
import com.kiosk.utility.Utility;


/**
 * Class : KWA10_TC01_ScanPromptScreenUI - Verify content of Scan Instruction Prompt Screen
 * Author : Kishan Singh Chilwal
 * (C) Xavient Information System 2017
 * 
 */


public class KWA10_TC01_ScanPromptScreenUI extends GenericClass {
	
	public static boolean flag;
	public static String imagePath;
	Screen sc;
	
	@Test
	public void scanPromptScreenContent(){
		
		try{
			Assert.assertTrue(Login.launchURl(KioskConfigMapper.URL),"Unable to navigate to URL");
			Reports.pass("User Successfully LaunchedURL");
			Log.info("User Successfully LaunchedURL");
			
			// Click on BUY A CARD button visible on the home screen
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.buyCard));
			Reports.pass("User successfully clicked on BUY A CARD button");
			Log.info("User successfully clicked on BUY A CARD button");			
			assertTrue(Utility.urlVerification("card-buy"));
			Reports.pass("User Successfully navigated on Seach/Scran Screen");
			
			//Click on Scan button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.scanCardButton));
			Reports.pass("User successfully clicked on SCAN button");
			Log.info("User successfully clicked on SCAN button");
			assertTrue(Utility.urlVerification("/card-buy/scan"));
			Reports.pass("User Successfully navigated on  Instruction prompt screen");
			
			// Validate BUY A CARD image on scan instruction prompt screen
			sc = new Screen();
			sc.find(System.getProperty("user.dir")+ "\\src\\test\\resources\\testdata\\SikuliImages\\BuyButton.PNG");
			Reports.pass("BUY A CARD image is visible as expected");
			Log.info("BUY A CARD image is visible as expected");
			
			//Validate content on scan instruction prompt screen
			Utility.getLocator(KioskLocatorsMapper.appLogo).isDisplayed();
			Reports.pass("App logo is visible");
			Log.info("App logo is visible");
			
			Utility.getLocator(KioskLocatorsMapper.pickCardPlaceHolder).isDisplayed();
			Reports.pass("Pick Card PlaceHolder is visible");
			Log.info("Pick Card PlaceHolder is visible");
			
			Utility.getLocator(KioskLocatorsMapper.scanCardPlaceHolder).isDisplayed();
			Reports.pass("Scan Card PlaceHolder is visible");
			Log.info("Scan Card PlaceHolder is visible");
			
			Utility.getLocator(KioskLocatorsMapper.goBackScanPromptScreen).isDisplayed();
			Reports.pass("Go Back Button is displayed as expected");
			Log.info("Go Back Button is displayed as expected");
			
			Utility.getLocator(KioskLocatorsMapper.buyButton).isDisplayed();
			Reports.pass("BUY Button is displayed as expected");
			Log.info("BUY Button is displayed as expected");
			
			Utility.getLocator(KioskLocatorsMapper.cancelButton).isDisplayed();
			Reports.pass("CANCEL Button is displayed as expected");
			Log.info("CANCEL Button is displayed as expected");			
			
			
		}catch(Exception e){
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
			
		}
		
	}


}
