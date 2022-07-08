package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BooksCategoryPage {


    @FindBy(xpath = "//a[@class='ico-wishlist']")
    WebElement wishListLink;

    @FindBy(linkText = "Shopping cart")
    WebElement shoppingCartLink;

    @FindBy(xpath = "(//h2[@class='product-title'])[1]/a")
    WebElement fahrenheit451BookLink;

    @FindBy(xpath = "(//h2[@class='product-title'])[2]/a")
    WebElement firstPrizePiesBookLink;

    @FindBy(id = "bar-notification")
    WebElement notificationBar; // The product has been added to your shopping cart

    @FindBy(css = "span.close")
    WebElement notificationBarCloseBtn;

    WebDriver driver;

    public BooksCategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getWishListLink() {
        return wishListLink;
    }

    public WebElement getShoppingCartLink() {
        return shoppingCartLink;
    }

    public WebElement getFahrenheit451BookLink() {
        return fahrenheit451BookLink;
    }


    public WebElement getFirstPrizePiesBookLink() {
        return firstPrizePiesBookLink;
    }


    public WebElement getNotificationBar() {
        return notificationBar;
    }

    public WebElement getNotificationBarCloseBtn() {
        return notificationBarCloseBtn;
    }
}
