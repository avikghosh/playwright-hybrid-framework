package org.avikghosh.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PlaywrightFactory {

    private static final Logger log = LoggerFactory.getLogger(PlaywrightFactory.class);
    private final PlaywrightManager playwrightManager;

    public PlaywrightFactory(PlaywrightManager playwrightManager) {
        this.playwrightManager = playwrightManager;
    }

    public synchronized <T extends BasePage> T getOrCreatePage(Class<T> pageClass) {
        try {
            T page = pageClass.getDeclaredConstructor(PlaywrightManager.class).newInstance(playwrightManager);
            log.info("{} page created...", pageClass.getSimpleName());
            return page;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create page: " + pageClass.getName(), e);
        }
    }

    public <T extends BaseClient> T getOrCreateClient(Class<T> clientClass) {
        try {
            T client = clientClass.getDeclaredConstructor(PlaywrightManager.class).newInstance(playwrightManager);
            log.info("{} client created...", clientClass.getSimpleName());
            return client;
        } catch (Exception e) {
            throw new RuntimeException("Failed to create client: " + clientClass.getName(), e);
        }
    }
}
