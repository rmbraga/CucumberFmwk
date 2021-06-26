package com.framework.utils;

import com.framework.factory.DriverFactory;
import org.openqa.selenium.WebDriver;

public class WebDriverCommon {

    WebDriver driver = DriverFactory.getDriver();

    public String getPageTitle() {
        return driver.getTitle();
    }
}
