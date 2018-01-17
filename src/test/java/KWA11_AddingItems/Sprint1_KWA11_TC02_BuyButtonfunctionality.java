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
 * Class : KWA11_TC02_BuyButtonfunctionality-Verify the functionality of BUY BUTTON
 *  * Author : Umendra Singh Tomar
 * (C) Xavient Information System 2017
 * 
 */

public class Sprint1_KWA11_TC02_BuyButtonfunctionality extends GenericClass {
	
	public static boolean flag;
	public static String imagePath;
	Screen sc;
	int k=1;
	
	@Test
	public void buyButtonfunctionality(){
		
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
			Reports.pass("User successfully clicked on SCAN CARD button");
			Log.info("User successfully clicked on SCAN CARD button");	
			
			//Calling function to add card
			Utility.addCards();
			Reports.pass("User successfully clicked on SCAN CARD button");
			Log.info("User successfully clicked on SCAN CARD button");	
			
			//Calling function to add card info
			int todaysTotal=Utility.addedCardInfo();
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.buyButton));
			Reports.pass("User successfully clicked on buy button");
			Log.info("User successfully clicked on buy button");
			Utility.urlVerification("card-payment");
			Reports.pass("User successfully navigated on tender screen as expected");
			String[]  todaysTotalTenderScree=Utility.getLocator(KioskLocatorsMapper.todaysTotalTender).getText().split("\\$");
			Reports.pass("Tender screen todays total is -----> "  +Integer.parseInt(todaysTotalTenderScree[1]));
			Assert.assertEquals(Integer.parseInt(todaysTotalTenderScree[1]), todaysTotal);
			Reports.pass("Today's total amount are same for both tender and Screen Morph as ------->" +Integer.parseInt(todaysTotalTenderScree[1]));					

		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());}
	}
	

}
