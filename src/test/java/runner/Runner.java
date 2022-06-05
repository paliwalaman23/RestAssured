package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "./features", glue = { "stepdefinitions" },dryRun = false)

public class Runner extends AbstractTestNGCucumberTests {

//public class CucumberRunner extends AbstractTestNGCucumberTests{		

}
