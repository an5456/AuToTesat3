package testCase;

import base1.CaseBase;
import base1.baseDriver;
import bussiness.loginPro;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import page.PropertiesFile;
import util.HandleCookie;
import util.testngListenerScreenShot;

import java.io.IOException;
@Test
public class testLogin extends CaseBase {
    public baseDriver driver;
    public loginPro lp;
    public PropertiesFile pf;
    public HandleCookie handleCookie;
    @BeforeClass
    public void beforeClass() throws IOException {
        this.driver=InitDriver("chrome");
        lp=new loginPro(driver);
        handleCookie=new HandleCookie(driver);
        pf=new PropertiesFile("element.properties");
        driver.wait1(5);
        driver.get(pf.getFile("url"));
    }
    @Test
    public void testLogin() throws IOException, InterruptedException {
        String username=pf.getFile("user");
        String password=pf.getFile("pass");
        lp.login1(username,password);
        Thread.sleep(5000);
        if(lp.sureloginUsername(pf.getFile("exception"))){
            System.out.println("登陆成功");
            handleCookie.writeCookie();
        }else {
            System.out.println("登陆失败");
        }
        System.out.println(pf.getFile("exception"));
    }
    @AfterClass
    public void afterClass(){
        driver.close();
    }
}
