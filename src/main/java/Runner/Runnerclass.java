package Runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)

@CucumberOptions(features="src/main/java/Faeture", glue={"src/main/java/StepDefinition"},
tags= {"@tag"}, dryRun=false, monochrome=true )


public class Runnerclass {
	
	

}

