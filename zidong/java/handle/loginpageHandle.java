package handle;


import base1.baseDriver;

import page.loginPage;

import java.io.IOException;

public class loginpageHandle  {

    public loginPage lp;
    public loginpageHandle(baseDriver driver){
        lp=new loginPage(driver);
    }
    /*输入用户名
    * */
    public void sendkeysUsername(String username) throws IOException {
        lp.sendkeys(lp.getUserNameBoxElement(),username);
    }
    /*输入密码
    * */
    public void sendkeysPassword(String password) throws IOException {
        lp.sendkeys(lp.getPasswordBoxElement(),password);
    }
    /*点击登陆
    * */
    public void clickLoginButton() throws IOException {
        lp.click(lp.getButtonElement());
    }
    /*判断输入框是否显示
    * */
    public boolean assertLonginDisplay() throws IOException {
        return lp.assertElementDisplay(lp.getUserNameBoxElement());
    }
    /*
    * 获取用户名信息*/
    public String getUserInfor() throws IOException {
        return lp.getText(lp.getUsernameInfor());
    }
}
