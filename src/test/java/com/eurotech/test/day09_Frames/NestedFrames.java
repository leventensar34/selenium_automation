package com.eurotech.test.day09_Frames;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class NestedFrames {


    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        // Thread.sleep(2000);
        driver.close();
    }

    @Test
    public void nestedFrameTest() {

        driver.get("https://demoqa.com/nestedframes");

        driver.switchTo().frame("frame1");

        WebElement parentBody = driver.findElement(By.tagName("body"));
        System.out.println("parentBody.getText() = " + parentBody.getText());

        driver.switchTo().frame(0);
        WebElement childFrame=driver.findElement(By.tagName("p"));
        System.out.println("childFrame.getText() = " + childFrame.getText());

        driver.switchTo().parentFrame();
        driver.switchTo().parentFrame();
        WebElement messageText=driver.findElement(By.xpath("//div[contains(text(),'Sample')]"));
        System.out.println("messageText.getText() = " + messageText.getText());

    }
}
