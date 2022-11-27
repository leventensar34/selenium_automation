package com.eurotech.test.AmazonTest;

import com.eurotech.pages.AmazonPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.BrowserUtils;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonAramaTest extends TestBase {


    AmazonPage page = new AmazonPage();

    @Test
    public void aramaTest() {

        driver.get(ConfigurationReader.get("url"));

        Select select = new Select(page.kategoriList);
        select.selectByVisibleText("Automotive");

        page.searchBox.sendKeys("car phone holder" + Keys.ENTER);

        try {
            for (WebElement e : page.tümUrunler) {
                WebElement fiyat = e.findElement(By.className("a-price-whole"));
                System.out.println("fiyat.getText() = " + fiyat.getText());
            }
        } catch (Exception e) {

        }
    }

    @Test
    public void allTabTest() {

        driver.get(ConfigurationReader.get("url"));

        page.changeAddressBtn.click();
        page.navigateAllMenu2("Amazon Music", "Podcasts");

        WebElement actualMessage = driver.findElement(By.xpath("(//div/span[@class='macro'])[1]"));

        Assert.assertEquals(actualMessage.getText(), "Want access to top ad-free podcasts and 100 million songs? Try Amazon Music Unlimited");

    }

    @Test
    public void testName() {

        driver.get(ConfigurationReader.get("url"));

         page.changeAddressBtn.click();

        page.navigateMenu1("Baby", "kinder hippos");

        String enIyiUrunIsim = "", enIyiUrunPuan = "", enIyiUrunSayi = "", enIyiUrunFiyat = "";

        int enYuksek = 0;

        for (WebElement urun : page.tümUrunler) {

            WebElement isim = urun.findElement(By.xpath("//a/span[@class='a-size-base-plus a-color-base a-text-normal']"));
            WebElement fiyat = urun.findElement(By.className("a-price-whole"));
            WebElement puan = urun.findElement(By.cssSelector("[aria-label~='stars']"));
            WebElement sayi = urun.findElement(By.xpath("//a/span[@class='a-size-base s-underline-text']"));

            String puanBul[] = puan.getAttribute("aria-label").split("out");
            int temelPuan = (int) Float.parseFloat(puanBul[0]);
            int degerlendirmeSayisi = Integer.parseInt(sayi.getText().replace(",", ""));
            int temelFiyat = Integer.parseInt(fiyat.getText());

            int sonuc = (temelPuan * degerlendirmeSayisi) - (temelFiyat * 200);

            if (sonuc > enYuksek) {
                enIyiUrunIsim = isim.getText();
                enIyiUrunPuan = "" + temelPuan;
                enIyiUrunSayi = "" + degerlendirmeSayisi;
                enIyiUrunFiyat = "" + temelFiyat;
            }

        }
        System.out.println("enIyiUrunIsim = " + enIyiUrunIsim);
        System.out.println("enIyiUrunPuan = " + enIyiUrunPuan);
        System.out.println("enIyiUrunSayi = " + enIyiUrunSayi);
        System.out.println("enIyiUrunFiyat = " + enIyiUrunFiyat);


    }
}
