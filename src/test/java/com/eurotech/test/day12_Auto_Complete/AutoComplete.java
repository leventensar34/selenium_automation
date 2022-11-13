package com.eurotech.test.day12_Auto_Complete;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class AutoComplete {



    WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown(){

        driver.close();
    }

    @Test
    public void autoComplete() {

        driver.get("https://demoqa.com/auto-complete");


        WebElement inputMultiple=driver.findElement(By.cssSelector("#autoCompleteMultipleInput"));
        inputMultiple.sendKeys("G");


        List<WebElement> suggestion2=driver.findElements(By.cssSelector("div.autoComplete__option"));
        for (WebElement element : suggestion2) {
            String text1= element.getText();
            if (text1.toLowerCase().contains("G")){
                element.click();
                break;
            }
        }

        WebElement inputSingle=driver.findElement(By.id("autoCompleteSingleInput"));
        inputSingle.sendKeys("R");

        List<WebElement> suggestion=driver.findElements(By.cssSelector("div.auto-complete__option"));

        for (WebElement suggest : suggestion) {
            String text2=suggest.getText();
            if (text2.toLowerCase().contains("r")){
                System.out.println(text2+" has r letter");
            }
        }



    }
}
