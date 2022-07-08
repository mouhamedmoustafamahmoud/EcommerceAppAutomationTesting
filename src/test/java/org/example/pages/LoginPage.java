package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "Email")
    WebElement emailTxtField;

    @FindBy(id = "Password")
    WebElement passwordTxtField;

    @FindBy(css = "span.forgot-password")
    WebElement forgotPasswordLink;

    @FindBy(css = "button.button-1.login-button")
    WebElement loginBtn;

    @FindBy(css = "div.message-error.validation-summary-errors")
    WebElement errorMessage; //Login was unsuccessful. Please correct the errors and try again. No customer account found

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getEmailTxtField() {
        return emailTxtField;
    }

    public WebElement getPasswordTxtField() {
        return passwordTxtField;
    }

    public WebElement getForgotPasswordLink() {
        return forgotPasswordLink;
    }

    public WebElement getLoginBtn() {
        return loginBtn;
    }

    public WebElement getErrorMessage() {
        return errorMessage;
    }
}
