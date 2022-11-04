package com.eurotech.test.day05_BrokenLinks;

import com.eurotech.utilities.WebDriverFactory;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpResponse;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;

public class Broken_Image {

    public static void main(String[] args) throws IOException {


        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/broken");
        driver.manage().window().maximize();

        WebElement brokenImage= driver.findElement(By.xpath("//div/img[2]"));
        String brokenImageUrl= brokenImage.getAttribute("src");
        System.out.println("brokenImageUrl = " + brokenImageUrl);

        CloseableHttpClient client= HttpClientBuilder.create().build();
        HttpGet request=new HttpGet(brokenImageUrl);
        HttpResponse response= client.execute(request);

        int statusCode=response.getCode();
        System.out.println("statusCode = " + statusCode);


    }
}
