package util;

import base1.baseDriver;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;


public class testngListenerScreenShot extends TestListenerAdapter {
    public baseDriver driver;
    public void onTestSuccess(ITestResult var1) {
        super.onTestSuccess(var1);
    }
    public void onTestFailure(ITestResult var1) {
        super.onTestFailure(var1);
        this.takeScreenShot(var1);
    }
    public void takeScreenShot(ITestResult var1){
        baseDriver b=(baseDriver)var1.getInstance();
        b.takeScreenShot();
    }
}
