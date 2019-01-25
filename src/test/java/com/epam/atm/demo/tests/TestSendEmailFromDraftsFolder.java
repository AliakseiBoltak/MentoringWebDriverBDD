package com.epam.atm.demo.tests;

import com.epam.atm.demo.pages.UserAccountPage;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestSendEmailFromDraftsFolder extends BaseTest {

    private Logger log = Logger.getLogger(TestSendEmailFromDraftsFolder.class);
    private UserAccountPage userAccountPage;

    @Test()
    public void createDraftEmailAndSendItFromDraftsFolder() {

        userAccountPage = new UserAccountPage(driver);

        log.info("Create new email and save it in drafts");
        userAccountPage.createNewEmailAndSaveItInDrafts();

        log.info("Navigate to drafts and check email is saved in drafts");
        userAccountPage.navigateToDrafts();
        Assert.assertTrue(userAccountPage.isEmailExists());

        log.info("Send email and check that it disappeared from drafts");
        userAccountPage.sendDraftEmail();
        Assert.assertFalse(userAccountPage.isEmailExists());

        log.info("Navigate to sent folder and check that email now is in sent folder");
        userAccountPage.clickOnSentLink();
        Assert.assertTrue(userAccountPage.isEmailExists());

    }
}
