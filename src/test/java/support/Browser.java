package support;

import io.github.bonigarcia.wdm.WebDriverManager;
import net.bytebuddy.asm.Advice;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Browser {
    private static final Integer TIMEOUT = 20;
    public static WebDriverWait wait;

    public static WebDriver openBrowser(String name){
        WebDriver driver;
        if (name.equalsIgnoreCase("chrome")){
            WebDriverManager.chromedriver().setup();
            driver= new ChromeDriver();
        }else if (name.equalsIgnoreCase("firefox")){
            WebDriverManager.firefoxdriver().setup();
            driver= new FirefoxDriver();
        }else if (name.equalsIgnoreCase("safari")){
            driver= new SafariDriver();
        }else {
            throw new IllegalArgumentException("The browser "+name +" does not support");
        }
        wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
        return driver;
    }

    public static void click(WebDriver driver, By locator){
        driver.findElement(locator).click();
    }

    public static void fill(WebDriver driver,By locator,String withText){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(withText);
    }

    public static void fillAndEnter(WebDriver driver,By locator,String withText){
        driver.findElement(locator).clear();
        driver.findElement(locator).sendKeys(withText+ Keys.ENTER);
    }

    public static WebElement waitForElementPresent(WebDriver driver, By locator){
        return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }
}
