package utils;

import configurations.driverconfigs.ThreadSafeSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class JavaScriptExecuter {

    private JavaScriptExecuter() {
    }

    public static void clickButtonUsingJS(WebElement button) {
        JavascriptExecutor jse = (JavascriptExecutor) ThreadSafeSingleton.getDriverInstance();
        jse.executeScript("arguments[0].click();", button);
    }

    public static void scrollToElement(WebElement element) {
        JavascriptExecutor jse = (JavascriptExecutor) ThreadSafeSingleton.getDriverInstance();
        jse.executeScript("arguments[0].scrollIntoView(true);", element);
    }

}