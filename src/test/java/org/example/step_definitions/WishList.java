package org.example.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.pages.WishListPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class WishList {

    HomePage homePage;
    WishListPage wishListPage;
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
    SoftAssert softAssert = new SoftAssert();

    @Given("User at the homepage")
    public void user_at_the_homepage() {
        homePage = new HomePage(Hooks.driver);
        homePage.getHomePageLink().click();
    }

    @When("User click on add to wishlist button of htc phone")
    public void user_click_on_add_to_wishlist_button_of_htc_phone() {
        homePage.getHtcPhoneAddToWishlistBtn().click();
    }

    @And("User click on Wishlist link")
    public void user_click_on_wishlist_link() {
        homePage = new HomePage(Hooks.driver);
        wait.until(ExpectedConditions.invisibilityOf(homePage.getSuccessNotification()));
        homePage.getWishListLink().click();
    }

    @Then("success message appears which confirm adding of the product")
    public void success_message_appears_which_confirm_adding_of_the_product() {
        homePage = new HomePage(Hooks.driver);
        softAssert.assertTrue(homePage.getSuccessNotification().isDisplayed());
        softAssert.assertEquals(homePage.getSuccessNotification().
                getCssValue("background-color"), "rgba(75, 176, 122, 1)"); // Green
        softAssert.assertAll();
    }


    @Then("User will navigate to wishlist page which contain htc phone product with its quantity")
    public void user_will_navigate_to_wishlist_page_which_contain_htc_phone_product_with_its_quantity() {
        wishListPage = new WishListPage(Hooks.driver);
        softAssert.assertTrue(Hooks.driver.getCurrentUrl().contains("wishlist"));
        int productQuantity = Integer.parseInt(wishListPage.getProductQuantity().getAttribute("value"));
        softAssert.assertTrue(productQuantity > 0);
        softAssert.assertAll();
    }

}
