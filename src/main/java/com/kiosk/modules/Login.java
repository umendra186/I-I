
package com.kiosk.modules;

import static org.testng.Assert.assertTrue;

import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.kiosk.constant.Constant;
import com.kiosk.constant.KioskConfigMapper;
import com.kiosk.constant.KioskLocatorsMapper;
import com.kiosk.reports.Log;
import com.kiosk.reports.Reports;
import com.kiosk.utility.Utility;

public class Login extends LaunchEnvironment {
	public static boolean flag;
	public static String imagePath;

	public static WebDriverWait wait = new WebDriverWait(driver, 120);

	public static Properties slingRepository = Utility.loadProperty(Constant.locator_kiosk);
	public static Properties slingConfig = Utility.loadProperty(Constant.config_kiosk);
	
	
	

}
