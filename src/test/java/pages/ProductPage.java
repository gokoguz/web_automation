package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtil;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class ProductPage extends BasePage {

    private final By cartCount = By.cssSelector(".shopping_cart_badge");
    private final By cartLink = By.className("shopping_cart_link");
    private final By productPrices = By.className("inventory_item_price");
    private final By productTitle = By.className("title");
    private final By sortSelect = By.className("product_sort_container");

    public ProductPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart(String productName) {
        String formattedName = productName.toLowerCase().replace(" ", "-").replaceAll("[^a-z0-9\\-]", "");
        By idLocator = By.id("add-to-cart-" + formattedName);
        if (!driver.findElements(idLocator).isEmpty()) {
            click(idLocator);
            return;
        }

        By productButton = By.xpath("//div[contains(@class,'inventory_item_name') and normalize-space(text())='" + productName + "']/ancestor::div[contains(@class,'inventory_item')]//button[contains(@id,'add-to-cart') or contains(text(),'Add to cart')]");
        click(productButton);
    }

    public String getCartCount() {
        List<WebElement> badges = findElements(cartCount);
        if (badges.isEmpty()) {
            return "0";
        }

        // Try to get text directly first
        String text = badges.get(0).getText();
        if (text != null && !text.trim().isEmpty() && !text.equals("null")) {
            return text;
        }

        // If direct text fails, try JavaScript
        try {
            return (String) ((org.openqa.selenium.JavascriptExecutor) driver)
                .executeScript("return arguments[0].textContent;", badges.get(0));
        } catch (Exception e) {
            return "0";
        }
    }

    public void waitForCartCount(String expectedCount) {
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.presenceOfElementLocated(cartCount));

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(driver -> {
                    String actualText = getCartCount();
                    return expectedCount.equals(actualText);
                });
    }

    public void goToCart() {
        click(cartLink);
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.urlContains("cart.html"));
        WaitUtil.waitForVisible(driver, By.className("cart_item"));
    }

    public void sortProductsBy(String option) {
        org.openqa.selenium.WebElement selectElement = WaitUtil.waitForClickable(driver, sortSelect);
        Select select = new Select(selectElement);
        select.selectByVisibleText(option);
    }

    public boolean isProductsPageVisible() {
        return getText(productTitle).equalsIgnoreCase("Products");
    }

    public boolean arePricesSortedAscending() {
        List<Double> prices = findElements(productPrices)
                .stream()
                .map(WebElement::getText)
                .map(text -> text.replaceAll("[^0-9.,]", ""))
                .map(price -> Double.parseDouble(price.replace(",", ".")))
                .collect(Collectors.toList());

        for (int i = 1; i < prices.size(); i++) {
            if (prices.get(i) < prices.get(i - 1)) {
                return false;
            }
        }
        return true;
    }
}