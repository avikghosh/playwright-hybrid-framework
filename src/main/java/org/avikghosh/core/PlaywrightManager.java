package org.avikghosh.core;

import com.microsoft.playwright.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class PlaywrightManager {

    private static final Logger log = LoggerFactory.getLogger(PlaywrightManager.class);

    private static final ThreadLocal<Playwright> threadLocalPlaywright = ThreadLocal.withInitial(Playwright::create);
    private static final ThreadLocal<Browser> threadLocalBrowser = ThreadLocal.withInitial(PlaywrightManager::createBrowser);
    private static final ThreadLocal<BrowserContext> threadLocalContext = new ThreadLocal<>();
    private static final ThreadLocal<Page> threadLocalPage = new ThreadLocal<>();
    private static final ThreadLocal<APIRequestContext> apiRequestContextThreadLocal = new ThreadLocal<>();

    private static Browser createBrowser() {
        String browserName = System.getProperty("browser", "chromium");
        boolean headless = Boolean.parseBoolean(System.getProperty("headless", "false"));

        BrowserType.LaunchOptions options = new BrowserType.LaunchOptions()
                .setHeadless(headless)
                .setArgs(List.of("--start-maximized"));

        return switch (browserName.toLowerCase()) {
            case "chromium" -> threadLocalPlaywright.get().chromium().launch(options);
            case "firefox" -> threadLocalPlaywright.get().firefox().launch(options);
            case "webkit" -> threadLocalPlaywright.get().webkit().launch(options);
            default -> throw new RuntimeException("Unsupported browser: " + browserName);
        };
    }

    public static void createContextAndPage() {
        if (threadLocalContext.get() == null) {
            BrowserContext context = threadLocalBrowser.get().newContext();
            threadLocalContext.set(context);
            log.info("Created new BrowserContext");
        }
        if (threadLocalPage.get() == null) {
            Page page = threadLocalContext.get().newPage();
            threadLocalPage.set(page);
            log.info("Created new Page");
        }
    }

    public Page getPage() {
        if (threadLocalPage.get() == null) {
            createContextAndPage();
        }
        return threadLocalPage.get();
    }

    public APIRequestContext createAPIRequestContext() {
        log.info("API Request Context setup");
        if (threadLocalPage.get() != null) {
            apiRequestContextThreadLocal.set(threadLocalPage.get().request());
        } else {
            apiRequestContextThreadLocal.set(threadLocalPlaywright.get().request().newContext());
        }
        return apiRequestContextThreadLocal.get();
    }

    public APIRequestContext getAPIRequestContext() {
        if (apiRequestContextThreadLocal.get() == null) {
            return createAPIRequestContext();
        }
        return apiRequestContextThreadLocal.get();
    }

    public static void closeApiRequestContext() {
        if (apiRequestContextThreadLocal.get() != null) {
            try {
                apiRequestContextThreadLocal.get().dispose();
                log.info("Disposed APIRequestContext");
            } catch (Exception e) {
                log.info("Failed to dispose APIRequestContext", e);
            } finally {
                apiRequestContextThreadLocal.remove();
            }
        }
    }

    public static void closeContextAndPage() {
        if (threadLocalContext.get() != null) {
            try {
                threadLocalContext.get().close();
            } catch (Exception e) {
                log.info("Browser Context may have been already closed");
            } finally {
                threadLocalContext.remove();
                threadLocalPage.remove();
            }
        }
    }

    public static void closeBrowser() {
        if (threadLocalBrowser.get() != null) {
            try {
                threadLocalBrowser.get().close();
                log.info("Closed Browser");
            } catch (Exception e) {
                log.error("Failed to close Browser", e);
            } finally {
                threadLocalBrowser.remove();
            }
        }
    }

    public static void closePlaywright() {
        if (threadLocalPlaywright.get() != null) {
            try {
                threadLocalPlaywright.get().close();
                log.info("Closed Playwright");
            } catch (Exception e) {
                log.error("Failed to close Playwright", e);
            } finally {
                threadLocalPlaywright.remove();
            }
        }
    }

    public static void closeAll() {
        closeApiRequestContext();
        closeContextAndPage();
        closeBrowser();
        closePlaywright();
    }
}
