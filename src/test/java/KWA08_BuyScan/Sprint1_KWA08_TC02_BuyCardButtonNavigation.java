package KWA08_BuyScan;

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

/**
 * Class : KWA08_TC02_BuyCardButtonNavigation - Verify Buy a Card Button Redirected on search screen
 * Author : Umendra Singh Tomar
 * (C) Xavient Information System 2017
 * 
 */

public class Sprint1_KWA08_TC02_BuyCardButtonNavigation extends GenericClass {
	
	public static boolean flag;
	public static String imagePath;	
	
	@Test
	public void buyCardButtonNavigation(){
		
		try{
			Assert.assertTrue(Login.launchURl(KioskConfigMapper.URL),"Unable to navigate to URL");
			Reports.pass("User Successfully LaunchedURL");
			Log.info("User Successfully LaunchedURL");
			
			//Click on BUY A CARD
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.buyCard));
			Reports.pass("User successfully clicked on BUY A CARD button");
			Log.info("User successfully clicked on BUY A CARD button");			
			assertTrue(Utility.urlVerification("card-buy"));
			Reports.pass("User Successfully navigated on Seach/Scran Screen");		
						
					
		}catch(Exception e){
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot(e.getMessage(), imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());			
		}
		
	}


}
