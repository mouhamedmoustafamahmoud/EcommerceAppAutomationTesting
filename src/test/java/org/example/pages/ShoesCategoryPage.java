package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShoesCategoryPage {


    @FindBy(xpath = "//ul[@class='top-menu notmobile']/li[3]/a")
    WebElement apparelLink;

    @FindBy(xpath = "//ul[@class='top-menu notmobile']/li[3]/ul/li[1]/a")
    WebElement shoesLink;

    @FindBy(css = "div.product-item")
    List<WebElement> products;

    @FindBy(id = "attribute-option-15")
    WebElement redColorCheckBox;

    WebDriver driver;

    public ShoesCategoryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getProducts() {
        return products;
    }

    public WebElement getRedColorCheckBox() {
        return redColorCheckBox;
    }

    public WebElement getApparelLink() {
        return apparelLink;
    }

    public WebElement getShoesLink() {
        return shoesLink;
    }
}
