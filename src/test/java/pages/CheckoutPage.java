package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtil;

import java.time.Duration;

public class CheckoutPage extends BasePage {

    private final By errorMessage = By.cssSelector("h3[data-test='error']");

    @FindBy(className = "shopping_cart_link")
    WebElement cartLink;

    @FindBy(id = "checkout")
    WebElement checkoutButton;

    @FindBy(id = "first-name")
    WebElement firstName;

    @FindBy(id = "last-name")
    WebElement lastName;

    @FindBy(id = "postal-code")
    WebElement postalCode;

    @FindBy(id = "continue")
    WebElement continueBtn;

    @FindBy(id = "finish")
    WebElement finishBtn;

    @FindBy(className = "complete-header")
    WebElement successMessage;

    public CheckoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private final By cartLinkLocator = By.className("shopping_cart_link");
    private final By checkoutLocator = By.id("checkout");

    public void startCheckout() {
        org.openqa.selenium.WebElement cartBtn = WaitUtil.waitForClickable(driver, cartLinkLocator);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", cartBtn);

        // Wait for cart page to load and stabilize
        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.urlContains("cart.html"));
        WaitUtil.waitForPageLoad(driver);
        WaitUtil.waitForVisible(driver, By.className("cart_list"));

        // Wait for checkout button to appear and be clickable
        org.openqa.selenium.WebElement checkoutBtn = WaitUtil.waitForClickable(driver, checkoutLocator);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", checkoutBtn);

        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(ExpectedConditions.urlContains("checkout-step-one.html"));
        WaitUtil.waitForVisible(driver, By.id("first-name"));
    }

    public void fillInformation(String first, String last, String zip) {
        type(By.id("first-name"), first);
        type(By.id("last-name"), last);
        type(By.id("postal-code"), zip);
    }

    public void continueCheckout() {
        org.openqa.selenium.WebElement continueBtn = WaitUtil.waitForClickable(driver, By.id("continue"));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", continueBtn);

        new WebDriverWait(driver, Duration.ofSeconds(20))
                .until(d -> d.getCurrentUrl().contains("checkout-step-two.html")
                        || !d.findElements(errorMessage).isEmpty());

        if (driver.getCurrentUrl().contains("checkout-step-two.html")) {
            WaitUtil.waitForVisible(driver, By.id("finish"));
        }
    }

    public void finishCheckout() {
        org.openqa.selenium.WebElement finishBtn = WaitUtil.waitForClickable(driver, By.id("finish"));
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", finishBtn);
        WaitUtil.waitForPageLoad(driver);
        new WebDriverWait(driver, Duration.ofSeconds(15))
                .until(ExpectedConditions.urlContains("checkout-complete.html"));
        WaitUtil.waitForVisible(driver, By.className("complete-header"));
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public boolean isCheckoutErrorDisplayed() {
        return driver.findElements(errorMessage).stream()
                .anyMatch(element -> element.isDisplayed());
    }
}