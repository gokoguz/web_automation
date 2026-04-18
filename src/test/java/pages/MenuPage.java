package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtil;

public class MenuPage extends BasePage {

    private final By menuButtonLocator = By.id("react-burger-menu-btn");
    private final By logoutButtonLocator = By.id("logout_sidebar_link");

    public MenuPage(WebDriver driver) {
        super(driver);
    }

    public void openMenu() {
        org.openqa.selenium.WebElement menuBtn = WaitUtil.waitForClickable(driver, menuButtonLocator);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", menuBtn);
    }

    public void logout() {
        openMenu();

        new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10))
                .until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(logoutButtonLocator));

        org.openqa.selenium.WebElement logoutButton = driver.findElement(logoutButtonLocator);
        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript("arguments[0].click();", logoutButton);

        new org.openqa.selenium.support.ui.WebDriverWait(driver, java.time.Duration.ofSeconds(10))
                .until(org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated(By.id("login-button")));
    }
}