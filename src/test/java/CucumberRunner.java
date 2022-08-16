import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
// @CucumberOptions(features="features", glue="stepsImplementations", tags="@ranking")
@CucumberOptions(features="src/test/features", plugin = {"pretty", "html:target/cucumber"}, tags="@high")
public class CucumberRunner {
}
