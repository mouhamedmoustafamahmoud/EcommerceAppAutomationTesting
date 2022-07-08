package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ShoppingCartPage {

    @FindBy(xpath = "//table[@class='cart']/tbody/tr")
    List<WebElement> numOfProducts;

    @FindBy(id = "termsofservice")
    WebElement termsOfServiceCheckBox;

    @FindBy(id = "checkout")
    WebElement checkoutBtn;

    WebDriver driver;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getNumOfProducts() {
        return numOfProducts;
    }

    public WebElement getTermsOfServiceCheckBox() {
        return termsOfServiceCheckBox;
    }

    public WebElement getCheckoutBtn() {
        return checkoutBtn;
    }
}
