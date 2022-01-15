package com.sreejithmahesan.TestRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/java/com/sreejithmahesan/Features/"},
        tags = "@Smoke1 or @Smoke3 and not @Smoke2",
        plugin = {"pretty", "html:target/TestReports/cucumber-html-report.html", "json:target/TestReports/cucumber-report.json","junit:target/TestReports/cucumber-junit.xml"},
        glue = {"com.sreejithmahesan.StepDefinitions"}
)
public class TestRunner {
}
