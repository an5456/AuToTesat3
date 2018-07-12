package base1;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class baseDriver {
    WebDriver driver;
    public  baseDriver(String browser){
        selectDriver select=new selectDriver();
        this.driver=select.driverName(browser);
    }
    /*封装element
    * */
    public WebElement element(By by){
      WebElement el= driver.findElement(by);
      return el;
    }
    /*封装get
    * */
    public void get(String url){

        driver.get(url);
    }
    /*点击
    * */
    public void click(WebElement element){
        element.click();
    }
    /*操作模态框
    * */
    public void switchTo(){
        driver.switchTo().activeElement();
    }
    /*鼠标悬停
    * */
    public void moveTo(WebElement element){
        Actions actions=new Actions(driver);
        actions.moveToElement(element).perform();
    }
    /*隐士等待
    * */
    public void wait1(int tiem){
        driver.manage().timeouts().implicitlyWait(tiem,TimeUnit.SECONDS);
    }
    /*关闭网页
    * */
    public void close(){
        driver.close();
    }
    /*获取cookie
    * */
    public Set<Cookie> getCookie(){
       Set<Cookie> cookies=driver.manage().getCookies();
       return cookies;
    }
    /*删除cookie
    * */
    public void deleteCookie(Cookie cookie){
        driver.manage().deleteCookie(cookie);
    }
    /*设置cookie
    * */
    public void addCookie(Cookie cookie){
        driver.manage().addCookie(cookie);
    }
    /*截图
     * */
    public void takeScreenShot(){
        long timeStamp = System.currentTimeMillis();
        String path=String.valueOf(timeStamp);
        // SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // String sd = sdf.format(new Date(Long.parseLong(String.valueOf(timeStamp))));
        //System.out.println(sd);
        String systemPath=System.getProperty("user.dir");
        path=path+".png";
        String screenPath=systemPath+"/"+path;
        File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screen,new File(screenPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
