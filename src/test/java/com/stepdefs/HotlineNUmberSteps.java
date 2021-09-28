package com.stepdefs;

import com.pages.Homepage;
import com.settings.RunFeatures;

import cucumber.api.java.en.*;
import junit.framework.Assert;

public class HotlineNUmberSteps extends RunFeatures{
	
	Homepage homepage = new Homepage(driver);
	
	@SuppressWarnings("deprecation")
	@Given("^User is on Homepage$")
	public void user_is_on_Homepage() {
	   Assert.assertTrue("User is not on Homepage", homepage.homePageisDisplayed());
	}

	@Then("^User must be able to view the Hotline number option$")
	public void user_must_be_able_to_view_the_Hotline_number_option() {
		 homepage.verifyHotline();
	    
	}

}
