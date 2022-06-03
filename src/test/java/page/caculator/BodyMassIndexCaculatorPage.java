package page.caculator;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static support.Browser.fill;

public class BodyMassIndexCaculatorPage {
    //String URL ="https://www.calculator.net/bmi-calculator.html";
    WebDriver driver;

    //private By matricTab = By.xpath("//a[.='Metric Units']");

    @FindBy(xpath = "//a[.='Metric Units']")
    WebElement metricTab;

    private By ageTxt = By.id("cage");
//    @FindBy(id = "cage")
//    WebElement ageTxt;

    //private By maleRad = By.xpath("//label[@for='csex1']");
    @FindBy(xpath = "//label[@for='csex1']")
    WebElement maleRad;

    //private By femaleRad = By.xpath("//label[@for='csex2']");
    @FindBy (xpath = "//label[@for='csex2']")
    WebElement femaleRad;

    //private By heightTxt = By.id("cheightmeter");
    @FindBy (id = "cheightmeter")
    WebElement heightTxt;

    //private By weightTxt = By.id("ckg");
    @FindBy(id = "ckg")
    WebElement weightTxt;

    //private By calculateBtn = By.xpath("//input[@value='Calculate']");
    @FindBy(xpath = "//input[@value='Calculate']")
    WebElement calculateBtn;

    //private By resultLbl = By.className("bigtext");
    @FindBy(className = "bigtext")
    WebElement resultLbl;


    public void navigate(String URL){
        driver.navigate().to(URL);
    }

    public BodyMassIndexCaculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void selectMetricTab()
    {
        metricTab.click();
    }

    public void fillForm(String age, String gender, String weight, String height){
        fill(driver,ageTxt,age);

        if(gender.contentEquals("male")){
            maleRad.click();
        }else  if (gender.contentEquals("female")){
            femaleRad.click();
        }

        heightTxt.clear();
        heightTxt.sendKeys(height);

        weightTxt.clear();
        weightTxt.sendKeys(weight);
    }

    public void clickCulcalate(){
        calculateBtn.click();
    }

    public String getResult(){
        return resultLbl.getText();
    }
}
