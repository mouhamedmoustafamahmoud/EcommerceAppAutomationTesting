package org.example.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ShoppingCart {

    HomePage homePage;
    ProductDetailsPage productDetailsPage;
    NotebooksCategoryPage notebooksCategoryPage;
    BooksCategoryPage booksCategoryPage;
    ShoppingCartPage shoppingCartPage;
    Actions actions;
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));


    @When("User navigate to Notebooks category page")
    public void user_navigate_to_notebooks_category_page() {
        homePage = new HomePage(Hooks.driver);
        actions = new Actions(Hooks.driver);
        actions.moveToElement(homePage.getComputersLink())
                .moveToElement(homePage.getNotebooksLink())
                .click().build().perform();
    }

    @And("User click on Add To Cart button for a product")
    public void user_click_on_add_to_cart_button_for_a_product() {
        notebooksCategoryPage = new NotebooksCategoryPage(Hooks.driver);

        // Add Laptop to shopping cart
        notebooksCategoryPage.getAsusLaptopLink().click();
        productDetailsPage = new ProductDetailsPage(Hooks.driver);
        productDetailsPage.getAddToCartBtn().click();
        productDetailsPage = new ProductDetailsPage(Hooks.driver);
        wait.until(ExpectedConditions.visibilityOf(productDetailsPage.getSuccessNotification()));
        productDetailsPage.getNotificationBarCloseBtn().click();
    }

    @And("User navigate to Books category page")
    public void user_navigate_to_books_category_page() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(productDetailsPage.getBooksLink()));
        // I tried a lot with Explicit Wait but not worked correctly every time, so I will use Thread.sleep()
        Thread.sleep(3000);
        productDetailsPage.getBooksLink().click();
    }

    @And("User click on Add To Cart button for two books from products")
    public void user_click_on_add_to_cart_button_for_two_books_from_products() throws InterruptedException {

        // Add the first book to shopping cart
        booksCategoryPage = new BooksCategoryPage(Hooks.driver);
        booksCategoryPage.getFahrenheit451BookLink().click();
        productDetailsPage = new ProductDetailsPage(Hooks.driver);
        productDetailsPage.getAddToCartBtn().click();
        productDetailsPage = new ProductDetailsPage(Hooks.driver);
        wait.until(ExpectedConditions.visibilityOf(productDetailsPage.getSuccessNotification()));
        productDetailsPage.getNotificationBarCloseBtn().click();
        wait.until(ExpectedConditions.elementToBeClickable(productDetailsPage.getBooksLink()));
        // I tried a lot with Explicit Wait but not worked correctly every time, so I will use Thread.sleep()
        Thread.sleep(3000);
        productDetailsPage.getBooksLink().click();

        // Add the second book to shopping cart
        booksCategoryPage = new BooksCategoryPage(Hooks.driver);
        booksCategoryPage.getFirstPrizePiesBookLink().click();
        productDetailsPage = new ProductDetailsPage(Hooks.driver);
        productDetailsPage.getAddToCartBtn().click();
        productDetailsPage = new ProductDetailsPage(Hooks.driver);
        wait.until(ExpectedConditions.visibilityOf(productDetailsPage.getSuccessNotification()));
        productDetailsPage.getNotificationBarCloseBtn().click();
        wait.until(ExpectedConditions.visibilityOf(productDetailsPage.getShoppingCartLink()));
    }

    @And("User navigate to Shopping Cart page")
    public void user_navigate_to_shopping_cart_page() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(productDetailsPage.getShoppingCartLink()));
        // I tried a lot with Explicit Wait but not worked correctly every time, so I will use Thread.sleep()
        Thread.sleep(3000);
        productDetailsPage.getShoppingCartLink().click();
    }

    @Then("Shopping cart will contains all selected products")
    public void shopping_cart_will_contains_all_selected_products() {
        shoppingCartPage = new ShoppingCartPage(Hooks.driver);
        Assert.assertEquals(shoppingCartPage.getNumOfProducts().size(), 3); // no of products in Shopping cart

    }

}
