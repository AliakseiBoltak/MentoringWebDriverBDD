package hooks;

import browser.BrowserProvider;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.log4j.Logger;
import property.PropertyProvider;

public class Hooks {

    private static Logger log = Logger.getLogger(Hooks.class);

    @Before
    public void openBrowserAndNavigateToBaseURL() {
        BrowserProvider.getBrowser().get(PropertyProvider.getProperty("url"));
    }

    @After
    public void closeBrowser(Scenario scenario) {
        if (scenario.isFailed()) {
            try {
                byte[] screenshot = BrowserProvider.getBrowser().getScreenshotAsBytes();
                scenario.embed(screenshot, "image/png");
            } catch (Exception e) {
                log.error("Unable to attach screenshot ", e);
            }
        }
        BrowserProvider.closeBrowser();
    }
}
