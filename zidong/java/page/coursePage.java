package page;

import base1.baseDriver;
import base1.basePage;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class coursePage extends basePage {
    public coursePage(baseDriver driver) {
        super(driver);
    }
    /*获取立即购买element
    * */
    public WebElement getBuyElement() throws IOException {
        return element(getByLocal.getStr("buyNow"));
    }
    /*获取添加购物车element
    * */
    public WebElement getAddCartElement() throws IOException {
        return element(getByLocal.getStr("addCart"));
    }
    /*获取右上角购物车element
    * */
    public WebElement getShopCartElement() throws IOException {
        return element(getByLocal.getStr("shopCart"));
    }
    /*获取添加数字element
    * */
    public WebElement getShopCartNowElement() throws IOException {
        return element(getByLocal.getStr("cartNum"));
    }
    /*获取左上角课程信息element
    * */
    public WebElement getCourseInforElement() throws IOException {
        return ondeElement(getByLocal.getStr("courseInfo"),getByLocal.getStr("courseInfoText"));

    }
}
