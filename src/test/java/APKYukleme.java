import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class APKYukleme {
    AndroidDriver<AndroidElement> driver;

    @Test
    public void apkyukleme() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");//cihazimizin adi
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); //isletim sistemi
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0"); //versiyonu biz 10 sectik
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");//android kullandigimiz icin UiAutomator2, IOS icin XCUITest kullanilir
        caps.setCapability(MobileCapabilityType.APP, "/Users/copperdevil/IdeaProjects/T145_Appium/Apps/all-currency-converter-3-9-0 (1).apk");

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
}