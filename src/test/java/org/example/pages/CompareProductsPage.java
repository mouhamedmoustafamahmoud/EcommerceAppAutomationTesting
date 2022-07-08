package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CompareProductsPage {


    @FindBy(xpath = "//tr[@class='product-name']/td")
    List<WebElement> productsLinksPlusNameLbl; // No of products + Name Label

    WebDriver driver;

    public CompareProductsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public List<WebElement> getProductsLinksPlusNameLbl() {
        return productsLinksPlusNameLbl;
    }
}
