package org.avikghosh.clients;

import com.microsoft.playwright.options.RequestOptions;
import org.avikghosh.core.BaseClient;
import org.avikghosh.core.PlaywrightManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;

public class ReqResClient extends BaseClient {

    private static final Logger log = LoggerFactory.getLogger(ReqResClient.class);

    public ReqResClient(PlaywrightManager playwrightManager) {
        super(playwrightManager);
    }

    private String makeAPICall() {
        return apiRequestContext.get("https://reqres.in/api/users",
                RequestOptions
                        .create()
                        .setQueryParam("page", "2")).text();
    }

    public String listUsers() {
        String response =  makeAPICall();
        log.info(response);
        Assert.assertNotNull(response);
        return response;
    }


}
