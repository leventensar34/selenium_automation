package com.eurotech.test.day03_DynamicButton;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DinamikElementBulma2_2 {

    public static void main(String[] args) {


        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://demoqa.com/dynamic-properties");
        driver.manage().window().maximize();

        WebElement colorChangeButton= driver.findElement(By.id("colorChange"));
        String className= colorChangeButton.getAttribute("class");
        System.out.println("className = " + className);

        WebDriverWait wait=new WebDriverWait(driver,4);
        wait.until(ExpectedConditions.attributeToBe(colorChangeButton,"class","mt-4 text-danger btn btn-primary"));
        className= colorChangeButton.getAttribute("class");
        System.out.println("className = " + className);

    }
}
