package org.avikghosh.stepdefinitions;

import io.cucumber.java.en.Then;
import org.avikghosh.core.PlaywrightManager;
import org.avikghosh.pages.StatusCodesPage;

public class StatusCodesStepDefinitions extends BaseStepDefinitions {

    private final StatusCodesPage statusCodesPage;
    public StatusCodesStepDefinitions(PlaywrightManager playwrightManager) {
        super(playwrightManager);
        this.statusCodesPage = getPage(StatusCodesPage.class);
    }

    @Then("^I should see Status Codes Page$")
    public void iShouldSeeStatusCodesPage() {
        statusCodesPage.verifyPageIsDisplayed();
    }

}
