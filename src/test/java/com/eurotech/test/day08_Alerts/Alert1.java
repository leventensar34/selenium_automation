package com.eurotech.test.day08_Alerts;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Alert1 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(2000);
         driver.close();
    }

    @Test
    public void test1() throws InterruptedException {

        // Click Button to see alert
        driver.get("https://demoqa.com/alerts");

        driver.findElement(By.cssSelector("#alertButton")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();

        // On button click, alert will appear after 5 seconds
        driver.findElement(By.cssSelector("#timerAlertButton")).click();
        Thread.sleep(5000);
        driver.switchTo().alert().accept();

        // On button click, confirm box will appear

        driver.findElement(By.cssSelector("#confirmButton")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();

        // On button click, prompt box will appear
        driver.findElement(By.cssSelector("#promtButton")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("Galatasaray");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
    }
}
