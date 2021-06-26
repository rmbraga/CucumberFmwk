package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    private By emailId = By.id("email");
    private By password = By.id("passwd");
    private By signInButton = By.id("SubmitLogin");
    private By forgotPwdLink = By.linkText("Forgot your password?");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isForgotPwdLinkPresent() {
        return driver.findElement(forgotPwdLink).isDisplayed();
    }

    public void enterUsername(String username) {
        driver.findElement(emailId).sendKeys(username);
    }

    public void enterPwd(String pwd) {
        driver.findElement(password).sendKeys(pwd);
    }

    public void clickOnLogin() {
        driver.findElement(signInButton).click();
    }

    public AccountsPage doLogin(String username, String pwd) {
        enterUsername(username);
        enterPwd(pwd);
        clickOnLogin();
        return new AccountsPage(driver);
    }
}
