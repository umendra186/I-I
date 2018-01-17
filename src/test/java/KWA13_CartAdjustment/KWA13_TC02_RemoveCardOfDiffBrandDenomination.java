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

/* Class : KWA13_TC02_RemoveCardOfDiffBrandDenomination- Verify the remove card functionality for card of diff brand and denomination
*  * Author : Kishan Singh Chilwal
* (C) Xavient Information System 2017
* 
*/
public class KWA13_TC02_RemoveCardOfDiffBrandDenomination extends GenericClass {
	
	public static boolean flag;
	public static String imagePath;
	Screen sc;
	int k=1;
	
	@Test
	public void removeCardOfDiffBrandDenomination(){

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
			int todaysTotalBeforeRemoveCard=Utility.addedCardInfo();

			// Calling function to add card info
			Utility.removeSomeAddedCards();
			int todaysTotalAfterRemoveCard = Utility.addedCardInfo();
			
			if(todaysTotalBeforeRemoveCard!=todaysTotalAfterRemoveCard)
			{
				Reports.pass("Todays Total Amount is successfully updated after removing cards");
			}else{
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("Today's Total is not update after removing cards", imagePath);
				Reports.fail("Today's Total is not update after removing cards");}
			

		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}
	}


}
