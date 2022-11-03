package com.eurotech.test.day02_ClickButton;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButton_Yes {

    public static void main(String[] args) {

        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://demoqa.com/radio-button");

        WebElement yesRadioButton= driver.findElement(By.cssSelector("label[for='yesRadio']"));

        boolean isEnable= yesRadioButton.isEnabled();
        if (isEnable){
            yesRadioButton.click();
            System.out.println("clicked yesRadio button");
        }else {
            System.out.println("not clicked yesRadio button");
        }

        WebElement outputTex= driver.findElement(By.cssSelector("p.mt-3"));
        System.out.println(outputTex.getText());

    }
}
