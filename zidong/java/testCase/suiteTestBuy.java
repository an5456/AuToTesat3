package testCase;

import base1.CaseBase;
import base1.baseDriver;
import handle.coursePageHandle;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import page.PropertiesFile;
import util.HandleCookie;

import java.io.IOException;
@Test
public class suiteTestBuy extends CaseBase {
    public baseDriver driver;
    public coursePageHandle cph;
    public PropertiesFile pf;
    public HandleCookie handleCookie;
    @BeforeClass
    public void beforeClass() throws IOException, InterruptedException {
        this.driver=InitDriver("chrome");
        cph=new coursePageHandle(driver);
        handleCookie=new HandleCookie(driver);
        driver.get("https://coding.imooc.com/class/230.html");
        handleCookie.setCookie();
        driver.get("https://coding.imooc.com/class/230.html");
        Thread.sleep(2000);
    }
    @AfterClass
    public void afterClass(){
        driver.close();
    }
    @Test
    public void testBuy() throws IOException, InterruptedException {
        cph.clickBuyNowButton();
        Thread.sleep(2000);
    }
}

