package base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utils.WaitUtil;

import java.util.List;

public class BasePage {

    protected WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void click(By locator) {
        WebElement element = WaitUtil.waitForClickable(driver, locator);
        try {
            element.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
        }
    }

    protected void type(By locator, String text) {
        WebElement element = WaitUtil.waitForClickable(driver, locator);
        element.clear();
        element.sendKeys(text);
    }

    protected String getText(By locator) {
        return WaitUtil.waitForVisible(driver, locator).getText();
    }

    protected WebElement findElement(By locator) {
        return WaitUtil.waitForVisible(driver, locator);
    }

    protected List<WebElement> findElements(By locator) {
        return driver.findElements(locator);
    }
}