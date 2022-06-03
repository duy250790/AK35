package testsuite.amazon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.util.List;
import java.util.Random;

public class AddItem {

    WebDriver driver;
    String URL = "https://www.amazon.com/";

    @BeforeMethod
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to(URL);
    }
    @Test
    void addItemToCart()  {
        //Search Item errari 488 GTE
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("ferrari 488 GTE"+ Keys.ENTER);

        //Get list Item Result
        List<WebElement> listitem = driver.findElements(By.xpath("//div[@data-component-type='s-search-result']"));

        // select a item
        listitem.get((random(listitem.size()))).click();

        //add item to cart
        WebElement addtocart_button = driver.findElement(By.xpath("//span[@id='submit.add-to-cart']"));
        addtocart_button.click();

        //Check cart have 1 item
        WebElement icon_cart = driver.findElement(By.id("nav-cart-count"));
        Assert.assertEquals(icon_cart.getText(),"1");
    }

    int random(int x){
        Random rand = new Random();
        return rand.nextInt(x);
    }

    @AfterMethod
    void tearDown()
    {

        driver.quit();
    }
}
