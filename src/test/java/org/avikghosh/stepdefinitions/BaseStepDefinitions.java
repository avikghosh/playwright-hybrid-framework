package org.avikghosh.stepdefinitions;

import org.avikghosh.core.BaseClient;
import org.avikghosh.core.BasePage;
import org.avikghosh.core.PlaywrightFactory;
import org.avikghosh.core.PlaywrightManager;

public abstract class BaseStepDefinitions {

    private final PlaywrightFactory playwrightFactory;

    public BaseStepDefinitions(PlaywrightManager playwrightManager) {
        this.playwrightFactory = new PlaywrightFactory(playwrightManager);
    }

    protected <T extends BasePage> T getPage(Class<T> pageClass) {
        return playwrightFactory.getOrCreatePage(pageClass);
    }
    protected <T extends BaseClient> T getClient(Class<T> clientClass) {
        return playwrightFactory.getOrCreateClient(clientClass);
    }
}
