package pageObjects.AutomationExercise;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.BasePage;

public class SignupLoginPage extends BasePage {
    public SignupLoginPage(WebDriver driver) {
        super(driver);
    }

    private String newSignupLabel = "//div[@class='signup-form']//h2[text()='%s']";
    private By nameInput = By.xpath("//div[@class='signup-form']//input[@name='name']");
    private By emailInput = By.xpath("//div[@class='signup-form']//input[@name='email']");
    private By accountInforText = By.xpath("//div[@class='login-form']/h2[contains(@class,'title')]//b");
    private By addressInforText = By.xpath("//form[@action='/signup']//h2[contains(@class,'title')]//b");
    private String titleCheckbox = "//input[@value='%s']";
    private String informationInput = "//label[contains(text(),'%s')]//following-sibling::input";
    private By daySelect = By.id("days");
    private By monthSelect = By.id("months");
    private By yearSelect = By.id("years");

    public Boolean isSignupLabelVisible(String signupLabel) {
        return getElement(String.format(newSignupLabel, signupLabel)).isDisplayed();
    }

    public void enterNameAndEmailAddress(String name, String email) {
        getElement(nameInput).sendKeys(name);
        getElement(emailInput).sendKeys(email);
    }

    public String getAccountInformationText() {
        return getElementText(accountInforText);
    }

    public String getAddressInformationText() {
        return getElementText(addressInforText);
    }

    public void chooseTitle(String title) {
        getElement(String.format(titleCheckbox, title)).click();
    }

    public void inputPassword(String password) {
        getElement(String.format(informationInput, "Password"));
    }

    public void inputDateOfBirth(String day, String month, String year) {

    }
}
