package testsuite.tvn;

import org.testng.Assert;
import org.testng.annotations.Test;
import tvn.CheckSoNT;

public class AppTestSoNT {
    CheckSoNT checksoNT = new CheckSoNT();

    @Test
    void TC1(){
        Assert.assertEquals(checksoNT.kiemTraSoNT(1),false);
    }

    @Test
    void TC2(){
        Assert.assertEquals(checksoNT.kiemTraSoNT(2),true);
    }

    @Test
    void TC3(){
        Assert.assertEquals(checksoNT.kiemTraSoNT(3),true);
    }

    @Test
    void TC4(){
        Assert.assertEquals(checksoNT.kiemTraSoNT(17),true);
    }

    @Test
    void TC5(){
        Assert.assertEquals(checksoNT.kiemTraSoNT(27),false);
    }
}
