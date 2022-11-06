package com.eurotech.test.day06_DateDownload_Upload;

import com.eurotech.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

public class Download {

    public static void main(String[] args) throws InterruptedException {



        WebDriver driver= WebDriverFactory.getDriver("chrome");

        driver.get("https://demoqa.com/upload-download");
        driver.manage().window().maximize();

        WebElement downloadButton= driver.findElement(By.id("downloadButton"));
        downloadButton.click();

        String path="/Users/User/Downloads";

        String fileName="sampleFile.jpeg";

        Thread.sleep(3000);

        boolean isDownload=isFileDownload(path,fileName);
        System.out.println("isDownload = " + isDownload);

        driver.close();
    }

    public static boolean isFileDownload(String downloadPath,String fileName){
        File file=new File(downloadPath);
        File[] files=file.listFiles();

        for (int i = 0; i < files.length; i++) {
           if (files[i].getName().equals(fileName)){
               files[i].delete();
               return true;
           }

        }
        return false;
    }
}
