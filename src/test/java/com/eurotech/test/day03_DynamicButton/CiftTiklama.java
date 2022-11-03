package com.eurotech.test.day03_DynamicButton;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CiftTiklama {

    public static void main(String[] args) {

        WebDriver driver=WebDriverFactory.getDriver("chrome");

        driver.get("https://demoqa.com/buttons");
        driver.manage().window().maximize();

        WebElement doubleClickButton= driver.findElement(By.id("doubleClickBtn"));



    }
}
