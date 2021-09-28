package com.pages;

import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

import com.settings.RunFeatures;
import com.utility.Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class Homepage extends RunFeatures{
	
	Common common = new Common();
	
	@iOSXCUITFindBy(id = "For serious medical emergencies, or an ambulance, call 911.")
	private MobileElement homePage;
	
	@iOSXCUITFindBy(id = "btn_emergency")
	private MobileElement emergencyNotification;
	
	@iOSXCUITFindBy(id = "btn_non_emergrncy")
	private MobileElement hospitalTransfer;
	
	@iOSXCUITFindBy(id = "tab_home")
	private MobileElement Homebutton;
	
	@iOSXCUITFindBy(id = "tab_waittime")
	private MobileElement waitTimeButton;
	
	@iOSXCUITFindBy(id = "tab_hotline")
	private MobileElement hotLineButton;
	
	@iOSXCUITFindBy(id = "tab_mychart")
	private MobileElement myChartButton;
	
	public Homepage (AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public boolean homePageisDisplayed() {
		boolean retValue = false;
		try {
			retValue = Common.explicitWait_Displayed(homePage, 10).isDisplayed();
		} catch (Exception e) {
			System.out.println("Home page is not displayed");
			retValue = false;
		}
		return retValue;
	}
	
	public void clickEmergencyNotification() {
		emergencyNotification.click();
	}
	
	public void clickHospitalTransfer() {
		hospitalTransfer.click();
	}
	
	public void clickHomeButton() {
		Homebutton.click();
	}
	
	public void clickWaitTime() {
		waitTimeButton.click();
	}
	
	public void verifyHotline() {
		hotLineButton.isDisplayed();
	}
	
	public void verifyMyChartIcon() {
		myChartButton.isDisplayed();
	}
	
	

}
