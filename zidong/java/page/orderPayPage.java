package page;

import base1.baseDriver;
import base1.basePage;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class orderPayPage extends basePage {
    public orderPayPage(baseDriver driver) {
        super(driver);
    }
    /*获取订单号element
    * */
    public WebElement getOrderNumElement() throws IOException {
        return element(getByLocal.getStr("order"));
    }
   /*获取课程信息element
   * */
   public WebElement getOrderCourseNameElement() throws IOException {
       return ondeElement(getByLocal.getStr("orderCourse"),getByLocal.getStr("orderCourseNode"));
   }
    /*获取支付方式element
    * */
    public WebElement getPayStyleElement() throws IOException {
        return element(getByLocal.getStr("alipay"));
    }
    /*获取立即支付element
    * */
    public WebElement getPayNowElement() throws IOException {
        return element(getByLocal.getStr("orderpay"));
    }
}
