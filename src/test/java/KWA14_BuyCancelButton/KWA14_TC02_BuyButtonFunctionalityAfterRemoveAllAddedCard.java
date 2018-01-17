package KWA14_BuyCancelButton;

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


/* Class : KWA14_TC02_BuyButtonFunctionalityAfterRemoveAllAddedCard
*  * Author : Umendra Singh Tomar
* (C) Xavient Information System 2017
* 
*/
public class KWA14_TC02_BuyButtonFunctionalityAfterRemoveAllAddedCard extends GenericClass{
	
	public static boolean flag;
	public static String imagePath;
	Screen sc;
	int k=1;
	
	@Test
	public void buyButtonFunctionalityAfterRemoveAllAddedCard(){
		
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
			
			//Calling function to add card
			Utility.addCards();
			Utility.addedCardInfo();

			//Calling function to Remove all added card
			Utility.removeAllAddedCards();
			Utility.addedCardInfo();
			
			//Check Buy Button Functionality
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.buyButton));
			Boolean value=Utility.urlVerification("/scan-cart");
			if(value!=false){
				Reports.pass("As Expected,BUY button is disabled ");
			}else{
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("Execption Occured", imagePath);
				Reports.fail("Buy button is clickable and navigated on tender screen");
				
			}

			

		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());}
	}
	


}
