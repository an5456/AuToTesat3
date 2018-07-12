package page;

import base1.baseDriver;
import base1.basePage;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class loginPage extends basePage {
    public loginPage(baseDriver driver){

        super(driver);
    }
    /*获取输入框定位元素
    * */
    public WebElement getUserNameBoxElement() throws IOException {
    return element(getByLocal.getStr("username"));
    }
    /*获取密码框定位元素
    * */
    public WebElement getPasswordBoxElement() throws IOException {
        return element(getByLocal.getStr("userpass"));
    }
    /*获取登陆按钮的定位元素
    * */
    public WebElement getButtonElement() throws IOException {
        return element(getByLocal.getStr("button"));
    }
    /*获取用户名信息定位元素
    * */
    public WebElement getUsernameInfor() throws IOException {
         action(element(getByLocal.getStr("head")));
         return element(getByLocal.getStr("boxHead"));
    }

}
