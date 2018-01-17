package KWA49_Personalization;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.kiosk.constant.KioskConfigMapper;
import com.kiosk.constant.KioskLocatorsMapper;
import com.kiosk.modules.GenericClass;
import com.kiosk.modules.Login;
import com.kiosk.reports.Log;
import com.kiosk.reports.Reports;
import com.kiosk.utility.ExcelUtils;
import com.kiosk.utility.Utility;

/* Class : Sprint3_KWA49_TC42_NextButtonValidationWhenAllFieldsValidEntery -- Verify Next button functionality when all text field is complete and valid
*  * Author : Umendra Singh Tomar
* (C) Xavient Information System 2018
* 
*/
public class Sprint3_KWA49_TC42_NextButtonValidationWhenAllFieldsValidEntery extends GenericClass{

			
		public static boolean flag;
		public static String imagePath;
		
		
		@Test
		public void nextButtonValidationWhenAllFieldsValidEntery(){
			
			try{
				Assert.assertTrue(Login.launchURl(KioskConfigMapper.URL), "Unable to navigate to URL");
				Reports.pass("User Successfully LaunchedURL");
				Log.info("User Successfully LaunchedURL");

				// Click on SEND A CARD button
				Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.sendACard));
				Reports.pass("User successfully clicked on SEND A CARD button");
				Log.info("User successfully clicked on SEND A CARD button");			
				assertTrue(Utility.urlVerification("card-send"));
				Reports.pass("User Successfully navigated on eGift/Pickup Screen");
							
				//Click on Email button and Verify Navigation			
				Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.email));
				Reports.pass("User successfully clicked on EMAIL button");
				Log.info("User successfully clicked on EMAIL button");
				assertTrue(Utility.urlVerification("card-send/search"));
				Reports.pass("User Successfully navigated on Search Screen");
				
				
				//click on "Add fixed amount card" button
				Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.fixAmountCard));
				Reports.pass("User successfully clicked on \'add fix amount card\' Mock button");
				Log.info("User successfully clicked on \'add fix amount card\' Mock button");
				
				//Calling function to add some card
				Utility.clickOnFixedRangePage();						
				
				//Click on Buy Button
				Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.buyButton));
				Reports.pass("User Successfully Clicked on Buy Button");
				Log.info("User Successfully Clicked on Buy Button");
				Utility.urlVerification("/card-payment");
				Reports.pass("User successfully naviaged on Tender Screen");
				Log.info("User successfully naviaged on Tender Screen");

				
				//Click on Credit Card Button
				Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.creditCardButton));
				Reports.pass("User successfully clicked on Credit Card button");
				Log.info("User successfully clicked on Credit Card button");
				assertTrue(Utility.urlVerification("card-send/credit-card"));
				Reports.pass("User Successfully navigated on Credit Card Screen");
				
				//Validate the Navigation of Personalization Screen
				Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.mockButtonToMoveOnPersonalizationPage));
				Reports.pass("User successfully clicked on Mock Button to Move on Personalization Page");
				Log.info("User successfully clicked on Mock Button to Move on Personalization Page");
				assertTrue(Utility.urlVerification("/card-personalization/address"));
				Reports.pass("User Successfully navigated on Personalization Page");
				
				//RecipentName Validation
				Utility.getLocator(KioskLocatorsMapper.senderEmailInputBox).sendKeys(ExcelUtils.readDataForPersonalization().get("REmailValidEmail"));
				System.out.println("Text---------------." +Utility.getLocator(KioskLocatorsMapper.senderEmailInputBox).getText());
				Reports.info("User Successfully Entered the value in Sender Email as --->"+ExcelUtils.readDataForPersonalization().get("REmailValidEmail"));
				Utility.getLocator(KioskLocatorsMapper.recipientName).sendKeys(ExcelUtils.readDataForPersonalization().get("RNameAlphabet"));
				Reports.info("User Successfully Entered the value in Recipient Name as --->"+ExcelUtils.readDataForPersonalization().get("RNameAlphabet"));
				Utility.getLocator(KioskLocatorsMapper.recipientEmailInputBox).sendKeys(ExcelUtils.readDataForPersonalization().get("REmailValidEmail"));
				Reports.info("User Successfully Entered the value in Recipient Email as --->"+ExcelUtils.readDataForPersonalization().get("REmailValidEmail"));
				Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.nextButton));
				Reports.pass("User Successfully Clicked on Next Button");
				Thread.sleep(2000);				
				if (Utility.currentURL().endsWith(
						"/card-personalization/message")) {
					Reports.pass("User is Redirected on Next Page After Clicked on Next Button when All Fields are valid Entery");
				} else {
					imagePath = Utility.getfailScreenshot();
					Reports.attachfailScreenshot("", imagePath);
					Reports.fail("User is unable to redirect on expected page");
				}						
			}catch(Exception e){
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot(e.getMessage(), imagePath);
				e.printStackTrace();
				Reports.fail(e.toString());
				
			}
		}

}
