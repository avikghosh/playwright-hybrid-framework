package org.avikghosh.stepdefinitions;

import io.cucumber.java.en.Then;
import org.avikghosh.clients.ReqResClient;
import org.avikghosh.core.PlaywrightManager;

public class APIStepDefinitions extends BaseStepDefinitions {

    private final ReqResClient reqResClient;

    public APIStepDefinitions(PlaywrightManager playwrightManager) {
        super(playwrightManager);
        this.reqResClient = getClient(ReqResClient.class);
    }


    @Then("I should be able to make api call")
    public void iShouldMakeAPICall() {
        reqResClient.listUsers();
    }
}
