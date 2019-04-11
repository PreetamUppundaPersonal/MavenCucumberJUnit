package com.simpleProject.Maven.bindings;

import com.simpleProject.Maven.BaseStepDdef;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class sample2 extends BaseStepDdef {

    @When("^check driver$")
    public void checkDriver() throws Throwable {
        getDriver().findElement(By.cssSelector("input[name='q']")).sendKeys("Hi" + Keys.ENTER);
        System.out.println("===============Scenario 2 Step 2 Done============");
    }
}
