package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class NotebooksCategoryPage {

    @FindBy(xpath = "//ul[@class='top-menu notmobile']/li[1]/a")
    WebElement computersLink;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']/li[1]/ul/li[2]/a")
    WebElement notebooksLink;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']/li[5]/a")
    WebElement booksLink;

    @FindBy(css = "strong.current-item")
    WebElement notebooksBreadCrumb;

    @FindBy(xpath = "//div[@class='page-title']/h1")
    WebElement pageTitleHeader;

    @FindBy(css = "div.product-item")
    List<WebElement> products;

    @FindBy(xpath = "(//h2[@class='product-title'])[1]/a")
    WebElement appleMacbookLink; // First Product

    @FindBy(xpath = "(//h2[@class='product-title'])[2]/a")
    WebElement asusLaptopLink;  // Second Product

    @FindBy(xpath = "(//h2[@class='product-title'])[3]/a")
    WebElement hpSleekbookLink; // Third Product

    @FindBy(id = "bar-notification")
    WebElement notificationBar;

    @FindBy(css = "span.close")
    WebElement notificationBarCloseBtn;

    @FindBy(xpath = "//div[@class='tags']/ul/li[2]/a")
    WebElement awesomeTagLink;

    @FindBy(xpath = "//div[@class='tags']/ul/li[5]/a")
    WebElement cellTagLink;


    WebDriver driver;

    public NotebooksCategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
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

    public WebElement getNotebooksBreadCrumb() {
        return notebooksBreadCrumb;
    }

    public WebElement getPageTitleHeader() {
        return pageTitleHeader;
    }

    public List<WebElement> getProducts() {
        return products;
    }

    public WebElement getAsusLaptopLink() {
        return asusLaptopLink;
    }

    public WebElement getAppleMacbookLink() {
        return appleMacbookLink;
    }

    public WebElement getHpSleekbookLink() {
        return hpSleekbookLink;
    }

    public WebElement getNotificationBar() {
        return notificationBar;
    }

    public WebElement getNotificationBarCloseBtn() {
        return notificationBarCloseBtn;
    }

    public WebElement getAwesomeTagLink() {
        return awesomeTagLink;
    }

    public WebElement getCellTagLink() {
        return cellTagLink;
    }
}
