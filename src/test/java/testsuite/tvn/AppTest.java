package testsuite.tvn;

import org.testng.Assert;
import org.testng.annotations.Test;
import tvn.App;
import tvn.Product;

public class AppTest {
    App app = new App();
    @Test
    void TC1(){
        App app = new App();
        Assert.assertTrue(app.kiemTraSoChan(4));
    }
    @Test
    void TC2(){
        App app = new App();
        Assert.assertFalse(app.kiemTraSoChan(5));
    }

    @Test
    void TC3(){
        Assert.assertEquals(app.sum(3,4),7);
    }

    @Test
    void TC4(){
        Assert.assertEquals(app.sub(5,4),1);
    }

    @Test
    void TC5(){
        Assert.assertEquals(app.mul(5,4),20);
    }

    @Test
    void TC6(){
        Assert.assertEquals(app.div(5,4),1);
    }

    @Test
    void TC7(){
        Assert.assertEquals(app.kiemTraSoNT(1),false);
    }

    @Test
    void TC9(){
        Assert.assertEquals(app.kiemTraSoNT(1),false);
    }

    @Test
    void TC10(){
        Assert.assertEquals(app.kiemTraSoNT(2),true);
    }

    @Test
    void TC11(){
        Assert.assertEquals(app.kiemTraSoNT(3),true);
    }




    @Test
    void TC8(){
        Product book = new Product("13.104 đ","10.080 đ");
        Assert.assertEquals(book.getDiscount(),23);
    }
}
