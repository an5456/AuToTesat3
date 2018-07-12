package page;

import base1.baseDriver;
import base1.basePage;
import org.openqa.selenium.WebElement;
import java.io.IOException;

public class sureOrderPage extends basePage {
    public sureOrderPage(baseDriver driver) {
        super(driver);
    }
    /*获取提交订单按钮element
    * */
    public WebElement getOrderElement() throws IOException {
       return element(getByLocal.getStr("sureOrder"));
    }
}
