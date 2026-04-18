import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class DebugLocators {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://www.saucedemo.com/");
            Thread.sleep(2000);
            driver.findElement(By.id("user-name")).sendKeys("standard_user");
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            Thread.sleep(5000);
            System.out.println("Title=" + driver.getTitle());
            System.out.println("Current URL=" + driver.getCurrentUrl());
            System.out.println("Has cart link=" + !driver.findElements(By.className("shopping_cart_link")).isEmpty());
            if (!driver.findElements(By.className("shopping_cart_link")).isEmpty()) {
                System.out.println("Cart link HTML=" + driver.findElement(By.className("shopping_cart_link")).getAttribute("outerHTML"));
            }
            System.out.println("Has cart badge=" + !driver.findElements(By.cssSelector(".shopping_cart_badge")).isEmpty());
            if (!driver.findElements(By.cssSelector(".shopping_cart_badge")).isEmpty()) {
                System.out.println("Cart badge HTML=" + driver.findElement(By.cssSelector(".shopping_cart_badge")).getAttribute("outerHTML"));
            }
            System.out.println("Has menu button=" + !driver.findElements(By.id("react-burger-menu-btn")).isEmpty());
            System.out.println("Has logout link=" + !driver.findElements(By.id("logout_sidebar_link")).isEmpty());
            System.out.println("Has cart item name=" + !driver.findElements(By.className("inventory_item_name")).isEmpty());
            List<WebElement> addButtons = driver.findElements(By.xpath("//button[contains(@id,'add-to-cart')]") );
            System.out.println("Add button count=" + addButtons.size());
            if (!addButtons.isEmpty()) {
                WebElement button = addButtons.get(0);
                String buttonId = button.getAttribute("id");
                System.out.println("First add id=" + buttonId);
                System.out.println("First add text=" + button.getText());
                System.out.println("First add displayed=" + button.isDisplayed());
                System.out.println("First add enabled=" + button.isEnabled());
                System.out.println("First add outerHTML=" + button.getAttribute("outerHTML"));
                ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", button);
                Thread.sleep(5000);
                System.out.println("After add, has cart badge=" + !driver.findElements(By.cssSelector(".shopping_cart_badge")).isEmpty());
                if (!driver.findElements(By.cssSelector(".shopping_cart_badge")).isEmpty()) {
                    System.out.println("Cart badge HTML after add=" + driver.findElement(By.cssSelector(".shopping_cart_badge")).getAttribute("outerHTML"));
                    System.out.println("Cart badge text=" + driver.findElement(By.cssSelector(".shopping_cart_badge")).getText());
                }
                System.out.println("Cart link HTML after add=" + driver.findElement(By.className("shopping_cart_link")).getAttribute("outerHTML"));
                org.openqa.selenium.WebElement cartLink = driver.findElement(By.className("shopping_cart_link"));
                ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", cartLink);
                Thread.sleep(5000);
                System.out.println("After cart click current URL=" + driver.getCurrentUrl());
                System.out.println("Cart page has cart items=" + !driver.findElements(By.className("cart_item")).isEmpty());

                System.out.println("Logout visible before menu click=" + !driver.findElements(By.id("logout_sidebar_link")).isEmpty());
                org.openqa.selenium.WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
                ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", menuButton);
                Thread.sleep(3000);
                System.out.println("Logout visible after menu click=" + !driver.findElements(By.id("logout_sidebar_link")).isEmpty());
                if (!driver.findElements(By.id("logout_sidebar_link")).isEmpty()) {
                    System.out.println("Logout HTML=" + driver.findElement(By.id("logout_sidebar_link")).getAttribute("outerHTML"));
                    System.out.println("Menu button HTML=" + menuButton.getAttribute("outerHTML"));
                }

                // Checkout inspection
                if (!driver.findElements(By.id("checkout")).isEmpty()) {
                    org.openqa.selenium.WebElement checkoutBtn = driver.findElement(By.id("checkout"));
                    ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", checkoutBtn);
                    Thread.sleep(3000);
                    System.out.println("After checkout click URL=" + driver.getCurrentUrl());
                    System.out.println("First name element exists=" + !driver.findElements(By.id("first-name")).isEmpty());
                    if (!driver.findElements(By.id("first-name")).isEmpty()) {
                        org.openqa.selenium.WebElement firstName = driver.findElement(By.id("first-name"));
                        System.out.println("First name displayed=" + firstName.isDisplayed());
                        System.out.println("First name enabled=" + firstName.isEnabled());
                        System.out.println("First name outerHTML=" + firstName.getAttribute("outerHTML"));
                        driver.findElement(By.id("first-name")).sendKeys("Ali");
                        driver.findElement(By.id("last-name")).sendKeys("Veli");
                        driver.findElement(By.id("postal-code")).sendKeys("34000");
                        org.openqa.selenium.WebElement continueBtn = driver.findElement(By.id("continue"));
                        System.out.println("Continue displayed=" + continueBtn.isDisplayed());
                        System.out.println("Continue enabled=" + continueBtn.isEnabled());
                        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", continueBtn);
                        Thread.sleep(3000);
                        System.out.println("After continue click URL=" + driver.getCurrentUrl());
                        System.out.println("Finish button exists=" + !driver.findElements(By.id("finish")).isEmpty());
                        if (!driver.findElements(By.id("finish")).isEmpty()) {
                            org.openqa.selenium.WebElement finishBtn = driver.findElement(By.id("finish"));
                            System.out.println("Finish displayed=" + finishBtn.isDisplayed());
                            System.out.println("Finish enabled=" + finishBtn.isEnabled());
                            System.out.println("Finish outerHTML=" + finishBtn.getAttribute("outerHTML"));
                        }
                    }
                }
            }
        } finally {
            driver.quit();
        }
    }
}
