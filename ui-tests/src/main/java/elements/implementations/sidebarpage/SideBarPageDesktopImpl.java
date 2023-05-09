package elements.implementations.sidebarpage;

import static utils.WebDriverWaiter.waitForVisibilityOfElement;

import elements.abstractions.page.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SideBarPageDesktopImpl extends AbstractPage {

    @FindBy(xpath = "//a[@href='#default_personal/launches']")
    private WebElement launchesButton;

    public SideBarPageDesktopImpl() {
    }

    public void clickLaunchesButton() {
        waitForVisibilityOfElement(10000, launchesButton);
        launchesButton.click();
    }
}
