package stepDefinitions;

import hooks.CucumberHooks;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.SauceLab.HomePage;
import utilities.ExcelHelpers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HomePageStepDefs {
    WebDriver driver;
    HomePage homePage;
    ExcelHelpers excelHelpers;
    List<Double> defaultProductPrice = new ArrayList<>();

    public HomePageStepDefs() {
        this.driver = CucumberHooks.getDriver();
        this.excelHelpers = CucumberHooks.excelHelpers;
        homePage = new HomePage(driver);
    }

    @Then("user can go to home page successfully")
    public void userCanGoToHomePageSuccessfully() {
        Assert.assertTrue(homePage.isHomePageLogoDisplayed());
    }

    @Then("user choose sort low to high")
    public void userChooseSortLowToHigh() {
        defaultProductPrice = homePage.getPriceProductTextList();
        System.out.println("Default list: ---------------------------------------");
        for (Double price: defaultProductPrice) {
            System.out.print(price + " ");
        }
        Collections.reverse(defaultProductPrice);
        System.out.print("Reverse Default list: ---------------------------------------");
        for (Double price: defaultProductPrice) {
            System.out.print(price + " ");
        }
        System.out.println("Sort -> Reverse");
        Collections.sort(defaultProductPrice);
        Collections.reverse(defaultProductPrice);
        System.out.print("Before sort: ----------------------------------------");
        for (Double price: defaultProductPrice) {
            System.out.print(price + " ");
        }
        homePage.chooseSortOption("Price (low to high)");
    }

    @Then("verify product price will be order low to high")
    public void verifyProductPriceWillBeOrderLowToHigh() {
        List<Double> priceListAfterSort = homePage.getPriceProductTextList();
        System.out.println("After sort: ----------------------------------------");
        for (Double price: priceListAfterSort) {
            System.out.println(price);
        }
        Assert.assertEquals(defaultProductPrice, priceListAfterSort);
    }
}
