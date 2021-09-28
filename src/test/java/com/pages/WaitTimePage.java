package com.pages;

import org.openqa.selenium.support.PageFactory;

import com.settings.RunFeatures;
import com.utility.Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class WaitTimePage extends RunFeatures{
	
	Common common = new Common();
	
	@iOSXCUITFindBy(id = "txt_wait_time")
	private MobileElement waittime;
	
	public WaitTimePage (AppiumDriver<MobileElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public String displayedWaitTime() {
		common.explicitWait_Displayed(waittime, 10);
		String waititimevalue = waittime.getAttribute("value");
		return waititimevalue;
	}
}
