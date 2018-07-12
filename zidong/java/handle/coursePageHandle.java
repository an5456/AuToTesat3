package handle;

import base1.baseDriver;
import page.coursePage;

import java.io.IOException;

public class coursePageHandle {
    public baseDriver driver;
    public coursePage basepage;
    public coursePageHandle(baseDriver driver){
        this.driver=driver;
        basepage=new coursePage(driver);
    }
    /*点击立即购买车按钮
    * */
    public void clickBuyNowButton() throws IOException {
        basepage.click(basepage.getBuyElement());

    }
    /*点击添加购物车按钮
    * */
    public void clickAddShopButton() throws IOException {
        basepage.click(basepage.getAddCartElement());
    }
    /*点击添加购物车按钮
    * */
    public void clickCart1Button() throws IOException {
        basepage.click(basepage.getAddCartElement());
    }
    /*点击右上角购物车按钮
    * */
    public void clickShopCartButton() throws IOException {
        basepage.click(basepage.getShopCartElement());
    }
    /*
    * 获取右上角购物车数量*/
    public String getCourseNum() throws IOException {
       return basepage.getText(basepage.getShopCartNowElement());
    }
    /*获取右上角购物车数量
    * */
    public String getCourseInfor() throws IOException {
        return basepage.getText(basepage.getCourseInforElement());
    }

}
