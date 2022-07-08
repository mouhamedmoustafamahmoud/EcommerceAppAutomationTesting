package org.example.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.pages.ProductDetailsPage;
import org.example.pages.SearchPage;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class Search {

    HomePage homePage;
    SearchPage searchPage;
    ProductDetailsPage productDetailsPage;
    SoftAssert softAssert = new SoftAssert();


    @When("User enter a product name {string} in search text field")
    public void user_enter_a_product_name_in_search_text_field(String name) {
        homePage = new HomePage(Hooks.driver);
        homePage.getSearchTxtField().sendKeys(name);
    }

    @When("User enter a product sku {string} in search text field")
    public void user_enter_a_product_sku_in_search_text_field(String sku) {
        homePage = new HomePage(Hooks.driver);
        homePage.getSearchTxtField().sendKeys(sku);
    }

    @And("User click on search button")
    public void user_click_on_search_button() {
        homePage.getSearchBtn().click();
    }

    @Then("Search result appears with products related to the product name {string}")
    public void search_result_appears_with_products_related_to_the_product_name(String name) {
        searchPage = new SearchPage(Hooks.driver);
        softAssert.assertTrue(Hooks.driver.getCurrentUrl().toLowerCase().contains("search"));
        List<WebElement> products = searchPage.getProducts();
        for (WebElement product : products) {
            softAssert.assertTrue(product.getText().toLowerCase().contains(name));
        }

        softAssert.assertAll();
    }

    @Then("Search result appears with products related to the product sku {string}")
    public void search_result_appears_with_products_related_to_the_product_sku(String sku) {
        searchPage = new SearchPage(Hooks.driver);
        searchPage.getProducts().get(0).click();
        productDetailsPage = new ProductDetailsPage(Hooks.driver);
        Assert.assertTrue(productDetailsPage.getProductSku().getText().contains(sku));
    }
}
