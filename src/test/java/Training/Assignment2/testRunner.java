package Training.Assignment2;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features= {"src/test/java/feature/eLearning.feature"},
		glue= {"stepDefinition"})

public class testRunner {

}
