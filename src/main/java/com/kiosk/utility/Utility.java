package com.kiosk.utility;

import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import net.sourceforge.htmlunit.corejs.javascript.ast.CatchClause;
import net.sourceforge.htmlunit.corejs.javascript.ast.TryStatement;

import org.apache.commons.io.FileUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.HasTouchScreen;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.kiosk.constant.Constant;
import com.kiosk.constant.KioskLocatorsMapper;
import com.kiosk.modules.LaunchEnvironment;
import com.kiosk.reports.Log;
import com.kiosk.reports.Reports;

public class Utility extends LaunchEnvironment {
	public static Properties prop;
	public static InputStream file;
	public static String value, data, filepath;
	public static String locvalue;
	public static String loctype, currentURL, currentDatetime;
	public static WebElement loct;
	public static boolean flag;
	public static Actions ac;
	public static int invalidImageCount;
	public static String imagePath;
	public static int todaysAmount;
	public static int TodaysTotal;
	public static String hiddenText;
	public static int minvalue, randdomNUM;
	public static int[] minvalueRetrun;
	public static int[] minMaxValue;
	public static int validRandomNumber, randomInvalidNumber, minValue,
			maxValue, availabeCardCount;
	private static int AmountFixdenomination,size,todaysTotalCartScreen;

	public static String ReadProperty(String key) {
		file = null;
		try {
			file = new FileInputStream(Constant.locator_kiosk);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop = new Properties();
			prop.load(file);
			value = prop.getProperty(key);

		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Unable to Load/Read property file");
		}
		return value;
	}

	public static Properties loadProperty(String filelocation) {
		// file = null;
		prop = new Properties();
		try {
			file = new FileInputStream(filelocation);
		} catch (FileNotFoundException e) {
			Reports.fail(e.toString());
			e.printStackTrace();
		}
		try {
			prop.load(file);
		} catch (IOException e) {
			Reports.fail(e.toString());
			e.printStackTrace();
		}
		return prop;
	}

	public static String ReadConfigProperty(String key) {
		file = null;
		try {
			file = new FileInputStream(Constant.config_kiosk);
		} catch (FileNotFoundException e) {
			Reports.fail(e.toString());
			e.printStackTrace();
		}
		try {
			prop = new Properties();
			prop.load(file);
			value = prop.getProperty(key);

		} catch (IOException e) {
			Reports.fail(e.toString());
			System.out.println("Unable to Load/Read Config property file");
		}
		return value;
	}

	public static WebElement getLocator(String key) {
		try {
			// String locaterValue = Utility.ReadProperty(key);
			// String[] locaterarray = locaterValue.split("##");
			String[] locaterarray = key.split("##");
			locvalue = locaterarray[0];
			loctype = locaterarray[1];
		} catch (ArrayIndexOutOfBoundsException e) {
			Reports.fail(e.toString());
			e.printStackTrace();
		}
		// System.out.println(locvalue);
		// System.out.println(loctype);
		try {
			if (loctype.equalsIgnoreCase("id")) {
				loct = driver.findElement(By.id(locvalue));
				// ElementHighlight(loct);
			} else if (loctype.equalsIgnoreCase("xp")) {
				loct = driver.findElement(By.xpath(locvalue));
			} else if (loctype.equalsIgnoreCase("lnktxt")) {
				loct = driver.findElement(By.linkText(locvalue));
				// ElementHighlight(loct);
			} else if (loctype.equalsIgnoreCase("name")) {
				loct = driver.findElement(By.name(locvalue));
				// ElementHighlight(loct);
			} else if (loctype.equalsIgnoreCase("partlnktxt")) {
				loct = driver.findElement(By.partialLinkText(locvalue));
				// ElementHighlight(loct);
			} else if (loctype.equalsIgnoreCase("css")) {
				loct = driver.findElement(By.cssSelector(locvalue));
				ElementHighlight(loct);
			} else if (loctype.equalsIgnoreCase("tagname")) {
				loct = driver.findElement(By.tagName(locvalue));
				// ElementHighlight(loct);
			} else if (loctype.equalsIgnoreCase("cn")) {
				loct = driver.findElement(By.className(locvalue));
				// ElementHighlight(loct);
			} else {
				System.out.println("Locaters not matched");
			}
		} catch (ElementNotFoundException e) {
			Reports.fail(e.toString());
			e.printStackTrace();

		}
		return loct;

	}

	/*
	 * public static String getSuccessScreenshot() { try { filepath = null; File
	 * file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	 * filepath = System.getProperty("user.dir") +
	 * "\\Screenshots\\SuccessScreenshot\\" + System.currentTimeMillis() +
	 * ".png"; FileUtils.copyFile(file, new File(filepath)); } catch
	 * (IOException e) { Reports.fail(e.toString()); e.printStackTrace(); }
	 * return filepath; }
	 */

	public static void closeBrowser() throws IOException {
		try {
			Log.info("Closing Browser");
			driver.quit();
			
		} catch (Exception e) {
			Reports.fail(e.toString());
			e.printStackTrace();

		}

	}

	public static String getfailScreenshot() {
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		try {
			filepath = null;
			File file = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			filepath = System.getProperty("user.dir")
					+ "\\Screenshots\\FailedScreenshot\\"
					+ dateFormat.format(date) + ".png";
			FileUtils.copyFile(file, new File(filepath));
		} catch (IOException e) {
			Reports.fail(e.toString());
			e.printStackTrace();
		}
		return filepath;
	}

	public static void ElementHighlight(WebElement element) {
		try {
			((JavascriptExecutor) driver)
					.executeScript(
							"arguments[0].setAttribute('style', 'background:yellow; border:2px solid red;');",
							element);
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			Reports.fail(e.toString());
			e.printStackTrace();
		}
		((JavascriptExecutor) driver)
				.executeScript(
						"arguments[0].setAttribute('style', 'border: solid 2px green ');",
						element);
	}

	/*
	 * public static String getDatetime() { DateFormat dateFormat = new
	 * SimpleDateFormat("yyyy/MM/dd HH:mm:ss"); Date date = new Date(); String
	 * founddate = dateFormat.format(date);
	 * //System.out.println(dateFormat.format(date)); // 2014/08/06 15:59:48
	 * 
	 * String[] parts = founddate.split(" "); // String part1 = parts[0]; // 004
	 * String[] appenderpart1 = parts[0].split("/"); String[] appenderpart2 =
	 * parts[1].split(":"); String appender = appenderpart1[1] +
	 * appenderpart1[2] + appenderpart2[0] + appenderpart2[1] +
	 * appenderpart2[2]; //System.out.println(appender); return appender; }
	 */

	public static void waitElement(WebElement element) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(120, TimeUnit.SECONDS)
				.pollingEvery(300, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);

	}

	/************************ Drop Down handle Method *****************************/

	public static int dropDownhandler(WebElement element, int indexValue,
			String tagType) {
		int listSize = 0;
		try {
			if (tagType.equalsIgnoreCase("li")) {
				List<WebElement> eleCount = element.findElements(By
						.tagName("li"));
				listSize = eleCount.size();
				eleCount.get(indexValue).click();
			} else if (tagType.equalsIgnoreCase("label")) {
				List<WebElement> eleCount = element.findElements(By
						.tagName("label"));
				listSize = eleCount.size();
				eleCount.get(indexValue).click();
			}
		} catch (ElementNotFoundException e) {
			Reports.fail(e.toString());
			e.printStackTrace();

		}

		return listSize;

	}

	/*
	 * public static void dropDownhandler(WebElement element, int indexValue,
	 * String tagType) { try { List<WebElement> eleCount =
	 * element.findElements(By.tagName(tagType));
	 * eleCount.get(indexValue).click(); } catch (ElementNotFoundException e) {
	 * Reports.fail(e.toString()); e.printStackTrace(); } }
	 */

	public static Boolean dropDownHandlerBySelect(WebElement element,
			String visbleText) {
		flag = true;
		try {
			Select sl = new Select(element);
			sl.selectByVisibleText(visbleText);
			flag = true;
		} catch (ElementNotFoundException e) {
			flag = false;
			Reports.fail(e.toString());
			e.printStackTrace();
		}
		return flag;
	}

	public static void dropDownHandlerSelectByIndex(WebElement element,
			int indexValue) {
		try {
			Select sl = new Select(element);
			sl.selectByIndex(indexValue);
		} catch (ElementNotFoundException e) {
			Reports.fail(e.toString());
			e.printStackTrace();
		}
	}

	/************************ Drop Down Count Method *****************************/
	public static int dropDownCount(WebElement element, String tagType) {
		int listSize = 0;
		try {
			if (tagType.equalsIgnoreCase("li")) {
				List<WebElement> eleCount = element.findElements(By
						.tagName("li"));
				listSize = eleCount.size();
			} else if (tagType.equalsIgnoreCase("label")) {
				List<WebElement> eleCount = element.findElements(By
						.tagName("label"));
				listSize = eleCount.size();
			} else if (tagType.equalsIgnoreCase("option")) {
				List<WebElement> eleCount = element.findElements(By
						.tagName("option"));
				listSize = eleCount.size();
			} else if (tagType.equalsIgnoreCase("div")) {
				List<WebElement> eleCount = element.findElements(By
						.tagName("div"));
				listSize = eleCount.size();
			} else if (tagType.equalsIgnoreCase("tr")) {
				List<WebElement> eleCount = element.findElements(By
						.tagName("tr"));
				listSize = eleCount.size();
			}
		} catch (ElementNotFoundException e) {
			Reports.fail(e.toString());
			e.printStackTrace();
		}
		return listSize;
	}

	/************************ Soft Assertion *****************************/
	public static boolean softAssertions(String actualResult,
			String expectedResult) {
		flag = true;
		try {
			SoftAssert s_assert = new SoftAssert();
			System.out.println("Actual Result:--" + actualResult
					+ "Expected Result:--" + expectedResult);
			s_assert.assertEquals(actualResult, expectedResult);
			s_assert.assertAll();
		} catch (ElementNotFoundException e) {
			Reports.fail(e.toString());
			e.printStackTrace();
		}
		return flag;
	}

	/************************ Assertion *****************************/
	public static boolean assertions(String actualResult, String expectedResult) {
		flag = true;
		try {
			System.out.println("Actual Result:--  " + actualResult
					+ "Expected Result:--  " + expectedResult);
			Assert.assertEquals(actualResult, expectedResult);
			flag = true;
		} catch (ElementNotFoundException e) {
			flag = false;
			Reports.fail(e.toString());
			e.printStackTrace();
		}
		return flag;
	}

	/**************************
	 * Explicit Wait * @return
	 * 
	 * @throws InterruptedException
	 ************************/
	public static boolean explicitWait(WebElement element)
			throws InterruptedException {
		flag = false;
		try {
			System.out.println("Explicit wait method");
			WebDriverWait wait = new WebDriverWait(driver, 50);
			// wait.until(ExpectedConditions.visibilityOf(element));
			wait.until(ExpectedConditions.invisibilityOf(element));
			flag = true;
		} catch (Exception e) {
			flag = false;
			Reports.fail(e.toString());
			e.printStackTrace();

		}
		return flag;

	}

	public static void dragAnddropFile(WebElement target, File filePath,
			int offsetX, int offsetY) throws InterruptedException {
		if (!filePath.exists())
			throw new WebDriverException("File not found: "
					+ filePath.toString());

		WebDriver driver = ((RemoteWebElement) target).getWrappedDriver();
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		WebDriverWait wait = new WebDriverWait(driver, 30);
		Thread.sleep(2000);
		String JS_DROP_FILE = "var target = arguments[0],"
				+ "    offsetX = arguments[1],"
				+ "    offsetY = arguments[2],"
				+ "    document = target.ownerDocument || document,"
				+ "    window = document.defaultView || window;"
				+ ""
				+ "var input = document.createElement('INPUT');"
				+ "input.type = 'file';"
				+ "input.style.display = 'none';"
				+ "input.onchange = function () {"
				+ "  var rect = target.getBoundingClientRect(),"
				+ "      x = rect.left + (offsetX || (rect.width >> 1)),"
				+ "      y = rect.top + (offsetY || (rect.height >> 1)),"
				+ "      dataTransfer = { files: this.files };"
				+ ""
				+ "  ['dragenter', 'dragover', 'drop'].forEach(function (name) {"
				+ "    var evt = document.createEvent('MouseEvent');"
				+ "    evt.initMouseEvent(name, !0, !0, window, 0, 0, 0, x, y, !1, !1, !1, !1, 0, null);"
				+ "    evt.dataTransfer = dataTransfer;"
				+ "    target.dispatchEvent(evt);"
				+ "  });"
				+ ""
				+ "  setTimeout(function () { document.body.removeChild(input); }, 25);"
				+ "};" + "document.body.appendChild(input);" + "return input;";
		Thread.sleep(2000);
		WebElement input = (WebElement) jse.executeScript(JS_DROP_FILE, target,
				0, 0);
		input.sendKeys(filePath.getAbsoluteFile().toString());
		wait.until(ExpectedConditions.stalenessOf(input));
	}

	/************************** url* @return ************************/

	public static String currentURL() {
		currentURL = driver.getCurrentUrl();
		return currentURL;

	}

	/******************* Current Date *******************************/
	public static String currentDate() {
		DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd HH-mm-ss");
		Date date = new Date();
		currentDatetime = dateFormat.format(date);
		return currentDatetime;

	}

	/************************** GetText 
	 * @return ************************/

	public static String getText(String valueName) {
		String text = null;
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		String jlocator = "'[name=" + "\"" + "recipientName" + "\"" + "]'";
		if(valueName.equalsIgnoreCase("RecipientName")){
        String script = " return document.querySelectorAll(" + jlocator + ")[0].value";
         text = (String) ((JavascriptExecutor) driver).executeScript(script);}
		else if(valueName.equalsIgnoreCase("RecipientEmail")){
			String script = " return document.getElementsByName('recipientEmail')[0].value";
	        text = (String) ((JavascriptExecutor) driver).executeScript(script);
	        }
		else if(valueName.equalsIgnoreCase("SenderEmail")){
			String script = " return document.getElementsByName('senderEmail')[0].value";
	        text = (String) ((JavascriptExecutor) driver).executeScript(script);
	        }
		return text;
	}
	
	/************************** Scroll window/Div Up/down ************************/

	public static void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,350)", "");

	}

	public static void scrollup() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,-350)");
	}

	public static void scrollDivDown() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.querySelector('.scrollbar.style-3').scrollTop= 500");
			Reports.pass("Successfully scrolldown the div");
			Thread.sleep(1000);
		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot(e.getMessage(), imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}
	}

	public static void scrollDivUP() {
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("document.querySelector('.scrollbar.style-3').scrollTop= 0");
			Reports.pass("Successfully scrollUp the div");
			Thread.sleep(1000);
		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot(e.getMessage(), imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}
	}

	/**************************
	 * Div Scroll Visibility
	 * 
	 * @return
	 ************************/

	public static boolean scrillVisibilityOfDiv() {
		flag = false;
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Boolean b1 = (Boolean) js
					.executeScript("return document.querySelector('.scrollbar.style-3').scrollHeight>document.querySelector('.scrollbar.style-3').clientHeight;");
			if (b1 == true) {
				Reports.pass("Scrollbar is present on page.");
				flag = true;
			} else {
				Reports.info("Scrollbar is not present on page.");
				imagePath = Utility.getfailScreenshot();
				Reports.attachScreenshot("", imagePath);
				flag = false;
			}

		} catch (Exception e) {
			flag = false;
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot(e.getMessage(), imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}
		return flag;
	}

	/************************** Brand,Category and StoreName List Count ************************/
	public static int countOfAvailableCards(WebElement ele) {
		try {
			// WebElement suggestionList1 =
			// Utility.getLocator(KioskLocatorsMapper.searchlistBrandCateoryStoreName);
			List<WebElement> suggestionListCount = ele.findElements(By
					.tagName("li"));
			availabeCardCount = suggestionListCount.size();
			Reports.info("Available list count are ---->" + availabeCardCount);
		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot(e.getMessage(), imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());

		}
		return availabeCardCount;

	}

	/************************** Actions Class Event ************************/

	public static void hoverMouse(WebElement target) {
		ac = new Actions(driver);
		ac.moveToElement(target).perform();

	}

	public static void doubleClick(WebElement target) {
		ac = new Actions(driver);
		ac.doubleClick(target).build().perform();

	}

	/************************
	 * This function is use to check response code of images to validate valid
	 * images
	 ***********/
	public static void validateInvalidImages() {
		try {
			invalidImageCount = 0;
			List<WebElement> imagesList = driver
					.findElements(By.tagName("img"));
			Log.info("Total no. of images are " + imagesList.size());
			Reports.info("Total no. of images are " + imagesList.size());
			for (WebElement imgElement : imagesList) {
				if (imgElement != null) {
					try {
						HttpClient client = HttpClientBuilder.create().build();
						HttpGet request = new HttpGet(
								imgElement.getAttribute("src"));
						HttpResponse response = client.execute(request);
						if (response.getStatusLine().getStatusCode() != 200)
							invalidImageCount++;
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
			Log.info("Total no. of invalid images are " + invalidImageCount);
			Reports.pass("Total no. of invalid images are " + invalidImageCount);
		} catch (Exception e) {
			e.printStackTrace();
			Reports.fail(e.getMessage());
		}

	}

	/*************************
	 * This function is to randomly add a random card or a card of same brand
	 * and denomination
	 *********************************/
	public static void addCards() {
		try {
			for (int i = 1; i <= 5; i++) {
				int k = (i % 2) + 1;
				driver.findElement(
						By.xpath("(//*[@class='mock-button btn btn-outline-secondary'])["
								+ k + "]")).click();
				// driver.findElement(By.xpath("(//*[@class='mock-button btn btn-outline-secondary'])[1]")).click();

			}
			Reports.pass("Successfully added the cards");
			Log.info("Successfully added the cards");
		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}

	}

	/************************* This function is use to add cards same brand and denomination *********************************/
	public static void addSameCards() {
		try {
			for (int i = 1; i <= 5; i++) {
				driver.findElement(
						By.xpath("(//*[@class='mock-button btn btn-outline-secondary'])[1]"))
						.click();
			}
			Reports.pass("Successfully added the cards");
			Log.info("Successfully added the cards");
		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}

	}

	/************************* This function is use to add random cards *********************************/
	public static void addRandomCards() {
		try {
			for (int i = 1; i <= 5; i++) {
				driver.findElement(
						By.xpath("(//*[@class='mock-button btn btn-outline-secondary'])[2]"))
						.click();
			}
			Reports.pass("Successfully added the cards");
			Log.info("Successfully added the cards");
		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}

	}

	/*************************
	 * This function is to fetch registry info
	 * 
	 * @return
	 *********************************/
	public static int addedCardInfo() {
		int amount = 0;
		try {
			List<WebElement> LineTotal = driver.findElements(By
					.className("lineTotalText"));
			System.out.println("Total Added Card is" + LineTotal.size());
			Log.info("Total added cards are" + LineTotal.size());
			for (int j = 1; j <= LineTotal.size(); j++) {
				Thread.sleep(500);
				String dollor = driver.findElement(
						By.xpath("(//*[@class='lineTotalText'])[" + j + "]"))
						.getText();
				Reports.pass(j
						+ "st Line total is -->"
						+ dollor.substring(1)
						+ " and added card quantity is -->"
						+ driver.findElement(
								By.xpath("(//*[@class='qtyText'])[" + j + "]"))
								.getText());
				System.out.println("Conversion in integer"
						+ Integer.parseInt(dollor.substring(1)));
				amount = Integer.parseInt(dollor.substring(1)) + amount;
			}
			Log.info("Total amount is " + amount);
			Reports.pass("Total Line amount is " + amount);

			String[] TodayTotal = driver
					.findElement(By.className("totalAmout")).getText()
					.split(" ");
			System.out.println("Today's Total is -->"
					+ TodayTotal[3].substring(1));
			todaysAmount = Integer.parseInt(TodayTotal[3].substring(1));
			Reports.pass("Today's Total is -->" + TodayTotal[3].substring(1));

			if (amount == todaysAmount) {
				Log.info("Total Line amount and Today's Toatal is same ");
				Reports.pass("Total Line amount and Today's Toatal are same ");
			} else {
				Reports.fail("Total Line amount and Today's Toatal are not same ");
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot(
						"Total Line amount and Today's Toatal are not same ",
						imagePath);
			}
		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}

		return todaysAmount;

	}

	/******************** Todays Total Amount *************************************/
	public static int todaysTotal(WebElement ele) {
		try {
			if (ele.getText().isEmpty()) {
				JavascriptExecutor jse = (JavascriptExecutor) driver;
				String text = (String) jse.executeScript(
						"return arguments[0].text", ele);
				System.out
						.println("getHiddenText------------------------------>"
								+ text);
				String[] TodayTotal = text.split("\\$");
				TodaysTotal = Integer.parseInt(TodayTotal[1]);
			} else {
				System.out.println("getText------------------------------>"
						+ ele.getText());
				String[] TodayTotal = ele.getText().split("\\$");
				TodaysTotal = Integer.parseInt(TodayTotal[1]);
			}
			System.out
					.println("Todays total is --------------------------------------------->"
							+ TodaysTotal);
		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}
		return TodaysTotal;

	}

	/******************** Go Back Functionality *************************************/
	public static int goBackButton(int expectedTodayAmount, WebElement ele,
			String URL) {
		try {
			int actualTodayAmount = todaysTotal(ele);
			if (actualTodayAmount == expectedTodayAmount) {
				Reports.pass("Today's Total is same as on previous screen  --->"
						+ actualTodayAmount);
			} else {
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot(
						"Today's Total is not same as on previous screem ",
						imagePath);
				Reports.fail("Go back button functionality is not working fine");
			}
			if (currentURL().endsWith(URL)) {
				Reports.pass("Go back button functionality working fine");
			} else {
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("", imagePath);
				Reports.fail("Go back button functionality is not working fine");
			}

		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}
		return TodaysTotal;

	}

	/************************* This function is to Remove the added Cards *********************************/
	public static void removeSomeAddedCards() {
		try {
			List<WebElement> addedCard = driver.findElements(By
					.xpath("//div[@class='card-icon']"));
			if (addedCard.size() < 1) {
				System.out.println("Added card count are ------------>"
						+ addedCard.size());
				Reports.pass("No card is avilable to remove");
			} else {
				System.out.println("Calling function to add more card");
				addSameCards();
				List<WebElement> addedCards = driver.findElements(By
						.xpath("//div[@class='card-icon']"));
				Reports.info("Added Cards count are ------------->"
						+ addedCards.size());
				for (int i = 1; i <= addedCards.size() - 3; i++) {
					driver.findElement(By.xpath("//div[@class='card-icon']"))
							.click();
				}
				List<WebElement> availableCards = driver.findElements(By
						.xpath("//div[@class='card-icon']"));
				Reports.info("Available cards count after removed some cards are ------------->"
						+ availableCards.size());
			}
		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}

	}

	/************************* This function is to Remove all the added Cards *********************************/
	public static void removeAllAddedCards() {
		try {
			List<WebElement> addedCard = driver.findElements(By
					.xpath("//div[@class='card-icon']"));
			Reports.info("Added Card count are --->" + addedCard.size());
			for (int i = 1; i <= addedCard.size(); i++) {
				driver.findElement(By.xpath("//div[@class='card-icon']"))
						.click();
			}
			Reports.pass("Successfully removed all added cards");
		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}

	}

	/***************** URL Validation ***************************************************/

	public static boolean urlVerification(String ExpectedResult)
			throws IOException {
		flag = false;
		Log.info("Verifing the URL of Navigated Page");
		try {
			String URL = driver.getCurrentUrl();
			Log.info("Current URL is :- " + URL);
			if (URL.endsWith(ExpectedResult)) {
				Log.info("Url Matched with navigated page");
				Reports.pass("As Expected user navigated  -----> " + URL);
				flag = true;
			} else {
				flag = false;
				Reports.fail("User is unable to navigated on expected page");
				Log.fail("User is unable to navigated on expected page");
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("", imagePath);
			}

		} catch (Exception e) {
			flag = false;
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot(e.getMessage(), imagePath); 
			e.printStackTrace();
			Utility.closeBrowser();
		}
		return flag;
	}

	/*************************
	 * This function is use to perform touch/click operation
	 * 
	 * @return
	 * @throws InterruptedException
	 *********************************/

	public static boolean touchEvent(WebElement target)
			throws InterruptedException {
		flag = false;
		try {
			// Single Tab
			target.click();
			flag = true;
			Thread.sleep(1000 / 2);
			// if (driver instanceof HasTouchScreen) {
			// TouchActions tap = new TouchActions(driver).singleTap(target);
			// tap.build().perform();
			// flag= true;
			// } else {
			// flag= true;
			// target.click();
			// }
		} catch (NoSuchElementException e) {
			e.printStackTrace();
			Reports.fail(e.getMessage());
		}
		return flag;
	}

	/******************** Todays Total Amount *************************************/
	public static String hiddenElementEvent(WebElement ele) {
		try {
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			hiddenText = (String) jse.executeScript("return arguments[0].text",
					ele);
			Log.info("Hidden Text is ------------->" + hiddenText);

		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}
		return hiddenText;

	}

	/******************** Logo Validation *************************************/
	public static void logoFunctionality() {
		try {
			touchEvent(driver.findElement(By.className("logo")));
			Reports.pass("User Successfully clicked on logo");
			Log.info("User Successfully clicked on logo");
			if (Utility.currentURL().endsWith("/home")) {
				Reports.pass("User Successfully Navigated on Home Page");
				Log.info("User Successfully Navigated on Home Page");
			} else {
				Reports.fail("User unable to redirected on Home Page");
				Log.info("User unable to redirected on Home Page");
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("Execption Occured", imagePath);
			}
		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}

	}

	/******************** this function is return the min and max value of variable screen *************************************/

	public static int[] infoMinMax() throws InterruptedException {
		try {
			String minMaxStr = Utility.getLocator(
					KioskLocatorsMapper.minMaxString).getText();
			Log.info("On Range page,Card Min and Max values are as  ------>  "
					+ minMaxStr);
			System.out
					.println("On Range page,Card Min and Max values are as  ------>  "
							+ minMaxStr);
			minvalueRetrun = stringToInteger(minMaxStr);
			Log.info("Min value is ---->" + minvalueRetrun[0]
					+ "Max value is ---->" + minvalueRetrun[1]);
			System.out.println("Min value is ---->" + minvalueRetrun[0]
					+ "Max value is ---->" + minvalueRetrun[1]);
		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot("Execption Occured", imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}
		return minvalueRetrun;

	}

	/******************** This function is return the min and max value of variable screen *************************************/
	public static int[] stringToInteger(String minMaxString) {
		try {
			String value[] = minMaxString.split(" ");
			Log.info("Converted Min value is ------------->"
					+ value[1].substring(1));
			Log.info("Converted Min value is ------------->"
					+ value[4].substring(1));
			System.out.println("Converted Min value is ------------->"
					+ value[1].substring(1));
			System.out.println("Converted Min value is ------------->"
					+ value[4].substring(1));
			minValue = Integer.parseInt(value[1].substring(1));
			maxValue = Integer.parseInt(value[4].substring(1));
			Reports.pass("On Range Page,Min value is ------------->" + minValue);
			Reports.pass("On Range Page,max value is ------------->" + maxValue);
			System.out.println("On Range Page,Min value is ------------->"
					+ minValue);
			System.out.println("On Range Page,max value is ------------->"
					+ maxValue);
			// minMaxValue = { minValue, maxValue };

		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot(e.toString(), imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}
		int[] minMaxValue = { minValue, maxValue };
		return minMaxValue;

	}

	/**********************
	 * This function is Generate Random number between Min and Max value on
	 * Range page
	 ***********************************************/

	public static int gengrateRandomValidNumber(int[] minvalueRetrun2) {
		try {
			Random random = new Random();
			int num = random.nextInt(100);
			Reports.pass("Random Code generated:---------->" + num);
			if (num > minvalueRetrun2[0] && num < minvalueRetrun2[1]) {
				validRandomNumber = num;
				Reports.pass("Generated Random number is between Min and Max value ---->"
						+ validRandomNumber);
			} else {
				Reports.pass("Generated Random number is not between Min and Max value, So Again function called to Genetrate the Random number");
				gengrateRandomValidNumber(minvalueRetrun);
			}
		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot(e.toString(), imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}
		return validRandomNumber;
	}

	/**********************
	 * This function is Generate Random number which is Grater then Max Value of
	 * Range page
	 ***********************************************/

	public static int generateRandomNumberGreaterThenMaxValue(
			int[] minvalueRetrun2) {
		try {
			Random random = new Random();
			int num = random.nextInt(900) + 100;
			Reports.pass("Generate Random Number:---------->" + num);
			if (num > minvalueRetrun2[1]) {
				validRandomNumber = num;
				Reports.pass("Successfully Generated the Number which is Grater then Max Value --------> "
						+ validRandomNumber);
			} else {
				Reports.pass("Generated Random number is not greater then Max value on range page ---->"
						+ validRandomNumber
						+ "So Again function called to Genetrate the Random number");
				generateRandomNumberGreaterThenMaxValue(minvalueRetrun);
			}
		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot(e.toString(), imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}
		return validRandomNumber;
	}

	/**********************
	 * This function is Generate Random number which is less then Min Value of
	 * Range page
	 ***********************************************/

	public static int generateRandomNumberlessThenMinValue(int[] minvalueRetrun2) {

		try {
			Random random = new Random();
			int num = random.nextInt(10) + 1;
			Reports.pass("Generate Random Number---------->" + num);
			if (num < minvalueRetrun2[1]) {
				validRandomNumber = num;
				Reports.pass("Successfully Generated the Number which is less then Min Value of Range Page --------> "
						+ validRandomNumber);
			} else {
				Reports.pass("Generated Random number is not less then Min value of range page, So Again function called to Genetrate the Random number");
				generateRandomNumberlessThenMinValue(minvalueRetrun);
			}
		} catch (Exception e) {

			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot(e.toString(), imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}
		return validRandomNumber;
	}

	/************************************ This function enter the value using virtual Numpad ***********************************/

	public static void keypad(int value) throws InterruptedException {
		try {
			String Digit = String.valueOf(value);
			int DigitLenght = Digit.length();
			Log.info("Lenght of Amount which you want to enter are/is ------>"
					+ DigitLenght);
			if (Digit.length() == 2) {
				String FirstDigit = Digit.charAt(0) + "";
				String SecoundDigit = Digit.charAt(1) + "";
				Log.info("1st Digit is -------->" + FirstDigit);
				Log.info("2nd Digit is -------->" + SecoundDigit);

				WebElement ele = driver.findElement(By
						.className("Calculator_Slot"));
				List<WebElement> keypadButton = ele.findElements(By
						.tagName("button"));
				Log.info("Keypad Button count are  -------->"
						+ keypadButton.size());
				for (int k = 0; k < keypadButton.size() - 1; k++) {
					if (keypadButton.get(k).getText().equals(FirstDigit)) {
						keypadButton.get(k).click();
						Reports.pass("User Successfully Enter the 1st digit of amount is --------->"
								+ keypadButton.get(k).getText());
						break;
					}
				}
				for (int j = 0; j < keypadButton.size() - 1; j++) {
					if (keypadButton.get(j).getText().equals(SecoundDigit)) {
						keypadButton.get(j).click();
						Reports.pass("User Successfully Enter the 2nd digit of amount is --------->"
								+ keypadButton.get(j).getText());
						break;
					}
				}
			} else if (Digit.length() == 1) {
				String FirstDigit = Digit.charAt(0) + "";
				Log.info("Amount to be Enter is  -------->" + FirstDigit);
				WebElement ele = driver.findElement(By
						.className("Calculator_Slot"));
				List<WebElement> keypadButton = ele.findElements(By
						.tagName("button"));
				Log.info("Keypad Button Count are  -------->"
						+ keypadButton.size());
				for (int k = 0; k < keypadButton.size() - 1; k++) {
					System.out.println(keypadButton.get(k).getText());
					if (keypadButton.get(k).getText().equals(FirstDigit)) {
						keypadButton.get(k).click();
						Reports.pass("User Successfully Enter the 1st digit of amount is--------->"
								+ keypadButton.get(k).getText());
						break;
					}
				}
			} else if (Digit.length() == 3) {
				String FirstDigit = Digit.charAt(0) + "";
				String SecoundDigit = Digit.charAt(1) + "";
				String ThridDigit = Digit.charAt(2) + "";
				Log.info("1st Didit of amount to be enter is-------->"
						+ FirstDigit);
				Log.info("2nd Didit of amount to be enter is -------->"
						+ SecoundDigit);

				WebElement ele = driver.findElement(By
						.className("Calculator_Slot"));
				List<WebElement> keypadButton = ele.findElements(By
						.tagName("button"));
				Log.info("KeypadButton size is  -------->"
						+ keypadButton.size());
				for (int k = 0; k < keypadButton.size() - 1; k++) {
					System.out.println(keypadButton.get(k).getText());
					if (keypadButton.get(k).getText().equals(FirstDigit)) {
						keypadButton.get(k).click();
						Reports.pass("User Successfully Enter the 1st digit of amount is --------->"
								+ keypadButton.get(k).getText());
						break;
					}
				}
				for (int j = 0; j < keypadButton.size() - 1; j++) {
					System.out.println(keypadButton.get(j).getText());
					if (keypadButton.get(j).getText().equals(SecoundDigit)) {
						keypadButton.get(j).click();
						Reports.pass("User Successfully Enter the 2nd digit of amount is --------->"
								+ keypadButton.get(j).getText());
						break;
					}
				}
				for (int j = 0; j < keypadButton.size() - 1; j++) {
					System.out.println(keypadButton.get(j).getText());
					if (keypadButton.get(j).getText().equals(ThridDigit)) {
						keypadButton.get(j).click();
						Reports.pass("User Successfully Enter the 3rd digit of amount is --------->"
								+ keypadButton.get(j).getText());
						break;
					}
				}

			} 
			else{
				Reports.fail("Entered Amount is more then three digit, The value of entered Amount is ---->" +value);
				Log.info("Entered Amount is more then three digit, The value of entered Amount is ---->" +value);
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("", imagePath);

			}

		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot(e.toString(), imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}

	}

	/*********** This function is validate the Cross button functionality previously ****************************/

	public static void CrossButtonFunctionality() {
		try {
			// Calling
			minvalueRetrun = infoMinMax();
			randdomNUM = generateRandomNumberGreaterThenMaxValue(minvalueRetrun);
			keypad(randdomNUM);
			// Check the Cross button functionality of Keypad
			String enteredValue = driver
					.findElement(By.className("amountCard")).getText();
			Reports.info("Entered Amount is -------->" + enteredValue);
	//Click on Cross Button to clear the entered amount
			keyPadHandler(11);
			if(driver.findElement(By.className("amountCard")).getText().equalsIgnoreCase("$0")){

				Reports.pass("User Successfully clear the Entered value after click on cross button ");
			} else {
				Reports.fail("Cross button function is now working ");
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("", imagePath);
			}

		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot(e.toString(), imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}

	}

	
/***************************This function enter the amount as per your parameter on Range page *******************/	
	public static void keyPadHandler(int digit ) throws InterruptedException{
		try{
		WebElement ele = driver.findElement(By.className("Calculator_Slot"));
		List<WebElement> keypadButton = ele.findElements(By.tagName("button"));
		keypadButton.get(digit).click();
		//Reports.pass("User Successfully Tap on ----->" +keypadButton.get(digit).getText() +   "    button");
		
		Thread.sleep(2000);
		}catch(Exception e){
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot(e.toString(), imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}
	}

	/***************** This function is check the Arrow button functionality ******************************/
	public static void arrowButtonFunctionality() {
		try {

			minvalueRetrun = infoMinMax();
			randdomNUM = generateRandomNumberGreaterThenMaxValue(minvalueRetrun);
			keypad(randdomNUM);
			// Check the Cross button functionality of Keypad
			String enteredValue = Utility.getLocator(
					KioskLocatorsMapper.enteredAmountValue).getText();
			Reports.info("Entered Amount is -------->" + enteredValue);
			// Click on Cross Button to clear the entered amount
			keyPadHandler(9);
			if (enteredValue.length() == Utility
					.getLocator(KioskLocatorsMapper.enteredAmountValue)
					.getText().length() + 1) {
				Reports.pass("User Successfully removed the last digit of entered amount");
				Reports.pass("Visible amount after removed the last digit is ----->"
						+ driver.findElement(By.className("amountCard"))
								.getText());
			} else {
				Reports.fail("Arrow button is unable to removed the last digit");
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("", imagePath);
			}

		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot(e.toString(), imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}
	}

	/**************************** This function is check the error message functionality ************************/

	public static void errorMessageHanlderOnVariableRangeCard() {
		try {
//			minvalueRetrun = infoMinMax();
//			randdomNUM = generateRandomNumberGreaterThenMaxValue(minvalueRetrun);
//			keypad(randdomNUM);
			// Check the Cross button functionality of Keypad
			String enteredValue = Utility.getLocator(
					KioskLocatorsMapper.enteredAmountValue).getText();

			Reports.info("Entered Amount is -------->" + enteredValue);
			// Clicked on Next Button
			driver.findElement(By.xpath("//*[text()='Next']")).click();
			if (driver.findElement(By.xpath("//span[@class='bgred']"))
					.getText().equals("Invalid Amount!")) {
				Reports.pass("As Expected,Error Message is displayed as --->"
						+ driver.findElement(By.xpath("//span[@class='bgred']"))
								.getText());
				if (driver.findElement(By.xpath("//span[@class='bgred']"))
						.getCssValue("color")
						.equalsIgnoreCase("rgba(255, 0, 0, 1)")) {
					Reports.pass("As Expected.Text Color is Red and RGB is --->"
							+ driver.findElement(
									By.xpath("//span[@class='bgred']"))
									.getCssValue("color"));
				} else {
					Reports.fail("Color of Error Message is not matched");
					imagePath = Utility.getfailScreenshot();
					Reports.attachfailScreenshot("", imagePath);
				}
			} else {
				Reports.fail("Error Message is not displayed");
				imagePath = Utility.getfailScreenshot();
				Reports.attachfailScreenshot("", imagePath);
			}
		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot(e.toString(), imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}

	}

	/************** This function is to test the A-Z Alphabetically sorting order ***************/

	public static void aToZAlphSortingValidation() throws InterruptedException {
		try {
			ArrayList<String> obtainedList = new ArrayList<String>();
			WebElement ele = Utility
					.getLocator(KioskLocatorsMapper.searchlistBrandCateoryStoreName);
			List<WebElement> elementList = ele.findElements(By.tagName("li"));
			Reports.info("Count of total visible cards are---------->"
					+ elementList.size());
			for (int i = 0; i < elementList.size(); i++) {
				String s = elementList.get(i).getText();
				obtainedList.add(s);
			}
			Log.info("Obtaned list before sort ---->>>" + obtainedList);

			ArrayList<String> sortedList = new ArrayList<String>();
			for (String s : obtainedList) {
				sortedList.add(s);
			}
			Collections.sort(sortedList);
			Collections.sort(obtainedList);
			Log.info("Obtaned list after sort ---->>>" + obtainedList);
			Iterator itr = sortedList.iterator();
			while (itr.hasNext()) {
				String s = (String) itr.next();
				Log.info(s);
			}
			Assert.assertTrue(sortedList.equals(obtainedList));
			Reports.pass("As Expected ,-->Category are visible in A-Z sorted way");
		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot(e.toString(), imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}
	}

	/************** This function is to handle Range/Denomination Page ***************/
	public static void clickOnFixedRangePage() {

		try {
			if (driver.getCurrentUrl().endsWith("/fix-denomination")) {
				Reports.pass("User navigated on Fixed Denomination Page");
				WebElement denominationContainer = driver.findElement(By
						.xpath("(//div[@class='row'])[3]"));
				List<WebElement> denominatiaon = denominationContainer
						.findElements(By.tagName("span"));
				Reports.info("Total Available Cards of 'Fix-Denomination' are -----------> "
						+ denominatiaon.size());
				for (int i = 0; i < denominatiaon.size(); i++) {
					Reports.info(+i + 1 + " - Card Denomination is ----->"
							+ denominatiaon.get(i).getText());
				}

				// Clicked on 1st card
				denominatiaon.get(0).click();
				Reports.pass("User Successfully clicked on 1st denomination card");
				Reports.info("User Successfully added a card in cart");

			} else {
				if (driver.getCurrentUrl().endsWith("/variable-amount")) {
					Reports.pass("User naaviged on Range page");
					minvalueRetrun = infoMinMax();
					randdomNUM = gengrateRandomValidNumber(minvalueRetrun);
					keypad(randdomNUM);
					touchEvent(Utility
							.getLocator(KioskLocatorsMapper.nextButton));
					Reports.pass("User Successfully Clicked on Next Button");
					Reports.info("User Successfully added a card in cart");
				} else {
					Reports.fail("User Unable to navigaed on Range/Fixed Denomination Page");
					imagePath = Utility.getfailScreenshot();
					Reports.attachfailScreenshot("", imagePath);
				}
			}
		} catch (Exception e) {
			imagePath = Utility.getfailScreenshot();
			Reports.attachfailScreenshot(e.toString(), imagePath);
			e.printStackTrace();
			Reports.fail(e.toString());
		}
	}
	
	
	/************************This function return size of webelements*****************************************/

	public static int getsize(String key) {
		int count = 0;
		try {

			String[] locaterarray = key.split("##");
			locvalue = locaterarray[0];
			loctype = locaterarray[1];
		} catch (ArrayIndexOutOfBoundsException e) {
			Reports.fail(e.toString());
			e.printStackTrace();
		}

		try {
			if (loctype.equalsIgnoreCase("xp")) {
				count = driver.findElements(By.xpath(locvalue)).size();
			}
		} catch (ElementNotFoundException e) {
			Reports.fail(e.toString());
			e.printStackTrace();

		}

		return count;

	}
	
	/************************This function return Amount of Fixed Card*****************************************/
	public static int addFixedAmountCard(int size) throws InterruptedException, IOException{
		// TODO Auto-generated method stub
		Random random = new Random();
		int f=0;
		while (f != 1) {
			int index = random.nextInt(10);
			if (index>=1 && index <=size) {
				Reports.info("Generated denomiation index : " + index);
				Log.info("Generated denomiation index : " + index);
				AmountFixdenomination = Utility.todaysTotal(Utility.getLocator("(//*[@class=' cardText'])["+index+"]##xp")); 
				Reports.info("Amount on index "+index+ " : " + AmountFixdenomination);
				Log.info("Amount on index "+index+ " : " + AmountFixdenomination); 
				Utility.touchEvent(Utility.getLocator("(//*[@class=' cardText'])["+index+"]##xp"));
				Reports.pass("User successfully clicked on $ " + AmountFixdenomination + " on Fixed Denomination page");
				Log.info("User successfully clicked on $ " + AmountFixdenomination + " on Fixed Denomination page");
				assertTrue(Utility.urlVerification("card-send/cart"));
				Reports.pass("User Successfully navigated on Cart Screen");	
				f++;
			}
			else
			{
				Log.info("Calling Function to Generate Random Number");
			}
		}
		return AmountFixdenomination;
		
	}
	
	 /***************************This function is to remove the first card from the card list in cart *******************/ 

    public static void removeSingleCard(){ 
            try { 
                    driver.findElement(By.xpath("//div[@class='card-icon']")).click(); 
            } 
            catch(Exception e){ 
                    imagePath = Utility.getfailScreenshot(); 
                    Reports.attachfailScreenshot(e.toString(), imagePath); 
                    e.printStackTrace(); 
                    Reports.fail(e.toString()); 
            } 
    }



	


}
