package bindings;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sample {
    WebDriver driver;

    @Given("^Open browser$")
    public void open_browser() {
        System.setProperty("webdriver.chrome.driver", "D:\\AutomationProj\\MavenCucumberJUnit\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com");
    }

    @When("^test$")
    public void test() {
        driver.findElement(By.cssSelector("input[name='q']")).sendKeys("Hi" + Keys.ENTER);
    }

    @Then("^result$")
    public void result() {
        Assert.assertTrue(driver.findElement(By.cssSelector("a[href='https://www.urbandictionary.com/define.php?term=Hi']")).isDisplayed());
        driver.quit();
    }
}
