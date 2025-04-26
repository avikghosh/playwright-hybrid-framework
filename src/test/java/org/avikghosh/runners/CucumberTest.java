package org.avikghosh.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.avikghosh.core.ContainerConfig;
import org.avikghosh.core.PlaywrightManager;
import org.testng.annotations.*;

@CucumberOptions(features = "src/test/resources/features",
        glue = "org.avikghosh.stepdefinitions",
        plugin = {"pretty",
                "html:build/cucumber/cucumber-report.html",
                "json:build/cucumber/cucumber-report.json"
        }
)
public class CucumberTest extends AbstractTestNGCucumberTests {

    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }

    @BeforeSuite(alwaysRun = true)
    public void baseSetup() {
        ContainerConfig.setupContainer();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        PlaywrightManager.closeAll();
    }

}
