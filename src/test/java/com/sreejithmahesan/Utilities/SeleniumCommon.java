package com.sreejithmahesan.Utilities;

import org.openqa.selenium.WebDriver;

public interface SeleniumCommon {
    WebDriver WebdriverSetup();
    void WebdriverTearDown();
}
