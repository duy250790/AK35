package testsuite.theinternet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class JSAlertTest {
    WebDriver driver;
    String URL = "https://the-internet.herokuapp.com";
    WebDriverWait wait;

    @BeforeMethod
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.navigate().to(URL+"/javascript_alerts");
    }
    @Test
    void getAlert() {

        WebElement buttonJSAlert = driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        wait.until(ExpectedConditions.elementToBeClickable(buttonJSAlert)).click();
        String text = driver.switchTo().alert().getText();
        System.out.println(text);
        Assert.assertEquals(text,"I am a JS Alert");
        driver.switchTo().alert().accept();

        String result = driver.findElement(By.id("result")).getText();
        System.out.println(result);
        Assert.assertEquals(result,"You successfully clicked an alert");

    }

    @AfterMethod
    void tearDown(ITestResult result) throws IOException {
        /**
         * Capture screenshot when test failed only
         */
        String testName = result.getMethod().getMethodName();

        if (!result.isSuccess()) {
            System.out.printf("Test : %s is FAIL\n", testName);
            testName = testName + "-" + System.currentTimeMillis();
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(String.format("./target/screen-shots/%s.png", testName)));
        } else {
            System.out.printf("Test : %s is PASS\n", testName);
        }
        //driver.quit();
    }
}
