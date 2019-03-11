package stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import pages.GmailLoginPage;
import pages.GmailMainPage;
import pages.GmailPasswordPage;

public class MyStepdefs {

    @Given("^I Logged into the gmail account$")
    public void iLoggedIntoGmailAccount() {
        new GmailLoginPage().pressSignInButton().fillEmailIInput().pressNextButton();
        new GmailPasswordPage().fillGmailPasswordInput().pressPasswordNextButton();
    }

    @When("^I Compose new email$")
    public void iComposeNewEmail() {
        new GmailMainPage().pressComposeButton()
                .fillRecipientInput()
                .fillSubjectInput()
                .fillBodyInput();
    }

    @When("^I Close email$")
    public void iCloseThisEmail() {
        new GmailMainPage().saveAndCloseEmail();
    }

    @When("^I send email from Drafts$")
    public void iSendWEmailFromDrafrs() {
        new GmailMainPage().clickOnDraftsLink()
                .clickOnDraftEmail()
                .waitForRecipientToLoadInEmail()
                .sendEmail();
    }

    @Then("^I see that this email is saved in drafts$")
    public void iSeeThatThisEmailIsSavedInDrafts() {
        Assert.assertTrue(new GmailMainPage().isEmailAppearedInDrafts());
    }

    @When("^I open Sent folder$")
    public void iOpenSentFolder() {
        new GmailMainPage().clickOnSentLink();
    }

    @Then("^I see that this email appeared in Sent folder$")
    public void iSeeThatThisEmailAppearedInSentFolder() {
        Assert.assertTrue(new GmailMainPage().isEmailAppearedInSentFolder());
    }

    @When("^I open Drafts$")
    public void iOpenDrafts() {
        new GmailMainPage().clickOnDraftsLink();
    }

    @When("^I logout$")
    public void iLogOut() {
        new GmailMainPage().clickOnImageButton().clickOnSignOutButton();
    }

    @When("^I log out without saving changes$")
    public void iLogOutWithoutSavingChanges() {
        new GmailMainPage().clickOnImageButton().clickOnSignOutButton().acceptAlert();
    }

    @Then("^I am on the enter password page$")
    public void iAmOnTheEnterPasswordPage() {
        Assert.assertTrue(new GmailPasswordPage().isPasswordInputDisplayed());
    }
}

