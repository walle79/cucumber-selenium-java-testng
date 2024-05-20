package stepDefinitions.DemoQA;

import hooks.CucumberHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObjects.DemoQA.FormPage;
import utilities.ExcelHelpers;
import utilities.RandomString;

public class FormStepdefs {
    WebDriver driver;
    FormPage formPage;
    ExcelHelpers excelHelpers;

    public FormStepdefs() {
        this.driver = CucumberHooks.getDriver();
        this.excelHelpers = CucumberHooks.excelHelpers;
        formPage = new FormPage(driver);
    }
    @Given("user is on practice form page")
    public void userIsOnPracticeFormPage() {
    }

    @When("input the first name {string}")
    public void inputTheFirstName(String firstName) {
        formPage.inputFirstName(firstName);
    }

    @When("input the last name {string}")
    public void inputTheLastName(String lastName) {
        String lastNameRandom = lastName + RandomString.generateRandomString(6);
        formPage.inputLastName(lastNameRandom);
    }

    @When("input the email {string}")
    public void inputTheEmail(String arg0) {
    }

    @When("user click on Submit button")
    public void userClickOnSubmitButton() {
    }

    @Then("verify the first name is {string}")
    public void verifyTheFirstNameIs(String firstName) {
        formPage.getInformationText("First Name");
        Assert.assertEquals(formPage.getInformationText("First Name"), firstName);
    }

    @Then("verify the last name is {string}")
    public void verifyTheLastNameIs(String arg0) {
    }

    @Then("verify the email is {string}")
    public void verifyTheEmailIs(String arg0) {
    }
}
