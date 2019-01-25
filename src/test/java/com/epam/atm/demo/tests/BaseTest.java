package com.epam.atm.demo.tests;

import com.epam.atm.demo.pages.LoginPage;
import com.epam.atm.demo.pages.UserAccountPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    private static final String BASE_URL = "https://www.google.com/intl/eng/gmail/about/#";
    private static final String USER_EMAIL = "irene.test02@gmail.com";
    private static final String USER_PASSWORD = "S2501552s";
    private Logger log = Logger.getLogger(BaseTest.class);
    private LoginPage loginPage;
    private UserAccountPage userAccountPage;
    protected WebDriver driver;

    @BeforeClass
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        log.info("Start browser");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void closeBrowser() {
        log.info("Close browser");
        driver.quit();
    }

    @BeforeMethod
    public void login() {
        log.info("Navigate to login page");
        driver.get(BASE_URL);
        log.info("Login into user`s account");
        loginPage = new LoginPage(driver);
        loginPage.login(USER_EMAIL, USER_PASSWORD);
    }

    @AfterMethod
    public void logout() {
        log.info("Log out from user`s account");
        userAccountPage = new UserAccountPage(driver);
        userAccountPage.logout();
    }
}
