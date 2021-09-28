package com.stepdefs;

import com.pages.Homepage;
import com.pages.HospitalTransferPage;
import com.settings.RunFeatures;

import cucumber.api.java.en.*;
import junit.framework.Assert;

public class HospitalTransferSteps extends RunFeatures{
	
	HospitalTransferPage hospitaltransfer = new HospitalTransferPage(driver);
	Homepage homepage = new Homepage(driver);
	String hospitalTransfersuccessmessage = "";
	
	@SuppressWarnings("deprecation")
	@Given("^The user is on Homepage$")
	public void the_user_is_on_Homepage(){
		Assert.assertTrue("user is not on the Homepage", homepage.homePageisDisplayed());
	    
	}
	
	@And("^The user clicks on Hospital transfer option$")
	public void the_user_clicks_on_Hospital_transfer_option(){
		homepage.clickHospitalTransfer();
	    
	}

	@SuppressWarnings("deprecation")
	@Then("^The user must land on Successfull transfer page$")
	public void the_user_must_land_on_Successfull_transfer_page() {
		Assert.assertTrue("Hospital transfer was not successfull", hospitaltransfer.transferSuccessisDisplayed());
		homepage.clickHomeButton();
		
	}

}
