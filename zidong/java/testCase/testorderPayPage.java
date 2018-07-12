package testCase;

import base1.CaseBase;
import base1.baseDriver;
import bussiness.orderPayPagePro;
import bussiness.sureOrderPagePro;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.HandleCookie;

import java.io.IOException;

public class testorderPayPage extends CaseBase {
    public baseDriver driver;
    public orderPayPagePro sureorderPagePro;
    public HandleCookie handleCookie;
    @BeforeClass
    public void befoerClass() throws IOException, InterruptedException {
        this.driver=InitDriver("chrome");
        sureorderPagePro=new orderPayPagePro(driver);
        handleCookie=new HandleCookie(driver);
        driver.get("https://order.imooc.com/pay/cashier?trade_number=1807011800581851");
        handleCookie.setCookie();
        driver.get("https://order.imooc.com/pay/cashier?trade_number=1807011800581851");
        Thread.sleep(5000);

    }
    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
    @Test
    public void testOrderPayPage() throws IOException {
        sureorderPagePro.orderPayPro();
    }
}