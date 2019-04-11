package com.simpleProject.Maven;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BaseStepDdef {

    public static RemoteWebDriver driver;

    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", "D:\\AutomationProj\\MavenCucumberJUnit\\MavenCucumberJUnit\\src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public RemoteWebDriver getDriver() {
        return driver;
    }
}
