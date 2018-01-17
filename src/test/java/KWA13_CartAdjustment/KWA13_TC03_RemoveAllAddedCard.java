package KWA13_CartAdjustment;

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

/* Class : KWA13_TC03_RemoveAllAddedCard- Verify that cart total is updated when user removes all cards
*  * Author : Kishan Singh Chilwal
* (C) Xavient Information System 2017
* 
*/

public class KWA13_TC03_RemoveAllAddedCard extends GenericClass{
	
	public static boolean flag;
	public static String imagePath;
	Screen sc;
	int k=1;
	
	@Test
	public void removeAllAddedCard(){

		try {
			Assert.assertTrue(Login.launchURl(KioskConfigMapper.URL),"Unable to navigate to URL");
			Reports.pass("User Successfully Launched Home screen");
			Log.info("User Successfully Launched Home screen");

			// Click on BUY A CARD
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.buyCard));
			Reports.pass("User successfully clicked on BUY A CARD button");
			Log.info("User successfully clicked on BUY A CARD button");
			assertTrue(Utility.urlVerification("card-buy"));

			// Click on Scan button
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.scanCardButton));
			Reports.info("User Successfully clicked on Scan Button");
			Log.info("User Successfully clicked on Scan Button");

			// Calling function to add card
			Utility.addCards();
			int TodaysTotalBeforeRemoveCard=Utility.todaysTotal(Utility.getLocator(KioskLocatorsMapper.todaystotal));

			// Calling function to add card info
			Utility.removeAllAddedCards();
			int todaysTotalAfterRemoveCard=Utility.todaysTotal(Utility.getLocator(KioskLocatorsMapper.todaystotal));
			
			if(todaysTotalAfterRemoveCard==0){
				Reports.pass("As expected, After Removing the all card Todays total is showing as -----> "  + todaysTotalAfterRemoveCard);
				Log.info("As expected, After Removing the all card Todays total is showing as -----> "  + todaysTotalAfterRemoveCard);
			}else{
				Reports.fail("After Removing the all card value of Todays total is not Zero");
				Log.info("After Removing the all card value of Todays total is not Zero -----> "  + todaysTotalAfterRemoveCard);
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("Todays Total", imagePath);			
			}			

		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}
	}


}
