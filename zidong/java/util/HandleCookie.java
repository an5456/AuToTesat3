package util;

import base1.baseDriver;


import org.openqa.selenium.Cookie;
import page.PropertiesFile;

import java.io.IOException;
import java.util.Set;

public class HandleCookie {
    public baseDriver driver;
    public PropertiesFile pf;
    public HandleCookie(baseDriver driver) throws IOException {
        this.driver=driver;
        pf=new PropertiesFile("element.properties");
    }
    public void setCookie(){
        String value=pf.getFile("apsid");
        Cookie cookie=new Cookie("apsid",value,".imooc.com","/",null);
        driver.addCookie(cookie);
    }
    /*获取cookie
    * */
    public void  writeCookie() throws IOException {
        Set<Cookie> cookies=driver.getCookie();
        for(Cookie cookie:cookies){
            if(cookie.getName().equals("apsid")){
                    pf.WritePro(cookie.getName(),cookie.getValue());
            }
        }
    }
}
