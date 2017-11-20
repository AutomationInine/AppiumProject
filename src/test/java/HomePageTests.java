
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;




public class HomePageTests {



    @SuppressWarnings("rawtypes")
    private IOSDriver driver;

    @SuppressWarnings("rawtypes")
    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "iOS");
        caps.setCapability("platformVersion", "10.3");
        caps.setCapability("deviceName", "iPhone Simulator");
        caps.setCapability("automationName", "XCUITest");
        caps.setCapability("app", "/Users/e001844/Downloads/ios-uicatalog-master/build/Release-iphonesimulator/UICatalog.app");
        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }

    @Test
    public void testiOS() throws InterruptedException, IOException {


        driver.rotate(ScreenOrientation.LANDSCAPE);
        File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(scrFile, new File("/Users/e001844/SampleiOSApp/Test.png"));
        TouchAction t = new TouchAction(driver);
        t.press(236,128).release();
        driver.performTouchAction(t);
        Thread.sleep(2000);
        FileUtils.copyFile(scrFile, new File("/Users/e001844/SampleiOSApp/test2.jpg"));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
