package com.eurotech.test.day07_Browser_Windows;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Windows_Tab1 {

    public static void main(String[] args) {



        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://demoqa.com/browser-windows");
        driver.manage().window().maximize();

        WebElement tabButton= driver.findElement(By.id("tabButton"));
        tabButton.click();

        List<String> tabs=new ArrayList<>(driver.getWindowHandles());

        System.out.println("tabs.size() = " + tabs.size());

        driver.switchTo().window(tabs.get(1));
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        WebElement sampleText= driver.findElement(By.id("sampleHeading"));
        System.out.println("sampleText.getText() = " + sampleText.getText());

    }
}
