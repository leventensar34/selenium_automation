package com.eurotech.test.day14_Slider;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SliderTest {


    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() {

        driver.close();
    }


    @Test
    public void sliderTest() {

        // Not: Butunun saga sola kaymasi icin  Action classindan obje olusturulup sonrasindan metodlari kullanilir.
        // metod larin sonuna mutlaka perform(); metodu yazilir yoksa calismaz.
        driver.get("https://demoqa.com/slider");

        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));

        Actions action = new Actions(driver);
        action.dragAndDropBy(slider, 30, 0).perform();

        WebElement sliderUnderValue= driver.findElement(By.xpath("//div[@class='range-slider__tooltip__label']"));
        String value=sliderUnderValue.getText();
        System.out.println("value = " + value);

        WebElement sliderValue= driver.findElement(By.cssSelector("#sliderValue"));
        String sliderValueText=sliderValue.getAttribute("value");
        System.out.println("sliderValueText = " + sliderValueText);

        Assert.assertEquals(value,"56");


    }
}
