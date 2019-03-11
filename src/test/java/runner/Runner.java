package runner;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
	@CucumberOptions(
			features = "src/test/resources/features", //the path of the feature files
			glue={"stepdefs", "hooks"}, //the path of the step definition files and hooks
			format= {"pretty","html:test-output"},
					//"json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"}, //to generate different types of reporting
			monochrome = true, //display the console output in a proper readable format
			strict = true, //it will check if any step is not defined in step definition file
			dryRun = false //to check the mapping is proper between feature file and step def file
			//tags = {"~@SmokeTest" , "~@RegressionTest", "~@End2End"}
			)
public class Runner {
}
