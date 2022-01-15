package com.sreejithmahesan.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class HomePage {

    WebDriver driver = null;
    HomePage home_page_Instance = null;

    By txt_Username = By.id("email");
    By txt_Password = By.id("pass");
    By btn_Login  = By.name("login");


    public HomePage(WebDriver driver)
    {
        this.driver = driver;
    }

public void UserName_Enter(String str)
{
    driver.findElement(txt_Username).sendKeys(str);
}

public void Password_Enter(String str)
{
    driver.findElement(txt_Password).sendKeys(str);
}

public void Click_Login()
{
    try {
        driver.findElement(btn_Login).click();
    }
    catch (Exception e)
    {
        driver.findElement(btn_Login).sendKeys(Keys.ENTER);
    }

}

}
