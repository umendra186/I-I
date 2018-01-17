package KWA12_ScreenMorph;

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


/* Class : KWA12_TC03_ScrollFunctionality- Verify the scroll functionality
*  * Author : Umendra Singh Tomar
* (C) Xavient Information System 2017
* 
*/

public class KWA12_TC03_ScrollFunctionality extends GenericClass {
	
	public static boolean flag;
	public static String imagePath;
	Screen sc;
	int k=1;
	
	@Test
	public void scrollFunctionality(){

		try {
			Assert.assertTrue(Login.launchURl(KioskConfigMapper.URL),
					"Unable to navigate to URL");
			Reports.pass("User Successfully LaunchedURL");
			Log.info("User Successfully LaunchedURL");

			// Click on BUY A CARD
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.buyCard));
			Reports.pass("User successfully clicked on BUY A CARD button");
			Log.info("User successfully clicked on BUY A CARD button");
			assertTrue(Utility.urlVerification("card-buy"));

			// Click on Scan button
			Utility.touchEvent(Utility
					.getLocator(KioskLocatorsMapper.scanCardButton));
			Reports.info("User Successfully clicked on Scan Button");
			Log.info("User Successfully clicked on Scan Button");

			// Calling function to add card
			Utility.addCards();

			// Verify the scroll functionality
			if (Utility.countOfAvailableCards(Utility.getLocator(KioskLocatorsMapper.addedCards)) > 3) {
				Reports.info("Scroll bar is visible for avialabe list");
				Utility.scrollDivDown();
				Utility.scrollDivUP();
				Reports.pass("Scroll functionality working fine");
			}else{
				Reports.info("No scroll bar is visible because all avilable cards are visible");
			}


		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}
	}


}
