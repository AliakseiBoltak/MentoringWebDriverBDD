package com.epam.atm.demo.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//*[@class='gmail-nav__nav-link gmail-nav__nav-link__sign-in']")
    private WebElement buttonSignIn;

    @FindBy(id = "identifierId")
    private WebElement inputEmail;

    @FindBy(name = "password")
    private WebElement inputPassword;

    @FindBy(xpath = "//*[@id='identifierNext']")
    private WebElement idNext;

    @FindBy(xpath = "//*[@id='passwordNext']")
    private WebElement passNext;

    @FindBy(xpath = "//*[@class='gmail-nav__nav-link gmail-nav__nav-link__create-account']")
    private WebElement buttonCreateAccount;


    private By buttonPasswordNextLocator = By.xpath("//*[@id='passwordNext']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnButtonCreateAccount() {
        buttonCreateAccount.click();
    }

    public LoginPage clickOnButtonSignIn() {
        buttonSignIn.click();
        return this;
    }

    public LoginPage clickOnPasswordNext() {
        waitForElementVisible(buttonPasswordNextLocator);
        waitForElementAndClick(driver, buttonPasswordNextLocator);
        return this;
    }

    public LoginPage clickOnIdentifierNext() {
        idNext.click();
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
