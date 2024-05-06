package stepDefinitions;

import hooks.CucumberHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import utilities.ExcelHelpers;

public class LoginPageStepDefs {
    WebDriver driver;
    LoginPage loginPage;
    ExcelHelpers excelHelpers;

    public LoginPageStepDefs() {
        this.driver = CucumberHooks.getDriver();
        this.excelHelpers = CucumberHooks.excelHelpers;
        loginPage = new LoginPage(driver);
    }

    @Given("user is on login page")
    public void userIsOnLoginPage() {

    }

    @When("user login with valid username and password")
    public void userLoginWithValidUsernameAndPassword() throws Exception {
        String username = excelHelpers.getCellData("User Name", 1);
        String password = excelHelpers.getCellData("password", 1);
        System.out.println(excelHelpers.getCellData("First Name", 1));
        System.out.println(excelHelpers.getCellData("Last Name", 1));
        loginPage.loginIntoSystem(username, password);
    }
}
