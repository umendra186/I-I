package com.kiosk.constant;

import java.util.Properties;

import com.kiosk.utility.Utility;

public class KioskLocatorsMapper {

	
	static Properties kioskRepository = Utility.loadProperty(Constant.locator_kiosk);
	
	//GLobal Page 
	public static String appLogo = kioskRepository.getProperty("appLogo");
	public static String buyCard = kioskRepository.getProperty("buyCard");
	public static String sendACard = kioskRepository.getProperty("sendACard");
	public static String scanCardButton = kioskRepository.getProperty("scanCardButton");
	public static String buyButton = kioskRepository.getProperty("buyButton");
	public static String cancelButton = kioskRepository.getProperty("cancelButton");
	public static String emailEGiftPickUp = kioskRepository.getProperty("emailEGiftPickUp");
	public static String storeName = kioskRepository.getProperty("storeName");
	public static String brandButton = kioskRepository.getProperty("brandButton");
	public static String quickSelect = kioskRepository.getProperty("quickSelect");

	
	//Scan Prompt screen
	public static String goBackScanPromptScreen = kioskRepository.getProperty("goBackScanPromptScreen");
	public static String pickCardPlaceHolder = kioskRepository.getProperty("pickCardPlaceHolder"); 
    public static String scanCardPlaceHolder = kioskRepository.getProperty("scanCardPlaceHolder");
    public static String buyButtonScanPromptScreen = kioskRepository.getProperty("buyButtonScanPromptScreen");
	public static String brandText = kioskRepository.getProperty("brandText");
	public static String storeNameText = kioskRepository.getProperty("storeNameText"); 
    public static String scanText = kioskRepository.getProperty("scanText");
    public static String categoryText = kioskRepository.getProperty("categoryText");

	
	//Adding Cards
	public static String scanMore = kioskRepository.getProperty("scanMore");
	public static String addRandomCard = kioskRepository.getProperty("addRandomCard");
	public static String addCard = kioskRepository.getProperty("addCard");
	public static String brandName = kioskRepository.getProperty("brandName");
	public static String denomination = kioskRepository.getProperty("denomination");
	public static String quantity = kioskRepository.getProperty("quantity");
	public static String lineTotal = kioskRepository.getProperty("lineTotal");
	public static String todaystotal = kioskRepository.getProperty("todaystotal");
	public static String addedCards = kioskRepository.getProperty("addedCards");
	public static String variableAmountCard = kioskRepository.getProperty("variableAmountCard");
	public static String fixAmountCard = kioskRepository.getProperty("fixAmountCard");

	//Tender Screen
	public static String todaysTotalTender = kioskRepository.getProperty("todaysTotalTender");
	public static String goBackButtonTender = kioskRepository.getProperty("goBackButtonTender");
	public static String todayTotalTextTender = kioskRepository.getProperty("todayTotalTextTender");
	public static String cashButton = kioskRepository.getProperty("cashButton");
	public static String tenderLabel = kioskRepository.getProperty("tenderLabel");
	public static String todaysTotalText = kioskRepository.getProperty("todaysTotalText");
	public static String creditCardText = kioskRepository.getProperty("creditCardText");
	public static String debitCardText = kioskRepository.getProperty("debitCardText");
	public static String cashText = kioskRepository.getProperty("cashText");
	public static String mobileWalletText = kioskRepository.getProperty("mobileWalletText");


	
	//Payment Screen
	public static String status = kioskRepository.getProperty("status");
	public static String postStatus1 = kioskRepository.getProperty("postStatus1");
	public static String postStatus2 = kioskRepository.getProperty("postStatus2");
	public static String creditCardButton = kioskRepository.getProperty("creditCardButton");
	public static String debitCardButton = kioskRepository.getProperty("debitCardButton");
	public static String mobileWalletCardButton = kioskRepository.getProperty("mobileWalletCardButton");	
	
	//Credit Card
	public static String todaysTotalCC = kioskRepository.getProperty("todaysTotalCC");
	public static String goBackButtonCC = kioskRepository.getProperty("goBackButtonCC");
	
	//Range Page
	public static String minMaxString = kioskRepository.getProperty("minMaxString");
	public static String enteredAmountValue = kioskRepository.getProperty("enteredAmountValue");
	public static String nextButton = kioskRepository.getProperty("nextButton");
	public static String IntailAmountOnRangePage = kioskRepository.getProperty("IntailAmountOnRangePage");

	
	//Search Page
	public static String searchlistBrandCateoryStoreName = kioskRepository.getProperty("searchlistBrandCateoryStoreName");
	public static String category = kioskRepository.getProperty("category");
	public static String brand = kioskRepository.getProperty("brand");

	
	//#eGift/Pickup
	public static String email = kioskRepository.getProperty("email");
	public static String kioskpickup = kioskRepository.getProperty("kioskpickup");
	public static String emailDef = kioskRepository.getProperty("emailDef");
	public static String kioskpickupDef = kioskRepository.getProperty("kioskpickupDef");
	
	//#eGift/Pickup
	public static String fixedCards = kioskRepository.getProperty("fixedCards");
	public static String fixedDenCount = kioskRepository.getProperty("fixedDenCount");
	public static String cardFigure = kioskRepository.getProperty("cardFigure");

	
	//Personalization Screen
	public static String mockButtonToMoveOnPersonalizationPage = kioskRepository.getProperty("mockButtonToMoveOnPersonalizationPage");
	public static String recipientName = kioskRepository.getProperty("recipientName");
	public static String senderEmailErrorMsg = kioskRepository.getProperty("senderEmailErrorMsg");
	public static String recipientEmailErrorMsg = kioskRepository.getProperty("recipientEmailErrorMsg");	
	public static String recipientNameErrorMsg = kioskRepository.getProperty("recipientNameErrorMsg");
	public static String recipientEmailInputBox = kioskRepository.getProperty("recipientEmailInputBox");
	public static String senderEmailInputBox = kioskRepository.getProperty("senderEmailInputBox");



	//Cash payment screen
	public static String billTender1 = kioskRepository.getProperty("billTender1");
	public static String billTender2 = kioskRepository.getProperty("billTender2");
	public static String cashPostStatus1 = kioskRepository.getProperty("cashPostStatus1");
	public static String cashPostStatus2 = kioskRepository.getProperty("cashPostStatus2");
	public static String cashTotal = kioskRepository.getProperty("cashTotal");
	
	//Email Failure Screen
	public static String Oops = kioskRepository.getProperty("Oops");
	public static String wrongEmailMessage = kioskRepository.getProperty("wrongEmailMessage");
	public static String recipientEmail = kioskRepository.getProperty("recipientEmail");
	public static String reciverEmail = kioskRepository.getProperty("reciverEmail");	

		
	//Error Screen
	public static String sorryMessage = kioskRepository.getProperty("sorryMessage");
	public static String reversalMessage = kioskRepository.getProperty("reversalMessage");
	public static String moreInfo = kioskRepository.getProperty("moreInfo");
	
	//Success Screen
	public static String successMessage = kioskRepository.getProperty("successMessage");
	public static String successEmailMessage = kioskRepository.getProperty("successEmailMessage");
	public static String successRecieptMessage = kioskRepository.getProperty("successRecieptMessage");





		
}
