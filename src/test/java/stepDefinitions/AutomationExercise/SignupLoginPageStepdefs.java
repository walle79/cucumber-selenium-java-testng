package stepDefinitions.AutomationExercise;

import hooks.CucumberHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.AutomationExercise.SignupLoginPage;
import pageObjects.BasePage;
import utilities.ExcelHelpers;
import utilities.RandomString;

public class SignupLoginPageStepdefs {
    WebDriver driver;
    SignupLoginPage signupLoginPage;
    ExcelHelpers excelHelpers;
    BasePage basePage;

    public SignupLoginPageStepdefs() {
        this.driver = CucumberHooks.getDriver();
        this.excelHelpers = CucumberHooks.excelHelpers;
        signupLoginPage = new SignupLoginPage(driver);
        basePage = new BasePage(driver);
    }

    @Then("Verify {string} is visible")
    public void verifyNewUserSignupIsVisible(String signupLabel) {
        Assert.assertTrue(signupLoginPage.isSignupLabelVisible(signupLabel));
    }

    @Then("Enter name and email address")
    public void enterNameAndEmailAddress() throws Exception {
        String name = excelHelpers.getCellData("name", 1) + RandomString.generateRandomString(3);
        String email = "son" + RandomString.generateRandomString(3) + excelHelpers.getCellData("emailDomain", 1);
        signupLoginPage.enterNameAndEmailAddress(name, email);
    }

    @And("Click {string} button")
    public void clickSignupButton(String button) {
        basePage.clickElement(String.format(basePage.getButton(), button));
    }

    @Then("Verify that {string} is visible")
    public void verifyThatENTERACCOUNTINFORMATIONIsVisible(String text) {
        Assert.assertEquals(signupLoginPage.getAccountInformationText(), text);
    }

    @When("Fill details: Title, Name, Email, Password, Date of birth")
    public void fillDetailsTitleNameEmailPasswordDateOfBirth() {
    }

    @And("Select checkbox {string}")
    public void selectCheckboxSignUpForOurNewsletter() {
    }

    @And("Fill details: First name, Last name, Company, Address, Address{int}, Country, State, City, Zipcode, Mobile Number")
    public void fillDetailsFirstNameLastNameCompanyAddressAddressCountryStateCityZipcodeMobileNumber(int arg0) {
    }

    @And("Click {string}")
    public void clickCreateAccountButton() {
    }

    @Then("Verify that {string} is visible and click {string} button")
    public void verifyThatACCOUNTDELETEDIsVisibleAndClickContinueButton() {
    }
}
