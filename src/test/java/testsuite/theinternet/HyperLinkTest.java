package testsuite.theinternet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class HyperLinkTest {
    WebDriver driver;
    String URL = "https://the-internet.herokuapp.com";
    String status;

    @BeforeMethod
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to(URL+"/status_codes");
    }
    @Test
    void validateCheckbox1IsSelected() throws InterruptedException {

       linktext("200");
       Assert.assertEquals(driver.getCurrentUrl(),getURL("200"));
       linktext("here");
       linktext("301");
       Assert.assertEquals(driver.getCurrentUrl(),getURL("301"));

       //Assert.assertEquals(driver.getCurrentUrl(),URL+"/status_codes/200");
    }

    void linktext(String text){
        driver.findElement(By.linkText(text)).click();
    }

    String getURL(String status){
        return String.format(URL+"/status_codes/%s",status);
    }



    @AfterMethod
    void tearDown()
    {
        //driver.quit();
    }
}
