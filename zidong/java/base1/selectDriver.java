package base1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class selectDriver {
    public WebDriver driverName(String bowser){
        if(bowser.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.firefox.marionette", "D:\\wps\\selenium-2.42.2\\geckodriver.exe");
            return new FirefoxDriver();
        }else {
            System.setProperty("webdriver.chrome.driver", "D:\\wps\\selenium-2.42.2\\chromedriver.exe");
            return new ChromeDriver();
        }
    }
}
