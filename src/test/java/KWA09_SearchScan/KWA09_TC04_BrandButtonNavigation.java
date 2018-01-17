package KWA09_SearchScan;

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

/**
 * Class : kWA09_TC04_BrandButtonNavigation - Verify the Brand button Navigation  
 * Author : Umendra Singh Tomar
 * (C) Xavient Information System 2017
 * 
 */
public class KWA09_TC04_BrandButtonNavigation extends GenericClass {

		
		public static boolean flag;
		public static String imagePath;
		Screen sc;
		
		@Test
		public void brandButtonNavigation(){
			
			try{
				Assert.assertTrue(Login.launchURl(KioskConfigMapper.URL),"Unable to navigate to URL");
				Reports.pass("User successfully launched Home screen");
				Log.info("User successfully launched Home screen");
				
				//Click on BUY A CARD on home screen
				Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.buyCard));
				Reports.pass("User successfully clicked on BUY A CARD button");
				Log.info("User successfully clicked on BUY A CARD button");			
				assertTrue(Utility.urlVerification("card-buy"));
				Reports.pass("User is successfully navigated on Seach/Scran Screen");
				
				//Click on Scan button
				Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.brandButton));
				Reports.pass("User successfully clicked on Brand button");
				Log.info("User successfully clicked on Brand button");
				
				//Validating the user navigated on brand page. 
				assertTrue(Utility.urlVerification("/card-buy/brand"));
				Reports.pass("User Successfully navigated on Brand screen");
					
						
			}catch(Exception e){
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("", imagePath);
				e.printStackTrace();
				Reports.fail(e.toString());			
			}
			
		}

}
