package com.eurotech.test.AmazonTest;

import com.eurotech.pages.AmazonPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AmazonAramaTest extends TestBase {


    AmazonPage page=new AmazonPage();

    @Test
    public void aramaTest() {

     driver.get(ConfigurationReader.get("url"));

        Select select=new Select(page.kategoriList);
        select.selectByVisibleText("Automotive");

        page.searchBox.sendKeys("car phone holder"+ Keys.ENTER);

        for (WebElement e: page.tümUrunler) {

            WebElement fiyat=e.findElement(By.className("a-price-whole"));
            System.out.println("fiyat.getText() = " + fiyat.getText());

        }

    }

    @Test
    public void allTabTest() {

        driver.get(ConfigurationReader.get("url"));

        page.changeAddressBtn.click();
        page.navigateAllMenu("Amazon Music","Podcasts");

        WebElement actualMessage=driver.findElement(By.xpath("(//div/span[@class='macro'])[1]"));

        Assert.assertEquals(actualMessage.getText(),"Want access to top ad-free podcasts and 100 million songs? Try Amazon Music Unlimited");

    }
}
