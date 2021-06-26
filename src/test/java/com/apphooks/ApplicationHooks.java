package com.apphooks;

import com.framework.factory.DriverFactory;
import com.framework.utils.ConfigReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.util.Properties;

import static org.openqa.selenium.OutputType.BYTES;

public class ApplicationHooks {

    private DriverFactory driverFactory;
    private WebDriver driver;
    private ConfigReader configReader;
    Properties prop;

    @Before(order = 0)
    public void getProperty() {
        configReader = new ConfigReader();
        prop = configReader.initProperties();
    }

    @Before(order = 1)
    public void launchBrowser() {
        driverFactory = new DriverFactory();
        driver = driverFactory.initDriver(prop.getProperty("browser"));
        driver.get(prop.getProperty("url"));
    }

    @After(order = 0)
    public void quitBrowser() {
        driver.quit();
    }

    @After(order = 1)
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            String ssName = scenario.getName().replaceAll(" ", "_");
            byte[] sourcePath = ((TakesScreenshot) driver).getScreenshotAs(BYTES);
            scenario.attach(sourcePath, "image/png", ssName);
        }
    }

}
