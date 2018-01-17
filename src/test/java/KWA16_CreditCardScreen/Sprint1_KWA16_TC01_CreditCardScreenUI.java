package KWA16_CreditCardScreen;

import static org.testng.Assert.assertTrue;

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

/** Class : KWA16_TC01_CreditCardScreenUI -- Validate the UI of Credit Card Screen
 *  Author : Kishan Singh Chilwal
 *  (C) Xavient Information System 2017
 * 
 */

public class Sprint1_KWA16_TC01_CreditCardScreenUI extends GenericClass {

	public static boolean flag;
	public static String imagePath;

	@Test
	public void creditCardScreenUI(){

		try{			
			Assert.assertTrue(Login.launchURl(KioskConfigMapper.URL),"Unable to navigate to URL");
			Reports.pass("User Successfully launched Home screen");
			Log.info("User Successfully launched Home screen");

			// Click on the buy a card button
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

			//Calling function to add some card
			Utility.addCards();

			//Click on Buy Button of the cart screen
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.buyButton));
			Reports.pass("User successfully clicked on Buy button of cart screen");
			Log.info("User successfully clicked on Buy button of cart screen");
			assertTrue(Utility.urlVerification("/card-buy/card-payment"));
			Reports.pass("User Successfully navigated on Tender screen");

			//Click the Credit card button on tender screen
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.creditCardButton));
			Reports.pass("User successfully clicked on Credt card button of tender screen");
			Log.info("User successfully clicked on Credt card button of tender screen");
			assertTrue(Utility.urlVerification("/card-buy/credit-card"));
			Reports.pass("User Successfully navigated to credit card screen");			

			//Calling function to know added card details
			PaymentScreen.paymentCardScreenUI();					

		}catch(Exception e){
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());

		}

	}


}
