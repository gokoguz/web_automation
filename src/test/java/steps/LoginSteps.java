package steps;

import drivers.DriverFactory;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.LoginPage;
import pages.MenuPage;

public class LoginSteps {

    LoginPage loginPage = new LoginPage(DriverFactory.getDriver());
    MenuPage menuPage = new MenuPage(DriverFactory.getDriver());

    @Given("user is on login page")
    public void user_is_on_login_page() {
        loginPage.open();
    }

    @Given("user is logged in with {string} and {string}")
    public void user_is_logged_in_with_and(String user, String pass) {
        loginPage.open();
        loginPage.login(user, pass);
    }

    @When("user logs in with {string} and {string}")
    public void user_logs_in_with_and(String user, String pass) {
        loginPage.login(user, pass);
    }

    @When("user logs out")
    public void user_logs_out() {
        menuPage.logout();
    }

    @Then("user should see products page")
    public void user_should_see_products_page() {
        Assert.assertTrue("Products page should be visible", loginPage.isProductsPageVisible());
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Assert.assertTrue("Error message should appear after failed login", loginPage.isErrorMessageDisplayed());
    }

    @Then("login page should be displayed")
    public void login_page_should_be_displayed() {
        Assert.assertTrue("Login page should be displayed after logout", loginPage.isLoginPageDisplayed());
    }
}