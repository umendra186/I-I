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


/* Class : KWA14_TC03_CancelButtonFunctionality- Verify the cancel button functionality
*  * Author : Umendra Singh Tomar
* (C) Xavient Information System 2017
* 
*/

public class KWA14_TC03_CancelButtonFunctionality extends GenericClass {
	
	public static boolean flag;
	public static String imagePath;
	Screen sc;
	int k=1;
	
	@Test
	public void cancelButtonFunctionality(){
		
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
		
			//Check Cancel Button Functionality
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.cancelButton));
			Boolean value=Utility.urlVerification("/home");
			if(value!=false){
				Reports.pass("As Expected,User is navigated on Home screen after click on cancel button ");
			}else{
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("Execption Occured", imagePath);
				Reports.fail("User Unable to navigated on home screen");
				
			}

			

		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());}
	}
	

}
