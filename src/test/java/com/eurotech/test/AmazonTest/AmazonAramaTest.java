package com.eurotech.test.AmazonTest;

import com.eurotech.pages.AmazonPage;
import com.eurotech.test.TestBase;
import com.eurotech.utilities.ConfigurationReader;
import com.eurotech.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
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
}
