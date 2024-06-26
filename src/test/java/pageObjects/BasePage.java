package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    private String headerMenuLink = "//*[contains(text(),'%s')]//parent::a";
    private String button = "//button[text()='%s']";
    public String getHeaderMenuLink() {
        return headerMenuLink;
    }

    public String getButton() {
        return button;
    }

    public WebElement getElement(By locator) {
        return driver.findElement(locator);
    }

    public WebElement getElement(String locator) {
        return driver.findElement(By.xpath(locator));
    }

    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    public WebElement getElementByDynamicLocator(String locator, String value) {
        return driver.findElement(By.xpath(String.format(locator, value)));
    }

    public String getElementText(By locator) {
        return getElement(locator).getText();
    }

    public void clickElement(By locator) {
        waitForElementClickable(locator);
        getElement(locator).click();
    }

    public void clickElement(String locator) {
        waitForElementClickable(locator);
        getElement(locator).click();
    }

    public void sendKeyToElement(By locator, String value) {
        getElement(locator).sendKeys(value);
    }

    public void selectValueInDropdown(By locator, String value) {
        Select select = new Select(getElement(locator));
        select.selectByVisibleText(value);
    }

    public void waitForElementClickable(By locator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        explicitWait.until(ExpectedConditions.elementToBeClickable(getElement(locator)));
    }

    public void waitForElementClickable(String locator) {
        WebDriverWait explicitWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        explicitWait.until(ExpectedConditions.elementToBeClickable(getElement(locator)));
    }

    public void clickByJS(By locator) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].click();", getElement(locator));
    }

    public void clickByJS(WebElement element) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor)driver;
        javascriptExecutor.executeScript("arguments[0].click();", element);
    }

    public String getElementCssAttribute(By locator, String cssAttr) {
        return getElement(locator).getCssValue(cssAttr);
    }

    public boolean isElementDisplayed(By locator) {
        return getElement(locator).isDisplayed();
    }

    public String getElementCssValue(By locator, String cssName) {
        return getElement(locator).getCssValue(cssName);
    }
}
