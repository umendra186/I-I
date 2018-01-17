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

/* Class : KWA38_TC11_FunctionalitySubCategoryCard-Verify the functionality when user tap on any Sub-Category/Card of Category 
*  * Author : Umendra Singh Tomar
* (C) Xavient Information System 2017
* 
*/
public class KWA38_TC11_FunctionalitySubCategoryCard extends GenericClass{
	
	public static boolean flag;
	public static String imagePath;
	
	@Test
	public void functionalitySubCategoryCard(){
		
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
			
			//Validating the Suggestion list
			Utility.getLocator(KioskLocatorsMapper.searchlistBrandCateoryStoreName).isDisplayed();
			Reports.pass("Suggestion List div are visible as Expected");
			WebElement suggestionList=Utility.getLocator(KioskLocatorsMapper.searchlistBrandCateoryStoreName);
			List<WebElement> suggestionListCount= suggestionList.findElements(By.tagName("li"));
			Reports.pass("For Catagory, Count of Defualt Avialble suggestion list are ---->" +suggestionListCount.size());
			
			//Add Demo Card 
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.addRandomCard));
			Utility.clickOnFixedRangePage();
			Log.info("URL------->" +Utility.currentURL());
			if (Utility.currentURL().endsWith("/card-send/cart")) {
				Reports.pass("User Successfully Enter the valid value and naviaged on Cart screen");				
			} else {
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("Execption Occured", imagePath);
				Reports.pass("User Unable to navigated on cart screen after the enter the valid value");
				}

			
		}catch(Exception e){
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
			
		}
		
	}
	
	

}
