package com.kiosk.modules;

import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.kiosk.constant.Constant;
import com.kiosk.reports.Log;
import com.kiosk.reports.Reports;
import com.kiosk.utility.Utility;

public class GenericClass {
	
	static Properties KioskConfig = Utility.loadProperty(Constant.config_kiosk);
	public static String imagePath;

	// To launch the before/after code
	
	@BeforeMethod
	public void Config() throws Exception {
		DOMConfigurator.configure("log4j.xml");
		Reports.startTest(this.getClass().getSimpleName(),
				"User logging into the application");
		if (LaunchEnvironment.LaunchEnv(KioskConfig.getProperty("browser"))) {
			Reports.pass("Configuration Launched Successfully");
			Log.info("Configuration Launched");
		} else {
			Reports.fail("Unable to Launch Configuration");
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("", imagePath);
			Utility.closeBrowser();
		}
	}

	
	@AfterMethod
	public static void FlushReport() throws Exception {
		Reports.info("**************************' TEST CASE FINISH  '*****************************");
		Reports.endTest();
		Reports.flush();
		Utility.closeBrowser();
	}
}

