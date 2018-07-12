package handle;

import base1.baseDriver;
import page.sureOrderPage;

import java.io.IOException;

public class sureOrderHandle {
    public baseDriver driver;
    public sureOrderPage sureorder;
    public sureOrderHandle(baseDriver driver){
        this.driver=driver;
        sureorder=new sureOrderPage(driver);
    }
    /*点击确认订单按钮
    * */
    public void clickSureOrderElement() throws IOException {
        driver.click(sureorder.getOrderElement());
    }
}
