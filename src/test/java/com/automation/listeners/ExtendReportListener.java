package com.automation.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ExtendReportListener implements ITestListener {
    ExtentReports extendReports;
    ExtentTest extendTest;
    @Override
    public void onStart(ITestContext context){

        ExtentSparkReporter sparkReporter = new ExtentSparkReporter("report/extent-report.html");
        sparkReporter.config().setReportName("Automation Execution Report");

        extendReports = new ExtentReports();
        extendReports.attachReporter(sparkReporter);
    }

    @Override
    public void onTestStart(ITestResult result){
        extendTest = extendReports.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result){
        extendTest.log(Status.PASS,"Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result){
        extendTest.log(Status.PASS,"Test Failed");
    }

    @Override
    public void onTestSkipped(ITestResult result){
        extendTest.log(Status.PASS,"Test Skipped");
    }

    @Override
    public void onFinish(ITestContext context){extendReports.flush();}

}
