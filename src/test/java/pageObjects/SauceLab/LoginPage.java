package pageObjects.SauceLab;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By usernameInput = By.id("user-name");
    private By passwordInput = By.id("password");
    private By loginBtn = By.id("login-button");

    public void loginIntoSystem(String username, String password) {
        getElement(usernameInput).sendKeys(username);
        getElement(passwordInput).sendKeys(password);
        getElement(loginBtn).click();
    }
}
