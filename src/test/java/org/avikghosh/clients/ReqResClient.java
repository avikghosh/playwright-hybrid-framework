package org.avikghosh.clients;

import com.microsoft.playwright.APIResponse;
import com.microsoft.playwright.options.RequestOptions;
import org.avikghosh.core.BaseClient;
import org.avikghosh.core.PlaywrightManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ReqResClient extends BaseClient {

    private static final Logger log = LoggerFactory.getLogger(ReqResClient.class);

    public ReqResClient(PlaywrightManager playwrightManager) {
        super(playwrightManager);
    }

    private APIResponse makeAPICall() {
        return apiRequestContext.get("https://reqres.in/api/users",
                RequestOptions
                        .create()
                        .setQueryParam("page", "2"));
    }

    public String listUsers() {
        APIResponse response =  makeAPICall();
        log.info(response.text());
        assertThat(response).isOK();
    return response.text();
    }


}
