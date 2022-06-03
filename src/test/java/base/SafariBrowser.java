package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SafariBrowser {

    @Test
    void navigateToGoogleTest(){
        WebDriver driver = new SafariDriver();
        driver.navigate().to("http:/www.google.com");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.google.com/?gws_rd=ssl");
        driver.quit();
    }



}
