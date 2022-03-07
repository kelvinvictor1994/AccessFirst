package com.stepdefs;

import com.pages.EmergencyNotificationPage;
import com.pages.Homepage;
import com.pages.NotificationSubmitPage;
import com.settings.RunFeatures;

import cucumber.api.java.en.*;
import junit.framework.Assert;

public class EmergncyNotificationSteps extends RunFeatures{
	
	Homepage homepage = new Homepage(driver);
	EmergencyNotificationPage emergencynotification = new EmergencyNotificationPage(driver);
	NotificationSubmitPage submitnotification = new NotificationSubmitPage(driver);
	
	@SuppressWarnings("deprecation")
	@Given("^The user is on the Homepage$")
	public void the_user_is_on_the_Homepage() {
		Assert.assertTrue("user is not on the Homepage", homepage.homePageisDisplayed());
	   
	}

	@When("^clicks on emergency notification$")
	public void clicks_on_emergency_notification(){
		homepage.clickEmergencyNotification();	   
	}

	@And("^user enters the patients name as (.*)$")
	public void user_enters_the_patient_s_name(String PatientName) {
		emergencynotification.enterPatientName(PatientName);
	    
	}

	@And("^user selects patient type as (.*)$")
	public void user_selects_patient_type(String PatientType) {
		emergencynotification.choosePatientType(PatientType);
	}

	@And("^user chooses an emergency location as (.*) and (.*)$")
	public void user_chooses_an_emergency_location(String CityName, String Location) {
		emergencynotification.chooseLocation();
		emergencynotification.clickCity(CityName);
		emergencynotification.Locationclick(Location);
	    
	}
	
	@And("^user enters patient age as (.*)$")
	public void user_enters_the_patient_age(String PatientAge) {
		emergencynotification.enterPatientAge(PatientAge);
	    
	}
	
	@And("^user enters Emergency as (.*)$")
	public void user_enters_emergency_as(String PatientEmergency) {
		emergencynotification.enterPatientEmergency(PatientEmergency);
	    
	}
	
	@And("^user enters primary contact name as (.*)$")
	public void user_enters_primary_contact_name_as(String PrimaryName) {
		emergencynotification.enterPrimaryName(PrimaryName);
	    
	}
	
	@And("^user enters primary contact as (.*)$")
	public void user_enters_primary_contact_as(String PatientContact) {
		emergencynotification.enterPrimaryContact(PatientContact);
	    
	}

	@And("^user clicks on submit$")
	public void user_clicks_on_submit() {
	    emergencynotification.clickSubmit();
		//homepage.clickHomeButton();
	    
	}
	
	@Then("^user must land on Notification successfully submitted page (.*)$")
	public void user_lands_on_successfull_notification_submission_page(String Location) {
		//submitnotification.AccessFirstLogoispresent();
		submitnotification.getLocationName(Location);
		submitnotification.verifyViewLocationGetDirection();

	    homepage.clickHomeButton();
	}

}
