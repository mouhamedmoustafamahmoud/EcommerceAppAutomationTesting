package org.example.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.pages.ShoesCategoryPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class Filter {

    HomePage homePage;
    ShoesCategoryPage shoesCategoryPage;
    Actions actions;
    int productsNumberBeforeFilter = 0;

    @And("User navigate to category which has filter color options for its products")
    public void user_navigate_to_category_which_has_filter_color_options_for_its_products() {
        homePage = new HomePage(Hooks.driver);
        actions = new Actions(Hooks.driver);
        actions.moveToElement(homePage.getApparelLink()).
                moveToElement(homePage.getShoesLink()).
                click().build().perform();
    }
    @When("User select a specific color from options")
    public void user_select_a_specific_color_from_options() throws InterruptedException {
        shoesCategoryPage = new ShoesCategoryPage(Hooks.driver);
        productsNumberBeforeFilter = shoesCategoryPage.getProducts().size();
        System.out.println("Before Filter : " + productsNumberBeforeFilter);
        shoesCategoryPage.getRedColorCheckBox().click();
        Thread.sleep(4000);
    }
    @Then("Category products will change to be for that color only")
    public void category_products_will_change_to_be_for_that_color_only() {
        shoesCategoryPage = new ShoesCategoryPage(Hooks.driver);
        System.out.println("After Filter : " + shoesCategoryPage.getProducts().size());
        Assert.assertTrue(shoesCategoryPage.getProducts().size() != productsNumberBeforeFilter);
    }
}
