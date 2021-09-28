package com.stepdefs;

import com.pages.LoginPage;
import com.settings.RunFeatures;

import cucumber.api.java.en.*;

public class InvalidUserLoginSteps extends RunFeatures{
	
	LoginPage login = new LoginPage(driver);
	
	@Given("^The User has launched the app$")
	public void the_User_has_launched_the_app() {
		login.AccessFirstLogoispresent();
	    
	}

	@And("^Enters the userid as (.*)$")
	public void enters_the_userid(String emailid) {
		login.enterusername(emailid);
	    
	}

	@And("^Enters password as (.*)$")
	public void enters_password(String password) {
		login.enterpassword(password);
	   
	}

	@And("^clicks on Login button$")
	public void clicks_on_Login_button() {
		login.clicklogin();
	   
	}

	@Then("^The User must see the invalid credentials error message$")
	public void the_User_must_see_the_invalid_credentials_error_message() {
		login.invalidUserMsgDisplayed();
	    
	}


}
