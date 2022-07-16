package org.example.step_definitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.example.pages.NotebooksCategoryPage;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class Category {

    HomePage homePage;
    NotebooksCategoryPage notebooksCategoryPage;
    Actions actions;
    SoftAssert softAssert = new SoftAssert();
    String subCategory;
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(3));


    @When("User hover to a category and click on one of its sub-categories")
    public void user_hover_to_a_category_and_click_on_one_of_its_sub_categories() {
        homePage = new HomePage(Hooks.driver);
        actions = new Actions(Hooks.driver);
        actions.moveToElement(homePage.getComputersLink()).
                moveToElement(homePage.getNotebooksLink()).build().perform();

        wait.until(ExpectedConditions.visibilityOf(homePage.getNotebooksLink()));
        subCategory = homePage.getNotebooksLink().getText().toLowerCase().trim(); // notebooks
        System.out.println("***************" + subCategory + "*********************");
        actions.moveToElement(homePage.getComputersLink()).
                moveToElement(homePage.getNotebooksLink())
                .click().build().perform();

    }

    @Then("User will navigate to a page contains products about that sub-category")
    public void user_will_navigate_to_a_page_contains_products_about_that_sub_category() {
        notebooksCategoryPage = new NotebooksCategoryPage(Hooks.driver);
        softAssert.assertTrue(Hooks.driver.getCurrentUrl().contains("notebooks"));
        softAssert.assertTrue(notebooksCategoryPage.getNotebooksBreadCrumb().isDisplayed());
        softAssert.assertEquals(notebooksCategoryPage.getPageTitleHeader().getText(), "Notebooks");
        softAssert.assertTrue(notebooksCategoryPage.getPageTitleHeader().getText().
                              toLowerCase().equals(subCategory));
        softAssert.assertAll();

    }


}
