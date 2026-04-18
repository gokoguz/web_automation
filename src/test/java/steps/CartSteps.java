package steps;

import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import drivers.DriverFactory;
import pages.CartPage;
import pages.ProductPage;

import static org.junit.Assert.*;

public class CartSteps {

    WebDriver driver = DriverFactory.getDriver();

    ProductPage productPage = new ProductPage(driver);
    CartPage cartPage = new CartPage(driver);

    @When("user adds {string} to cart")
    public void user_adds_product_to_cart(String productName) {
        productPage.addProductToCart(productName);
    }

    @When("user removes {string} from cart")
    public void user_removes_product_from_cart(String productName) {
        productPage.goToCart();
        cartPage.removeProduct(productName);
    }

    @Then("cart badge should show {string}")
    public void cart_badge_should_show(String count) {
        productPage.waitForCartCount(count);
        assertEquals(count, productPage.getCartCount());
    }

    @Then("cart should contain {string}")
    public void cart_should_contain_product(String productName) {
        assertTrue(cartPage.isProductInCart(productName));
    }

    @Then("cart should be empty")
    public void cart_should_be_empty() {
        assertTrue(cartPage.isCartEmpty());
    }

    @Given("user is on cart page")
    public void user_is_on_cart_page() {
        productPage.goToCart();
    }
}