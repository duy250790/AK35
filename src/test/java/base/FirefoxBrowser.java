package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirefoxBrowser {

    @Test
    void navigateToGoogle(){
        //System.setProperty("webdriver.gecko.driver","drivers/geckodriver");
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.navigate().to("http:/www.google.com");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.google.com/?gws_rd=ssl");
        driver.quit();
    }



}
