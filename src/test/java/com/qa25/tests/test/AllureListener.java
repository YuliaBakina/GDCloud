package com.qa25.tests.test;

import com.qa25.tests.fw.HelperBase;
import io.qameta.allure.Attachment;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class AllureListener  implements ITestListener{

    private static String getTestMethodName(ITestResult iTestResult){
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    private byte[] saveScreenshot(byte[] screenshot){
        return screenshot;
    }

    @Attachment(value = "{0}", type = "text/plain")
    public static String saveTextLog(String message){
        return message;
    }

    @Override
    public void onTestFailure(ITestResult result){
        System.out.println("Test method " + getTestMethodName(result) + " FAILURE");
        System.out.println("Screenshot for test case: " + getTestMethodName(result));
        saveScreenshot(HelperBase.takeScreenShot());
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart method " + getTestMethodName(result));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("Test method " + getTestMethodName(result) + " SUCCESS");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onSkippedTest method " + getTestMethodName(result) + " SKIPPED");

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("===");
    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {
        System.out.println("===");
    }

    @Override
    public void onStart(ITestContext context) {
        System.out.println("onStart method " + context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish method " + context.getName());
    }
}
