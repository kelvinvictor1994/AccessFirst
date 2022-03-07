package com.settings;

import java.net.URL;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.JUnitCore;
import org.junit.runner.RunWith;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.cucumber.listener.Reporter;
//import com.github.mkolisnyk.cucumber.runner.AfterSuite;
//import com.github.mkolisnyk.cucumber.runner.ExtendedCucumber;
//import com.github.mkolisnyk.cucumber.runner.ExtendedCucumberOptions;
import com.utility.AppiumServerInitiallization;
import com.utility.EmailUtility;
import com.utility.PropertyReader;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;


//@RunWith(ExtendedCucumber.class)
//@ExtendedCucumberOptions(jsonReport = "Reports/cucumber.json", retryCount = 0,
//						detailedReport = true, detailedAggregatedReport = true, overviewReport = true, 
//						coverageReport = true, featureOverviewChart = true, 
//						//jsonUsageReport = "Reports/cucumber-usage.json", usageReport = true, 
//						screenShotLocation = "Reports/", screenShotSize = "300px", toPDF = true, outputFolder = "Reports")
//@CucumberOptions(features = { "src/test/resources/Features" } , glue = {"com/stepdefs"}, tags = "@Regression3",
//				plugin = {"html:Reports/LoginReport", "json:Reports/cucumber.json"})

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features", glue = { "com/stepdefs" }, plugin = {
		"com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/AccessFirst.html" }, monochrome = true, tags = "@Regression7")




public class RunFeatures {

	public static AppiumDriver<MobileElement> driver;
	public static DesiredCapabilities capabilities;
	
	public static AppiumServiceBuilder builder;
	public static AppiumDriverLocalService service;
	
	static PropertyReader prop = new PropertyReader();
	static EmailUtility email = new EmailUtility();
	static AppiumServerInitiallization appiumserver = new AppiumServerInitiallization();
	
		
	public static String udidvalue = prop.properyReader("udid");
	public static String deviceName = prop.properyReader("deviceName");
	public static String platformNameValue = prop.properyReader("platformName");
	public static String platformVersionvalue = prop.properyReader("platformVersion");
	public static String appPathvalue = prop.properyReader("appPath");
	public static String appPackagevalue = prop.properyReader("appPackage");
	public static String appActivityvalue = prop.properyReader("appActivity");
	public static String avdvalue = prop.properyReader("simulatorName");

	public static void main(String[] args) {
		JUnitCore runner = new JUnitCore();
		runner.run(com.settings.RunFeatures.class);
		email.SendEmail();

	}
	
	@BeforeClass
	public static void DriverSetup() throws Exception {
		capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", deviceName);
		capabilities.setCapability("udid", udidvalue);
		capabilities.setCapability("platformName", platformNameValue);
		capabilities.setCapability("platformVersion", platformVersionvalue);
		capabilities.setCapability("noReset", false);
		//capabilities.setCapability("locationServicesEnabled", true);
		capabilities.setCapability("locationServicesAuthorized", true);
		//capabilities.setCapability("waitForQuiescence","false");
		
		
		String userdir = System.getProperty("user.dir");
		capabilities.setCapability("app", userdir+appPathvalue);

		
		appiumserver.startServer();
		driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub") ,capabilities);


	}

	@AfterClass
	public static void DriverTearDown() {
		driver.quit();
		appiumserver.stopServer();
		String userdir = System.getProperty("user.dir");
		Reporter.loadXMLConfig(userdir+"/configs/extent-config.xml");
		
	}
	
}

