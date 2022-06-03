package testsuite.amazon;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import page.amazon.SignUpPage;
import support.Browser;
import support.JavaUtils;

import java.io.File;
import java.io.IOException;

import static support.Browser.openBrowser;

public class SingUpTest {
    WebDriver driver;
    SignUpPage signUpPage;

    @Parameters ("browser")

    @BeforeClass
    void setup(String browser){
        driver = openBrowser(browser);
    }

    @DataProvider(name = "dataInfoAccount")
    Object [][] testData(){
        String pw = JavaUtils.generatePassword();
        return new Object[][]{
                {JavaUtils.generateCustomerName(),JavaUtils.generateEmail(),pw,pw,1},
                {JavaUtils.generateCustomerName(),JavaUtils.generateEmail()+"1",pw,pw,2},
                {JavaUtils.generateCustomerName(),JavaUtils.generateEmail(),pw,pw+"12",3}
        };
    }

    @Test (dataProvider = "dataInfoAccount")
    void createAccoutTest(String username,String email, String password, String rePassword, int number)  {
        signUpPage = new SignUpPage(driver);
        signUpPage.navigate();
        signUpPage.submitInfo(username,email,password,rePassword);
        Assert.assertTrue(signUpPage.IsDisplayedMsg(number));
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        /**
         * Capture screenshot when test failed only
         */
        String testName = result.getMethod().getMethodName();

        if (!result.isSuccess()) {
            System.out.printf("Test : %s is FAIL\n", testName);
            testName = testName + "-" + System.currentTimeMillis();
            File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File(String.format("./target/screen-shots/%s.png", testName)));
        } else {
            System.out.printf("Test : %s is PASS\n", testName);
        }
    }

    @AfterClass
    public void cleanUp(){
        driver.quit();
    }
}
