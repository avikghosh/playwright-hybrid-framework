package org.avikghosh.core;

import com.microsoft.playwright.Page;

public abstract class BasePage {

    protected final Page page;

    public BasePage(PlaywrightManager playwrightManager) {
        this.page = playwrightManager.getPage();
    }
}
