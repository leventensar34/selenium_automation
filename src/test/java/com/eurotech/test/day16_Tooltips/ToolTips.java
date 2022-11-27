package com.eurotech.test.day16_Tooltips;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ToolTips {



    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @AfterMethod
    public void tearDown() {

        driver.close();
    }

    @Test
    public void toolTips() {

        driver.get("https://demoqa.com/tool-tips");

        WebElement toolTipButton= driver.findElement(By.cssSelector("#toolTipButton"));

        Actions actions=new Actions(driver);
        actions.moveToElement(toolTipButton).perform();

        WebDriverWait wait=new WebDriverWait(driver,15);

        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("tooltip-inner")));
        }catch (Exception e){

        }

        WebElement toolTip=driver.findElement(By.className("tooltip-inner"));
        System.out.println("toolTip.getText() = " + toolTip.getText());


    }
}
