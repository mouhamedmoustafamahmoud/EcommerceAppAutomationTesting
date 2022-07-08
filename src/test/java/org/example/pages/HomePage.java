package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {

    @FindBy(linkText = "Register")
    WebElement registerLink;

    @FindBy(linkText = "Log in")
    WebElement loginLink;

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

    WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getRegisterLink() {
        return registerLink;
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

}
