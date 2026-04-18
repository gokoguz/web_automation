package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.WaitUtil;

public class LoginPage extends BasePage {

    private final By username = By.id("user-name");
    private final By password = By.id("password");
    private final By loginBtn = By.id("login-button");
    private final By errorMessage = By.cssSelector("h3[data-test='error']");
    private final By pageTitle = By.className("login_logo");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get("https://www.saucedemo.com/");
    }

    public void login(String user, String pass) {
        type(username, user);
        type(password, pass);
        click(loginBtn);
    }

    public boolean isProductsPageVisible() {
        WaitUtil.waitForVisible(driver, By.className("title"));
        return new ProductPage(driver).isProductsPageVisible();
    }

    public boolean isErrorMessageDisplayed() {
        return !driver.findElements(errorMessage).isEmpty();
    }

    public boolean isLoginPageDisplayed() {
        return !driver.findElements(pageTitle).isEmpty() && !driver.findElements(username).isEmpty();
    }
}