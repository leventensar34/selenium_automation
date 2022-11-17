package com.eurotech.test.day15_Progress_Bar;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ProgressBar {



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
    public void progressBar() {

        driver.get("https://demoqa.com/progress-bar");

        WebElement startStopButton= driver.findElement(By.cssSelector("#startStopButton"));
        startStopButton.click();

        WebElement progressBar=driver.findElement(By.cssSelector("div[role='progressbar']"));

        WebDriverWait wait=new WebDriverWait(driver,15);
        wait.pollingEvery(Duration.ofMillis(100));
        wait.until(ExpectedConditions.attributeToBe(progressBar,"aria-valuenow","45"));
        startStopButton.click();


    }
}
