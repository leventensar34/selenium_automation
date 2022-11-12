package com.eurotech.test.day10_Modals_Dialogs;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Modals {

    WebDriver driver;
    @BeforeMethod
    public void setUp() {

        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() {
        driver.close();

    }

    @Test
    public void modals() {

        driver.get("https://demoqa.com/modal-dialogs");

        driver.findElement(By.cssSelector("#showSmallModal")).click();

        WebElement smallModalText= driver.findElement(By.cssSelector(".modal-body"));
        System.out.println("smallModalText.getText() = " + smallModalText.getText());

        driver.findElement(By.cssSelector("#closeSmallModal")).click();


        driver.findElement(By.cssSelector("#showLargeModal")).click();

        WebElement largeModalText= driver.findElement(By.cssSelector(".modal-body"));
        System.out.println("largeModalText.getText() = " + largeModalText.getText());

        driver.findElement(By.cssSelector("#closeLargeModal")).click();



    }
}
