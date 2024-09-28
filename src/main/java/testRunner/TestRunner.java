package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;



@RunWith(Cucumber.class)
@CucumberOptions(
		features = "C:\\Users\\dhany\\OneDrive\\Desktop\\Java-Practice\\JavaPractice\\CucumberGoogle\\src\\main\\java\\features", 
		glue= {"stepdefinitions"},
		plugin = {"pretty","html:test-output/HTML-Report.html", "json:test-output/Json-Report.json", "junit:test-output/XML-Report.xml"}, //to generate different types of reporting
		dryRun = false,
		monochrome = true
//		tags = "@SmokeTest or @RegressionTest"
//      tags = "@SmokeTest and @RegressionTest"		
		tags = "not @SmokeTest or @RegressionTest"	
				)


public class TestRunner {

}
