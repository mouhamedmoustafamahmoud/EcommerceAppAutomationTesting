package org.example.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.example.pages.HomePage;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class FollowUs {

    HomePage homePage;

    @Given("User at the home page")
    public void user_at_home_page() {
        homePage = new HomePage(Hooks.driver);
        homePage.getHomePageLink().click();
    }

    @When("User click on facebook icon")
    public void user_click_on_facebook_icon() {
        homePage.getFacebookIcon().click();
    }

    @When("User click on twitter icon")
    public void user_click_on_twitter_icon() {
        homePage.getTwitterIcon().click();
    }

    @When("User click on rss icon")
    public void user_click_on_rss_icon() {
        homePage.getRssIcon().click();
    }

    @When("User click on youtube icon")
    public void user_click_on_youtube_icon() {
        homePage.getYoutubeIcon().click();
    }

    @Then("{string} is opened in new tab")
    public void is_opened_in_new_tab(String url) {

        List<String> tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        try {
            Thread.sleep(3000);
            Hooks.driver.switchTo().window(tabs.get(1));

        } catch (IndexOutOfBoundsException exp) {
            System.out.println("There is only one tab with url : " + Hooks.driver.getCurrentUrl());

        } catch (InterruptedException exp) {
            exp.printStackTrace();
        }
        Assert.assertEquals(Hooks.driver.getCurrentUrl(), url);
        Hooks.driver.close();
        Hooks.driver.switchTo().window(tabs.get(0));

    }

}
