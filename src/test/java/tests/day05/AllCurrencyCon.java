package tests.day05;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AllCurrencyPage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.io.File;
import java.io.IOException;

public class AllCurrencyCon {
    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();
    AllCurrencyPage page=new AllCurrencyPage();

    @Test
    public void allCurrencyCon() throws InterruptedException, IOException {
        // all currency uygulamasinin yuklendigi dogulanir
        Assert.assertTrue(driver.isAppInstalled("com.smartwho.SmartAllCurrencyConverter"));

        // uygulamanin acildigi dogrulanir
        //Assert.assertTrue(page.acilisSayfasiYazisi.isDisplayed());
        Assert.assertTrue(driver.findElementByXPath("//*[@text='CURRENCY CONVERTER']").isDisplayed());

        // cevirmek istedigimiz para birimi Türk Lirasi olarak secilir
        ReusableMethods.koordinatTiklamaMethodu(350,450,500);
        ReusableMethods.scrollWithUiScrollableAndClick("TRY");
        Thread.sleep(2000);
        page.bir.click();
        page.ucSifir.click();

        // cevirelecek olan para birimi Rus Rublesi olarak secilir
        ReusableMethods.koordinatTiklamaMethodu(350,650,500);
        ReusableMethods.scrollWithUiScrollableAndClick("Russian Ruble");


        // cevrilen tutar screenShot olarak kaydedilir
        File screenshot=driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot,new File("screnshot.jpg"));
        //Manuel ScreenShot almak icin bunu kullandık
        //Bir de Target altinda tarih ve saatli olusturduk o da ReusableMethods icin de almak icin bunu kullandık

        ReusableMethods.getScreenshot("SonucScreenShot");

        // Ardindan Türk lirasinin Rus Rublesi karsiligi olan degeri kaydedilir
        String cevrilenTutar=page.sonuc.getText();

        // kullaniciya sms olarak bildirilir
        driver.sendSMS("234567","Cevrilen Tutar: "+cevrilenTutar);



    }
















}