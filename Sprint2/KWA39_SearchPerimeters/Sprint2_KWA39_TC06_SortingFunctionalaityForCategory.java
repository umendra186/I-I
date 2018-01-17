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


/* Class : KWA39_TC06_SortingFunctionalaityForCategory- Verify sorting on Card of Category
*  * Author : Umendra Singh Tomar
* (C) Xavient Information System 2017
* 
*/

public class Sprint2_KWA39_TC06_SortingFunctionalaityForCategory extends GenericClass {
	
	public static boolean flag;
	public static String imagePath;
	Screen sc;

	
	@Test
	public void sortingFunctionalaityForCategory(){

		try {
			Assert.assertTrue(Login.launchURl(KioskConfigMapper.URL),"Unable to navigate to URL");
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

			/*// Click on Brand Name
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.category));
			Reports.info("User Successfully clicked on category Button");
			Log.info("User Successfully clicked on category Button");*/

			//Validating the functionality of A-Z sorting
			Utility.aToZAlphSortingValidation();
			

		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot(e.getMessage(), imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}
	}


}
