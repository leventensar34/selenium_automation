package com.eurotech.test.day05_BrokenLinks;

import com.eurotech.utilities.WebDriverFactory;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpResponse;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Broken_Links1 {

    public static void main(String[] args) throws IOException {


        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://demoqa.com/broken");
        driver.manage().window().maximize();


        CloseableHttpClient client= HttpClientBuilder.create().build();
        HttpGet request=new HttpGet("https://demoqa.com/");
        HttpResponse response=client.execute(request);

        int statusCode=response.getCode();
        System.out.println("statusCode = " + statusCode);

    }
}
