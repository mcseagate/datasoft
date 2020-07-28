package Base;

import ConfigFiles.ConfigFiles;
import Screenshots.Screenshot;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class TestBase {
    public static WebDriver driver;
    public static Properties prop;
    public static FileInputStream ip;



    public TestBase(){

        try{
       prop = new Properties();
       ip = new FileInputStream("/Users/mgodfrey/IdeaProjects/Datasoft/Config.Properties");
       prop.load(ip);
    }

        catch (FileNotFoundException e){
            e.printStackTrace();
    }
        catch (IOException e){
            e.printStackTrace();
        }

    }

    public static void initialization(){
        String browserName = prop.getProperty("browser");

        if(browserName.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "/Users/mgodfrey/Documents/Drivers/chromedriver");
            driver = new ChromeDriver();
        }

        else if(browserName.equalsIgnoreCase("firefox")){
            System.setProperty("webdriver.gecko.driver", "/Users/mgodfrey/Documents/Drivers/geckodriver");
        }

        else{
            System.out.println("Browser Type Not In Use");
        }

        driver.manage().timeouts().implicitlyWait(ConfigFiles.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(ConfigFiles.PAGE_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().window().fullscreen();
        driver.get(prop.getProperty("url"));


    }

/*
    @BeforeMethod
    public static void startUp(){

        report = new ExtentReports("/Users/mgodfrey/Documents/TestReport.html");
        test = report.startTest("Prayer Request");
        test.log(LogStatus.INFO, "Test Successfully Started");

    }

    @AfterMethod
    public static void tearDown(ITestResult testResult) throws IOException {
        if (testResult.getStatus() == ITestResult.FAILURE) {
            String path = Screenshot.takeScreenshots(driver, testResult.getName());
            String imagePath = test.addScreenCapture(path);
            test.log(LogStatus.FAIL, imagePath);

        }
        test.log(LogStatus.INFO, "Test Successfully Ended");
            report.endTest(test);
            report.flush();
            driver.quit();

    }

    */

}
