package com.stepdefs;

import com.pages.LoginPage;
import com.pages.PasswordHelpPage;
import com.settings.RunFeatures;
import com.utility.Common;

import com.utility.FAMApi;
import cucumber.api.java.en.*;
import gherkin.lexer.Fa;

public class FAMActivationSteps extends RunFeatures{
    String sessionID;
    FAMApi fam = new FAMApi();
    Common common = new Common();

    @Given("^The user logs into FAM$")
    public void The_user_logs_into_FAM(){
        sessionID = fam.loginToFam();
    }

    @And("^The user sends an activation email$")
    public void The_user_sends_an_activation_email()  {
        System.out.println(sessionID);
        common.simpleWait(1000);
        fam.disableMember(sessionID);
        common.simpleWait(1000);
        System.out.println(sessionID);
        fam.sendActivationLink(sessionID);
        common.simpleWait(1000);
        fam.logout(sessionID);
    }

    @Then("^The user sets up a password for AccessFirst$")
    public void The_user_sets_up_a_password_for_AccessFirst(){
        fam.createPassword();
    }

}
