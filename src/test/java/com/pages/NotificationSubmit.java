package com.pages;

import org.openqa.selenium.support.PageFactory;

import com.settings.RunFeatures;
import com.utility.Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class NotificationSubmit extends RunFeatures{
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Prepare for Your Visit \"]")
	private MobileElement prepareVisit;
	
	public NotificationSubmit (AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public boolean verifyPrepareVisit() {
			boolean retValue = false;
			try {
				retValue = Common.explicitWait_Displayed(prepareVisit, 10).isDisplayed();
			} catch (Exception e) {
				System.out.println("Notification is not sbumitted successfully");
				retValue = false;
			}
			return retValue;
		}
	
}
