package com.test.jawahar.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "classpath:features"
        , glue = {"com.test.jawahar.stepdefinition"}
        , plugin = {"pretty"
        , "json:target/cucumber.json"
        , "junit:target/cucumber-html-reports/cucumber.xml"
}
        , tags = {"@demo"}
        , strict = true
        , monochrome = true
)

public class CucumberTest extends AbstractTestNGCucumberTests {

}
