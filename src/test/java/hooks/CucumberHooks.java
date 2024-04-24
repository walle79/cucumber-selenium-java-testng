package hooks;

import globalConstants.GlobalConstants;
import io.cucumber.java.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import utilities.ExcelHelpers;
import utilities.PropertiesFileHelpers;

import java.time.Duration;

public class CucumberHooks {
    private static WebDriver driver;
    public static ExcelHelpers excelHelpers;

    public static WebDriver getDriver() {
        return driver;
    }

    @Before
    public void setup() throws Exception {
        PropertiesFileHelpers.setPropertiesFile(GlobalConstants.PROPERTIES_FILE_PATH);
        String browser = PropertiesFileHelpers.getPropValue("browser");
        String appUrl = PropertiesFileHelpers.getPropValue("appUrl");

        switch (browser) {
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                break;
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get(appUrl);
        excelHelpers = new ExcelHelpers();
        excelHelpers.setExcelFile(GlobalConstants.EXCEL_PATH, "Sheet1");
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

}
