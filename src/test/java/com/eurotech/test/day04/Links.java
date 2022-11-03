package com.eurotech.test.day04;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Links {


    public static void main(String[] args) {



        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://demoqa.com/links");
        driver.manage().window().maximize();

        WebElement textLinkPage= driver.findElement(By.tagName("h5"));
        System.out.println("textLinkPage.getText() = " + textLinkPage.getText());

        WebElement linkHome= driver.findElement(By.id("simpleLink"));
        linkHome.click();

        driver.navigate().back();

        driver.get("https://demoqa.com/links");

        driver.findElement(By.id("dynamicLink")).click();


    }
}
