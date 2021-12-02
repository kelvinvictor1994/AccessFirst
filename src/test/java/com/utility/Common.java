package com.utility;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.settings.RunFeatures;

import io.appium.java_client.MobileElement;

public class Common extends RunFeatures {
	
	public static void simpleWait(int millisec) {
		try {
			Thread.sleep(millisec);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static MobileElement explicitWait_Clickable(MobileElement reqValue, int reqTime) {
		WebDriverWait wait = new WebDriverWait(driver, reqTime);
		return (MobileElement) wait.until(ExpectedConditions.elementToBeClickable(reqValue));
	}

	public static MobileElement explicitWait_Displayed(MobileElement reqValue, int reqTime) {
		WebDriverWait wait = new WebDriverWait(driver, reqTime);
		return (MobileElement) wait.until(ExpectedConditions.visibilityOf(reqValue));
	}
	
	
}
