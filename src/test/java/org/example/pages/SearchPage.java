package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchPage {

    @FindBy(id = "small-searchterms")
    WebElement searchTxtField;

    @FindBy(css = "button.button-1.search-box-button")
    WebElement searchBtn;

    @FindBy(css = "div.product-item")
    List<WebElement> products;

    WebDriver driver;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getSearchTxtField() {
        return searchTxtField;
    }

    public WebElement getSearchBtn() {
        return searchBtn;
    }

    public List<WebElement> getProducts() {
        return products;
    }
}
