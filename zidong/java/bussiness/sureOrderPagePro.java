package bussiness;

import base1.baseDriver;
import handle.sureOrderHandle;

import java.io.IOException;

public class sureOrderPagePro {
    public baseDriver driver;
    public sureOrderHandle sureorderHandle;
    public sureOrderPagePro(baseDriver driver){
        this.driver=driver;
        sureorderHandle=new sureOrderHandle(driver);
    }
    /*确认订单按钮
    * */
    public void sureOrder() throws IOException {
        sureorderHandle.clickSureOrderElement();
    }
}
