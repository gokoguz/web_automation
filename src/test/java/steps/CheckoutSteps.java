package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import drivers.DriverFactory;
import org.junit.Assert;
import pages.CheckoutPage;

public class CheckoutSteps {

    WebDriver driver = DriverFactory.getDriver();
    CheckoutPage checkoutPage = new CheckoutPage(driver);

    @When("user proceeds to checkout")
    public void user_proceeds_to_checkout() {
        checkoutPage.startCheckout();
    }

    @When("user fills checkout form with {string}, {string}, {string}")
    public void user_fills_checkout_form(String first, String last, String zip) {
        checkoutPage.fillInformation(first, last, zip);
        checkoutPage.continueCheckout();
    }

    @When("user completes the purchase")
    public void user_completes_purchase() {
        checkoutPage.finishCheckout();
    }

    @Then("order should be successful")
    public void order_should_be_successful() {
        Assert.assertTrue(
                checkoutPage.getSuccessMessage()
                        .toLowerCase()
                        .contains("thank you")
        );
    }

    @Then("checkout error message should be displayed")
    public void checkout_error_message_should_be_displayed() {
        Assert.assertTrue("Checkout validation error should be displayed", checkoutPage.isCheckoutErrorDisplayed());
    }
}