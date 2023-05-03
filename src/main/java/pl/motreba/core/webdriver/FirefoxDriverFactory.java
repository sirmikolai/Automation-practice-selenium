package pl.motreba.core.webdriver;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import pl.motreba.core.PomParams;

public class FirefoxDriverFactory implements DriverFactory, PomParams {

    public WebDriver createWebDriver() {
        FirefoxOptions options = new FirefoxOptions();
        options.addPreference("intl.accept_languages", "en-US");
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);
        if (isHeadlessModeEnabled()) {
            options.addArguments("--headless");
        }
        return new FirefoxDriver(options);
    }
}
