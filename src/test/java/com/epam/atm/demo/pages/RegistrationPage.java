package com.epam.atm.demo.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends AbstractPage {

    @FindBy(xpath = "//*[@name='firstName']")
    private WebElement inputFirstName;

    @FindBy(xpath = "//*[@name='lastName']")
    private WebElement inputLastName;

    @FindBy(xpath = "//*[@name='Username']")
    private WebElement inputUserName;

    @FindBy(xpath = "//*[@name='Passwd']")
    private WebElement inputPassword;

    @FindBy(xpath = "//*[@name='ConfirmPasswd']")
    private WebElement inputConfirmPassword;

    @FindBy(xpath = "//*[contains(text(), 'Далее')]")
    private WebElement buttonNext;

    @FindBy(xpath = "//*[contains(text(), 'Укажите имя')]")
    private WebElement textEnterFirstName;

    @FindBy(xpath = "//*[contains(text(), 'Укажите фамилию')]")
    private WebElement textEnterLastName;

    public boolean isTextEnterFirstNameDisplayed(){
        return textEnterFirstName.isDisplayed();
    }

     public boolean isTextEnterLastNameDisplayed(){
        return textEnterLastName.isDisplayed();
    }

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage fillFirstName(String firstName){
        inputFirstName.sendKeys(firstName);
        return this;
    }

    public RegistrationPage fillLastName(String lastName){
        inputLastName.sendKeys(lastName);
        return this;
    }

    public RegistrationPage fillUserName(String userName){
        inputUserName.sendKeys(userName);
        return this;
    }

    public RegistrationPage fillPassword(String pass){
        inputPassword.sendKeys(pass);
        return this;
    }

    public RegistrationPage confirmPassword(String pass){
        inputConfirmPassword.sendKeys(pass);
        return this;
    }

    public RegistrationPage submitRegistrationForm(){
        buttonNext.click();
        return this;
    }


}
