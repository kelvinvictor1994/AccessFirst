package com.pages;

import org.openqa.selenium.support.PageFactory;

import com.settings.RunFeatures;
import com.utility.Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class PasswordHelpPage extends RunFeatures{
	
	Common common = new Common();
	
	@iOSXCUITFindBy(xpath ="//XCUIElementTypeStaticText[@name=\"Having trouble logging in? We can email you instructions to reset your password.\"]")
	private MobileElement passwordhelppage;
	
	@iOSXCUITFindBy(id = "Invalid username or password.")
	private MobileElement InvalidUserMsg;
	
	@iOSXCUITFindBy(id ="txt_email")
	private MobileElement Passwordresetfield;
	
	@iOSXCUITFindBy(id ="btn_submit")
	private MobileElement Submitbutton;
	
	@iOSXCUITFindBy(id ="Go back to the login page")
	private MobileElement backtoHomepage;
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeStaticText[@name=\"Success\"]")
	private MobileElement successpopup;
	
	@iOSXCUITFindBy(id = "OK")
	private MobileElement successpopupDismiss;
	
	public PasswordHelpPage (AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void enteremailid(String emailid) {
		Passwordresetfield.click();
		Passwordresetfield.clear();
		Passwordresetfield.sendKeys(emailid);
	}
	
	public void clickSubmit() {
		passwordhelppage.click();
		Submitbutton.click();
	}
	
	public void invalidUserMsg() {
		common.explicitWait_Displayed(InvalidUserMsg, 10);
		InvalidUserMsg.isDisplayed();
	}
	
	public void passwordresetSuccessfull() {
		common.explicitWait_Displayed(successpopup, 10);
		successpopup.isDisplayed();
		successpopupDismiss.click();
		
	}
	
	public void clickbacktoHomepage() {
		backtoHomepage.click();
	}
	

}
