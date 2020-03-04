package framework.wait;

import framework.browsers.BrowserActions;

import framework.utils.PropertiesManager;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;
import java.util.List;

public class Waiter {

    public static void waitElementClickable(WebElement webElement) {
        WebDriverWait wait = new WebDriverWait(BrowserActions.getBrowser(), Integer.parseInt(PropertiesManager.getProperty("timeoutClickable")));
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
    }

    public static void waitElementsVisible(List<WebElement> elements) {
        WebDriverWait listWait = new WebDriverWait(BrowserActions.getBrowser(), Integer.parseInt(PropertiesManager.getProperty("timeoutVisible")));
        listWait.until(ExpectedConditions.visibilityOfAllElements(elements));
    }

    public static void waitElementVisible(By by) {
        WebDriverWait wait = new WebDriverWait(BrowserActions.getBrowser(), Integer.parseInt(PropertiesManager.getProperty("timeoutVisible")));
        wait.until(ExpectedConditions.visibilityOf(BrowserActions.getBrowser().findElement(by)));
    }

    public static void waitElementInvisible(By by) {
        FluentWait<WebDriver> wait = new FluentWait(BrowserActions.getBrowser())
                .withTimeout(Duration.ofSeconds(Integer.parseInt(PropertiesManager.getProperty("fluentTimeout"))))
                .pollingEvery(Duration.ofSeconds(Integer.parseInt(PropertiesManager.getProperty("pollingEvery"))));
        wait.until(webDriver -> ExpectedConditions.invisibilityOfElementLocated(by));
    }

    public static void waitFileDownload(String filename, String path) {
        WebDriverWait wait = new WebDriverWait(BrowserActions.getBrowser(), Integer.parseInt(PropertiesManager.getProperty("timeout")));
        wait.ignoring(StaleElementReferenceException.class);
        wait.until((ExpectedCondition<Boolean>) webDriver -> {
            File file = new File(path + filename);
            return (file.exists() && file.length() > 0);
        });
    }
}
