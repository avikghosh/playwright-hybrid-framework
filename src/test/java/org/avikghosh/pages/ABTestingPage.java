package org.avikghosh.pages;

import com.microsoft.playwright.Locator;
import org.avikghosh.core.BasePage;
import org.avikghosh.core.PlaywrightManager;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class ABTestingPage extends BasePage {

    private final Locator abTestingHeader = page.locator("//div[@class='example']//h3");

    public ABTestingPage(PlaywrightManager playwrightManager) {
        super(playwrightManager);
    }

    public void verifyPageIsDisplayed() {
        assertThat(abTestingHeader).containsText("A/B Test");
    }
}
