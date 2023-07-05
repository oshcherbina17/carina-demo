package com.qaprosoft.carina.demo.rozetka;

import com.qaprosoft.carina.core.foundation.cucumber.CucumberBaseTest;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/features/rozetka/rozetka.feature",
        glue = "com.qaprosoft.carina.demo.rozetka.cucumber.stepDefenitions",
        plugin={"pretty",
                "html:target/cucumber-core-test-report",
                "pretty:target/cucumber-core-test-report.txt",
                "json:target/cucumber-core-test-report.json",
                "junit:target/cucumber-core-test-report.xml"}
)
public class CucumberWebSampleTest extends CucumberBaseTest {

}
