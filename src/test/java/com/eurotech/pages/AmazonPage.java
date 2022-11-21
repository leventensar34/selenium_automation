package com.eurotech.pages;

import com.eurotech.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AmazonPage {


    public AmazonPage(){

        PageFactory.initElements(Driver.get(),this);
    }


    @FindBy (id ="twotabsearchtextbox")
    public WebElement searchBox;

    @FindBy (id ="searchDropdownBox")
   public WebElement kategoriList;

    @FindBy(className = "a-price-whole")
    public List<WebElement> tumFiyatlar;

    @FindBy(css = "[data-component-type='s-search-result']")
    public List<WebElement> tümUrunler;



}
