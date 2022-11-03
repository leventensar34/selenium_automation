package com.eurotech.test.day01_FindElement;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Find_Element {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://demoqa.com/text-box");

        WebElement findElement= driver.findElement(By.id("userName"));
        findElement.click();
        findElement.sendKeys("leventensar1905@gmail.com");

        WebElement email= driver.findElement(By.cssSelector(".mr-sm-2[id='userEmail']"));
        email.click();
        email.sendKeys("Gs1905");

        WebElement currentAdress= driver.findElement(By.cssSelector(".form-control[id='currentAddress']"));
        currentAdress.click();
        currentAdress.sendKeys("Solingen  /  Almanya");

        WebElement permanentAdress=driver.findElement(By.id("permanentAddress"));
        try {
            permanentAdress.click();
        }catch (ElementClickInterceptedException e){
            e.printStackTrace();
        }

        permanentAdress.sendKeys("Istanbul  /  Türkiye");

        WebElement submitButton=driver.findElement(By.cssSelector("button[id='submit']"));
        try {
            submitButton.click();
        }catch (ElementClickInterceptedException e){
            e.printStackTrace();
        }

        boolean isEnable= submitButton.isEnabled();
        if (isEnable){
            System.out.println("clicked");
        }else {
            System.out.println("not clicked");
        }

    }
}
