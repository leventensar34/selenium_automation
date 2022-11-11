package com.eurotech.test.day09_Frames;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Frame1 {



    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
       // Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void frameTest() {

        driver.get("https://demoqa.com/frames");

       driver.switchTo().frame("frame1");

        WebElement frame1Text=driver.findElement(By.id("sampleHeading"));
        System.out.println("frame1Text.getText() = " + frame1Text.getText());

        driver.switchTo().parentFrame();
        List<WebElement> elementList=driver.findElements(By.cssSelector("div[id='framesWrapper'] div"));
        String paragraph=elementList.get(0).getText();
        System.out.println("paragraph = " + paragraph);

        driver.switchTo().frame("frame2");

        WebElement frame2Text= driver.findElement(By.id("sampleHeading"));
        System.out.println("frame2Text.getText() = " + frame2Text.getText());



    }
}
