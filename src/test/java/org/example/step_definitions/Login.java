package org.example.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.openqa.selenium.support.Color;
import org.testng.asserts.SoftAssert;

public class Login {

    HomePage homePage;
    LoginPage loginPage;
    SoftAssert softAssert = new SoftAssert();

    @Given("User open login page")
    public void user_open_login_page() {
        homePage = new HomePage(Hooks.driver);
        homePage.getLoginLink().click();
    }
    @When("User enter email {string} and password {string}")
    public void user_enter_email_and_password(String email, String password) {
       loginPage = new LoginPage(Hooks.driver);
       loginPage.getEmailTxtField().sendKeys(email);
       loginPage.getPasswordTxtField().sendKeys(password);
    }
    @And("User click on login button")
    public void user_click_on_login_button() {
        loginPage.getLoginBtn().click();
    }
    @Then("User login successfully and return to home page")
    public void user_login_successfully_and_return_to_home_page() {
        homePage = new HomePage(Hooks.driver);
        softAssert.assertTrue(homePage.getMyAccountLink().isDisplayed());
        softAssert.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
        softAssert.assertAll();
    }

    @Then("User login failed and error message appears")
    public void userLoginFailedAndErrorMessageAppears() {
        loginPage = new LoginPage(Hooks.driver);
        softAssert.assertTrue(loginPage.getErrorMessage().getText().contains("Login was unsuccessful"));
        softAssert.assertEquals((Color.fromString(loginPage.getErrorMessage().getCssValue("color")).asHex()),
                "#e4434b");
        softAssert.assertAll();
    }
}
