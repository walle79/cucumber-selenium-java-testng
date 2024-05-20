package utilities;

import io.qameta.allure.Allure;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class ScreenshotUtil {

    // Method to capture and attach screenshot
    public static void takeScreenshot(WebDriver driver, String screenshotName) {
        if (driver != null) {
            try {
                // Capture the screenshot
                byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
                String screenshotPath = System.getProperty("user.dir") + "/screenshots/" + screenshotName + ".png";
                File screenshotDestination = new File(screenshotPath);
                screenshotDestination.getParentFile().mkdirs(); // Create directories if not exists

                try (FileOutputStream outputStream = new FileOutputStream(screenshotDestination)) {
                    outputStream.write(screenshot);
                }

                // Attach the screenshot to Allure report
                try (InputStream screenshotStream = new ByteArrayInputStream(screenshot)) {
                    Allure.addAttachment("Screenshot on Failure", "image/png", screenshotStream, ".png");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
