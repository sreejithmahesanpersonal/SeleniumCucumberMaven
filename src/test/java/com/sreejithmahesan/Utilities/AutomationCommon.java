package com.sreejithmahesan.Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class AutomationCommon implements SeleniumCommon{

    public WebDriver driver = null;
    Properties prop = null;
    @Override
    public WebDriver WebdriverSetup() {
        try {
             prop = readPropertiesFile("src//test//java//Resources//TestEnvironment.properties");
        }
        catch (Exception e)
        {
            ;
        }

        switch(prop.getProperty("browser")) {
            case "chrome":
            {
                System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
                if(driver== null)
                    return driver = new ChromeDriver();
                else
                    return driver;
            }
            case "ie": {
                System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
                if(driver== null)
                    return driver = new InternetExplorerDriver();
                else
                    return driver;
            }
            default: {
                System.setProperty("webdriver.gecko.driver", "FirefoxDriver.exe");
                if(driver== null)
                    return driver = new FirefoxDriver();
                else
                    return driver;
            }
        }
    }

    @Override
    public void WebdriverTearDown() {
        driver.quit();
        driver = null;
    }

    public  Properties readPropertiesFile(String fileName) throws IOException {
        FileInputStream fis = null;
        Properties prop = null;
        try {
            fis = new FileInputStream(fileName);
            prop = new Properties();
            prop.load(fis);
        } catch(FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        } finally {
            fis.close();
        }
        return prop;
    }
}
