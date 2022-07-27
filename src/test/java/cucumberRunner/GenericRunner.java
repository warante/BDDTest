package cucumberRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
// @CucumberOptions(features="features", glue="stepsImplementations", tags="@ranking")
@CucumberOptions(features="src/test/features", glue= "stepDefinitions", plugin = {"pretty", "html:target/cucumber"})
public class GenericRunner {
}
