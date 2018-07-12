package handle;

import base1.baseDriver;
import page.orderPayPage;

import java.io.IOException;

public class orderPayPageHandle {
    public baseDriver dirver;
    public orderPayPage opp;
    public orderPayPageHandle(baseDriver dirver){
        this.dirver=dirver;
        opp=new orderPayPage(dirver);
    }
    /*
    * 获取订单文字*/
    public String getOrderNumText() throws IOException {
       return opp.getText(opp.getOrderNumElement());

    }
    /*获取课程信息文字信息
    * */
    public String getOrderCourseText() throws IOException {
       return opp.getText(opp.getOrderCourseNameElement());
    }
    /*点击支付宝支付
    * */
    public void clickPayBao() throws IOException {
        opp.click(opp.getPayStyleElement());
    }
    /*点击立即支付
    * */
    public void clickPayNow() throws IOException {
        opp.click(opp.getPayNowElement());
    }
}
