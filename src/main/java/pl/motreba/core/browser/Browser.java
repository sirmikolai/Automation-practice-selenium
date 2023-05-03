package pl.motreba.core.browser;

import org.openqa.selenium.WebDriver;
import pl.motreba.core.webdriver.DriverFactory;

public class Browser {

    private final DriverFactory driverFactory;

    public Browser(DriverFactory driverFactory) {
        this.driverFactory = driverFactory;
    }

    public WebDriver getDriver() {
        return this.driverFactory.createWebDriver();
    }
}
