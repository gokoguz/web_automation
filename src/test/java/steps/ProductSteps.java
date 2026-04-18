package steps;

import drivers.DriverFactory;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.ProductPage;

public class ProductSteps {

    ProductPage productPage = new ProductPage(DriverFactory.getDriver());

    @When("user sorts products by {string}")
    public void user_sorts_products(String option) {
        productPage.sortProductsBy(option);
    }

    @Then("products should be sorted by price ascending")
    public void verify_sorting() {
        Assert.assertTrue("Product prices should be sorted from low to high", productPage.arePricesSortedAscending());
    }
}