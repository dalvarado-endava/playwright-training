package helpers;

import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;

public class BrowserProvider {

    public BrowserType getBrowser(Playwright playwright, String browserName) {
        BrowserType browserType;
        switch (browserName) {
            case "Chrome":
                browserType = playwright.chromium();
                break;
            case "Firefox":
                browserType = playwright.firefox();
                break;
            case "WebKit":
                browserType = playwright.webkit();
                break;
            default:
                throw new IllegalArgumentException("Please provide valid browser name");
        }
        return browserType;
    }
}
