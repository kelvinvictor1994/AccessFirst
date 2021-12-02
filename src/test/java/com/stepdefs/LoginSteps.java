package com.stepdefs;

import com.pages.Homepage;
import com.pages.LoginPage;
import com.pages.OtpValidationPage;
import com.pages.PasswordHelpPage;
import com.settings.RunFeatures;

import com.utility.EmailUtility;
import com.utility.FAMApi;
import cucumber.api.java.en.*;

public class LoginSteps extends RunFeatures{
	LoginPage login = new LoginPage(driver);
	PasswordHelpPage passwordhelp = new PasswordHelpPage(driver);
	Homepage homepage = new Homepage(driver);
	OtpValidationPage otp = new OtpValidationPage(driver);

	@Given("^The User launches the app$")
	public void the_User_launches_the_app() {
		login.AccessFirstLogoispresent();

	}

	@And("^Enters the username as (.*)$")
	public void enters_the_username(String username){
	    login.enterusername(username);
	   
	}

	@And("^Enters the password as (.*)$")
	public void enters_the_password(String password){
	    login.enterpassword(password);
	    
	}

	@And("^user clicks on Login button$")
	public void user_clicks_on_Login_button() {
	    login.clicklogin();
	    //login.allowPermissions();
	    
	}
	
	@And("^user enters a valid otp from their mail id$")
	public void user_enters_a_valid_otp_from_their_mail_id() throws Exception{
	    otp.enterOtp();
	}
	
	@And("^user allows the permission for contacts and location$")
	public void user_allows_the_permission_for_contacts_and_location() {
		login.allowPermissions();
	}
	
	@Then("^the user must land successfully on the Homepage$")
	public void the_user_must_land_successfully_on_the_Homepage() {
		homepage.homePageisDisplayed();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
