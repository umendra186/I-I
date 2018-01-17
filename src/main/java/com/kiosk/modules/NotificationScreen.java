package com.kiosk.modules;

import com.kiosk.constant.KioskLocatorsMapper;
import com.kiosk.reports.Log;
import com.kiosk.reports.Reports;
import com.kiosk.utility.Utility;

public class NotificationScreen extends LaunchEnvironment {

	public static String sorryMessageActual = "Sorry, we couldn't send a card!";
	public static String reversalMessageActual = "Messaging about payment reversal";
	public static String moreInfoActual = "For more info call <XXX.XXX.XXXX>";
	public static String successMessageActual = "Your eGift is on its way!";
	public static String successEmailMessageActual = "You should receive an email confirmation shortly!";
	public static String successRecieptMessageActual = "Don’t forget your reciept!";
	public static String imagePath;

	
	/****************Function to validate UI content of Error Screen ******************************/
	public static void errorScreenUI() {

		try {
						
			// Images Validations
			Utility.validateInvalidImages();
			
			// Sorry Message validation
			if (Utility.getLocator(KioskLocatorsMapper.sorryMessage).getText()
					.equals(sorryMessageActual)) {
				Reports.pass("\"" + sorryMessageActual + "\""
						+ " Message is displayed as expected");
				Log.info("\"" + sorryMessageActual + "\""
						+ " Message is displayed as expected");
			} else {
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("Execption Occured", imagePath);
				Reports.fail("Wrong error Message is displayed");
			}

					
			// Reversal Message validation
			if (Utility.getLocator(KioskLocatorsMapper.reversalMessage)
					.getText().split("[<\\>]")[1].equals(reversalMessageActual)) {
				Reports.pass("\"" + reversalMessageActual + "\""
						+ " Message is displayed as expected");
				Log.info("\"" + reversalMessageActual + "\""
						+ " Message is displayed as expected");
			} else {
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("Execption Occured", imagePath);
				Reports.fail("Wrong reversal Message is displayed");
			}

			// For More Info Message validation
			if (Utility.getLocator(KioskLocatorsMapper.moreInfo).getText()
					.equals(moreInfoActual)) {
				String[] strs = Utility.getLocator(KioskLocatorsMapper.moreInfo).getText().split("[<\\>]");
				Reports.pass("\"" + strs[0] + strs[1] + "\""
						+ " Message is displayed as expected");
				Log.info("\"" + strs[0] + strs[1] + "\""
						+ " Message is displayed as expected");
			} else {
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("Execption Occured", imagePath);
				Reports.fail("Wrong More Info Message is displayed");
			}
		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot(e.getMessage(), imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}

	}
	
	/****************Function to validate Time Out Functionality ******************************/	
	public static void validateScreenTimeOut()  {
		try {
			Thread.sleep(30000);
			if (Utility.currentURL().endsWith("/home")) {
				Reports.pass("User Successfully Navigated on Home Screen after Timeout");
				Log.info("User Successfully Navigated on Home Screen after Timeout");
			} else {
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("Execption Occured", imagePath);
				Reports.fail("Time Out functionality is not working");
				Log.fail("Time Out functionality is not working");
			}
		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot(e.getMessage(), imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}
	}
	
	

	/****************Function to validate UI content of Success Screen ******************************/
	public static void successScreenUI() {

		try {

			// Images Validations
			Utility.validateInvalidImages();

			// Success Message validation
			if (Utility.getLocator(KioskLocatorsMapper.successMessage)
					.getText().equals(successMessageActual)) {
				Reports.pass("\"" + successMessageActual + "\""
						+ " Message is displayed as expected");
				Log.info("\"" + successMessageActual + "\""
						+ " Message is displayed as expected");
			} else {
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("Execption Occured", imagePath);
				Reports.fail("Wrong success Message is displayed");
			}

			// Success Email Message validation
			if (Utility.getLocator(KioskLocatorsMapper.successEmailMessage)
					.getText().equals(successEmailMessageActual)) {
				Reports.pass("\"" + successEmailMessageActual + "\""
						+ " Message is displayed as expected");
				Log.info("\"" + successEmailMessageActual + "\""
						+ " Message is displayed as expected");
			} else {
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("Execption Occured", imagePath);
				Reports.fail("Wrong success email Message is displayed");
			}

			// Don't forget your reciept Message validation
			if (Utility.getLocator(KioskLocatorsMapper.successRecieptMessage)
					.getText().equals(successRecieptMessageActual)) {
				Reports.pass("\"" + successRecieptMessageActual + "\""
						+ " Message is displayed as expected");
				Log.info("\"" + successRecieptMessageActual + "\""
						+ " Message is displayed as expected");
			} else {
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("Execption Occured", imagePath);
				Reports.fail("Wrong More Info Message is displayed");
			}
		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot(e.getMessage(), imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}

	}
	
}
