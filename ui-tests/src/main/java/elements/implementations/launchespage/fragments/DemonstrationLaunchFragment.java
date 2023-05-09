package elements.implementations.launchespage.fragments;

import static utils.JavaScriptExecuter.scrollToElement;
import static utils.WebDriverWaiter.waitForVisibilityOfElement;

import configurations.driverconfigs.ThreadSafeSingleton;
import elements.abstractions.fragment.AbstractFragment;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DemonstrationLaunchFragment extends AbstractFragment {

    @FindBy(xpath = "//div[@data-id='3']")
    private WebElement rootElement;

    public DemonstrationLaunchFragment() {
    }

    public String getTextOfElementsWithoutDiagram(String fieldName) {
        waitForVisibilityOfElement(20, rootElement);
        scrollToElement(rootElement);
        return ThreadSafeSingleton.getDriverInstance().findElement(By.xpath(
                "//div[@data-id='3']//span[@class='executionStatistics__title--3lur8' and text()='"
                        + fieldName + "']//following-sibling::a")).getText();
    }

    public String getTextOfElementsWithDiagram(String fieldName) {
        waitForVisibilityOfElement(30, rootElement);
        scrollToElement(rootElement);
        return ThreadSafeSingleton.getDriverInstance().findElement(By.xpath(
                "//div[@data-id='3']//span[@class='defectStatistics__title--_exCc' and text()='"
                        + fieldName + "']//following-sibling::div/a")).getText();
    }
}

