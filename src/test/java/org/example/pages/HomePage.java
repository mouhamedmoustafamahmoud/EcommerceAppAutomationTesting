package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    @FindBy(xpath = "//div[@class='header-logo']/a")
    WebElement homePageLink;

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(linkText = "Log in")
    WebElement loginLink;

    @FindBy(xpath = "//a[@class='ico-wishlist']")
    WebElement wishListLink;

    @FindBy(linkText = "My account")
    WebElement myAccountLink;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']/li[1]/a")
    WebElement computersLink;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']/li[1]/ul/li[2]/a")
    WebElement notebooksLink;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']/li[5]/a")
    WebElement booksLink;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']/li[3]/a")
    WebElement apparelLink;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']/li[3]/ul/li[1]/a")
    WebElement shoesLink;

    @FindBy(id = "customerCurrency")
    WebElement currencyDropDownMenu;

    @FindBy(id = "small-searchterms")
    WebElement searchTxtField;

    @FindBy(css = "button.button-1.search-box-button")
    WebElement searchBtn;

    @FindBy(css = "span.price.actual-price")
    List<WebElement> prices;

    @FindBy(xpath = "//div[@class='nivo-controlNav']/a[1]")
    WebElement nokiaSelector;

    @FindBy(xpath = "//div[@class='nivoSlider']/a[1]")
    WebElement nokiaImgLink;

    @FindBy(xpath = "//div[@class='nivo-controlNav']/a[2]")
    WebElement iphoneSelector;

    @FindBy(xpath = "//div[@class='nivoSlider']/a[2]")
    WebElement iphoneImgLink;

    @FindBy(css = "li.facebook")
    WebElement facebookIcon;

    @FindBy(css = "li.twitter")
    WebElement twitterIcon;

    @FindBy(css = "li.rss")
    WebElement rssIcon;

    @FindBy(css = "li.youtube")
    WebElement youtubeIcon;

    @FindBy(xpath = "(//div[@class='buttons'])[3]/button[3]")
    WebElement htcPhoneAddToWishlistBtn;

    @FindBy(css = "span.close")
    WebElement notificationBarCloseBtn;

    @FindBy(css = "div.bar-notification.success")
    WebElement successNotification;

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getHomePageLink() {
        return homePageLink;
    }

    public WebElement getRegisterLink() {
        return registerLink;
    }

    public WebElement getWishListLink() {
        return wishListLink;
    }

    public WebElement getLoginLink() {
        return loginLink;
    }

    public WebElement getMyAccountLink() {
        return myAccountLink;
    }

    public WebElement getComputersLink() {
        return computersLink;
    }

    public WebElement getNotebooksLink() {
        return notebooksLink;
    }

    public WebElement getBooksLink() {
        return booksLink;
    }

    public WebElement getApparelLink() {
        return apparelLink;
    }

    public WebElement getShoesLink() {
        return shoesLink;
    }

    public WebElement getCurrencyDropDownMenu() {
        return currencyDropDownMenu;
    }

    public WebElement getSearchTxtField() {
        return searchTxtField;
    }

    public WebElement getSearchBtn() {
        return searchBtn;
    }

    public List<WebElement> getPrices() {
        return prices;
    }

    public WebElement getNokiaSelector() {
        return nokiaSelector;
    }

    public WebElement getNokiaImgLink() {
        return nokiaImgLink;
    }

    public WebElement getIphoneSelector() {
        return iphoneSelector;
    }

    public WebElement getIphoneImgLink() {
        return iphoneImgLink;
    }

    public WebElement getFacebookIcon() {
        return facebookIcon;
    }

    public WebElement getTwitterIcon() {
        return twitterIcon;
    }

    public WebElement getRssIcon() {
        return rssIcon;
    }

    public WebElement getYoutubeIcon() {
        return youtubeIcon;
    }

    public WebElement getHtcPhoneAddToWishlistBtn() {
        return htcPhoneAddToWishlistBtn;
    }

    public WebElement getNotificationBarCloseBtn() {
        return notificationBarCloseBtn;
    }

    public WebElement getSuccessNotification() {
        return successNotification;
    }
}
