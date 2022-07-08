package org.example.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.example.pages.PasswordRecoveryPage;
import org.testng.asserts.SoftAssert;

public class PasswordRecovery {

    HomePage homePage;
    LoginPage loginPage;
    PasswordRecoveryPage passwordRecoveryPage;
    SoftAssert softAssert = new SoftAssert();


    @Given("User at login page")
    public void user_at_login_page() {
        homePage = new HomePage(Hooks.driver);
        homePage.getLoginLink().click();
    }

    @When("User click on forgot password link")
    public void user_click_on_forgot_password_link() {
        loginPage = new LoginPage(Hooks.driver);
        loginPage.getForgotPasswordLink().click();
    }

    @And("User enter valid email {string}")
    public void user_enter_valid_email(String name) {
        passwordRecoveryPage = new PasswordRecoveryPage(Hooks.driver);
        passwordRecoveryPage.getEmailTxtField().sendKeys(name);
    }

    @And("User click on recover button")
    public void user_click_on_recover_button() {
        passwordRecoveryPage.getRecoverBtn().click();
    }

    @Then("message appears tell user that an email has been sent to him")
    public void message_appears_tell_user_that_an_email_has_been_sent_to_him() {
        passwordRecoveryPage = new PasswordRecoveryPage(Hooks.driver);
        softAssert.assertTrue(passwordRecoveryPage.getNotificationBar().getText().
                contains("Email with instructions has been sent to you."));

        softAssert.assertEquals(passwordRecoveryPage.getSuccessNotification().
                getCssValue("background-color"), "rgba(75, 176, 122, 1)"); // Green
        softAssert.assertAll();
        passwordRecoveryPage.getNotificationCloseBtn().click();

    }

    @Then("message appears tell user this email is not found")
    public void messageAppearsTellUserThisEmailIsNotFound() {
        passwordRecoveryPage = new PasswordRecoveryPage(Hooks.driver);
        softAssert.assertTrue(passwordRecoveryPage.getNotificationBar().getText().contains("Email not found."));
        softAssert.assertEquals(passwordRecoveryPage.getErrorNotification().
                getCssValue("background-color"), "rgba(228, 68, 76, 1)"); // Red
        softAssert.assertAll();
        passwordRecoveryPage.getNotificationCloseBtn().click();
    }
}
