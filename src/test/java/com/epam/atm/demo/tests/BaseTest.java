package com.epam.atm.demo.tests;

import com.epam.atm.demo.pages.LoginPage;
import com.epam.atm.demo.pages.RegistrationPage;
import com.epam.atm.demo.pages.UserAccountPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.util.concurrent.TimeUnit;

public abstract class BaseTest {

    public static final String BASE_URL = "https://www.google.com/intl/eng/gmail/about/#";
    public static final String USER_EMAIL = "irene.test02@gmail.com";
    public static final String USER_PASSWORD = "S2501552s";
    public Logger log = Logger.getLogger(BaseTest.class);
    protected WebDriver driver;

    @BeforeClass
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        log.info("Start browser");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    @AfterClass
    public void closeBrowser() {
        log.info("Close browser");
        driver.quit();
    }
}
