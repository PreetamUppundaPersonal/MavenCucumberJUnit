package com.simpleProject.Maven.Hooks;

import com.simpleProject.Maven.BaseStepDdef;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class beforeAfter extends BaseStepDdef {
    @Before
    public void beforeScenario(){
        System.out.println("===============This will run before the Scenario============");
        setDriver();
    }

    @After
    public void afterScenario(){
        System.out.println("=================This will run after the Scenario================");
        getDriver().quit();
        System.out.println("-----------------------------------------------------------------------------------------------");
    }
}
