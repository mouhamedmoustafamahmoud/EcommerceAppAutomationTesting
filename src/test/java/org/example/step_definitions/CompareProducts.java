package org.example.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.CompareProductsPage;
import org.example.pages.HomePage;
import org.example.pages.NotebooksCategoryPage;
import org.example.pages.ProductDetailsPage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class CompareProducts {

    HomePage homePage;
    NotebooksCategoryPage notebooksCategoryPage;
    ProductDetailsPage productDetailsPage;
    CompareProductsPage compareProductsPage;
    WebDriverWait wait;
    Actions actions;
    SoftAssert softAssert = new SoftAssert();

    @When("User navigate to notebooks products page")
    public void user_navigate_to_notebooks_products_page() {
        homePage = new HomePage(Hooks.driver);
        actions = new Actions(Hooks.driver);
        actions.moveToElement(homePage.getComputersLink())
                .moveToElement(homePage.getNotebooksLink())
                .click().build().perform();
    }

    @And("User add different products to the compare list")
    public void user_add_different_products_to_the_compare_list() throws InterruptedException {

        // Add the first product to compare list
        notebooksCategoryPage = new NotebooksCategoryPage(Hooks.driver);
        notebooksCategoryPage.getAppleMacbookLink().click();
        productDetailsPage = new ProductDetailsPage(Hooks.driver);
        productDetailsPage.getAddToCompareListBtn().click();
        wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        productDetailsPage = new ProductDetailsPage(Hooks.driver);
        wait.until(ExpectedConditions.visibilityOf(productDetailsPage.getCompareProductsLink()));
        // I tried a lot with Explicit Wait but not worked correctly every time, so I will use Thread.sleep()
        Thread.sleep(2000);
        Hooks.driver.navigate().back();

        // Add second product to compare list
        notebooksCategoryPage = new NotebooksCategoryPage(Hooks.driver);
        notebooksCategoryPage.getAsusLaptopLink().click();
        productDetailsPage = new ProductDetailsPage(Hooks.driver);
        productDetailsPage.getAddToCompareListBtn().click();
        wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        productDetailsPage = new ProductDetailsPage(Hooks.driver);
        wait.until(ExpectedConditions.visibilityOf(productDetailsPage.getCompareProductsLink()));
        // I tried a lot with Explicit Wait but not worked correctly every time, so I will use Thread.sleep()
        Thread.sleep(2000);
        Hooks.driver.navigate().back();

        // Add third product to compare list
        notebooksCategoryPage = new NotebooksCategoryPage(Hooks.driver);
        notebooksCategoryPage.getHpSleekbookLink().click();
        productDetailsPage = new ProductDetailsPage(Hooks.driver);
        productDetailsPage.getAddToCompareListBtn().click();
        // I tried a lot with Explicit Wait but not worked correctly every time, so I will use Thread.sleep()
        Thread.sleep(3000);
    }

    @And("User navigate to compare products list page")
    public void user_navigate_to_compare_products_list_page() {
        wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(5));
        productDetailsPage = new ProductDetailsPage(Hooks.driver);
        wait.until(ExpectedConditions.visibilityOf(productDetailsPage.getCompareProductsLink()));
        productDetailsPage.getCompareProductsLink().click();
    }

    @Then("compare products list will contain all selected products")
    public void compare_products_list_will_contain_all_selected_products() {
        compareProductsPage = new CompareProductsPage(Hooks.driver);
        softAssert.assertTrue(Hooks.driver.getCurrentUrl().equals("https://demo.nopcommerce.com/compareproducts"));
        // No of products + Name Label = 4
        softAssert.assertEquals(compareProductsPage.getProductsLinksPlusNameLbl().size(), 4);
        softAssert.assertAll();

    }
}
