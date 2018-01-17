package KWA36_SendButton;

import static org.testng.Assert.assertTrue;

import org.sikuli.script.Screen;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.kiosk.constant.KioskConfigMapper;
import com.kiosk.constant.KioskLocatorsMapper;
import com.kiosk.modules.GenericClass;
import com.kiosk.modules.Login;
import com.kiosk.reports.Log;
import com.kiosk.reports.Reports;
import com.kiosk.utility.Utility;

/* Class : KWA26_TC01_SendCardButtonFunctionality- Verify the Send A Card Button Functionality
*  * Author : Umendra Singh Tomar
* (C) Xavient Information System 2017
* 
*/

public class Sprint2_KWA36_TC01_SendCardButtonFunctionality extends GenericClass {
		
	public static boolean flag;
	public static String imagePath;
	Screen sc;
	
	@Test
	public void sendCardButtonFunctionality(){
		
		try{
			Assert.assertTrue(Login.launchURl(KioskConfigMapper.URL),"Unable to navigate to URL");
			Reports.pass("User Successfully LaunchedURL");
			Log.info("User Successfully LaunchedURL");
			
			// Validating the content of Buy Content Screen
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.sendACard));
			Reports.pass("User successfully clicked on SEND A CARD button");
			Log.info("User successfully clicked on SEND A CARD button");			
			assertTrue(Utility.urlVerification("/card-send"));
			Reports.pass("User Successfully navigated on 'Send Type Selection'  Screen");
			
		}catch(Exception e){
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
			
		}
		
	}
	

}
