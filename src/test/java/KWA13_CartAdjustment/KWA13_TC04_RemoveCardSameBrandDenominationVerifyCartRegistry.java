package KWA13_CartAdjustment;

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

/* Class : KWA13_TC04_RemoveCardSameBrandDenominationVerifyCartRegistry- Verify that cart Registry is updated when user removes Card of Same Brand and Denomination
*  * Author : Kishan Singh Chilwal
* (C) Xavient Information System 2017
* 
*/

public class KWA13_TC04_RemoveCardSameBrandDenominationVerifyCartRegistry extends GenericClass{
	
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
			
			// Add multiple cards of same brand and denomination
			Utility.addSameCards();


			// Calling function to add card
			int CardQtyBeforeRemove = Integer.parseInt((Utility.getLocator(KioskLocatorsMapper.quantity)).getText());
			Reports.info("Card quatity before removing cards is -----> "+CardQtyBeforeRemove);
			Log.info("Card quatity before removing cards is -----> "+CardQtyBeforeRemove);
			String lineTotalBefore = Utility.getLocator(KioskLocatorsMapper.lineTotal).getText();
			String splitStringBefore[]= lineTotalBefore.split("\\$");
			int lineTotalBeforeRemove = Integer.parseInt(splitStringBefore[1]);
			Reports.info("Line total before removing cards is -----> "+lineTotalBeforeRemove);
			Log.info("Line total before removing cards is -----> "+lineTotalBeforeRemove);

			// Remove the first card in the list and fetch qty and line total
			Utility.removeSingleCard();
			int CardQtyAfterRemove=Integer.parseInt((Utility.getLocator(KioskLocatorsMapper.quantity)).getText());
			Reports.info("Card quatity after removing cards is -----> "+CardQtyAfterRemove);
			Log.info("Card quatity after removing cards is  -----> "+CardQtyAfterRemove);
			String lineTotalAfter = (Utility.getLocator(KioskLocatorsMapper.lineTotal)).getText();
			String splitStringAfter[]= lineTotalAfter.split("//$");
			int lineTotalAfterRemove=Integer.parseInt(splitStringAfter[1]);
			Reports.info("Line total after removing cards is -----> "+lineTotalAfterRemove);
			Log.info("Line total after removing cards is  -----> "+lineTotalAfterRemove);
			
			if(CardQtyAfterRemove == (CardQtyBeforeRemove-1)){
				Reports.pass("As expected, After Removing a card the Card qty and Linetotal are -----> "  + CardQtyAfterRemove+" "+lineTotalAfterRemove);
				Log.info("As expected, After Removing a card the Card qty and Linetotal are -----> "  + CardQtyAfterRemove+" "+lineTotalAfterRemove);
			}else{
				Reports.fail("After Removing a card Card qty and Linetotal are  -----> "  + CardQtyAfterRemove+" "+lineTotalAfterRemove);
				Log.info("After Removing a card Card qty and Linetotal are  -----> "  + CardQtyAfterRemove+" "+lineTotalAfterRemove);
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
