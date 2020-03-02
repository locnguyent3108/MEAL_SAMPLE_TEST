package utils;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import testcases.BaseTest;

public class TestListener implements ITestListener {
    @Override
    public void onTestStart(ITestResult iTestResult) {

    }

    @Override
    public void onTestSuccess(ITestResult iTestResult) {
//        System.out.println("I am in onTestSuccess method " + getTestMethodName(iTestResult));
    }

    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("on test failure ");
        Object testClass = iTestResult.getInstance();
        WebDriver driver = BaseTest.getDriver();
        if(driver instanceof  WebDriver) {
            System.out.println("Screenshot captured for test case");
            saveFailureScreenshots(driver);
        }
    }

    @Override
    public void onTestSkipped(ITestResult iTestResult) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {

    }

    @Override
    public void onStart(ITestContext iTestContext) {
        System.out.println("I'm in onStart method: " + iTestContext.getName());
        iTestContext.setAttribute("Webdriver", BaseTest.getDriver());
    }

    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("I'm in onFinish method: " + iTestContext.getName());

    }

    private static String getMethodsName(ITestResult result) {
        return result.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment
    public byte[] saveFailureScreenshots(WebDriver driver){
        return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
    }

    @Attachment (value = "{0}", type = "text/plain")
    public static String saveTextLog(String message) {
        return message;
    }

    //*********Constructor**********
    //*********Page Variables*******
    //*********Web Elements*********
    //*********Page Methods*********

}
