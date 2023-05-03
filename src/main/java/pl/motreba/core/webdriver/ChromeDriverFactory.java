package pl.motreba.core.webdriver;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import pl.motreba.core.PomParams;

public class ChromeDriverFactory implements DriverFactory, PomParams {

    public WebDriver createWebDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--lang=en");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("start-maximized");
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);
        if (isHeadlessModeEnabled()) {
            options.addArguments("--headless=new");
        }
        return new ChromeDriver(options);
    }
}
