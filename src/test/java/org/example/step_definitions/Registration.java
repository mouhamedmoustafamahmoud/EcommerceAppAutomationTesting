package org.example.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.pages.RegistrationPage;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class Registration {

    HomePage homePage;
    RegistrationPage registrationPage;
    Select select;
    SoftAssert softAssert = new SoftAssert();


    @Given("User open registration page")
    public void user_open_registration_page() {
        homePage = new HomePage(Hooks.driver);
        homePage.getRegisterLink().click();
    }

    @When("User enter gender type")
    public void userEnterGenderType() {
        registrationPage = new RegistrationPage(Hooks.driver);
        if (!registrationPage.getMaleGenderRadioBtn().isSelected()) {
            registrationPage.getMaleGenderRadioBtn().click();
        }

    }

    @And("User enter first name {string} and last name {string}")
    public void userEnterFirstNameAndLastName(String firstName, String lastName) {
        registrationPage.getFirstNameTxtField().sendKeys(firstName);
        registrationPage.getLastNameTxtField().sendKeys(lastName);
    }

    @And("User select date of birth")
    public void userSelectDateOfBirth() {
        select = new Select(registrationPage.getDayBirthDropDownMenu());
        select.selectByValue("23");
        select = new Select(registrationPage.getMonthBirthDropDownMenu());
        select.selectByIndex(11);
        select = new Select(registrationPage.getYearBirthDropDownMenu());
        select.selectByValue("1992");

    }

    @And("User enter email {string}")
    public void userEnterEmail(String email) {
        registrationPage.getEmailTxtField().sendKeys(email);
    }

    @And("User enter password fields {string}")
    public void userEnterPasswordFields(String password) {
        registrationPage.getPasswordTxtField().sendKeys(password);
        registrationPage.getConfirmPasswordTxtField().sendKeys(password);
    }

    @And("User click on register button")
    public void user_click_on_register_button() {
        registrationPage.getRegisterBtn().click();
    }

    @Then("success registration message appears")
    public void success_registration_message_appears() {
        registrationPage = new RegistrationPage(Hooks.driver);
        softAssert.assertTrue(registrationPage.getMessage().getText().contains("Your registration completed"));
        softAssert.assertEquals(registrationPage.getMessage().getCssValue("color"),
                "rgba(76, 177, 124, 1)"); // Green
    }

    @And("User click on continue button to return to home page")
    public void user_click_on_continue_button_to_return_to_home_page() {
        registrationPage.getContinueBtn().click();
        softAssert.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/");
        softAssert.assertAll();
    }


}
