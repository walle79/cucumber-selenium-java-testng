package stepDefinitions.AutomationExercise;

import hooks.CucumberHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.AutomationExercise.HomePage;
import pageObjects.BasePage;
import utilities.ExcelHelpers;

import java.time.Duration;

public class HomePageStepdefs {

    WebDriver driver;
    HomePage homePage;
    BasePage basePage;
    ExcelHelpers excelHelpers;

    public HomePageStepdefs() {
        this.driver = CucumberHooks.getDriver();
        this.excelHelpers = CucumberHooks.excelHelpers;
        homePage = new HomePage(driver);
        basePage = new BasePage(driver);
    }
    @Given("Launch browser")
    public void launchBrowser() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @When("Navigate to url {string}")
    public void navigateToUrl(String appUrl) {
        driver.get(appUrl);
    }

    @Then("Verify that home page is visible successfully")
    public void verifyThatHomePageIsVisibleSuccessfully() {
        Assert.assertTrue(homePage.isHomePageVisible());
    }

    @When("Click on {string} button")
    public void clickOnSignupLoginButton(String menuText) {
        basePage.clickElement(String.format(basePage.getHeaderMenuLink(), menuText));
    }
}
