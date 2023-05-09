package utils;

import static configurations.constants.DriverConstants.Urls.IMPLICITLY_WAIT_TIMEOUT;

import configurations.driverconfigs.ThreadSafeSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverWaiter {

    protected WebDriverWait wait;

    public WebDriverWaiter() {
        wait = new WebDriverWait(ThreadSafeSingleton.getDriverInstance(), IMPLICITLY_WAIT_TIMEOUT);
    }

    public static void waitForPageReadyState(int timeToWait) {
        new WebDriverWait(ThreadSafeSingleton.getDriverInstance(), timeToWait).until(
                webDriver -> ((JavascriptExecutor) webDriver)
                        .executeScript("return document.readyState")
                        .equals("complete"));
    }

    public static void waitForVisibilityOfElement(int timeToWait, WebElement element) {
        WebDriverWait wait = new WebDriverWait(ThreadSafeSingleton.getDriverInstance(), timeToWait);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}
