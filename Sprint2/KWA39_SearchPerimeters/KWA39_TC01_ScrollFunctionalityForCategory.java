package KWA39_SearchPerimeters;

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


/* Class : KWA39_TC01_ScrollCategoryFunctionality- Verify  infinite scroll for the Category 
*  * Author : Umendra Singh Tomar
* (C) Xavient Information System 2017
* 
*/

public class KWA39_TC01_ScrollFunctionalityForCategory extends GenericClass {
	
	public static boolean flag;
	public static String imagePath;
	Screen sc;
	
	@Test
	public void scrollCategoryFunctionality(){

		try {
			Assert.assertTrue(Login.launchURl(KioskConfigMapper.URL),
					"Unable to navigate to URL");
			Reports.pass("User Successfully LaunchedURL");
			Log.info("User Successfully LaunchedURL");

			// Click on SCAN A CARD
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.sendACard));
			Reports.pass("User successfully clicked on SCAN A CARD button");
			Log.info("User successfully clicked on SCAN A CARD button");
			assertTrue(Utility.urlVerification("/card-send"));

			// Click on Scan button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.emailEGiftPickUp));
			Reports.info("User Successfully clicked on EMAIL Button");
			Log.info("User Successfully clicked on EMAIL Button");

			// Verify the scroll functionality
			if (Utility.scrillVisibilityOfDiv()) {
				if (Utility
						.countOfAvailableCards(Utility
								.getLocator(KioskLocatorsMapper.searchlistBrandCateoryStoreName)) > 9) {
					Reports.info("Scroll bar is visible for avilable list");
					Utility.scrollDivDown();
					Utility.scrollDivUP();
					Reports.pass("Scroll functionality working fine");
				} else {
					Reports.info("No scroll bar is visible because all avilable cards are visible");
				}

			}
		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot(e.getMessage(), imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}
	}


}
