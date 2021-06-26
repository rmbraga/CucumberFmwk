package com.stepsdefinition;

import com.framework.factory.DriverFactory;
import com.framework.pages.AccountsPage;
import com.framework.pages.LoginPage;
import com.framework.utils.WebDriverCommon;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class AccountsPageSteps extends WebDriverCommon {

    private LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    private AccountsPage accountsPage;

    @Given("user is already logged into the application")
    public void user_is_already_logged_into_the_application(DataTable credentalTable) {
        List<Map<String, String>> credentials = credentalTable.asMaps();
        String username = credentials.get(0).get("username");
        String pwd = credentials.get(0).get("password");
        accountsPage = loginPage.doLogin(username, pwd);
    }

    @Given("user is on Accounts page")
    public void userIsOnAccountsPage() {
        System.out.println("Account page title: " + getPageTitle());
    }

    @Then("user gets accounts section")
    public void userGetsAccountsSection(DataTable sectionTable) {
        System.out.println("Expected List" + sectionTable.asList());
        System.out.println("Current List: " + accountsPage.getAccountsPageSectionList());
        assertTrue(sectionTable.asList().containsAll(accountsPage.getAccountsPageSectionList()));
    }

    @Then("accounts section count should be {int}")
    public void accountsSectionCountShouldBe(int expectedSectionCount) {
        assertTrue(accountsPage.getAccountsSectionCount() == expectedSectionCount);
    }
}
