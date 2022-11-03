package com.eurotech.test.day03_DynamicButton;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DinamikElementBulma2_1 {

    public static void main(String[] args) {


        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://demoqa.com/dynamic-properties");
        driver.manage().window().maximize();

        WebElement textElement= driver.findElement(By.xpath("//div/p"));
        String text= textElement.getText();
        System.out.println("text = " + text);

        WebElement firstButton= driver.findElement(By.id("enableAfter"));
        WebDriverWait wait=new WebDriverWait(driver,4);
        wait.until(ExpectedConditions.elementToBeClickable(firstButton));
        firstButton.click();


    }
}
