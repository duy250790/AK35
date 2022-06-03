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

public class FormAuthenticationTest {
    WebDriver driver;
    String URL = "https://the-internet.herokuapp.com";
//    Login successful with valid credentials
//    Steps:
//    Open browser - Chrome
//    Navigate to https://the-internet.herokuapp.com/login
//    Fill in username with tomsmith
//    Fill in the password with SuperSecretPassword!
//    Click on Login button
//    And the home page is appear
    @BeforeMethod
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to(URL+"/login");
    }

    @Test
    void loginSuccessfullyWithValidCredentials(){
        submitCredentials("tomsmith","SuperSecretPassword!");
        Assert.assertEquals(driver.getCurrentUrl(),URL+"/secure");
        driver.quit();
    }

    @Test
    void loginSuccessfullyWithInValidCredentials(){
        submitCredentials("tomsmith","SuperSecretPassword!");
        WebElement errorMessage = driver.findElement(By.className("error"));
        Assert.assertTrue(errorMessage.isDisplayed());
        driver.quit();
    }

    void submitCredentials(String username, String password){
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.tagName("button")).click();
    }

    @AfterMethod
    void tearDown()
    {
        driver.quit();
    }

}
