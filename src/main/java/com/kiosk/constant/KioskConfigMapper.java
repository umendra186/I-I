package com.kiosk.constant;

import java.util.Properties;

import com.kiosk.utility.Utility;

public class KioskConfigMapper {
	static Properties kioskConfig = Utility.loadProperty(Constant.config_kiosk);

	public static String URL = kioskConfig.getProperty("URL");
	public static String browser = kioskConfig.getProperty("browser");

}
