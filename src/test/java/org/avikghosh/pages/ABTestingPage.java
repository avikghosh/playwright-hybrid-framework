package org.avikghosh.pages;

import org.avikghosh.core.BasePage;
import org.avikghosh.core.PlaywrightManager;
import org.testng.Assert;

public class ABTestingPage extends BasePage {

    private final String abTestingHeader = "//div[@class='example']//h3";

    public ABTestingPage(PlaywrightManager playwrightManager) {
        super(playwrightManager);
    }

    public void verifyPageIsDisplayed() {
        Assert.assertEquals(
                page.locator(abTestingHeader).textContent().contains("A/B Test"),
                true,
                "A/B Testing Page did not load correctly");
    }
}
