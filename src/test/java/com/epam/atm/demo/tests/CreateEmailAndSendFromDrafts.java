package com.epam.atm.demo.tests;

import com.epam.atm.demo.pages.LoginPage;
import com.epam.atm.demo.pages.UserAccountPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateEmailAndSendFromDrafts extends BaseTest {

    private Logger log = Logger.getLogger(CreateEmailAndSendFromDrafts.class);

    @Test()
    public void createDraftEmailAndSendItFromDraftsFolder() {

        log.info("Login into user`s account");
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(USER_EMAIL, USER_PASSWORD);

        log.info("Create new email and save it in drafts");
        UserAccountPage userAccountPage = new UserAccountPage(driver);
        userAccountPage.createNewEmailAndSaveItInDrafts();

        log.info("Navigate to drafts and check email is saved in drafts");
        userAccountPage.navigateToDrafts();
        Assert.assertTrue(userAccountPage.isEmailDisplayedInDrafts());

        log.info("Send email");
        userAccountPage.sendDraftEmail();

        log.info("Navigate to sent folder and check that email is in sent folder");
        userAccountPage.clickOnSentLink();
        Assert.assertTrue(userAccountPage.isEmailDisplayedInSentFolder());

        log.info("Log out from user`s account");
        userAccountPage.logout();

    }
}
