package KWA38_SearchScreen;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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

/* Class : KWA39_TC01_SearchScreenUI- Verify the UI of Search Screen
*  * Author : Umendra Singh Tomar
* (C) Xavient Information System 2017
* 
*/
public class KWA38_TC01_SearchScreenUI extends GenericClass{
	
	public static boolean flag;
	public static String imagePath;
	
	@Test
	public void searchScreenUI(){
		
		try{
			Assert.assertTrue(Login.launchURl(KioskConfigMapper.URL),"Unable to navigate to URL");
			Reports.pass("User Successfully LaunchedURL");
			Log.info("User Successfully LaunchedURL");
			
			// Click on send a card
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.sendACard));
			Reports.pass("User successfully clicked on SEND A CARD button");
			Log.info("User successfully clicked on SEND A CARD button");			
			assertTrue(Utility.urlVerification("/card-send"));
			Reports.pass("User Successfully navigated on 'Send Type Selection'  Screen");
			
			//click on Email
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.emailEGiftPickUp));
			Reports.pass("User successfully clicked on EMAI button");
			Log.info("User successfully clicked on EMAI button");			
			assertTrue(Utility.urlVerification("/card-send/search"));
			Reports.pass("User Successfully navigated on 'Search'  Screen");
			
			//Validation the content of Search page
			Thread.sleep(2000);
			Utility.getLocator(KioskLocatorsMapper.category).isDisplayed();
			Reports.pass("As Expected,Category Button is displayed");
			Log.info("As Expected,Category Button is displayed");
			
			//Validation the content of Search page
			Utility.getLocator(KioskLocatorsMapper.storeName).isDisplayed();
			Reports.pass("As Expected, StoreName button is displayed");
			Log.info("As Expected, StoreName button is displayed");
			
			//Validation the content of Search page
			Utility.getLocator(KioskLocatorsMapper.brand).isDisplayed();
			Reports.pass("As Expected,Brand button is displayed");
			Log.info("As Expected,Brand button is displayed");
			
			
			//Validation the content of Search page
			Utility.getLocator(KioskLocatorsMapper.goBackButtonCC).isDisplayed();
			Reports.pass("As Expected,GO Back button is displayed");
			Log.info("As Expected,Go Back button is displayed");			
			
			//Validating the Suggestion list
			Utility.getLocator(KioskLocatorsMapper.searchlistBrandCateoryStoreName).isDisplayed();
			Reports.pass("Suggestion List div are visible as Expected");
			WebElement suggestionList=Utility.getLocator(KioskLocatorsMapper.searchlistBrandCateoryStoreName);
			List<WebElement> suggestionListCount= suggestionList.findElements(By.tagName("li"));
			Reports.pass("Count of Total Avialble suggestion list are ---->" +suggestionListCount);
			
			//Image Validation
			Utility.validateInvalidImages();
			
		}catch(Exception e){
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
			
		}
		
	}
	
	

}
