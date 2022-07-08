package org.example.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.pages.LoginPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class Currency {

    HomePage homePage;
    LoginPage loginPage;
    Select select;

    @Given("User log in with email {string} and password {string}")
    public void user_log_in_with_email_and_password(String email, String password) {
        homePage = new HomePage(Hooks.driver);
        homePage.getLoginLink().click();
        loginPage = new LoginPage(Hooks.driver);
        loginPage.getEmailTxtField().sendKeys(email);
        loginPage.getPasswordTxtField().sendKeys(password);
        loginPage.getLoginBtn().click();
    }
    @When("User select euro currency from drop down menu")
    public void user_select_euro_currency_from_drop_down_menu() {
        homePage = new HomePage(Hooks.driver);
        select = new Select(homePage.getCurrencyDropDownMenu());
        select.selectByVisibleText("Euro");
    }
    @Then("All items prices change to euro")
    public void all_items_prices_change_to_euro() {
        homePage = new HomePage(Hooks.driver);
        List<WebElement> prices = homePage.getPrices();
        for(WebElement price : prices){
            Assert.assertTrue(price.getText().contains("€"));
        }
    }

}
