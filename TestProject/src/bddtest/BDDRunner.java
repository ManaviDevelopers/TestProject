package bddtest;

import cucumber.api.CucumberOptions;

@CucumberOptions(features = "feature", glue = { "stepDefinition" })

public class BDDRunner {

}
