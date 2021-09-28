package com.stepdefs;

import com.pages.LoginPage;
import com.pages.PasswordHelpPage;
import com.settings.RunFeatures;
import com.utility.Common;

import cucumber.api.java.en.*;

public class PasswordResetSteps extends RunFeatures{
	
	LoginPage login = new LoginPage(driver);
	PasswordHelpPage passwordhelp = new PasswordHelpPage(driver);

@Given("^The user has launched the AccessFirst app$")
public void the_user_has_launched_the_AccessFirst_app(){
	login.AccessFirstLogoispresent();
}

@When("^user clicks on Password Help$")
public void user_clicks_on_Password_Help()  {
	login.clickPasswordHelp();

}

@And("^enters the email address (.*)$")
public void enters_the_email_address(String emailid){
	passwordhelp.enteremailid(emailid);
	
}

@And("^clicks on submit$")
public void clicks_on_submit(){
	passwordhelp.clickSubmit();
}

@Then("^user gets a success message about their password reset$")
public void user_gets_a_success_message_about_their_password_reset(){
	passwordhelp.passwordresetSuccessfull();
	passwordhelp.clickbacktoHomepage();
}

}
