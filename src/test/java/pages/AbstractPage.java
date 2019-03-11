package pages;

import browser.Browser;
import org.openqa.selenium.support.PageFactory;
import browser.BrowserProvider;

public abstract class AbstractPage {

    protected Browser browser;

    public AbstractPage() {
        this.browser = BrowserProvider.getBrowser();
        PageFactory.initElements(browser, this);
    }
}
