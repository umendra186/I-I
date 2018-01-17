package KWA49_Personalization;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.JavascriptExecutor;
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

/* Class : Sprint3_KWA49_TC44_CancelButtonValidationWhenAllFieldsInValidEntery -- Verify the functionality of Cancel button when all fields have valid info
*  * Author : Umendra Singh Tomar
* (C) Xavient Information System 2018
* 
*/
public class Sprint3_KWA49_TC43_CancelButtonValidationWhenAllFieldsInValidEntery extends GenericClass{

			
		public static boolean flag;
		public static String imagePath;
		
		
		@Test
		public void cancelButtonValidationWhenAllFieldsInValidEntery(){
			
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
				Utility.getLocator(KioskLocatorsMapper.senderEmailInputBox).sendKeys(ExcelUtils.readDataForPersonalization().get("REmailTrailingDot"));
				Reports.info("User Successfully Entered the value in Sender Email as --->"+ExcelUtils.readDataForPersonalization().get("REmailValidEmail"));
				Utility.getLocator(KioskLocatorsMapper.recipientName).sendKeys(ExcelUtils.readDataForPersonalization().get("RNameNonAlphanumeric"));
				Reports.info("User Successfully Entered the value in Recipient Name as --->"+ExcelUtils.readDataForPersonalization().get("RNameAlphabet"));
				Utility.getLocator(KioskLocatorsMapper.recipientEmailInputBox).sendKeys(ExcelUtils.readDataForPersonalization().get("REmailWhenTwoAtSign"));
				Reports.info("User Successfully Entered the value in Recipient Email as --->"+ExcelUtils.readDataForPersonalization().get("REmailValidEmail"));
				Reports.info("Entered Recipient Name Value is --------->"+Utility.getText("RecipientName"));	
				Reports.info("Entered Recipient Email Value is --------->"+Utility.getText("RecipientEmail"));				
				Reports.info("Entered Recipient Sender Email Value is --------->"+Utility.getText("SenderEmail"));
				Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.cancelButton));
				Reports.pass("User Successfully Clicked on Cancel Button");
				Thread.sleep(2000);
				if(Utility.getText("RecipientName").equalsIgnoreCase("")
						&&  Utility.getText("RecipientEmail").equalsIgnoreCase("")
						&&  Utility.getText("SenderEmail").equalsIgnoreCase("")
						){
					Reports.pass("All field are cleared after clicked on Clear button");
				}else{
					imagePath = Utility.getfailScreenshot();
					Reports.attachfailScreenshot("", imagePath);
					Reports.fail("All fields are not cleared");
				}			
			
								
			}catch(Exception e){
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot(e.getMessage(), imagePath);
				e.printStackTrace();
				Reports.fail(e.toString());
				
			}
		}

}
