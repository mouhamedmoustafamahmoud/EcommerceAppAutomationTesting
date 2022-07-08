package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PasswordRecoveryPage {

    @FindBy(id = "bar-notification")
    WebElement notificationBar; // Email with instructions has been sent to you.

    @FindBy(css = "div.bar-notification.success")
    WebElement successNotification; // Email not found.

    @FindBy(css = "div.bar-notification.error")
    WebElement errorNotification;

    @FindBy(css = "span.close")
    WebElement notificationCloseBtn;

    @FindBy(id = "Email")
    WebElement emailTxtField;

    @FindBy(css = "button.button-1.password-recovery-button")
    WebElement recoverBtn;

    WebDriver driver;

    public PasswordRecoveryPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getNotificationBar() {
        return notificationBar;
    }

    public WebElement getSuccessNotification() {
        return successNotification;
    }

    public WebElement getErrorNotification() {
        return errorNotification;
    }

    public WebElement getNotificationCloseBtn() {
        return notificationCloseBtn;
    }

    public WebElement getEmailTxtField() {
        return emailTxtField;
    }

    public WebElement getRecoverBtn() {
        return recoverBtn;
    }
}
