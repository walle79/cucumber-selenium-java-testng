package stepDefinitions;

import hooks.CucumberHooks;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.HomePage;
import utilities.ExcelHelpers;

public class HomePageStepDefs {
    WebDriver driver;
    HomePage homePage;
    ExcelHelpers excelHelpers;

    public HomePageStepDefs() {
        this.driver = CucumberHooks.getDriver();
        this.excelHelpers = CucumberHooks.excelHelpers;
        homePage = new HomePage(driver);
    }

    @Then("user can go to home page successfully")
    public void userCanGoToHomePageSuccessfully() {
        Assert.assertTrue(homePage.isHomePageLogoDisplayed());
    }
}
