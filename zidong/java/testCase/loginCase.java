package testCase;

import base1.CaseBase;
import base1.baseDriver;
import bussiness.coursePro;
import bussiness.loginPro;
import bussiness.orderPayPagePro;
import bussiness.sureOrderPagePro;
import handle.coursePageHandle;
import handle.sureOrderHandle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import page.PropertiesFile;
import page.getByLocal;

import java.io.IOException;

public class loginCase extends CaseBase {
    public baseDriver driver;
    public loginPro lp;
    public PropertiesFile pf;
    public coursePro coursepro;
    public sureOrderPagePro sureorderPagePro;
    public coursePageHandle cph;
    public orderPayPagePro opp;

    public loginCase() throws IOException {
        this.driver=InitDriver("chrome");
        lp=new loginPro(driver);
        pf=new PropertiesFile("element.properties");
        coursepro=new coursePro(driver);
        sureorderPagePro=new sureOrderPagePro(driver);
        cph=new coursePageHandle(driver);
        opp=new orderPayPagePro(driver);
    }
    //@Test
    public void getPage(){

        driver.get("https://www.imooc.com/user/newlogin/from_url");

    }
    @Test//(dependsOnMethods = {"getPage"})
    @Parameters({"username","password"})
    public void test(String username,String password) throws IOException {
        driver.get("https://www.imooc.com/user/newlogin/from_url");
        lp.login1(username,password);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
    /*立即购买
    * */
  // @Test(dependsOnMethods = {"test"})
    public void buyNow() throws IOException {
        cph.clickBuyNowButton();
    }
    /*提交订单
    * */
    @Test(dependsOnMethods = {"test"})
    public void testSureOrder() throws IOException, InterruptedException {
        driver.get("https://coding.imooc.com/class/230.html");
        cph.clickBuyNowButton();
        sureorderPagePro.sureOrder();
        Thread.sleep(2000);
        opp.orderPayPro();
    }
    /*添加购物车
    * */
    //@Test(dependsOnMethods = {"test"})
    public void testShopCart() throws IOException {
        driver.get("https://coding.imooc.com/class/236.html");
        coursepro.AddShopCart();
    }
    /*下单流程
    * */
    public void buyCourse() throws IOException {
       driver.get("https://coding.imooc.com/class/230.html");
        String path=driver.element(By.className("path")).findElement(By.tagName("span")).getText();
        driver.element(By.id("buy-trigger")).click();
        driver.element(By.linkText("提交订单")).click();

       try {
           Thread.sleep(3000);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       String order=driver.element(By.className("order")).getText();
        if(order!=null){
            String df=driver.element(By.className("left")).findElement(By.tagName("dt")).getText();
            Assert.assertEquals(path,df);
        }
    }
    /*下单流程
    * */
   // @Test(dependsOnMethods = {"test"})
    public void downOrder() throws IOException {
        driver.get("https://coding.imooc.com/class/236.html");
        String buyInfor=this.buyCourseNow();
        this.sureOrder();
        this.getOrder();
        String orderInfor=this.getOrderCourse();
        if(buyInfor.equals(orderInfor)) {
            System.out.println("下单成功");
        }
    }
    /*获取父element
    * */
    public WebElement getElement(By by){
        return driver.element(by);
    }
    /*获取子element
    * */
    public WebElement getElement(WebElement element,By by){
        return element.findElement(by);
    }
    /*获取课程信息
    * */
    public String getCourseText(WebElement element){
        return element.getText();
    }
    /*返回课程信息，点击立即购买
    * */
    public String buyCourseNow() throws IOException {
        WebElement element=this.getElement(getByLocal.getStr("courseInfo"));
        WebElement element1Now=this.getElement(element,getByLocal.getStr("courseInfoText"));
        String Course=this.getCourseText(element1Now);
        driver.click(this.getElement(getByLocal.getStr("buyNow")));
        return Course;
    }
    /*点击确认订单
    * */
    public void sureOrder() throws IOException {
        driver.click(this.getElement(getByLocal.getStr("sureOrder")));
    }
    /*获取订单text
    * */
    public String getOrder() throws IOException {
         String orderText=this.getCourseText(this.getElement(getByLocal.getStr("order")));
         return orderText;
    }
    /*获取支付中心商品信息
    * */
    public String getOrderCourse() throws IOException {
        WebElement element=this.getElement(getByLocal.getStr("orderCourse"));
        WebElement element1=this.getElement(element,getByLocal.getStr("orderCourseNode"));
        String sa=this.getCourseText(element1);
        return sa;
    }
}
