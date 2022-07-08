package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductDetailsPage {

    @FindBy(xpath = "//a[@class='ico-wishlist']")
    WebElement wishListLink;

    @FindBy(linkText = "Shopping cart")
    WebElement shoppingCartLink;

    @FindBy(css = "div.sku")
    WebElement productSku;

    @FindBy(xpath = "//div[@class='add-to-cart-panel']/button")
    WebElement addToCartBtn;

    @FindBy(xpath = "//div[@class='add-to-wishlist']/button")
    WebElement addToWishlistBtn;

    @FindBy(xpath = "//div[@class='compare-products']/button")
    WebElement addToCompareListBtn;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']/li[5]/a")
    WebElement booksLink;

    @FindBy(id = "bar-notification")
    WebElement notificationBar;

    @FindBy(css = "span.close")
    WebElement notificationBarCloseBtn;

    @FindBy(css = "div.bar-notification.success")
    WebElement successNotification;

    @FindBy(xpath = "//div[@class='bar-notification success']/p/a")
    WebElement compareProductsLink;

    WebDriver driver;

    public ProductDetailsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getWishListLink() {
        return wishListLink;
    }

    public WebElement getShoppingCartLink() {
        return shoppingCartLink;
    }

    public WebElement getProductSku() {
        return productSku;
    }

    public WebElement getAddToCartBtn() {
        return addToCartBtn;
    }

    public WebElement getAddToWishlistBtn() {
        return addToWishlistBtn;
    }

    public WebElement getBooksLink() {
        return booksLink;
    }

    public WebElement getNotificationBar() {
        return notificationBar;
    }

    public WebElement getNotificationBarCloseBtn() {
        return notificationBarCloseBtn;
    }

    public WebElement getSuccessNotification() {
        return successNotification;
    }

    public WebElement getAddToCompareListBtn() {
        return addToCompareListBtn;
    }

    public WebElement getCompareProductsLink() {
        return compareProductsLink;
    }
}
