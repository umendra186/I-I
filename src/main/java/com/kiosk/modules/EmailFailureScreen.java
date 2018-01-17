package com.kiosk.modules;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.kiosk.constant.KioskLocatorsMapper;
import com.kiosk.reports.Log;
import com.kiosk.reports.Reports;
import com.kiosk.utility.Utility;

public class EmailFailureScreen extends LaunchEnvironment {

	public static String imagePath;

	public static void EmailFailureScreenUI() {
		String actualMessage = "Your email isn't valid. Please enter a valid email!";

		try {
			// Go back Button validation
			Utility.getLocator(KioskLocatorsMapper.goBackButtonTender)
					.isDisplayed();
			Reports.pass("As Expected, GO BACK BUTTON is displayed");
			Log.info("As Expected, GO BACK BUTTON is displayed");

			// Images Validations
			Utility.validateInvalidImages();

			Utility.getLocator(KioskLocatorsMapper.Oops).isDisplayed();
			Reports.info("Oops! Message is displayed as expected");
			Log.info("Oops! Message is displayed as expected");

			if (Utility.getLocator(KioskLocatorsMapper.wrongEmailMessage)
					.getText().equals(actualMessage)) {
				Reports.info(actualMessage
						+ " Message is displayed as expected");
				Log.info(actualMessage + " Message is displayed as expected");
			} else {
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("Execption Occured", imagePath);
				Reports.fail("Wrong email Message is not displayed as expected");
				Log.fail("Wrong email Message is not displayed as expected");
			}

			Utility.getLocator(KioskLocatorsMapper.buyButtonScanPromptScreen)
					.isDisplayed();
			Reports.info("Send button is displayed as expected");
			Log.info("Send button is displayed as expected");

			Utility.getLocator(KioskLocatorsMapper.cancelButton).isDisplayed();
			Reports.info("Cancel button is displayed as expected");
			Log.info("Cancel button is displayed as expected");

			Utility.getLocator(KioskLocatorsMapper.recipientEmail).isDisplayed();
			Reports.info("Recipient\'s Email button is displayed as expected");
			Log.info("Recipient\'s Email button is displayed as expected");

		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());

		}

	}

	public static void FeedDataPersonalizationOne() throws IOException,
			InterruptedException {
		driver.findElement(By.name("recipientName")).sendKeys(
				"Alexander Joseph");
		driver.findElement(By.name("recipientEmail")).sendKeys(
				"Alexander.Joseph@mail.com");
		driver.findElement(By.name("senderEmail")).sendKeys(
				"Thomas.jule@mail.com");

		Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.nextButton));
		// driver.findElement(By.xpath("//*[@class='btn btnBuy']")).click();
		Reports.pass("User Successfully tap on Next button");
		Log.info("User Successfully tap on Next button");
		Utility.urlVerification("card-send/card-personalization/message");
		Reports.pass("User successfully navigated to Second page of Personalization Screen");
		Log.info("User successfully navigated to Second page of Personalization Screen");
	}

	public static void FeedDataPersonalizationTwo()
			throws InterruptedException, IOException {
		driver.findElement(By.name("quickMessage")).sendKeys("Happy New Year");
		driver.findElement(By.name("senderName")).sendKeys("Thomas Jule");
		// driver.findElement(By.xpath("//*[@class='btn btnBuy']")).click();
		Utility.touchEvent(Utility.getLocator(KioskLocatorsMapper.nextButton));
		Reports.pass("User Successfully tap on Next button");
		Log.info("User Successfully tap on Next button");
		Utility.urlVerification("card-send/confirmation");
		Reports.pass("User successfully navigated to Confirmation Screen");
		Log.info("User successfully navigated to Confirmation Screen");
	}

	public static void validateFocusField(WebElement ele) {
		try {
			if (ele.equals(driver.switchTo().activeElement())) {
				Reports.pass("As Expected cursor is on "
						+ ele.getAttribute("placeholder"));
				Log.info("As Expected cursor is on "
						+ ele.getAttribute("placeholder"));
			} else {
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("Execption Occured", imagePath);
				Reports.fail("User is navigated to Wrong input field");
			}
		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}
	}
}
