package com.kiosk.constant;

public class Constant {

	public static final String locator_kiosk = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\objectRepository\\KioskLocators.properties";

	public static final String tc_data_path = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\testdata\\ExcelData\\TCData.xlsx";

	public static final String screenshot_fail = System.getProperty("user.dir")
			+ "\\Screenshots\\FailedScreenshot";

	// public static final String Screenshot_pass =
	// System.getProperty("user.dir") +"\\Screenshots\\SuccessScreenshot";

	public static final String report_html = System.getProperty("user.dir")
			+ "\\ExecutionReports\\Reports.html";

	public static final String chromeDriver_path = System
			.getProperty("user.dir") + "\\Drivers\\chromedriver.exe";

	public static final String ieDriver_path = System.getProperty("user.dir")
			+ "\\Drivers\\IEDriverServer.exe";
	public static final String ffDriver_path = System.getProperty("user.dir")
			+ "\\Drivers\\geckodriver.exe";

	public static final String config_kiosk = System.getProperty("user.dir")
			+ "\\src\\test\\resources\\objectRepository\\KioskConfig.properties";

	public static final String kiosk_configMapper = System
			.getProperty("user.dir")
			+ "\\src\\main\\java\\com\\dish\\constant\\KioskConfigMapper.java";

}
