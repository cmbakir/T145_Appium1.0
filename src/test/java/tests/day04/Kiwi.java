package tests.day04;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.touch.offset.PointOption;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.KiwiPages;
import utilities.Driver;
import utilities.ReusableMethods;

public class Kiwi {

    AndroidDriver<AndroidElement> driver= Driver.getAndroidDriver();

    KiwiPages page=new KiwiPages();

    @Test
    public void KiwiTest() throws InterruptedException {
        // uygulamanin yuklendigi dogrulanir
        Assert.assertTrue(driver.isAppInstalled("com.skypicker.main"));

        //uygulamanin basariyla acildigi dogrulanir
        Assert.assertTrue(page.misafirButonu.isDisplayed());
        Thread.sleep(2000);

        // misafir olarak devam et e tiklanir
        page.misafirButonu.click();
        Thread.sleep(2000);

        // ardindan gelecek olan 3 adimda da yesil butona basilarak devam edilir
/*
        TouchAction action=new TouchAction(driver);
        for (int i = 0; i < 3; i++) {
            action.press(PointOption.point(538,2060)).release().perform();
            Thread.sleep(2000);
        }
 */
        for (int i = 0; i < 3; i++) {
            ReusableMethods.koordinatTiklamaMethodu(538, 2060, 500);
        }

        // Trip type,one way olarak secilir
        page.returnButonu.click();
        Thread.sleep(2000);
        page.oneWayButonu.click();

        // kalkis ulkesi secenegine tiklanir ve default olan ulke kaldirilir
        page.fromButonu.click();
        Thread.sleep(2000);
        page.clearButonu.click();
        Thread.sleep(2000);

        // kalkis yapilacak ulke/sehir girilir ve sec e tiklanir
        page.ulkeYazmaKutusu.click();

        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("Ankara");
        }else {
            page.ulkeYazmaKutusu.sendKeys("Ankara");
        }

        Thread.sleep(2000);
        page.kalkisvarisbutonu.click();
        Thread.sleep(2000);
        page.secButonu.click();

        // varis ulkesi secenegine tiklanir ve gidilecek ulke girilir
        Thread.sleep(2000);
        page.tobutonu.click();
        if (driver.isKeyboardShown()){
            driver.getKeyboard().pressKey("Frankfurt");
        }else {
            page.ulkeYazmaKutusu.sendKeys("Frankfurt");
        }
        Thread.sleep(2000);
        page.kalkisvarisbutonu.click();
        Thread.sleep(2000);
        page.secButonu.click();

        // gidis tarihi 29 Kasim olarak secilir ve set date e tiklanir
        page.tarihbutonu.click();
        Thread.sleep(2000);
        ReusableMethods.koordinatTiklamaMethodu(800,1400,500);
        page.SetDatebutonu.click();
        Thread.sleep(2000);

        // search butonuna tiklanir
        page.Seachbutonu.click();
        Thread.sleep(2000);

        // en  ucuz ve aktarmasiz filtrelemeleri yapilir
        page.bestbutonu.click();
        page.enUcuzbutonu.click();
        Thread.sleep(2000);
        page.Stopbutonu.click();
        page.nonStopbutonu.click();
        Thread.sleep(2000);

        // gelen bilet fiyati kaydedilir ve kullanicin telefonuna sms olarak gonderilir
        String fiyatbilgisi=page.FiyatYazisi.getText();
        driver.sendSMS("11111111111","Bilet fiyati: "+fiyatbilgisi);













    }





}