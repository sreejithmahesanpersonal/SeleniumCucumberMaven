package com.sreejithmahesan.StepDefinitions;
import com.sreejithmahesan.Pages.HomePage;
import com.sreejithmahesan.Utilities.AutomationCommon;
import com.sreejithmahesan.Utilities.ExtentReportingUtility;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class FirstFeatureSteps extends AutomationCommon {

    WebDriver driver;
    HomePage home_page = null;
    ExtentReportingUtility extentReportingUtility = null;

    @Before
    public void Setup() throws InterruptedException {
        driver = WebdriverSetup();
        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();
        Thread.sleep(10000);
        home_page = new HomePage(driver);
        extentReportingUtility = ExtentReportingUtility.getExtent_report_Instance();
    }


    @Given("I have entered {string}")
    public void i_have_entered(String string) {

        home_page.UserName_Enter(string);
        extentReportingUtility.CreateExtentTest("FacebookTest");
        extentReportingUtility.LogExtentReport("Entered User Name",1);
    }
    @Given("I have entered the {string}")
    public void i_have_entered_the(String string) {
        home_page.Password_Enter(string);
        extentReportingUtility.LogExtentReport("Entered Password",1);
    }
    @When("I click on the login button")
    public void i_click_on_the_login_button() {
       home_page.Click_Login();
        extentReportingUtility.LogExtentReport("Login clicked",1);
    }
    @Then("the user should be logged  in after authentication with {string}")
    public void the_user_should_be_logged_in_after_authentication_with(String string) {
        extentReportingUtility.LogExtentReport("Validation Failed",0);

    }


    @After
    public void TearDown()
    {
        extentReportingUtility.FlushExtentReport();
        WebdriverTearDown();
    }

}
