package com.epam.atm.demo.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    private Logger log = Logger.getLogger(LoginPage.class);

    @FindBy(linkText = "SIGN IN")
    private WebElement buttonSignIn;

    @FindBy(id = "identifierId")
    private WebElement inputEmail;

    @FindBy(name = "password")
    private WebElement inputPassword;

    private By buttonIdentifierNextLocator = By.xpath("//*[@id='identifierNext']");
    private By buttonPasswordNextLocator = By.xpath("//*[@id='passwordNext']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickOnButtonSignIn() {
        buttonSignIn.click();
        return this;
    }

    public LoginPage clickOnPasswordNext() {
        threadSleep();
        waitForElementAndClick(driver, buttonPasswordNextLocator);
        return this;
    }

    public LoginPage clickOnIdentifierNext() {
        threadSleep();
        waitForElementAndClick(driver, buttonIdentifierNextLocator);
        return this;
    }

    public LoginPage enterEmail(String email) {
        inputEmail.sendKeys(email);
        return this;
    }

    public LoginPage enterPassword(String password) {
        inputPassword.sendKeys(password);
        return this;
    }

    public LoginPage login(String email, String password) {
        clickOnButtonSignIn()
                .enterEmail(email)
                .clickOnIdentifierNext()
                .enterPassword(password)
                .clickOnPasswordNext();
        return this;
    }
}
