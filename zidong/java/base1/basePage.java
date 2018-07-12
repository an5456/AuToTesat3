package base1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class basePage {
    public baseDriver driver;
    public basePage (baseDriver driver){
        this.driver=driver;
    }
    /*封装获取element
    * */
    public WebElement element(By by){
      WebElement  ele=driver.element(by);
      return ele;
    }
    /*层级定位，通过父节点定位子节点
    传入父节点和子节点的by
    * */
    public WebElement ondeElement(By by,By nodeby){
       WebElement sa= this.element(by);
       return sa.findElement(nodeby);
    }
    /*封装点击操作
    * */
    public void click(WebElement element){
        element.click();
    }
    /*封装输入操作
    * */
    public void sendkeys(WebElement element,String key){

        element.sendKeys(key);
    }
    /*判断元素是否显示
    * */
    public boolean assertElementDisplay(WebElement element){
        return element.isDisplayed();
    }
    /*获取文本信息
    * */
    public String getText(WebElement element){
        return element.getText();
    }
    /*鼠标悬停
    * */
    public void action(WebElement element){
        driver.moveTo(element);
    }
}
