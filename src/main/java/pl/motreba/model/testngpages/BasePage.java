package pl.motreba.model.testngpages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pl.motreba.core.waits.SeleniumWait;

public class BasePage {

    protected WebDriver driver;
    protected JavascriptExecutor jsExecutor;
    protected SeleniumWait seleniumWait;
    protected Actions actions;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.jsExecutor = ((JavascriptExecutor) driver);
        this.seleniumWait = new SeleniumWait(driver);
        this.actions = new Actions(driver);
    }

}
