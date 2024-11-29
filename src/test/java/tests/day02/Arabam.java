package tests.day02;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class Arabam {


    // alt menuden ilan ara butonuna tiklanir
    // kategori olarak otomobil secilir
    // arac olarak Volkswagen secilir
    // arac markasi olarak passat secilir
    // 1.4 TSI BlueMotion secilir
    // Paket secimi yapilir
    // Ucuzdan pahaliya siralama yaparak filtreleme yapilir
    // Gelen en ucuz aracin 500.000 tl den buyuk oldugu dogrulanir
    AndroidDriver<AndroidElement> driver;

    @BeforeTest
    public void SetUp() throws MalformedURLException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel");//cihazimizin adi
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android"); //isletim sistemi
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0"); //versiyonu biz 10 sectik
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");//android kullandigimiz icin UiAutomator2, IOS icin XCUITest kullanilir
        //caps.setCapability(MobileCapabilityType.APP, "/Users/copperdevil/IdeaProjects/T145_Appium/Apps/arabam-com-5-4-1.apk");
        caps.setCapability("appPackage","com.dogan.arabam");
        caps.setCapability("appActivity","com.dogan.arabam.presentation.feature.home.HomeActivity");


       caps.setCapability("adbExecTimeout", 100000);
       caps.setCapability("androidInstallTimeout", 100000);
       caps.setCapability("newCommandTimeout", 300);

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
    }
    @Test
    public void Test1() throws InterruptedException {
        // uygulamanin basarili bir sekilde yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));
        Thread.sleep(1500);

        // uygulamanin basarili bir sekilde acildigi dogrulanir
        Assert.assertTrue(driver.findElementById("com.dogan.arabam:id/ivArabamLogo").isDisplayed());

    }
}