package bussiness;

import base1.baseDriver;
import handle.orderPayPageHandle;

import java.io.IOException;

public class orderPayPagePro {
    public baseDriver driver;
    public orderPayPageHandle opph;
    public orderPayPagePro(baseDriver driver){
        this.driver=driver;
        opph=new orderPayPageHandle(driver);
    }
    /*根据课程、订单判断跳转到立即购买页面
    * */
    public void orderPayPro() throws IOException {
        String orderNum=opph.getOrderNumText();
        String orderCourse=opph.getOrderCourseText();
        if(orderNum!=null&&orderCourse!=null){
            opph.clickPayBao();
            opph.clickPayNow();
        }
    }
}
