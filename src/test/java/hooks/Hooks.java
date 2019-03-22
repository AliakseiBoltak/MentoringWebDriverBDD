package hooks;

import browser.BrowserProvider;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import property.PropertyProvider;

public class Hooks {

    @Before
    public void openBrowserAndNavigateToBaseURL() {
        BrowserProvider.getBrowser().get(PropertyProvider.getProperty("url"));
    }

    @After
    public void closeBrowser() {
        BrowserProvider.closeBrowser();
    }
}
