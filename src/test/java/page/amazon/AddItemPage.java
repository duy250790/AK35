package page.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

import static support.Browser.fill;
import static support.Browser.fillAndEnter;

public class AddItemPage {
    public AddItemPage(WebDriver driver) {
        this.driver = driver;
    }

    WebDriver driver;

    private By searchTxt = By.xpath("//input[@id='twotabsearchtextbox']");
    private By itemListResult = By.xpath("//div[@data-component-type='s-search-result']");
    private By addToCartBtn = By.xpath("//span[@id='submit.add-to-cart']");
    private By cardIcon = By.id("nav-cart-count");

    public void negative(String URL){
        driver.navigate().to(URL);
    }

    public void SearchItem(String inputSearch){
        fillAndEnter(driver,searchTxt,inputSearch);
    }

    public void getListItemRandom(){
        List<WebElement> listItem = driver.findElements(itemListResult);
        listItem.get(1).click();
    }

    public void addItemToCart(){
        driver.findElement(addToCartBtn).click();
    }

    public int getCountCartCurrent(){
        return Integer.parseInt(driver.findElement(cardIcon).getText());
    }

    public

    int random(int x){
        Random rand = new Random();
        return rand.nextInt(x);
    }
}
