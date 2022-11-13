package com.eurotech.test.day11_Accordions;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Accordion {


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
    public void test1(){
        driver.get("https://demoqa.com/accordian");

        driver.findElement(By.cssSelector("#section1Heading")).click();

        WebElement accordTex1= driver.findElement(By.xpath("//div[@class='card-body']"));
        System.out.println("accordTex1.getText() = " + accordTex1.getText());

        driver.findElement(By.cssSelector("#section2Heading")).click();

        WebElement accordText2= driver.findElement(By.xpath("//div[@id='section2Content']/p"));
        System.out.println("accordText2.getText() = " + accordText2.getText());


        driver.findElement(By.cssSelector("#section3Heading")).click();

        WebElement accordTest3=driver.findElement(By.xpath("//div/p[contains(text(),'It is a long')]"));
        System.out.println("accordTest3.getText() = " + accordTest3.getText());


    }
}
