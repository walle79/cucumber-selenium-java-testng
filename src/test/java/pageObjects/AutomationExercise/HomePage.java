package pageObjects.AutomationExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.BasePage;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By homePageCarousel = By.id("slider-carousel");

    public Boolean isHomePageVisible() {
        return getElement(homePageCarousel).isDisplayed();
    }

}
