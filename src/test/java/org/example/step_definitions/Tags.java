package org.example.step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;

public class Tags {

    HomePage homePage;
    NotebooksCategoryPage notebooksCategoryPage;
    AwesomeTagPage awesomeTagPage;
    CellTagPage cellTagPage;
    Actions actions;
    SoftAssert softAssert = new SoftAssert();

    @When("User open notebooks category page")
    public void user_open_notebooks_category_page() {
        homePage = new HomePage(Hooks.driver);
        actions = new Actions(Hooks.driver);
        actions.moveToElement(homePage.getComputersLink())
                .moveToElement(homePage.getNotebooksLink())
                .click().build().perform();
    }

    @And("User click on awesome tag from product tags")
    public void user_click_on_awesome_tag_from_product_tags() {
        notebooksCategoryPage = new NotebooksCategoryPage(Hooks.driver);
        notebooksCategoryPage.getAwesomeTagLink().click();
    }

    @Then("User will navigate to a page contains products related to awesome tag")
    public void user_will_navigate_to_a_page_contains_products_related_to_awesome_tag() {
        awesomeTagPage = new AwesomeTagPage(Hooks.driver);
        softAssert.assertTrue(Hooks.driver.getCurrentUrl().contains("awesome"));
        softAssert.assertEquals(awesomeTagPage.getPageTitleHeader().getText(),
                "Products tagged with 'awesome'");
        softAssert.assertEquals(awesomeTagPage.getProducts().size(), 6); // No of products displayed
        softAssert.assertAll();
    }

    @And("User click on cell tag from product tags")
    public void user_click_on_cell_tag_from_product_tags() {
        notebooksCategoryPage = new NotebooksCategoryPage(Hooks.driver);
        notebooksCategoryPage.getCellTagLink().click();
    }

    @Then("User will navigate to a page contains products related to cell tag")
    public void user_will_navigate_to_a_page_contains_products_related_to_cell_tag() {
        cellTagPage = new CellTagPage(Hooks.driver);
        softAssert.assertTrue(Hooks.driver.getCurrentUrl().contains("cell"));
        softAssert.assertEquals(cellTagPage.getPageTitleHeader().getText(),
                "Products tagged with 'cell'");
        softAssert.assertEquals(cellTagPage.getProducts().size(), 2); // No of products displayed
        softAssert.assertAll();

    }

}
