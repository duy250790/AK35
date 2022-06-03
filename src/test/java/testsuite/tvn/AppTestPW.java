package testsuite.tvn;

import org.testng.Assert;
import org.testng.annotations.Test;
import tvn.PWIsComplex;

public class AppTestPW {
    PWIsComplex pw = new PWIsComplex();

    @Test
    public void TC1(){
        Assert.assertTrue(pw.pwIsComplex("abAB123456"));
    }

    @Test
    public void TC2(){
        Assert.assertFalse(pw.pwIsComplex("aA1234"));
    }

    @Test
    public void TC3(){
        Assert.assertFalse(pw.pwIsComplex("A123456"));
    }

    @Test
    public void TC4(){
        Assert.assertFalse(pw.pwIsComplex("a123456"));
    }

    @Test
    public void TC5(){
        Assert.assertFalse(pw.pwIsComplex("aAbBcCdD"));
    }

    @Test
    public void TC6(){
        Assert.assertFalse(pw.pwIsComplex("@aA-123456"));
    }
}
