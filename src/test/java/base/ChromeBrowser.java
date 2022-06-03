package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class ChromeBrowser {

    @Test
    void navigateToGoogle(){
        //System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http:/www.google.com");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.google.com/?gws_rd=ssl");
        driver.quit();
    }

    void navigateToGoogleWithHeadless(){
        //System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setHeadless(true);
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("http:/www.google.com");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.google.com/?gws_rd=ssl");
        driver.quit();
    }

    @Test
    void navigateToGoogleWithMobileViewMode(){
        // set chrome driver path --> $PATH
        WebDriverManager.chromedriver().setup();

        // setup mobile view
        Map<String, Object> deviceMetrics = new HashMap<>();
        deviceMetrics.put("width", 390);
        deviceMetrics.put("height", 944);
        deviceMetrics.put("pixelRatio", 1.0);
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceMetrics", deviceMetrics);
        mobileEmulation.put("userAgent", "Mozilla/5.0 (Linux; Android 9; Pixel 3 XL Build/PD1A.180621.003) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/67.0.3396.87 Mobile Safari/537.36");

        ChromeOptions chromeOptions = new ChromeOptions();

        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);

        // launch chrome app
        WebDriver driver = new ChromeDriver(chromeOptions);

        //navigate to google.com.vn
        driver.navigate().to("https://google.com.vn");

        // validate the current url match expected
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.google.com.vn/");

        // quit browser
        driver.quit();
    }



}
