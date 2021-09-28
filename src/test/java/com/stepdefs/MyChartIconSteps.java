package com.stepdefs;

import com.pages.Homepage;
import com.settings.RunFeatures;

import cucumber.api.java.en.*;
import junit.framework.Assert;

public class MyChartIconSteps extends RunFeatures{
	
	Homepage homepgae = new Homepage(driver);
	
	@SuppressWarnings("deprecation")
	@Given("^User is already on Hompage$")
	public void user_is_already_on_Hompage() {
		Assert.assertTrue("User is not on Homepage", homepgae.homePageisDisplayed());
	   
	}

	@Then("^User must be able to verify the Mychart Icon$")
	public void user_must_be_able_to_verify_the_Mychart_Icon() {
		homepgae.verifyMyChartIcon();
	   
	}

}
