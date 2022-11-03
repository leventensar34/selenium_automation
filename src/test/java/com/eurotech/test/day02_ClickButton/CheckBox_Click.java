package com.eurotech.test.day02_ClickButton;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckBox_Click {

    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://demoqa.com/checkbox");
        driver.manage().window().maximize();

        WebElement homeCheckBox=driver.findElement(By.cssSelector("label[for='tree-node-home'] span.rct-checkbox svg"));
        homeCheckBox.click();

        homeCheckBox= driver.findElement(By.cssSelector("label[for='tree-node-home'] span.rct-checkbox svg"));

        String homeCheckBoxClassName= homeCheckBox.getAttribute("class");

        System.out.println(homeCheckBoxClassName);


    }
}
