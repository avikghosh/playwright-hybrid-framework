package org.avikghosh.pages;

import org.avikghosh.core.BasePage;
import org.avikghosh.core.PlaywrightManager;
import org.testng.Assert;

public class HomePage extends BasePage {

    public static final String HOME_PAGE_HEADING = "//h1[@class='heading']";
    public static final String THE_INTERNET_SITE_URL = "https://the-internet.herokuapp.com/";

    public HomePage(PlaywrightManager playwrightManager) {
        super(playwrightManager);
    }

    public void visitSite() {
        page.navigate(THE_INTERNET_SITE_URL);
    }

    public void verifySiteIsLoaded() {
        Assert.assertEquals(page.locator(HOME_PAGE_HEADING).textContent(), "Welcome to the-internet",
                "Home Page is not displayed");
    }

    public void clickLink(String linkText) {
        page.getByText(linkText).click();
    }
}
