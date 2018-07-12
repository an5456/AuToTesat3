package bussiness;

import base1.baseDriver;
import handle.coursePageHandle;

import java.io.IOException;

public class coursePro {
    public baseDriver driver;
    public coursePageHandle pa;
    public coursePro(baseDriver driver){
        this.driver=driver;
        pa=new coursePageHandle(driver);
    }
    /*添加购物车
    * */
    public void AddShopCart() throws IOException {
        int beforeNum;
        int arterNum ;
        String afterCourseNum;
        String courseNum = pa.getCourseNum();
        try {
            beforeNum = Integer.valueOf(courseNum);
        }catch (Exception e){
            beforeNum=0;
        }
        pa.clickAddShopButton();
        try {
            driver.switchTo();
            pa.clickShopCartButton();
        }catch (Exception e ){
            System.out.println("haha");
        }
        afterCourseNum = pa.getCourseNum();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
                arterNum=Integer.valueOf(afterCourseNum);
        }catch (Exception e){
            arterNum=beforeNum;
       }

        //pa.clickShopCartButton();
        if(arterNum==beforeNum+1){
            System.out.println("添加购物车成功");
            pa.clickShopCartButton();
        }else if (arterNum>0){
            pa.clickShopCartButton();
        }
    }
}
