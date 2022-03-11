package com.pages;

import org.openqa.selenium.support.PageFactory;

import com.settings.RunFeatures;
import com.utility.Common;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;

public class EmergencyNotificationPage extends RunFeatures{
	
	Common common = new Common();
	
	@iOSXCUITFindBy(id = "Patient's name_textField")
	private MobileElement patientName;
	
	@iOSXCUITFindBy(id = "Choose a patient type_textField")
	private MobileElement patientType;
	
	@iOSXCUITFindBy(id = "Adult")
	private MobileElement adultPatientType;
	
	@iOSXCUITFindBy(id = "Pediatric")
	private MobileElement pediatricPatientType;
	
	@iOSXCUITFindBy(id = "Choose an emergency location_overlayButton")
	private MobileElement emergencyLocation;
	
	@iOSXCUITFindBy(id = "Manhattan")
	private MobileElement Manhatten;
	
	@iOSXCUITFindBy(id = "Brooklyn")
	private MobileElement Brooklyn;
	
	@iOSXCUITFindBy(id = "Long Island")
	private MobileElement LongIsland;
	
	@iOSXCUITFindBy(id = "Ronald O. Perelman Center for Emergency Services")
	private MobileElement Perelmanlocation;
	
	@iOSXCUITFindBy(id = "Samuels Orthopedic Immediate Care Center")
	private MobileElement SamuelsLocation;
	
	@iOSXCUITFindBy(id = "KiDS Emergency Department")
	private MobileElement KidsEmergencyDeptLocation;
	
	@iOSXCUITFindBy(id = "Emergency Department at NYU Langone Hospital—Brooklyn")
	private MobileElement EmergencyDeptBrooklynLocation;
	
	@iOSXCUITFindBy(id = "NYU Langone Health—Cobble Hill")
	private MobileElement CobbleHillLocation;
	
	@iOSXCUITFindBy(id = "Emergency Department at NYU Langone Hospital—Long Island")
	private MobileElement EmergencyDeptLILocation;
	
	@iOSXCUITFindBy(id = "Patient's age_textField")
	private MobileElement PatientAgeField;
	
	@iOSXCUITFindBy(id = "Tell us about the emergency")
	private MobileElement EmergencyField;
	
	@iOSXCUITFindBy(id = "Primary contact's name_textField")
	private MobileElement PrimaryNameField;
	
	@iOSXCUITFindBy(id = "Primary contact's email or phone_textField")
	private MobileElement PrimaryContactField;
	
	@iOSXCUITFindBy(id = "Submit")
	private MobileElement submitButton;
	
	public EmergencyNotificationPage(AppiumDriver<MobileElement> driver)  {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	
	public void enterPatientName(String PatientName) {
		common.explicitWait_Clickable(patientName, 10);
		patientName.click();
		patientName.clear();
		patientName.sendKeys(PatientName);
	}
	
	public void choosePatientType(String PatientType) {
		patientType.click();
		if(PatientType.equals("Adult"))
		{
		adultPatientType.click();
		}
		else
		pediatricPatientType.click();
	}
	
	public void chooseLocation() {
		emergencyLocation.click();
		
	}
	
	public void clickCity(String CityName) {
		if(CityName.equals("Manhattan"))
		{
		common.explicitWait_Clickable(Manhatten, 10);
		Manhatten.click();
		}
		else if(CityName.equals("Brooklyn"))
		{
			common.explicitWait_Clickable(Brooklyn, 10);
			Brooklyn.click();
		}
		else if(CityName.equals("Long Island"))
				{
			common.explicitWait_Clickable(LongIsland, 10);
			LongIsland.click();
				}
	}
	
	public void Locationclick(String LocationName) {
		if(LocationName.equals("Ronald O. Perelman Center for Emergency Services"))
		{
		common.explicitWait_Clickable(Perelmanlocation, 10);
		Perelmanlocation.click();
		}
		else if(LocationName.equals("Samuels Orthopedic Immediate Care Center"))
		{
			common.explicitWait_Clickable(SamuelsLocation, 10);
			SamuelsLocation.click();
		}
		else if(LocationName.equals("KiDS Emergency Department"))
		{
			common.explicitWait_Clickable(KidsEmergencyDeptLocation, 10);
			KidsEmergencyDeptLocation.click();
		}
		else if(LocationName.equals("Emergency Department at NYU Langone Hospital—Brooklyn"))
		{
			common.explicitWait_Clickable(EmergencyDeptBrooklynLocation, 10);
			EmergencyDeptBrooklynLocation.click();
		}
		else if(LocationName.equals("NYU Langone Health—Cobble Hill"))
		{
			common.explicitWait_Clickable(CobbleHillLocation, 10);
			CobbleHillLocation.click();
		}
		else if(LocationName.equals("Emergency Department at NYU Langone Hospital—Long Island"))
		{
			common.explicitWait_Clickable(EmergencyDeptLILocation, 10);
			EmergencyDeptLILocation.click();
		}
	}
	
	public void enterPatientAge(String PatientAge) {
		common.explicitWait_Clickable(PatientAgeField, 10);
		PatientAgeField.click();
		PatientAgeField.clear();
		PatientAgeField.sendKeys(PatientAge);
	}
	
	public void enterPatientEmergency(String PatientEmergency) {
		common.explicitWait_Clickable(EmergencyField, 10);
		EmergencyField.click();
		EmergencyField.clear();
		EmergencyField.sendKeys(PatientEmergency);
	}
	
	public void enterPrimaryName(String PrimaryName) {
		common.explicitWait_Clickable(PrimaryNameField, 10);
		PrimaryNameField.click();
		PrimaryNameField.clear();
		PrimaryNameField.sendKeys(PrimaryName);
	}
	
	public void enterPrimaryContact(String PrimaryContact) {
		common.explicitWait_Clickable(PrimaryContactField, 10);
		PrimaryContactField.click();
		PrimaryContactField.clear();
		PrimaryContactField.sendKeys(PrimaryContact);
	}
	
	public void clickSubmit() {
		submitButton.click();
	}
}
