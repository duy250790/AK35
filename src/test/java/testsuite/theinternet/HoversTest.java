package testsuite.theinternet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HoversTest {
    WebDriver driver;
    String URL = "https://the-internet.herokuapp.com";
    Actions actions;

    @BeforeMethod
    void Setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to(URL+"/hovers");
    }
    @Test
    void TC01(){
        WebElement avarter1 = driver.findElement(By.className("figure"));
        actions = new Actions(driver);
        actions.moveToElement(avarter1).perform();
        WebElement user1 = driver.findElement(By.xpath("//div[@class = 'figcaption']//h5"));
        System.out.print(user1.getText());
    }

    @AfterMethod
    void tearDown(){
        //driver.quit();
    }
}
