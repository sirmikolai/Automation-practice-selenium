package pl.motreba.core;

import pl.motreba.core.browser.BrowserType;

import java.util.Arrays;

public interface PomParams {

    default BrowserType getBrowserType() {
        final String browserValue = System.getProperty("browser").toUpperCase();
        return Arrays.stream(BrowserType.values()).filter(b -> b.toString().equalsIgnoreCase(browserValue)).findFirst().orElse(BrowserType.CHROME);
    }

    default boolean isHeadlessModeEnabled() {
        final String isHeadless = System.getProperty("headless");
        return isHeadless.toLowerCase().equalsIgnoreCase("yes");
    }
}
