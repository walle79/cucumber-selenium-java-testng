package pageObjects.DemoQA;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObjects.BasePage;

public class FormPage extends BasePage {

    public FormPage(WebDriver driver) {
        super(driver);
    }

    private By firstNameInput = By.id("firstName");
    private By lastNameInput = By.id("lastName");

    public void inputFirstName(String firstName) {
        getElement(firstNameInput).sendKeys(firstName);
    }

    public void inputLastName(String lastName) {
        getElement(lastNameInput).sendKeys(lastName);
    }

    public String getInformationText(String inforText) {
        return inforText;
    }
}
