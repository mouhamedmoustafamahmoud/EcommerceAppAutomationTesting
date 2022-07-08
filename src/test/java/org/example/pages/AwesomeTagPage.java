package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AwesomeTagPage {

    @FindBy(xpath = "//div[@class='product-item']")
    List<WebElement> products;

    @FindBy(xpath = "//div[@class='page-title']/h1")
    WebElement pageTitleHeader; // Products tagged with 'awesome'

    @FindBy(xpath = "//div[@class='tags']/ul/li[2]/a")
    WebElement awesomeTagLink;

    @FindBy(xpath = "//div[@class='tags']/ul/li[5]/a")
    WebElement cellTagLink;

    WebDriver driver;

    public AwesomeTagPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getProducts() {
        return products;
    }

    public WebElement getPageTitleHeader() {
        return pageTitleHeader;
    }

    public WebElement getAwesomeTagLink() {
        return awesomeTagLink;
    }

    public WebElement getCellTagLink() {
        return cellTagLink;
    }
}
