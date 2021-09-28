package com.stepdefs;

import com.pages.LoginPage;
import com.pages.PasswordHelpPage;
import com.settings.RunFeatures;

import cucumber.api.java.en.*;

public class InvalidUserPHSteps extends RunFeatures{
	
	LoginPage login = new LoginPage(driver);
	PasswordHelpPage passwordhelp = new PasswordHelpPage(driver);
	
	@Given("^The user is on the AccessFirst Login Page$")
	public void the_user_is_on_the_AccessFirst_Login_Page() {
	   login.AccessFirstLogoispresent();
	}

	@When("^user clicks on Password Help option$")
	public void user_clicks_on_Password_Help_option() {
		login.clickPasswordHelp();
	   
	}

	@And("^enters email address as (.*)$")
	public void enters_email_address(String emailid) {
		passwordhelp.enteremailid(emailid);
	   
	}

	@And("^clicks on submit button$")
	public void clicks_on_submit_button() {
		passwordhelp.clickSubmit();
	    
	}

	@Then("^the User must get a proper error message$")
	public void the_User_must_get_a_proper_error_message() {
	    passwordhelp.invalidUserMsg();
	    passwordhelp.clickbacktoHomepage();
	}

}
