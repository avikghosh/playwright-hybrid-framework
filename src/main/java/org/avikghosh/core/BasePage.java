package org.avikghosh.core;

import com.microsoft.playwright.Page;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class BasePage {

    private static final Logger log = LoggerFactory.getLogger(BasePage.class);
    protected final Page page;

    public BasePage(PlaywrightManager playwrightManager) {
        log.info("Base Page constructor called");
        this.page = playwrightManager.getPage();
    }
}
