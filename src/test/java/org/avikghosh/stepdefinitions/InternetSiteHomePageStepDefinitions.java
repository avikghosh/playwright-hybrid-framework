package org.avikghosh.stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.avikghosh.core.PlaywrightManager;
import org.avikghosh.pages.HomePage;

public class InternetSiteHomePageStepDefinitions extends BaseStepDefinitions {

    private final HomePage homePage;

    public InternetSiteHomePageStepDefinitions(PlaywrightManager playwrightManager) {
        super(playwrightManager);
        this.homePage = getPage(HomePage.class);
    }

    @When("I visit the Internet Site url")
    public void iVisitTheInternetSiteUrl() {
        homePage.visitSite();
    }

    @Then("I should be able to see the Internet Site")
    public void iShouldBeAbleToSeeTheInternetSite() {
        homePage.verifySiteIsLoaded();
    }

    @When("I click on link {}")
    public void iClickOnLinkABTesting(String linkText) {
        homePage.clickLink(linkText);
    }
}
