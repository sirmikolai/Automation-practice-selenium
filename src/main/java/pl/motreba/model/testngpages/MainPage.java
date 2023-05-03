package pl.motreba.model.testngpages;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    private static final Log logger = LogFactory.getLog(MainPage.class);

    private static final String SIGN_IN_BUTTON_CSS = "a[class='login']";

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage clickSignInButton() {
        logger.info("Click 'Sign in' button");
        seleniumWait.waitForPageInitialization();
        seleniumWait.waitUntil(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(SIGN_IN_BUTTON_CSS)));
        driver.findElement(By.cssSelector(SIGN_IN_BUTTON_CSS)).click();
        seleniumWait.waitForPageInitialization();
        return this;
    }

}
