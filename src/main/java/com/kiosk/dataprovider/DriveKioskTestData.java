package com.kiosk.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.kiosk.constant.Constant;
import com.kiosk.utility.ExcelUtils;

public class DriveKioskTestData {

	@DataProvider(name = "SignInAdminUser")
	public static Object[][] ReadExcelData() throws IOException {
		Object[][] data = ExcelUtils.readData(Constant.tc_data_path,
				"SignInAdminUser");
		return data;
	}

	
	@DataProvider(name = "InvalidCredentail")
	public static Object[][] ReadExcelDataInvalidCredential() throws IOException {
		Object[][] data = ExcelUtils.readData(Constant.tc_data_path,
				"InvalidCredentail");
		return data;
	}
	
	@DataProvider(name = "Credentials")
	public static Object[][] ReadExcelDataCredential() throws IOException {
		Object[][] data = ExcelUtils.readData(Constant.tc_data_path,
				"Credentials");
		return data;
	}
	
	@DataProvider(name = "ResetButton")
	public static Object[][] ReadExcelResetButton() throws IOException {
		Object[][] data = ExcelUtils.readData(Constant.tc_data_path,
				"ResetButton");
		return data;
	}
	
	@DataProvider(name = "SignInNormalUser")
	public static Object[][] ReadExcelSignInNormalUser() throws IOException {
		Object[][] data = ExcelUtils.readData(Constant.tc_data_path,
				"SignInNormalUser");
		return data;
	}
	
	
}
