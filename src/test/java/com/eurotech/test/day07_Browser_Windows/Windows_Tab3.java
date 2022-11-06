package com.eurotech.test.day07_Browser_Windows;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Windows_Tab3 {

    public static void main(String[] args) throws InterruptedException {



        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();

        WebElement tabNewButton= driver.findElement(By.id("messageWindowButton"));
        tabNewButton.click();



    }
}
