package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    private By appLogo = By.className("app_logo");
    private By priceProductItems = By.className("inventory_item_price");
    private By sortDropdown = By.className("product_sort_container");

    public Boolean isHomePageLogoDisplayed() {
        return isElementDisplayed(appLogo);
    }

    public List<Double> getPriceProductTextList() {
        List<WebElement> priceProductElement = getElements(priceProductItems);
        List<Double> priceProductElementText = new ArrayList<>();
        for (WebElement priceProductItem : priceProductElement) {
            priceProductElementText.add(Double.valueOf(priceProductItem.getText().replace("$", "")));
        }
        return priceProductElementText;
    }

    public void chooseSortOption(String option) {
        selectValueInDropdown(sortDropdown, option);
    }
}
