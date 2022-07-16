package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class WishListPage {

    @FindBy(xpath = "//table[@class='cart']/tbody/tr")
    List<WebElement> numOfProducts;

    @FindBy(css = "input.qty-input")
    WebElement productQuantity;

    WebDriver driver;

    public WishListPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getNumOfProducts() {
        return numOfProducts;
    }

    public WebElement getProductQuantity() {
        return productQuantity;
    }
}
