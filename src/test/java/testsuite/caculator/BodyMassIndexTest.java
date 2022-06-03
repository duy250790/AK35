package testsuite.caculator;


import base.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;
import page.caculator.BodyMassIndexCaculatorPage;

import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;

import static support.Browser.openBrowser;

public class BodyMassIndexTest extends BaseTest {
    BodyMassIndexCaculatorPage bmiPage;

    @Parameters({"browser","url"})
    @BeforeClass
    void setup(String browser,String url){
        driver = openBrowser(browser);
        bmiPage = new BodyMassIndexCaculatorPage(driver);
        bmiPage.navigate(url);
        bmiPage.selectMetricTab();
    }

    @DataProvider(name = "dataBMI")
    Object [][] testData(){
        return new Object[][]{
                {"32","male","172","72"},
                {"32","male","180","100"},
                {"20","female","160","50"},
                {"25","female","155","45"},
        };
    }

    @Test (dataProvider = "dataBMI")
    void TC01(String age, String gender, String height, String weight){
        bmiPage.fillForm(age, gender,weight,height);
        bmiPage.clickCulcalate();
        System.out.println(calculateBMI(weight,height));
        Assert.assertTrue(bmiPage.getResult().contains(calculateBMI(weight,height)));
    }

    public static String calculateBMI(String weight,String height){
        int weightInt = Integer.parseInt(weight);
        double heightM = Double.parseDouble(height)/100;
        double bmi= weightInt/(heightM*heightM);
        DecimalFormat f = new DecimalFormat("##.0");
        return f.format(bmi);
    }



    @AfterClass
    public void cleanUp(){
        driver.quit();
    }
}
