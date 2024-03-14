package stepdefinitions;

import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;

public class ApplicationHooks {
	public static Scenario scn;


	
	@BeforeStep
	public void getScenarioInstance(Scenario Scenrio) {
		ApplicationHooks.scn = Scenrio;
	}



	
}
