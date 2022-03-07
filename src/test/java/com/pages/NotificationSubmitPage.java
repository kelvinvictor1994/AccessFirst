package com.pages;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import com.settings.RunFeatures;
import com.utility.Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class NotificationSubmitPage extends RunFeatures{
	
	@iOSXCUITFindBy(xpath = "//XCUIElementTypeButton[@name=\"Prepare for Your Visit \"]")
	private MobileElement prepareVisit;

	@iOSXCUITFindBy(id = "heartLogo")
	private MobileElement accessFirstIcon;

	@iOSXCUITFindBy(id = "View Location & Get Directions")
	private MobileElement ViewLocationGetDirection;

	@iOSXCUITFindBy(id = "hospitalName")
	private MobileElement locationName;

	public NotificationSubmitPage(AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

/*	public boolean verifyPrepareVisit() {
			boolean retValue = false;
			try {
				retValue = Common.explicitWait_Displayed(prepareVisit, 10).isDisplayed();
			} catch (Exception e) {
				System.out.println("Notification is not submitted successfully");
				retValue = false;
			}
			return retValue;
		}*/

	public void AccessFirstLogoispresent() {
		Common.explicitWait_Displayed(accessFirstIcon,10);
		accessFirstIcon.isDisplayed();
	}

	public boolean verifyViewLocationGetDirection() {
		boolean retValue = false;
		try {
			retValue = Common.explicitWait_Displayed(ViewLocationGetDirection, 10).isDisplayed();
		} catch (Exception e) {
			System.out.println("Notification is not submitted successfully");
			retValue = false;
		}
		return retValue;
	}

	public boolean getLocationName(String Location) {


		String locName = locationName.getText();
		//String locName = staticLocationName.getText();

		System.out.println("in app location is "+locName);
		System.out.println("feature file location is "+Location);
		return locName.equals(Location);
	}

}
