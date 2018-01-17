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

/** Class : KWA13_TC02_RemoveCardForDiffBrandDenomination- Verify the Remove card functionality cards for diff brand and denomination
*  Author : Kishan Singh Chilwal
*  (C) Xavient Information System 2017
* 
*/
public class Sprint1_KWA13_TC02_RemoveCardForDiffBrandDenomination extends GenericClass {
	
	public static boolean flag;
	public static String imagePath;
	Screen sc;
	int k=1;
	
	@Test
	public void removeCardForDiffBrandDenomination(){

		try {
			Assert.assertTrue(Login.launchURl(KioskConfigMapper.URL),"Unable to navigate to URL");
			Reports.pass("User Successfully Launched home screen");
			Log.info("User Successfully Launched home screen");

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
			
			// Fetch todays total value before removing cards
			String todaysTotalBefore = (Utility.getLocator(KioskLocatorsMapper.todaystotal)).getText();
			String splitStringBefore[]= todaysTotalBefore.split("\\$");
			int todaysTotalBeforeRemoveCard=Integer.parseInt(splitStringBefore[1]);
			System.out.print(todaysTotalBeforeRemoveCard);
			Reports.info("Todays total before removing cards is -----> "+todaysTotalBeforeRemoveCard);
			Log.info("Todays total before removing cards is -----> "+todaysTotalBeforeRemoveCard);

			// Calling function to remove
			Utility.removeSomeAddedCards();
			
			// Fetch todays total value after removing cards
			Thread.sleep(500);
			String todaysTotalAfter = (Utility.getLocator(KioskLocatorsMapper.todaystotal)).getText();
			String splitStringAfter[]= todaysTotalAfter.split("\\$");
			int todaysTotalAfterRemoveCard=Integer.parseInt(splitStringAfter[1]);
			System.out.print(todaysTotalAfterRemoveCard);
			Reports.info("Todays total after removing cards is -----> "+todaysTotalAfterRemoveCard);
			Log.info("Todays total after removing cards is -----> "+todaysTotalAfterRemoveCard);
			
			if(todaysTotalBeforeRemoveCard!=todaysTotalAfterRemoveCard)
			{
				Reports.pass("Todays Total Amount is successfully updated after removed some cards");
			}else{
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("Today's Total is not update after removed some cards", imagePath);
				Reports.fail("Today's Total is not update after removed some cards");}
			

		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}
	}


}
