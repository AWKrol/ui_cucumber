
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        tags = "@all",features = "src/test/resources/features/",
        glue = {"steps"},
        plugin = {"pretty"}
)

public class CucumberRunnerTests extends AbstractTestNGCucumberTests {
}

