package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EdgeBrowser {
    @Test
    void navigateToGoogle(){
        //System.setProperty("webdriver.chrome.driver","drivers/chromedriver");
        WebDriverManager.edgedriver().setup();
        WebDriver driver = new EdgeDriver();
        driver.navigate().to("https:google.com.vn");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.google.com.vn/");
        //driver.quit();
    }
}
