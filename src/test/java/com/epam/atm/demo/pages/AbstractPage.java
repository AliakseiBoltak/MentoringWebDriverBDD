package com.epam.atm.demo.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.epam.atm.demo.Utils.RandomString.getRandomString;

public abstract class AbstractPage {

    private Logger log = Logger.getLogger(AbstractPage.class);

    protected WebDriver driver;
    public static final String SUBJECT = getRandomString(15);
    public static final String BODY = getRandomString(25);
    public static final String RECEIVER = "irymvi@gmail.com";

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public boolean isElementExists(WebDriver driver, By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            log.info("Element with locator " + by + " does not exist");
            return false;
        }
    }

    public void moveToElement(WebDriver driver, By by) {
        WebElement element = driver.findElement(by);
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    public void waitForElementAndClick(WebDriver driver, By by) {
        new WebDriverWait(driver, 15).ignoring(StaleElementReferenceException.class, WebDriverException.class)
                .until(ExpectedConditions.elementToBeClickable(by));
        driver.findElement(by).click();
    }

}
