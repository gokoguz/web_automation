package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class CartPage {

    private WebDriver driver;

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    private By cartItems = By.className("cart_item");
    private By itemName = By.className("inventory_item_name");
    private By removeButton = By.xpath(".//button[contains(text(),'Remove')]");

    public void removeProduct(String name) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(cartItems));

        List<WebElement> list = driver.findElements(cartItems);
        int initialSize = list.size();
        for (WebElement item : list) {
            String productName = item.findElement(itemName).getText();
            if (productName.equalsIgnoreCase(name)) {
                WebElement removeBtn = item.findElement(removeButton);
                try {
                    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", removeBtn);
                } catch (Exception e) {
                    removeBtn.click();
                }

                wait.until(ExpectedConditions.numberOfElementsToBe(cartItems, initialSize - 1));
                return;
            }
        }

        throw new RuntimeException("Product not found in cart: " + name);
    }

    public boolean isProductInCart(String name) {
        return driver.findElements(itemName)
                .stream()
                .anyMatch(e -> e.getText().equalsIgnoreCase(name));
    }

    public boolean isCartEmpty() {
        return driver.findElements(cartItems).isEmpty();
    }
}