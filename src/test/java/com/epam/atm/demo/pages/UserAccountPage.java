package com.epam.atm.demo.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserAccountPage extends AbstractPage {

    private Logger log = Logger.getLogger(UserAccountPage.class);

    @FindBy(xpath = "//*[@aria-label='Google Account: Irene Ash  \n" +
            "(irene.test02@gmail.com)']")
    private WebElement labelGoogleAccount;

    @FindBy(xpath = "//*[contains(text(), 'Sign out')]")
    private WebElement buttonSignOut;

    @FindBy(css = ".aic .z0 div")
    private WebElement buttonComposeNewEmail;

    @FindBy(css = ".oj div textarea")
    private WebElement emailReceiver;

    @FindBy(name = "subjectbox")
    private WebElement emailSubject;

    @FindBy(css = ".Ar.Au div")
    private WebElement emailBody;

    @FindBy(className = "Ha")
    private WebElement labelClose;

    @FindBy(xpath = "//*[@title='Drafts']")
    private WebElement linkDraftEmails;

    @FindBy(xpath = "//td[@class='gU Up']")
    private WebElement buttonSendEmail;

    @FindBy(xpath = "//*[@title='Sent']")
    private WebElement linkSentEmails;

    @FindBy(xpath = "//*[@class='Hq aUG']")
    private WebElement imageFullSize;

    private By buttonComposeMenuLocator = By.xpath("//div[@class='z0']");

    public UserAccountPage(WebDriver driver) {
        super(driver);
    }

    public UserAccountPage clickOnLabelGoogleAccount() {
        labelGoogleAccount.click();
        return this;
    }

    public UserAccountPage clickOnButtonSignOut() {
        buttonSignOut.click();
        return this;
    }

    public UserAccountPage clickOnButtonComposeNewEmail() {
        buttonComposeNewEmail.click();
        return this;
    }

    public UserAccountPage enterEmailsReceiver() {
        emailReceiver.sendKeys(RECEIVER);
        return this;
    }

    public UserAccountPage enterEmailsSubject() {
        emailSubject.sendKeys(SUBJECT);
        return this;
    }

    public UserAccountPage enterEmailsBody() {
        emailBody.sendKeys(BODY);
        return this;
    }

    public UserAccountPage clickOnLabelCloseEmail() {
        labelClose.click();
        return this;
    }

    public UserAccountPage openEmailsMenu() {
        moveToElement(driver, buttonComposeMenuLocator);
        return this;
    }

    public UserAccountPage clickOnDraftsLink() {
        linkDraftEmails.click();
        return this;
    }

    public UserAccountPage clickOnSentLink() {
        linkSentEmails.click();
        return this;
    }

    public UserAccountPage sendEmail() {
        buttonSendEmail.click();
        return this;
    }

    public UserAccountPage clickOnFullSize() {
        imageFullSize.click();
        return this;
    }

    public UserAccountPage clickOnDraftEmail() {
        new WebDriverWait(driver, 10)
                .ignoring(StaleElementReferenceException.class)
                .until((WebDriver d) -> {
                    d.findElement(By.xpath(String.format("//span[contains(text(), '%s')]", SUBJECT))).click();
                    return true;
                });
        return this;
    }

    public UserAccountPage createNewEmailAndSaveItInDrafts() {
        clickOnButtonComposeNewEmail()
                .enterEmailsReceiver()
                .enterEmailsSubject()
                .enterEmailsBody()
                .clickOnLabelCloseEmail();
        return this;
    }

    public UserAccountPage navigateToDrafts() {
        openEmailsMenu()
                .clickOnDraftsLink()
                .clickOnDraftEmail();
        return this;
    }

    public UserAccountPage sendDraftEmail() {
        clickOnDraftEmail().clickOnFullSize().sendEmail();
        //Thread sleep here is to wait for email to be sent
        threadSleep();
        //refresh the page to update the dom structure
        driver.navigate().refresh();
        return this;
    }

    public boolean isEmailExists() {
        return isElementExists(driver, By.xpath(String.format("//span[contains(text(), '%s')]", SUBJECT))) &&
                isElementExists(driver, By.xpath(String.format("//span[contains(text(), '%s')]", BODY)));
    }

    public UserAccountPage logout() {
        clickOnLabelGoogleAccount().clickOnButtonSignOut();
        return this;
    }
}
