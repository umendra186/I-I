package com.kiosk.modules;

import org.openqa.selenium.WebElement;

import com.kiosk.constant.KioskLocatorsMapper;
import com.kiosk.reports.Log;
import com.kiosk.reports.Reports;
import com.kiosk.utility.Utility;

public class PaymentScreen extends LaunchEnvironment {
	
	public static String imagePath;

	
	public static void paymentCardScreenUI() {

		try {
			// Go back Button validation
			Utility.getLocator(KioskLocatorsMapper.goBackButtonTender)
					.isDisplayed();
			Reports.pass("As Expected, GO BACK BUTTON is displayed");
			Log.info("As Expected, GO BACK BUTTON is displayed");

			// Images Validations
			Utility.validateInvalidImages();

			// Post message and status validation
			Reports.info("Current status is ----->"	+ Utility.getLocator(KioskLocatorsMapper.status).getText());
			Log.info("Current status is ----->"	+ Utility.getLocator(KioskLocatorsMapper.status).getText());
			Reports.info("Post Status Messaging  is  ----->"+ Utility.getLocator(KioskLocatorsMapper.postStatus1)
							.getText());
			Log.info("Post Status Messaging  ----->"+ Utility.getLocator(KioskLocatorsMapper.postStatus1)
							.getText());
			Reports.info("Post Status Messaging is ----->"	+ Utility.getLocator(KioskLocatorsMapper.postStatus2)
							.getText());
			Log.info("Post Status Messaging is  ----->"+ Utility.getLocator(KioskLocatorsMapper.postStatus2)
							.getText());
		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());

		}

	}
	
//*****************************	This method is to validate Cash Payment screen UI ****************************//
	public static void paymentCashScreenUI() {

		try {
			// Go back Button validation
			Utility.getLocator(KioskLocatorsMapper.goBackButtonTender)
					.isDisplayed();
			Reports.pass("As Expected, GO BACK BUTTON is displayed");
			Log.info("As Expected, GO BACK BUTTON is displayed");

			// Images Validations
			Utility.validateInvalidImages();
			
			//Bill Tender Validation line 1
			cashScreenTender(Utility.getLocator(KioskLocatorsMapper.billTender1));
			
			//Bill Tender Validation line 1
			cashScreenTender(Utility.getLocator(KioskLocatorsMapper.billTender2));
						
			//Total Amount Validation
			Reports.info("Total Amount is ----->"	+ Utility.getLocator(KioskLocatorsMapper.cashTotal).getText());
			Log.info("Total Amount is ----->"	+ Utility.getLocator(KioskLocatorsMapper.cashTotal).getText());

			// Post message validation
			Reports.info("Post Status Messaging  is  ----->"+ Utility.getLocator(KioskLocatorsMapper.cashPostStatus1)
							.getText());
			Log.info("Post Status Messaging  ----->"+ Utility.getLocator(KioskLocatorsMapper.cashPostStatus1)
							.getText());
			Reports.info("Post Status Messaging is ----->"	+ Utility.getLocator(KioskLocatorsMapper.cashPostStatus2)
							.getText());
			Log.info("Post Status Messaging is  ----->"+ Utility.getLocator(KioskLocatorsMapper.cashPostStatus2)
							.getText());
		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());

		}

	}
	
	public static void cashScreenTender(WebElement ele) {

		String tenderLabel = ele.getText();
		String[] cashTender = tenderLabel.split("\\>");

		for (int i = 0; i < cashTender.length; i++) {
			String runningTender[] = cashTender[i].split("\\<");
			if (i == 0) {
				Reports.info("Bill Tender is ----->" + runningTender[1]);
				Log.info("Bill Tender is ----->" + runningTender[1]);
			}
			if (i == 1) {
				Reports.info("Quantity is ----->" + runningTender[1]);
				Log.info("Quantity Tender is ----->" + runningTender[1]);
			}
			if (i == 2) {
				Reports.info("Tender Amount is ----->" + runningTender[1]);
				Log.info("Tender Amount is ----->" + runningTender[1]);
			}
		}
	}

}
