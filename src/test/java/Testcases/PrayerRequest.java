package Testcases;

import Base.TestBase;
import Screenshots.Screenshot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class PrayerRequest extends TestBase {
    ExtentReports report;
    ExtentTest test;

    public PrayerRequest(){
        super();
    }


    @BeforeMethod
    public void startUp(){
        initialization();
        report = new ExtentReports("/Users/mgodfrey/Documents/TestReport.html");
        test = report.startTest("Prayer Request");
        test.log(LogStatus.INFO, "Test Successfully Started");
    }


    @Test
    public void verifyTitle(){
        String title = driver.getTitle();
        Assert.assertEquals("Prayers – City of David", title);
        System.out.println(title);
        test.log(LogStatus.INFO, "Title is Returned as: " + title);
    }


    @AfterMethod
    public void tearDown(ITestResult testResult) throws IOException {
        if (testResult.getStatus()==ITestResult.FAILURE) {
            String path = Screenshot.takeScreenshots(driver, testResult.getName());
            String imagePath = test.addScreenCapture(path);
            test.log(LogStatus.FAIL, imagePath);

        }

        test.log(LogStatus.INFO, "Test Successfully Ended");
        report.endTest(test);
        report.flush();
        driver.quit();
    }

}
