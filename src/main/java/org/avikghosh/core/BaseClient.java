package org.avikghosh.core;

import com.microsoft.playwright.APIRequestContext;

public abstract class BaseClient {

    protected final APIRequestContext apiRequestContext;

    public BaseClient(PlaywrightManager playwrightManager) {
        this.apiRequestContext = playwrightManager.getAPIRequestContext();
    }
}
