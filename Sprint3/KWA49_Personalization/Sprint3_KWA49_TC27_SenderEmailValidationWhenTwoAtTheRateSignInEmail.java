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

/* Class : Sprint3_KWA49_TC26_SenderEmailValidationWhenTwoAtTheRateSignInEmail --This test case is to verify the validation on 'Sender's Email' field when user enter email which two @ sign  
*  * Author : Umendra Singh Tomar
* (C) Xavient Information System 2018
* 
*/
public class Sprint3_KWA49_TC27_SenderEmailValidationWhenTwoAtTheRateSignInEmail extends GenericClass{

			
		public static boolean flag;
		public static String imagePath;
		
		
		@Test
		public void senderEmailValidationWhenRecipentNameMissing(){
			
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
				Log.info("Excel Value--->"+ExcelUtils.readDataForPersonalization().get("REmailWhenTwoAtSign"));
				Utility.getLocator(KioskLocatorsMapper.senderEmailInputBox).sendKeys(ExcelUtils.readDataForPersonalization().get("REmailWhenTwoAtSign"));
				Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.nextButton));
				Thread.sleep(2000);
				/*if(Utility.getLocator(KioskLocatorsMapper.recipientEmailInputBox).getAttribute("ng-reflect-model").equals(ExcelUtils.readDataForPersonalization().get("REmailWhenTwoAtSign"))){
					Reports.pass("User Able to enter the Invalid email in Recipient Email field ");*/
					if(Utility.getLocator(KioskLocatorsMapper.recipientEmailErrorMsg).getText().equals("Please enter valid email") && Utility.getLocator(KioskLocatorsMapper.senderEmailErrorMsg).getText().equals("Please enter valid email") && Utility.getLocator(KioskLocatorsMapper.recipientNameErrorMsg).getText().equals("Please enter valid name") ){
					Reports.pass("As Expected,Error message is displayed for corresponding filed when user enter the value in only Recipient Email and click on next button");
					}else{
					imagePath = Utility.getfailScreenshot();
					Reports.attachfailScreenshot("", imagePath);
					Reports.fail("Error message is not displayed for corresponding filed");
					}
				/*}else{
					imagePath = Utility.getfailScreenshot();
					Reports.attachfailScreenshot("", imagePath);
					Reports.fail("User is unable to enter the Invalid Email in Recipient Email");
					}*/
									
						
			}catch(Exception e){
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot(e.getMessage(), imagePath);
				e.printStackTrace();
				Reports.fail(e.toString());
				
			}
		}

	}
