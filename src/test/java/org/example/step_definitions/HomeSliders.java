package org.example.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomeSliders {

    HomePage homePage;
    WebDriverWait wait = new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
    String nokiaProductDetailsPageUrl = "https://demo.nopcommerce.com/nokia-lumia-1020";
    String iphoneProductDetailsPageUrl = " https://demo.nopcommerce.com/iphone-6";

    @Given("User at home page")
    public void user_at_home_page() {
        homePage = new HomePage(Hooks.driver);
        homePage.getHomePageLink().click();
    }

    @When("User click on first slider nokia image")
    public void user_click_on_first_slider_nokia_image() {
        homePage.getNokiaImgLink().click();
    }

    @Then("User navigate to nokia product details page")
    public void user_navigate_to_nokia_product_details_page() {
        wait.until(ExpectedConditions.urlToBe(nokiaProductDetailsPageUrl));
        System.out.println(Hooks.driver.getCurrentUrl());
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), nokiaProductDetailsPageUrl);

    }

    @When("User click on second slider iphone image")
    public void user_click_on_second_slider_iphone_image() throws InterruptedException {
       homePage.getIphoneSelector().click();
        Thread.sleep(2000);
       homePage.getIphoneImgLink().click();
    }

    @Then("User navigate to iphone product details page")
    public void user_navigate_to_iphone_product_details_page() {
        wait.until(ExpectedConditions.urlToBe(iphoneProductDetailsPageUrl));
        System.out.println(Hooks.driver.getCurrentUrl());
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), iphoneProductDetailsPageUrl);
    }
}
