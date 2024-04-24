package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By appLogo = By.className("app_logo");

    public Boolean isHomePageLogoDisplayed() {
        return isElementDisplayed(appLogo);
    }
}
