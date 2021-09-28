package com.pages;

import org.openqa.selenium.support.PageFactory;

import com.settings.RunFeatures;
import com.utility.Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class HospitalTransferPage extends RunFeatures{
	
	@iOSXCUITFindBy(id ="success_msg")
	private MobileElement transferSuccess;
	
	public HospitalTransferPage (AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator (driver), this);
	}
	
	public boolean transferSuccessisDisplayed() {
		boolean retValue = false;
		try {
			retValue = Common.explicitWait_Displayed(transferSuccess, 10).isDisplayed();
		} catch (Exception e) {
			System.out.println("Hospital Transfer is not successfull");
			retValue = false;
		}
		return retValue;
	}
		
}
