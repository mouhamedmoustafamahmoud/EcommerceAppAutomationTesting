package org.example.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class CheckOut {

    HomePage homePage;
    BooksCategoryPage booksCategoryPage;
    ProductDetailsPage productDetailsPage;
    ShoppingCartPage shoppingCartPage;
    CheckOutPage checkOutPage;
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
    SoftAssert softAssert = new SoftAssert();


    @When("User select product from a category")
    public void user_select_product_from_a_category() {
        homePage = new HomePage(Hooks.driver);
        homePage.getBooksLink().click();
        booksCategoryPage = new BooksCategoryPage(Hooks.driver);
        booksCategoryPage.getFahrenheit451BookLink().click();
    }
    @And("User add the product to the shopping cart")
    public void user_add_the_product_to_the_shopping_cart() {
        productDetailsPage = new ProductDetailsPage(Hooks.driver);
        productDetailsPage.getAddToCartBtn().click();
        productDetailsPage = new ProductDetailsPage(Hooks.driver);
        wait.until(ExpectedConditions.visibilityOf(productDetailsPage.getSuccessNotification()));
        productDetailsPage.getNotificationBarCloseBtn().click();
        wait.until(ExpectedConditions.elementToBeClickable(productDetailsPage.getShoppingCartLink()));
        productDetailsPage.getShoppingCartLink().click();
    }
    @And("User click on checkout button to purchase the product")
    public void user_click_on_checkout_button_to_purchase_the_product() {
        shoppingCartPage = new ShoppingCartPage(Hooks.driver);
        if (!shoppingCartPage.getTermsOfServiceCheckBox().isSelected()){
            shoppingCartPage.getTermsOfServiceCheckBox().click();
        }
        shoppingCartPage.getCheckoutBtn().click();
    }
    @And("User enter mandatory valid information for payment")
    public void user_enter_mandatory_valid_information_for_payment() {
        checkOutPage = new CheckOutPage(Hooks.driver);
        wait.until(ExpectedConditions.elementToBeClickable(checkOutPage.getBillingAddressContinueBtn()));
        checkOutPage.enterBillingInformation("Ecuador", "Alexandria", "Test Address",
                "55674", "01234567898");
        checkOutPage.getBillingAddressContinueBtn().click();
        wait.until(ExpectedConditions.elementToBeClickable(checkOutPage.getShippingContinueBtn()));
        checkOutPage.getNextDayAirRadioBtn().click();
        checkOutPage.getShippingContinueBtn().click();
        wait.until(ExpectedConditions.elementToBeClickable(checkOutPage.getPaymentMethodContinueBtn()));
        if(!checkOutPage.getCashPaymentRadioBtn().isSelected()){
            checkOutPage.getCashPaymentRadioBtn().click();
        }
        checkOutPage.getPaymentMethodContinueBtn().click();
        wait.until(ExpectedConditions.elementToBeClickable(checkOutPage.getGetPaymentInfoContinueBtn()));
        checkOutPage.getGetPaymentInfoContinueBtn().click();

    }
    @And("User click on confirm button to complete the payment")
    public void user_click_on_confirm_button_to_complete_the_payment() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(checkOutPage.getConfirmOrderBtn()));
        checkOutPage.getConfirmOrderBtn().click();
        // I tried a lot with Explicit Wait but not worked correctly every time, so I will use Thread.sleep()
        Thread.sleep(3000);
    }
    @Then("Success completed order message appears")
    public void success_completed_order_message_appears() {
        checkOutPage = new CheckOutPage(Hooks.driver);
        wait.until(ExpectedConditions.visibilityOf(checkOutPage.getSuccessfulOrderMsg()));
        softAssert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/checkout/completed");
        softAssert.assertTrue(checkOutPage.getSuccessfulOrderMsg().getText()
                .contains("Your order has been successfully processed!"));
        softAssert.assertTrue(checkOutPage.getCompletedOrderContinueBtn().isDisplayed());
        softAssert.assertAll();
        checkOutPage.getCompletedOrderContinueBtn().click();

    }
}
