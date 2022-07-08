package org.example.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CheckOutPage {

    @FindBy(id = "BillingNewAddress_CountryId")
    WebElement countryDropDownMenu;

    @FindBy(id = "BillingNewAddress_City")
    WebElement cityTxtField;

    @FindBy(id = "BillingNewAddress_Address1")
    WebElement address1TxtField;

    @FindBy(id = "BillingNewAddress_ZipPostalCode")
    WebElement postalCodeTxtField;

    @FindBy(id = "BillingNewAddress_PhoneNumber")
    WebElement phoneNumberTxtField;

    @FindBy(css = "button.button-1.new-address-next-step-button")
    WebElement billingAddressContinueBtn;

    @FindBy(id = "shippingoption_1")
    WebElement nextDayAirRadioBtn;

    @FindBy(css = "button.button-1.shipping-method-next-step-button")
    WebElement shippingContinueBtn;

    @FindBy(id = "paymentmethod_0")
    WebElement cashPaymentRadioBtn;

    @FindBy(css = "button.button-1.payment-method-next-step-button")
    WebElement paymentMethodContinueBtn;

    @FindBy(css = "button.button-1.payment-info-next-step-button")
    WebElement getPaymentInfoContinueBtn;

    @FindBy(css = "button.button-1.confirm-order-next-step-button")
    WebElement confirmOrderBtn;

    @FindBy(xpath = "(//div[@class='title'])[1]/strong")
    WebElement successfulOrderMsg; // Your order has been successfully processed!

    @FindBy(css = "button.button-1.order-completed-continue-button")
    WebElement completedOrderContinueBtn;

    WebDriver driver;

    public CheckOutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getCountryDropDownMenu() {
        return countryDropDownMenu;
    }

    public WebElement getCityTxtField() {
        return cityTxtField;
    }

    public WebElement getAddress1TxtField() {
        return address1TxtField;
    }

    public WebElement getPostalCodeTxtField() {
        return postalCodeTxtField;
    }

    public WebElement getPhoneNumberTxtField() {
        return phoneNumberTxtField;
    }

    public WebElement getBillingAddressContinueBtn() {
        return billingAddressContinueBtn;
    }

    public WebElement getNextDayAirRadioBtn() {
        return nextDayAirRadioBtn;
    }

    public WebElement getShippingContinueBtn() {
        return shippingContinueBtn;
    }

    public WebElement getCashPaymentRadioBtn() {
        return cashPaymentRadioBtn;
    }

    public WebElement getPaymentMethodContinueBtn() {
        return paymentMethodContinueBtn;
    }

    public WebElement getGetPaymentInfoContinueBtn() {
        return getPaymentInfoContinueBtn;
    }

    public WebElement getConfirmOrderBtn() {
        return confirmOrderBtn;
    }

    public WebElement getSuccessfulOrderMsg() {
        return successfulOrderMsg;
    }

    public WebElement getCompletedOrderContinueBtn() {
        return completedOrderContinueBtn;
    }

    public void enterBillingInformation(String country, String city, String address,
                                        String postalCode, String phoneNumber){
        Select select = new Select(countryDropDownMenu);
        select.selectByVisibleText(country);
        cityTxtField.sendKeys(city);
        address1TxtField.sendKeys(address);
        postalCodeTxtField.sendKeys(postalCode);
        phoneNumberTxtField.sendKeys(phoneNumber);
    }
}
