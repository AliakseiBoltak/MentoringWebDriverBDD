package runner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"stepdefs", "hooks"},
        format = {"pretty", "html:target/cucumber-report"},
        //"json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"},
        strict = true,
        dryRun = false
        //tags = {"@test"}
)
public class FeatureRunner {
}
