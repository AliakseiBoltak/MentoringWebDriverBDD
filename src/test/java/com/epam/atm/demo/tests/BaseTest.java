package com.epam.atm.demo.tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    public static final String BASE_URL = "https://www.google.com/intl/ru/gmail/about/#";
    public static final String USER_EMAIL = "irene.test02@gmail.com";
    public static final String USER_PASSWORD = "S2501552s";
    public Logger log = Logger.getLogger(BaseTest.class);
    protected WebDriver driver;

    @BeforeClass
    public void startBrowserAndOpenBaseURL() {
        WebDriverManager.chromedriver().setup();
        log.info("Start browser");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        log.info("Navigate to home page");
        driver.get(BASE_URL);
    }

    @AfterClass
    public void closeBrowser() {
        log.info("Close browser");
        driver.quit();
    }
}
