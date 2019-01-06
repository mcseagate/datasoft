package Screenshots;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Screenshot {

    public static String takeScreenshots(WebDriver driver, String FileName) throws IOException {
            FileName = FileName + ".png";
            String directory = "/Users/mgodfrey/Documents/TestReport";
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(srcFile, new File(directory + FileName));
            String destination = directory + FileName;
            return destination;

        }


}
