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

public class WishList {

    HomePage homePage;
    NotebooksCategoryPage notebooksCategoryPage;
    BooksCategoryPage booksCategoryPage;
    ProductDetailsPage productDetailsPage;
    WishListPage wishListPage;
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
    Actions actions;

    @When("User navigate to the Notebooks category page")
    public void user_navigate_to_notebooks_category_page() {
        homePage = new HomePage(Hooks.driver);
        actions = new Actions(Hooks.driver);
        actions.moveToElement(homePage.getComputersLink())
                .moveToElement(homePage.getNotebooksLink())
                .click().build().perform();
    }

    @And("User click on Add To Wishlist button for a product")
    public void user_click_on_add_to_wishlist_button_for_a_product() {
        notebooksCategoryPage = new NotebooksCategoryPage(Hooks.driver);
        notebooksCategoryPage.getAsusLaptopLink().click();
        productDetailsPage = new ProductDetailsPage(Hooks.driver);
        productDetailsPage.getAddToWishlistBtn().click();
        productDetailsPage = new ProductDetailsPage(Hooks.driver);
        wait.until(ExpectedConditions.visibilityOf(productDetailsPage.getSuccessNotification()));
        productDetailsPage.getNotificationBarCloseBtn().click();
    }

    @And("User navigate to the Books category page")
    public void user_navigate_to_books_category_page() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(productDetailsPage.getBooksLink()));
        // I tried a lot with Explicit Wait but not worked correctly every time, so I will use Thread.sleep()
        Thread.sleep(3000);
        productDetailsPage.getBooksLink().click();
    }

    @And("User click on Add To Wishlist button for two books from products")
    public void user_click_on_add_to_wishlist_button_for_two_books_from_products() throws InterruptedException {
        // First Book
        booksCategoryPage = new BooksCategoryPage(Hooks.driver);
        booksCategoryPage.getFahrenheit451BookLink().click();
        productDetailsPage = new ProductDetailsPage(Hooks.driver);
        productDetailsPage.getAddToWishlistBtn().click();
        productDetailsPage = new ProductDetailsPage(Hooks.driver);
        wait.until(ExpectedConditions.visibilityOf(productDetailsPage.getSuccessNotification()));
        productDetailsPage.getNotificationBarCloseBtn().click();
        wait.until(ExpectedConditions.elementToBeClickable(productDetailsPage.getBooksLink()));
        // I tried a lot with Explicit Wait but not worked correctly every time, so I will use Thread.sleep()
        Thread.sleep(3000);
        productDetailsPage.getBooksLink().click();
        // Second Book
        booksCategoryPage = new BooksCategoryPage(Hooks.driver);
        booksCategoryPage.getFirstPrizePiesBookLink().click();
        productDetailsPage = new ProductDetailsPage(Hooks.driver);
        productDetailsPage.getAddToWishlistBtn().click();
        productDetailsPage = new ProductDetailsPage(Hooks.driver);
        wait.until(ExpectedConditions.visibilityOf(productDetailsPage.getSuccessNotification()));
        productDetailsPage.getNotificationBarCloseBtn().click();
        wait.until(ExpectedConditions.visibilityOf(productDetailsPage.getWishListLink()));
    }

    @And("User navigate to Wishlist page")
    public void user_navigate_to_wishlist_page() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(productDetailsPage.getWishListLink()));
        // I tried a lot with Explicit Wait but not worked correctly every time, so I will use Thread.sleep()
        Thread.sleep(3000);
        productDetailsPage.getWishListLink().click();
    }

    @Then("Wishlist will contains all selected products")
    public void wishlist_will_contains_all_selected_products() {
        wishListPage = new WishListPage(Hooks.driver);
        Assert.assertEquals(wishListPage.getNumOfProducts().size(), 3); // No of products in Wishlist
    }
}
