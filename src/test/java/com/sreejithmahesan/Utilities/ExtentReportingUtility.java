package com.sreejithmahesan.Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentKlovReporter;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.lang.invoke.SwitchPoint;

public class ExtentReportingUtility {

    ExtentReports extent = null;
    ExtentSparkReporter spark = null;
    ExtentTest test;
    private static ExtentReportingUtility extent_Report;
    public static ExtentReportingUtility getExtent_report() {
        if(extent_Report == null)
            return extent_Report = new ExtentReportingUtility();
        else
            return extent_Report;
    }

    ExtentReportingUtility()
    {
        extent = new ExtentReports();
        spark = new ExtentSparkReporter("target//TestReports//Spark.html");
    }

    public void CreateExtentTest(String testName)
    {
        test = extent.createTest(testName);

    }

    public void LogExtentReport(String message,int status)
    {
        switch (status)
        {
            case 1:
            {
                test.pass(message);
                test.log(Status.PASS, message);
                break;
            }
            case 0:
            {
                test.fail(message);
                test.log(Status.FAIL, message);
                break;
            }
            default:
            {
                test.warning(message);
                test.log(Status.WARNING,message);
                break;
            }
        }
    }

    public void FlushExtentReport()
    {
        extent.attachReporter(spark);
        extent.flush();
    }



}
