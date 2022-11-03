package com.eurotech.test.day02_ClickButton;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButton_Impressive {


    public static void main(String[] args) {


        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://demoqa.com/radio-button");

        WebElement impressiveRadioButton= driver.findElement(By.cssSelector("label[for='impressiveRadio']"));
        impressiveRadioButton.click();

        boolean isSelected= impressiveRadioButton.isSelected();
        if (isSelected){
            System.out.println(" impressive is selected");
        }

        WebElement impressiveButtonTex= driver.findElement(By.cssSelector("p.mt-3"));
        System.out.println(impressiveButtonTex.getText());


    }
}
