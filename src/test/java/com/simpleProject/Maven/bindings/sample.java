package com.simpleProject.Maven.bindings;

import com.simpleProject.Maven.BaseStepDdef;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class sample extends BaseStepDdef {

    @Given("^Open browser$")
    public void open_browser() {
        getDriver().get("https://www.google.com");
        System.out.println("===============Scenario 1 Step 1 Done============");
    }

    @When("^test$")
    public void test() {
        getDriver().findElement(By.cssSelector("input[name='q']")).sendKeys("Hi" + Keys.ENTER);
        System.out.println("===============Scenario 1 Step 2 Done============");
    }

    @Then("^result$")
    public void result() {
        Assert.assertTrue(getDriver().findElement(By.cssSelector("a[href='https://www.urbandictionary.com/define.php?term=Hi']")).isDisplayed());
        System.out.println("===============Scenario 1 Step 3 Done============");
    }
}
