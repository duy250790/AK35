package testsuite.theinternet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class DropdownListTest {
    WebDriver driver;
    String URL = "https://the-internet.herokuapp.com/";

    @BeforeMethod
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to(URL+"/dropdown");
    }

    @Test
    void validateDropdownlist()  {
        WebElement dropdown = driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select s = new Select(dropdown);
        s.selectByValue("2");
    }

    @AfterMethod
    void tearDown()
    {
        //driver.quit();
    }
}
