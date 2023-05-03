package testngtests.abstractClasses;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import pl.motreba.core.PomParams;
import pl.motreba.core.browser.Browser;
import pl.motreba.core.browser.BrowserType;
import pl.motreba.core.waits.SeleniumWait;
import pl.motreba.core.webdriver.ChromeDriverFactory;
import pl.motreba.core.webdriver.EdgeDriverFactory;
import pl.motreba.core.webdriver.FirefoxDriverFactory;

public abstract class AbstractTest implements PomParams {

    private static final Log logger = LogFactory.getLog(AbstractTest.class);

    protected WebDriver driver;
    private SeleniumWait seleniumWait;
    private static ThreadLocal<WebDriver> threadLocalDriver = new ThreadLocal<>();
    private static final String BASE_URL = "http://automationpractice.pl/";

    public void setup() {
        this.driver = getBrowser();
        this.seleniumWait = new SeleniumWait(driver);
        threadLocalDriver.set(driver);
        openBrowser(BASE_URL);
    }

    private WebDriver getBrowser() {
        BrowserType browserType = getBrowserType();
        switch (browserType) {
            case FIREFOX:
                return new Browser(new FirefoxDriverFactory()).getDriver();
            case EDGE:
                return new Browser(new EdgeDriverFactory()).getDriver();
            default:
                return new Browser(new ChromeDriverFactory()).getDriver();
        }
    }

    public static WebDriver getDriver() {
        return threadLocalDriver.get();
    }

    private void openBrowser(String url) {
        logger.info(String.format("Connecting to %s...", url));
        driver.manage().deleteAllCookies();
        driver.get(url);
        driver.manage().window().maximize();
    }

    @AfterClass(alwaysRun = true)
    public void quitDriver() {
        if (driver != null) {
            logger.info("Quit driver...");
            driver.quit();
        }
    }

}
