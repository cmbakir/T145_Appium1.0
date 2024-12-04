package tests.day02;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Arabam {

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

        driver = new AndroidDriver<AndroidElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }
    @Test
    public void Test1() throws InterruptedException {
        // uygulamanin basarili bir sekilde yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.dogan.arabam"));
        Thread.sleep(1500);

        // uygulamanin basarili bir sekilde acildigi dogrulanir
        Assert.assertTrue(driver.findElementById("com.dogan.arabam:id/ivArabamLogo").isDisplayed());

        // alt menuden ilan ara butonuna tiklanir
        Thread.sleep(1500);
        driver.findElementByXPath("//*[@text='İlan Ara']").click();

        // kategori olarak otomobil secilir
        Thread.sleep(2000);
        driver.findElementByXPath("//*[@text='Otomobil']").click();

        // arac olarak Volkswagen secilir
        Thread.sleep(3500);
        TouchAction action=new TouchAction<>(driver);
        action.press(PointOption.point(517,1890)).
                waitAction(WaitOptions.waitOptions(Duration.ofMillis(75))).
                moveTo(PointOption.point(517,378)).release().perform();
        // baslangic noktasiyla bitis noktasi arasindaki gecen sure (wait action)
        // eger sure azalirsa; gidilen yol mesafesi ARTAR. eger sureyi arttirirsan; gidilen yol mesafesi AZALIR !!
        // yani tamamen bir ters oranti vardir. ekranda daha fazla asagi ya da yukari gitmek istiyorsak birim zamanda sureyi azaltmaliyiz

        Thread.sleep(5000);
        driver.findElementByXPath("//*[@text='Volkswagen']").click();

        // arac markasi olarak passat secilir
        Thread.sleep(3000);
        driver.findElementByXPath("//*[@text='Passat']").click();

        // 1.4 TSI BlueMotion secilir
        driver.findElementByXPath("//*[@text='1.4 TSi BlueMotion']").click();

        // Paket secimi comfortline yapilir
        driver.findElementByXPath("//*[@text='Comfortline']").click();

        // Ucuzdan pahaliya siralama yaparak filtreleme yapilir
        Thread.sleep(4000);
        action.press(PointOption.point(409,296)).release().perform();

        driver.findElementByXPath("//*[@text='Fiyat - Ucuzdan Pahalıya']").click();
        Thread.sleep(2000);
        // Gelen en ucuz aracin 500.000 tl den buyuk oldugu dogrulanir
        String enucuzfiyat =driver.findElementByXPath(" (//*[@resource-id='com.dogan.arabam:id/tvPrice'])[1]").getText();
        enucuzfiyat=enucuzfiyat.replaceAll("\\D","");

        Assert.assertTrue(Integer.parseInt(enucuzfiyat)>500000);




    }
}