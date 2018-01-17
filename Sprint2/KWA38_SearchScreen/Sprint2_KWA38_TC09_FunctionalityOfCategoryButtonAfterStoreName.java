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

/** Class : KWA38_TC09_FunctionalityOfCategoryButtonAfterStoreName-Verify the functionality of Category button after coming from Store Name or Brand  
*  Author : Kishan Singh Chilwal
*  (C) Xavient Information System 2017
* 
*/
public class Sprint2_KWA38_TC09_FunctionalityOfCategoryButtonAfterStoreName extends GenericClass{
	
	public static boolean flag;
	public static String imagePath;
	
	@Test
	public void functionalityOfCategoryButtonAfterStoreName(){
		
		try{
			Assert.assertTrue(Login.launchURl(KioskConfigMapper.URL),"Unable to navigate to URL");
			Reports.pass("User Successfully Launched Home screen");
			Log.info("User Successfully Launched Home screen");
			
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
			assertTrue(Utility.urlVerification("/card-send/search/category/0"));
			Reports.pass("User Successfully navigated on 'Search'  Screen");	
			
			//Validating the Suggestion list
			Utility.getLocator(KioskLocatorsMapper.searchlistBrandCateoryStoreName).isDisplayed();
			Reports.pass("Suggestion List div are visible as Expected");
			WebElement suggestionList=Utility.getLocator(KioskLocatorsMapper.searchlistBrandCateoryStoreName);
			List<WebElement> suggestionListCount= suggestionList.findElements(By.tagName("li"));
			Reports.pass("For Catagory, Count of Defualt Avialble suggestion list are ---->" +suggestionListCount);
			
			//click on Store Name
			Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.storeName));
			WebElement suggestionListStore=Utility.getLocator(KioskLocatorsMapper.searchlistBrandCateoryStoreName);
			List<WebElement> suggestionListCountStore= suggestionListStore.findElements(By.tagName("li"));
			Reports.pass("For Store Name, Count of Defualt Avialble suggestion list are ---->" +suggestionListCountStore);
			
			//Validating the Suggestion list
			Utility.getLocator(KioskLocatorsMapper.searchlistBrandCateoryStoreName).isDisplayed();
			Reports.pass("Suggestion List div are visible as Expected");
			WebElement suggestionList1=Utility.getLocator(KioskLocatorsMapper.searchlistBrandCateoryStoreName);
			List<WebElement> suggestionListCount1= suggestionList1.findElements(By.tagName("li"));
			Reports.pass("Available Categories is displayed next to Option button and count are --->" +suggestionListCount1);
			
		}catch(Exception e){
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
			
		}
		
	}
	
	

}
