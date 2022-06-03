package page.amazon;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Random;

public class SignUpPage {
    String URL = "https://www.amazon.com/ap/register?openid.pape.max_auth_age=0&openid.return_to=https%3A%2F%2Fwww.amazon.com%2F%3F_encoding%3DUTF8%26ref_%3Dnav_newcust&openid.identity=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.assoc_handle=usflex&openid.mode=checkid_setup&openid.claimed_id=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0%2Fidentifier_select&openid.ns=http%3A%2F%2Fspecs.openid.net%2Fauth%2F2.0&";
    WebDriver driver;

    private By usernameTxt = By.id("ap_customer_name");
    private By emailTxt = By.id("ap_email");
    private By passwordTxt = By.id("ap_password");
    private By password_checkTxt = By.id("ap_password_check");
    private By continueBtn = By.id("continue");
    private By protectAccountMsg = By.xpath("//span[text()='Solve this puzzle to protect your account']");
    private By wrongMsg = By.xpath("//div[contains(text(),'Wrong or Invalid email address or mobile phone number')]");
    private By notMatchPassWord = By.xpath("//div[contains(text(),'Passwords must match')]");

    public SignUpPage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigate(){
        driver.navigate().to(URL);
    }

    public void submitInfo(String username,String email, String password, String repassword){
        driver.findElement(usernameTxt).sendKeys(username);
        driver.findElement(emailTxt).sendKeys(email);
        driver.findElement(passwordTxt).sendKeys(password);
        driver.findElement(password_checkTxt).sendKeys(repassword);
        driver.findElement(continueBtn).click();
    }

    public boolean IsDisplayedMsg(int number){
//        if(conditionValid == "inforvalid") {
//            return driver.findElement(protectAccountMsg).isDisplayed();
//        }else return driver.findElement(wrongMsg).isDisplayed();
        switch (number){
            case 1:
                return driver.findElement(protectAccountMsg).isDisplayed();
            case 2:
                return driver.findElement(wrongMsg).isDisplayed();
            case 3:
                return driver.findElement(notMatchPassWord).isDisplayed();
            default:
                return false;
        }
    }



//    public int random(){
//        Random rand = new Random();
//        return rand.nextInt(9999);
//    }
}
