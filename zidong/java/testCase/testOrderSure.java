package testCase;

import base1.CaseBase;
import base1.baseDriver;
import bussiness.sureOrderPagePro;
import handle.coursePageHandle;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.PropertiesFile;
import util.HandleCookie;

import java.io.IOException;

public class testOrderSure extends CaseBase {
    public baseDriver driver;
    public coursePageHandle cph;
    public sureOrderPagePro sureorderPagePro;
    public PropertiesFile pf;
    public HandleCookie handleCookie;
    @BeforeClass
    public void beforeClass() throws IOException, InterruptedException {
        this.driver=InitDriver("chrome");
        sureorderPagePro=new sureOrderPagePro(driver);
        pf=new PropertiesFile("element.properties");
        handleCookie=new HandleCookie(driver);
        driver.get("https://order.imooc.com/pay/confirm/goods_ids/1-230");
        handleCookie.setCookie();
        driver.get("https://order.imooc.com/pay/confirm/goods_ids/1-230");
        Thread.sleep(2000);
    }
    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(2000);
        //driver.close();
    }
    @Test
    public void testOrder() throws IOException {
        sureorderPagePro.sureOrder();
    }
}
