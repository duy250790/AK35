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

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class TableTest {
    WebDriver driver;
    String URL = "https://the-internet.herokuapp.com";

    @BeforeMethod
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.navigate().to(URL+"/tables");
    }
    @Test
    void table1() {
        //get rows
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']//tr"));

        //get cell dou
        List<WebElement> douColumn = driver.findElements(By.xpath("//table[@id='table1']//td[4]"));
        List<WebElement> firstNameColumn = driver.findElements(By.xpath("//table[@id='table1']//td[1]"));
        List<WebElement> lastNameColumn = driver.findElements(By.xpath("//table[@id='table1']//td[2]"));
        douColumn.forEach(dou -> System.out.println(Float.parseFloat(dou.getText().replace("$",""))));
        int indexMax = findIndexDouLargest2(douColumn);
        System.out.println(indexMax);
        String fullName = firstNameColumn.get(indexMax).getText() + " " + lastNameColumn.get(indexMax).getText();
        System.out.println(fullName);
        Assert.assertEquals(fullName,"Doe Jason");
    }

    int findIndexDouLargest(List<WebElement> element){
        ArrayList<Float> list = new ArrayList<>();
        int index = 0;
        element.forEach(e -> list.add(Float.parseFloat(e.getText().replace("$",""))));
        float max = list.get(1);
        for (int i = 2;i < list.size();i++){
            if(list.get(i) > max){
                max = list.get(i);
                index = i;
            }
        }
        return index;
    }
    int findIndexDouLargest2(List<WebElement> element){
        ArrayList<Double> list = new ArrayList<>();
        int index = 0;
        element.forEach(e -> list.add(Double.parseDouble(e.getText().replace("$",""))));
        double max = list.stream().mapToDouble(l -> l).max().orElseThrow(NoSuchElementException::new);
        index = list.stream().map(l ->l).collect(Collectors.toList()).indexOf(max);

//        for (int i = 1;i < list.size();i++){
//            if(list.get(i) == max){
//                index = i;
//            }
//        }
        return index;
    }

    @AfterMethod
    void tearDown()
    {
        //driver.quit();
    }
}
