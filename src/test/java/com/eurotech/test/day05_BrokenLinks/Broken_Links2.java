package com.eurotech.test.day05_BrokenLinks;

import com.eurotech.utilities.WebDriverFactory;
import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.apache.hc.core5.http.HttpResponse;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class Broken_Links2 {

    public static void main(String[] args) throws IOException {


        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://demoqa.com/broken");
        driver.manage().window().maximize();

        CloseableHttpClient client= HttpClientBuilder.create().build();
        HttpGet reguest=new HttpGet("http://the-internet.herokuapp.com/status_codes/500");
        HttpResponse response= client.execute(reguest);

        int statusCode= response.getCode();
        System.out.println("statusCode = " + statusCode);
    }


}
