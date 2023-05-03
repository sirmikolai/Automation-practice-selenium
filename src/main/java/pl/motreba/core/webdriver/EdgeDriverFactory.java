package pl.motreba.core.webdriver;

import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import pl.motreba.core.PomParams;

public class EdgeDriverFactory implements DriverFactory, PomParams {

    public WebDriver createWebDriver() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--lang=en");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("start-maximized");
        options.setCapability(CapabilityType.ACCEPT_INSECURE_CERTS, true);
        options.setUnhandledPromptBehaviour(UnexpectedAlertBehaviour.DISMISS);
        if (isHeadlessModeEnabled()) {
            options.addArguments("--headless=new");
        }
        return new EdgeDriver(options);
    }
}
