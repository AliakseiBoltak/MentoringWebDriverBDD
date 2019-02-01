package com.epam.atm.demo.tests;

import com.epam.atm.demo.pages.LoginPage;
import com.epam.atm.demo.pages.RegistrationPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubmitEmptyRegistrationForm extends BaseTest {

    private Logger log = Logger.getLogger(SubmitEmptyRegistrationForm.class);
    public static final String REGISTRATION_PAGE_TITLE = "Create your Google Account";

    @Test
    public void registerNewUser() {
        log.info("Navigate to home page");
        driver.get(BASE_URL);

        log.info("Navigate to create account page");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickOnButtonCreateAccount();

        log.info("Switch to new registration tab in browser");
        loginPage.switchToRequiredTabInBrowser(REGISTRATION_PAGE_TITLE);

        log.info("Submit empty form");
        RegistrationPage registrationPage = new RegistrationPage(driver);
        registrationPage.submitRegistrationForm();

        log.info("Verify that empty form was not sent, error message is displayed");
        Assert.assertTrue(registrationPage.isTextEnterFirstNameDisplayed(), "Alert enter first name is not displayed");
        Assert.assertTrue(registrationPage.isTextEnterLastNameDisplayed(), "Alert enter last name is not displayed");

    }
}
