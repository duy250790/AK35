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

public class CheckboxesTest {
    WebDriver driver;
    String URL = "https://the-internet.herokuapp.com/";

    @BeforeMethod
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to(URL+"/checkbox");
    }
    @Test
    void validateCheckbox1IsSelected(){
        WebElement checkbox1 = driver.findElement(By.xpath("//form[@id='checkboxes']//input[1]"));
        checkbox1.click();
        Assert.assertTrue(checkbox1.isSelected());
    }

    @Test
    void validateCheckbox2IsSelected(){
        WebElement checkbox2= driver.findElement(By.xpath("//form[@id='checkboxes']//input[2]"));
        if( !checkbox2.isSelected()){
            checkbox2.click();
        }
        Assert.assertTrue(checkbox2.isSelected());
    }



    @AfterMethod
    void tearDown()
    {
        //driver.quit();
    }
}
