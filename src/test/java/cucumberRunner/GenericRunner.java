package cucumberRunner;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
// @CucumberOptions(features="features", glue="stepsImplementations", tags="@ranking")
@CucumberOptions(features="features", glue="stepsImplementations", tags="@ranking")
public class GenericRunner {
}
