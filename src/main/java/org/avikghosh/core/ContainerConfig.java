package org.avikghosh.core;

import org.picocontainer.DefaultPicoContainer;
import org.picocontainer.MutablePicoContainer;

public class ContainerConfig {

    private static MutablePicoContainer container;

    public static void setupContainer() {
        container = new DefaultPicoContainer();
        container.addComponent(PlaywrightManager.class);
    }

    public static MutablePicoContainer getContainer() {
        return container;
    }
}
