package com.eurotech.test.day03_DynamicButton;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class DinamikElementBulma1 {

    public static void main(String[] args) {


        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://demoqa.com/buttons");
        driver.manage().window().maximize();

        WebElement dynamicClickButton= driver.findElement(By.xpath("//div[last()]/button"));
        dynamicClickButton.click();

        WebElement dynamicClickMessage= driver.findElement(By.id("dynamicClickMessage"));
        String clickMessage=dynamicClickMessage.getText();
        System.out.println("clickMessage = " + clickMessage);


    }
}
