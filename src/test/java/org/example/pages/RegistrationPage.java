package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    @FindBy(id = "gender-male")
    WebElement maleGenderRadioBtn;

    @FindBy(id = "FirstName")
    WebElement firstNameTxtField;

    @FindBy(id = "LastName")
    WebElement lastNameTxtField;

    @FindBy(name = "DateOfBirthDay")
    WebElement dayBirthDropDownMenu;

    @FindBy(name = "DateOfBirthMonth")
    WebElement monthBirthDropDownMenu;

    @FindBy(name = "DateOfBirthYear")
    WebElement yearBirthDropDownMenu;

    @FindBy(id = "Email")
    WebElement emailTxtField;

    @FindBy(id = "Password")
    WebElement passwordTxtField;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPasswordTxtField;

    @FindBy(id = "register-button")
    WebElement registerBtn;

    @FindBy(css = "div.result")
    WebElement message; //Your registration completed

    @FindBy(xpath = "//div[@class='buttons']")
    WebElement continueBtn;

    WebDriver driver;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public WebElement getMaleGenderRadioBtn() {
        return maleGenderRadioBtn;
    }

    public WebElement getDayBirthDropDownMenu() {
        return dayBirthDropDownMenu;
    }

    public WebElement getMonthBirthDropDownMenu() {
        return monthBirthDropDownMenu;
    }

    public WebElement getYearBirthDropDownMenu() {
        return yearBirthDropDownMenu;
    }

    public WebElement getFirstNameTxtField() {
        return firstNameTxtField;
    }

    public WebElement getLastNameTxtField() {
        return lastNameTxtField;
    }

    public WebElement getEmailTxtField() {
        return emailTxtField;
    }

    public WebElement getPasswordTxtField() {
        return passwordTxtField;
    }

    public WebElement getConfirmPasswordTxtField() {
        return confirmPasswordTxtField;
    }

    public WebElement getRegisterBtn() {
        return registerBtn;
    }

    public WebElement getMessage() {
        return message;
    }

    public WebElement getContinueBtn() {
        return continueBtn;
    }
}
