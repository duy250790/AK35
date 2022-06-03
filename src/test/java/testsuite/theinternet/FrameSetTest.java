package testsuite.theinternet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class FrameSetTest {
    WebDriver driver;
    String URL = "https://the-internet.herokuapp.com";

    @BeforeMethod
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to(URL+"/nested_frames");
    }
    @Test
    void getFrame() {
        WebDriver frameTop = driver.switchTo().frame("frame-top");
        WebDriver frameLeft = frameTop.switchTo().frame("frame-left");
        String frameLeftContent = frameLeft.findElement(By.xpath("/html/body")).getText();
        Assert.assertEquals(frameLeftContent,"LEFT");

        WebDriver frameMiddle = frameLeft.switchTo().parentFrame().switchTo().frame("frame-middle");
        String frameMiddleContent = frameMiddle.findElement(By.xpath("/html/body")).getText();
        Assert.assertEquals(frameMiddleContent,"MIDDLE");

        WebDriver frameRight = frameMiddle.switchTo().parentFrame().switchTo().frame("frame-right");
        String frameRightContent = frameRight.findElement(By.xpath("/html/body")).getText();
        Assert.assertEquals(frameRightContent,"RIGHT");


        WebDriver frameBottom = frameRight.switchTo().parentFrame().switchTo()
                .parentFrame().switchTo().frame("frame-bottom");
        String frameBottomContent = frameBottom.findElement(By.xpath("/html/body")).getText();
        Assert.assertEquals(frameBottomContent,"BOTTOM");
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
    }
}
