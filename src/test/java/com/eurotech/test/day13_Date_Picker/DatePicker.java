package com.eurotech.test.day13_Date_Picker;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DatePicker {


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
    public void datePicker() {

        driver.get("https://demoqa.com/date-picker");

        driver.findElement(By.cssSelector("#datePickerMonthYearInput")).click();

        WebElement monthElement = driver.findElement(By.cssSelector(".react-datepicker__month-select"));

        Select select = new Select(monthElement);
        select.selectByIndex(3);

        WebElement yearElement= driver.findElement(By.cssSelector(".react-datepicker__year-select"));
        select=new Select(yearElement);
        select.selectByVisibleText("2008");

        List<WebElement> daysElement=driver.findElements(By.cssSelector("div.react-datepicker__day"));

        for (WebElement dayElement : daysElement) {
            String text= dayElement.getText();
            if (text.equals("15")){
                dayElement.click();
                break;
            }
        }

    }
}
