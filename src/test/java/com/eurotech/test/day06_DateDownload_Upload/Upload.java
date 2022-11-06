package com.eurotech.test.day06_DateDownload_Upload;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Upload {

    public static void main(String[] args) {



        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://demoqa.com/upload-download");
        driver.manage().window().maximize();

        WebElement uploadButton= driver.findElement(By.id("uploadFile"));
        uploadButton.sendKeys("C:\\Users\\User\\Pictures\\Screenshots");

        driver.close();
    }
}
