package com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.settings.RunFeatures;
import com.utility.Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSBy;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class LoginPage extends RunFeatures{
	
	Common common = new Common();
	
	@iOSXCUITFindBy(id = "Login")
	private MobileElement loginbutton;
	
	@iOSXCUITFindBy(id = "txt_email")
	private MobileElement emailfield;
	
	@iOSXCUITFindBy(id = "txt_password")
	private MobileElement passwordfield;
	
	@iOSXCUITFindBy(id = "Allow While Using App")
	private MobileElement locationallowbtn;
	
	@iOSXCUITFindBy(id = "OK")
	private MobileElement Contactsallowbtn;
	
	@iOSXCUITFindBy(id = "heartLogo")
	private MobileElement accessFirstIcon;
	
	@iOSXCUITFindBy(id="Invalid username or password.")
	private MobileElement InvalidCredMsg;
	
	@iOSXCUITFindBy(id = "Password Help")
	private MobileElement passwordHelplink;
	
	public LoginPage (AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void AccessFirstLogoispresent() {
		accessFirstIcon.isDisplayed();
	}
	
	public void enterusername (String username)
	{
		emailfield.click();
		emailfield.clear();
		emailfield.sendKeys(username);
	}
	
	public void enterpassword (String password) 
	{
		passwordfield.click();
		passwordfield.clear();
		passwordfield.sendKeys(password);
		accessFirstIcon.click();
	}
	
	public void clicklogin() {
		common.explicitWait_Clickable(loginbutton, 10);
		loginbutton.click();
		
	}
	
	public void allowPermissions() {
		common.explicitWait_Displayed(locationallowbtn, 10);
		locationallowbtn.click();
		common.explicitWait_Displayed(Contactsallowbtn, 10);
		Contactsallowbtn.click();
	}
	
	public void invalidUserMsgDisplayed() {
		common.explicitWait_Displayed(InvalidCredMsg, 10);
		InvalidCredMsg.isDisplayed();
	}
	
	public void clickPasswordHelp() {
		passwordHelplink.click();
		
	}
}
