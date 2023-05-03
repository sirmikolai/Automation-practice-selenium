package pl.motreba.core.waits;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class SeleniumWait {

    private static final Log logger = LogFactory.getLog(SeleniumWait.class);

    private WebDriver driver;
    private static final int TIMEOUT = 25;

    public SeleniumWait(WebDriver driver) {
        this.driver = driver;
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TIMEOUT));
    }

    public void waitUntil(ExpectedCondition<?> expectedCondition, int seconds) {
        logger.info(String.format("Waiting until \"%s\" for %d seconds...", expectedCondition.toString(), seconds));
        new WebDriverWait(driver, Duration.ofSeconds(seconds)).until(expectedCondition);
    }

    public void waitUntil(ExpectedCondition<?> expectedCondition) {
        logger.info(String.format("Waiting until \"%s\" for %d seconds...", expectedCondition.toString(), TIMEOUT));
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)).until(expectedCondition);
    }

    public void waitInMillis(int milliseconds) {
        logger.info(String.format("Waiting for %d milliseconds...", milliseconds));
        sleepInMillis(milliseconds);
    }

    public void waitInSeconds(int seconds) {
        logger.info(String.format("Waiting for %d seconds...", seconds));
        sleepInMillis(seconds * 1000);
    }

    private void sleepInMillis(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void waitForPageInitialization() {
        logger.info("Waiting until page has been initialized for 25 seconds...");
        final String jsScript = "return document.readyState";
        JavascriptExecutor jsExecutor = ((JavascriptExecutor) driver);
        ExpectedCondition<Boolean> pageInitializationCondition = driver1 -> jsExecutor.executeScript(jsScript).equals("complete");
        new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT)).until(pageInitializationCondition);
    }

}
