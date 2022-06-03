package testsuite.amazon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import page.amazon.AddItemPage;

import java.util.List;
import java.util.Random;

import static support.Browser.openBrowser;

public class AddItemTest {

    WebDriver driver;
    String URL = "https://www.amazon.com/";
    AddItemPage addItemPage;

    @Parameters("browser")
    @BeforeMethod
    void setup(String browser){
        driver = openBrowser(browser);
        addItemPage = new AddItemPage(driver);
        addItemPage.negative(URL);
    }
    @Test
    void addItemToCart()  {
        int countItemInCart = addItemPage.getCountCartCurrent();
        addItemPage.SearchItem("ferrari 488 GTE");
        addItemPage.getListItemRandom();
        addItemPage.addItemToCart();
        Assert.assertEquals(countItemInCart+1,addItemPage.getCountCartCurrent());
    }

    @AfterClass
    public void cleanUp(){
        driver.quit();
    }
}
