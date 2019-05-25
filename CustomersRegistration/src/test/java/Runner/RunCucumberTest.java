package Runner;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.testng.annotations.DataProvider;


@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/java/Feature"
	,glue={"src/main/java/StepDefinitions"}
		)
public class RunCucumberTest {

}

 

 
