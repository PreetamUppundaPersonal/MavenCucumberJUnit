package runners;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:reports/cucumber-html-report",
                "json:reports/cucumber.json",
                "pretty"},
        tags = {"@sample","~@ignore"},
        features = {"src/test/resources"},
        glue = {"com/simpleProject/Maven/Hooks", "com/simpleProject/Maven/bindings"}
)

public class MyRunner {
}
