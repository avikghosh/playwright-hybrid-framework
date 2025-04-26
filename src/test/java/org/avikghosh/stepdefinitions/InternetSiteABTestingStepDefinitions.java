package org.avikghosh.stepdefinitions;

import io.cucumber.java.en.Then;
import org.avikghosh.core.PlaywrightManager;
import org.avikghosh.pages.ABTestingPage;

public class InternetSiteABTestingStepDefinitions extends BaseStepDefinitions {

    private final ABTestingPage abTestingPage;

    public InternetSiteABTestingStepDefinitions(PlaywrightManager playwrightManager) {
        super(playwrightManager);
        this.abTestingPage = getPage(ABTestingPage.class);
    }


    @Then("I should see A\\/B Testing Page")
    public void iShouldSeeABTestingPage() {
        abTestingPage.verifyPageIsDisplayed();
    }
}
