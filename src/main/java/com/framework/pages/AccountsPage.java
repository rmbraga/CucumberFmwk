package com.framework.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class AccountsPage {

    private WebDriver driver;

    private By accountsSection = By.cssSelector("div#center_column span");

    public AccountsPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getAccountsSectionCount() {
        return driver.findElements(accountsSection).size();
    }

    public List<String> getAccountsPageSectionList() {
        List<WebElement> accountsHeaderList = driver.findElements(accountsSection);

        return accountsHeaderList
                .stream()
                .map(l -> l.getText())
                .collect(Collectors.toList());
    }
}
