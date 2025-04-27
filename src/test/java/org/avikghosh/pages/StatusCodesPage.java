package org.avikghosh.pages;

import com.microsoft.playwright.Locator;
import org.avikghosh.core.BasePage;
import org.avikghosh.core.PlaywrightManager;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class StatusCodesPage extends BasePage {

    public StatusCodesPage(PlaywrightManager playwrightManager) {
        super(playwrightManager);
    }
    private final Locator statusCodesHeader = page.locator("//div[@class='example']//h3");

    public void verifyPageIsDisplayed() {
        assertThat(statusCodesHeader).containsText("Status Codes");
    }
}
