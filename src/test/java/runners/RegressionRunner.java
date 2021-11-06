package runners;

import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features"},
        glue = {"step_defs"},
        dryRun = false,
        tags = {"@Regression"}
)

public class RegressionRunner {


}
