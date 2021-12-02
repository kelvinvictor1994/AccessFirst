package com.pages;

import com.utility.Common;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.PageFactory;

import com.settings.RunFeatures;
import com.utility.EmailUtility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class OtpValidationPage extends RunFeatures{
	
	EmailUtility email = new EmailUtility();
	Common common = new Common();

	@iOSXCUITFindBy(id = "txt_email")
	private MobileElement otpTextField;
	
	@iOSXCUITFindBy(id = "Submit")
	private MobileElement submitButton;
	
	public OtpValidationPage (AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void enterOtp() throws Exception {
		common.explicitWait_Clickable(otpTextField,10);
		otpTextField.click();
		otpTextField.clear();
		String otp = email.searchEmails();
		otpTextField.sendKeys(otp);
		otpTextField.sendKeys(Keys.ENTER);
		//submitButton.click();
	}
}
