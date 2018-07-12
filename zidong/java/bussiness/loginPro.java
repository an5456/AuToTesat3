package bussiness;

import base1.baseDriver;
import handle.loginpageHandle;
import java.io.IOException;
public class loginPro {
    public loginpageHandle lph;
    public loginPro(baseDriver driver){

        lph=new loginpageHandle(driver);
    }
    public void login1(String username,String password) throws IOException {
        if(lph.assertLonginDisplay()){
            lph.sendkeysUsername(username);
            lph.sendkeysPassword(password);
            lph.clickLoginButton();
        }else {
            System.out.println("页面元素不存在");
        }
    }
    /*判断是否是登陆的用户名和信息
    * */
    public Boolean sureloginUsername(String username) throws IOException {
        if(lph.getUserInfor().equals(username)) {
                return true;
            }
            else {
            return false;
        }
    }
}
